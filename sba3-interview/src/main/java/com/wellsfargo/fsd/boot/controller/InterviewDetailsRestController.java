package com.wellsfargo.fsd.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wellsfargo.fsd.boot.dto.InterviewDetailsDto;
import com.wellsfargo.fsd.boot.entity.InterviewDetails;
import com.wellsfargo.fsd.boot.exception.InterviewDetailsException;
import com.wellsfargo.fsd.boot.service.InterviewDetailsConverter;
import com.wellsfargo.fsd.boot.service.InterviewDetailsService;

@RestController
@RequestMapping("/intervewDetails")
public class InterviewDetailsRestController {
	@Autowired
	private InterviewDetailsService interviewDetailsService;
	
	@Autowired
	private InterviewDetailsConverter interviewDetailsConverter;
	
	@GetMapping
	public List<InterviewDetailsDto> getAllInterviewDetails() throws InterviewDetailsException{			
		List<InterviewDetails> getAllInterviewDetails = interviewDetailsService.getAllInterviewDetails();
		return interviewDetailsConverter.entityToDto(getAllInterviewDetails);
	}

	@GetMapping("/{id}")
	public InterviewDetailsDto getAllInterviewDetails(@PathVariable("id") int intvId) throws InterviewDetailsException{			
		InterviewDetails interviewDetails =interviewDetailsService.getInterviewDetails(intvId);
		InterviewDetailsDto interviewDetailsDto = interviewDetailsConverter.entityToDto(interviewDetails);
		return interviewDetailsDto;
	}
	
	@DeleteMapping("/{id}")
	public void deleteInterviewDetails(@PathVariable("id") int intvId) throws InterviewDetailsException{			
		interviewDetailsService.deleteInterviewDetails(intvId);
	}
	
	@PostMapping
	public InterviewDetailsDto addInterviewDetails(@RequestBody InterviewDetailsDto interviewDetailsDto) throws InterviewDetailsException{			
		InterviewDetails interviewDetails = interviewDetailsConverter.dtoToEntity(interviewDetailsDto);
		interviewDetails = interviewDetailsService.add(interviewDetails);
		return interviewDetailsConverter.entityToDto(interviewDetails);
	}

	@PutMapping
	public InterviewDetailsDto saveInterviewDetails(@RequestBody InterviewDetailsDto interviewDetailsDto) throws InterviewDetailsException{			
		InterviewDetails interviewDetails = interviewDetailsConverter.dtoToEntity(interviewDetailsDto);
		interviewDetails = interviewDetailsService.save(interviewDetails);
		return interviewDetailsConverter.entityToDto(interviewDetails);
	}
}
