package com.wellsfargo.fsd.boot.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wellsfargo.fsd.boot.dto.AttendeeDto;
import com.wellsfargo.fsd.boot.dto.InterviewDetailsDto;
import com.wellsfargo.fsd.boot.dto.UserDto;
import com.wellsfargo.fsd.boot.exception.InterviewDetailsException;
import com.wellsfargo.fsd.boot.exception.UserException;
import com.wellsfargo.fsd.boot.service.InterviewDetailsService;
import com.wellsfargo.fsd.boot.service.UserService;

@RestController
@RequestMapping("/visitors")
public class VisitorsRestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private InterviewDetailsService interviewDetailsService;
	
	@GetMapping("/showUsers")
	public ResponseEntity<List<UserDto>> getAllUsers() throws UserException{			
		return new ResponseEntity<List<UserDto>> (userService.getAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/showUser/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable("userId") int userId) throws UserException{			
		ResponseEntity<UserDto> response =null;
		UserDto user = userService.getUser(userId);
		if(user!=null){
			response = new ResponseEntity<>(user,HttpStatus.OK);
		}else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<UserDto> addUser(@RequestBody @Valid UserDto user, BindingResult results) throws UserException{
		if(results.hasErrors()) {
			throw new UserException(GlobalExceptionController.errorMsgFrom(results));
		}
		return new ResponseEntity<>(userService.addUser(user),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUser/{userId}") 
	public ResponseEntity<Void> deleteUser(@PathVariable("userId") int userId) throws UserException{
		userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/showInterviewDetails")
	public ResponseEntity<List<InterviewDetailsDto>> getAllInterviewDetails() throws InterviewDetailsException{			
		return new ResponseEntity<List<InterviewDetailsDto>>(interviewDetailsService.getAllInterviewDetails(), HttpStatus.OK);
	}
	
	
	  @GetMapping("/showInterviewCount") 
	  public ResponseEntity<String> getAllInterviewsCount() throws InterviewDetailsException{ 
		  return new ResponseEntity<>(interviewDetailsService.getAllInterviewDetailsCount(), HttpStatus.OK); }
	 

	@GetMapping("/showInterviewDetails/{interviewId}")
	public ResponseEntity<InterviewDetailsDto> getInterviewDetails(@PathVariable("interviewId") int interviewId) throws InterviewDetailsException{			
		ResponseEntity<InterviewDetailsDto> response =null;
		InterviewDetailsDto interviewDetails = interviewDetailsService.getInterviewDetailsById(interviewId);
		if(interviewDetails!=null){
			response = new ResponseEntity<>(interviewDetails,HttpStatus.OK);
		}else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	@GetMapping("/showInterviewDetails/{interviewName}/{interviewerName}")
	public ResponseEntity<List<InterviewDetailsDto>> searchInterviewDetails(@PathVariable("interviewName") String interviewName, @PathVariable("interviewerName") String interviewerName) throws InterviewDetailsException{			
		ResponseEntity<List<InterviewDetailsDto>> response =null;
		List<InterviewDetailsDto> interviewDetails = interviewDetailsService.searchInterviewDetails(interviewName, interviewerName);
		if(interviewDetails!=null){
			response = new ResponseEntity<>(interviewDetails,HttpStatus.OK);
		}else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	@PostMapping("/addInterview")
	public ResponseEntity<InterviewDetailsDto> addInterviewDetails(@RequestBody @Valid InterviewDetailsDto interviewDetails, BindingResult results) throws InterviewDetailsException{
		if(results.hasErrors()) {
			throw new InterviewDetailsException(GlobalExceptionController.errorMsgFrom(results));
		}
		return new ResponseEntity<>(interviewDetailsService.addInterviewDetails(interviewDetails),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteInterviewDetails/{interviewId}") 
	public ResponseEntity<Void> deleteInterviewDetails(@PathVariable("interviewId") int interviewId) throws InterviewDetailsException{
		interviewDetailsService.deleteInterviewDetails(interviewId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/InterviewDetailsStatus/{interviewId}/{interviewStatus}") 
	public ResponseEntity<InterviewDetailsDto> updateInterviewStatus(@PathVariable("interviewId") int interviewId,@PathVariable("interviewStatus") String interviewStatus) throws InterviewDetailsException{
		return new ResponseEntity<>(interviewDetailsService.updateInterviewStatus(interviewId, interviewStatus),HttpStatus.OK);	
	}
	 
	 @PostMapping("/addAttendee")
		public ResponseEntity<String> addAttendee(@RequestBody @Valid AttendeeDto attendee, BindingResult results) throws InterviewDetailsException{
			if(results.hasErrors()) {
				throw new InterviewDetailsException(GlobalExceptionController.errorMsgFrom(results));
			}
			return new ResponseEntity<>(interviewDetailsService.addAttendee(attendee),HttpStatus.OK);
		}
}
