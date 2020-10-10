package com.wellsfargo.fsd.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.fsd.boot.entity.InterviewDetails;
import com.wellsfargo.fsd.boot.entity.User;
import com.wellsfargo.fsd.boot.exception.InterviewDetailsException;
import com.wellsfargo.fsd.boot.service.InterviewDetailsService;

@RestController
@RequestMapping("/intervewDetails")
public class InterviewDetailsRestController {
	@Autowired
	private InterviewDetailsService interviewDetailsService;

	@GetMapping
	public ResponseEntity<List<InterviewDetails>> getAllInterviewDetails() throws InterviewDetailsException{			
		return new ResponseEntity<List<InterviewDetails>>(interviewDetailsService.getAllInterviewDetails(),HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<InterviewDetails> getAllInterviewDetails(@PathVariable("id") int intvId) throws InterviewDetailsException{			
		ResponseEntity<InterviewDetails> resp = null;
		InterviewDetails interviewDetails =interviewDetailsService.getInterviewDetails(intvId);
		if(interviewDetails!=null) {
			resp = new ResponseEntity<InterviewDetails>(interviewDetails,HttpStatus.OK);
		}else {
			 new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return resp;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteInterviewDetails(@PathVariable("id") int intvId) throws InterviewDetailsException{			
		interviewDetailsService.deleteInterviewDetails(intvId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<InterviewDetails> addInterviewDetails(@RequestBody InterviewDetails interviewDetails) throws InterviewDetailsException{			
		return new ResponseEntity<InterviewDetails>(interviewDetailsService.add(interviewDetails), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<InterviewDetails> saveInterviewDetails(@RequestBody InterviewDetails interviewDetails) throws InterviewDetailsException{			
		return new ResponseEntity<InterviewDetails>(interviewDetailsService.add(interviewDetails), HttpStatus.OK);
	}
}
