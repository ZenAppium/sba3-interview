package com.wellsfargo.fsd.boot.service;

import java.util.List;
import com.wellsfargo.fsd.boot.dto.AttendeeDto;
import com.wellsfargo.fsd.boot.dto.InterviewDetailsDto;
import com.wellsfargo.fsd.boot.dto.UserDto;
import com.wellsfargo.fsd.boot.exception.InterviewDetailsException;

public interface InterviewDetailsService {
	InterviewDetailsDto addInterviewDetails(InterviewDetailsDto interviewDetails) throws InterviewDetailsException;	
	boolean deleteInterviewDetails(int interviewId) throws InterviewDetailsException;	
	InterviewDetailsDto getInterviewDetailsById(int interviewId) throws InterviewDetailsException;	
	List<InterviewDetailsDto> getAllInterviewDetails() throws InterviewDetailsException;	
	InterviewDetailsDto updateInterviewStatus(int  interviewId, String interviewStatus) throws InterviewDetailsException;	
	String getAllInterviewDetailsCount() throws InterviewDetailsException;	
	List<InterviewDetailsDto> searchInterviewDetails(String interviewName,String interviewerName ) throws InterviewDetailsException;	
	List<UserDto> showUsers(int  interviewId) throws InterviewDetailsException;	
	String addAttendee(AttendeeDto attendeeDto) throws InterviewDetailsException;
	//List<InterviewDetailsDto> showAttendees(int interviewId) throws InterviewDetailsException;
}
