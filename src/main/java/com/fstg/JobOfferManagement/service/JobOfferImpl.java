package com.fstg.JobOfferManagement.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import  com.fstg.JobOfferManagement.dao.jobofferdao;
import com.fstg.JobOfferManagement.dto.JobOfferRequestDto;
import com.fstg.JobOfferManagement.dto.JobOfferResponseDto;
import com.fstg.JobOfferManagement.exception.EntityNotFoundException;
import com.fstg.JobOfferManagement.model.JobOffer;

@Service()
public  class JobOfferImpl implements JobOfferService {
	private jobofferdao dao;
	private ModelMapper mapper ;
	public JobOfferImpl(jobofferdao dao ,ModelMapper mapper) {
		this.dao=dao;
		this.mapper = mapper ;
	}
	@Override 
    public JobOfferResponseDto save(JobOfferRequestDto Dto) {
		JobOffer offer = mapper.map( Dto , JobOffer.class );
		JobOffer saved = dao.save(offer);
		return mapper.map(saved,JobOfferResponseDto.class);
	}
	
	@Override
	public JobOfferResponseDto findById(Integer id) {
		
		JobOffer offer = dao.findById(id).orElseThrow(()-> new EntityNotFoundException("offer not found"));
		
		return mapper.map(offer,JobOfferResponseDto.class);

	}
	
	@Override
	public JobOfferResponseDto findByTitle(String title) {
		JobOffer offer = dao.findByTitle(title);
		return mapper.map(offer,JobOfferResponseDto.class);

	}
	
/*
	@Override
	public JobOfferResponseDto findByRecruiter(Integer Rec) {
		JobOffer offer = dao.findByRecruiter(Rec);
		return mapper.map(offer,JobOfferResponseDto.class);
	}
	*/
	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}
	@Override
	public JobOfferResponseDto update(JobOfferRequestDto dto , Integer id) throws  NotFoundException{
		Optional<JobOffer> offer = dao.findById(id);
		if(offer.isPresent()) {
			JobOffer joboffer = mapper.map(dto, JobOffer.class);
			joboffer.setId(id);
			JobOffer updated = dao.save(joboffer);
			return mapper.map(updated, JobOfferResponseDto.class);
		}else {
			throw new EntityNotFoundException("offer not found");
		}

	}
	
	@Override
	public List<JobOfferResponseDto> findAll(){
		return dao.findAll().stream()
				.map(el -> mapper
				.map(el, JobOfferResponseDto.class))
				.collect(Collectors.toList());
	}
	

}
