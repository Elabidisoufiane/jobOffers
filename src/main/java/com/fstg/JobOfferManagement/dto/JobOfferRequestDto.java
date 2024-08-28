package com.fstg.JobOfferManagement.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobOfferRequestDto {
	
	@NotBlank(message = "title est obligatoire !!")
    @Size(min = 5, message = "ce champ doit avoir au moins 5 charactere")
    @Size(max = 20, message = "ce champs ne doit pas depasser 20 charactere")
	private String title;
	
	@NotBlank(message = "description est obligatoire !!")
    @Size(min = 20, message = "ce champ doit avoir au moins 20 charactere")
    @Size(max = 100, message = "ce champs ne doit pas depasser 100 charactere")
	private String description;
	
	@NotBlank(message = "requirements est obligatoire !!")
    @Size(min = 10, message = "ce champ doit avoir au moins 10 charactere")
    @Size(max = 50, message = "ce champs ne doit pas depasser 50 charactere")
	private String requirements ;
	
	@NotNull(message = "recruiterId est obligatoire !!")
	private Integer recruiter ;
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRequirements() {
		return requirements;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getRecruiter() {
		return recruiter;
	}
	public void setRecruiter(Integer recruiter) {
		this.recruiter = recruiter;
	}
	
	

}
