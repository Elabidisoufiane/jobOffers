package com.fstg.JobOfferManagement.controller;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fstg.JobOfferManagement.dto.JobOfferRequestDto;
import com.fstg.JobOfferManagement.dto.JobOfferResponseDto;
import com.fstg.JobOfferManagement.service.JobOfferService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/JobOffers")
public class JobOfferController {
	
	private JobOfferService service ;
	
	public JobOfferController(JobOfferService service) {
		this.service= service ;
	}
	
	@GetMapping("/Offers")
	public ResponseEntity< List<JobOfferResponseDto> > getJobOffers(){
		//return service.findAll();	
		return new ResponseEntity<> (service.findAll(),HttpStatus.OK) ;
	}
	@PostMapping("/AddOffer")
	public ResponseEntity<JobOfferResponseDto> save(@Valid @RequestBody() JobOfferRequestDto request) {
		JobOfferResponseDto dto = service.save(request) ;
		return new ResponseEntity <> (dto,HttpStatus.CREATED) ;
	}
	
	@PutMapping("/Offers/update/{id}")
    public ResponseEntity<JobOfferResponseDto> update(@Valid @RequestBody JobOfferRequestDto produitDto,@PathVariable Integer id) throws NotFoundException {
		JobOfferResponseDto dto = service.update(produitDto, id);
        return ResponseEntity.accepted().body(dto);
    }
	
	@GetMapping("/Offers/id/{id}")
	public ResponseEntity<JobOfferResponseDto> findById(@PathVariable Integer id) {
		JobOfferResponseDto dto = service.findById(id) ;
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/Offers/title/{title}")
	public JobOfferResponseDto findByTitle(@PathVariable String title) {
		return service.findByTitle(title);
	}
	
	
	/*@GetMapping("/Offers/recruiter/{id}")
	public JobOfferResponseDto findByRecruiter(@PathVariable Integer id) {
		return service.findByRecruiter(id);
	}
	*/
	@DeleteMapping("/Offers/id/{id}")
	public ResponseEntity<?> delet(@PathVariable Integer id) {
		service.delete(id);
        return ResponseEntity.noContent().build();
	}
	
}
