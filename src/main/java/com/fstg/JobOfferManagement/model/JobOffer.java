package com.fstg.JobOfferManagement.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "JobOffer4")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobOffer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobOfferId;

	@Column(nullable = false)
    private String title;

	@Column(nullable = false)
    private String description;

	@Column(nullable = false)
    private String requirements;

	@Column(nullable = false)
    private Integer recruiter;

	public void setId(Integer id) {
		// TODO Auto-generated method stub
		this.jobOfferId=id;
	}

	

	
	
}
    
	

	

	

   


