package com.fstg.JobOfferManagement.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobOfferResponseDto {
	
	private Integer id ;
	
	private String title;
	
	private String description;
	
	private String requirements ;
	
	private Integer recruiter ;



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public Integer getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Integer recruiter) {
		this.recruiter = recruiter;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
}
