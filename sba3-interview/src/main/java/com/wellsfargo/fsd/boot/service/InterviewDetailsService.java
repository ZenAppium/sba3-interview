package com.wellsfargo.fsd.boot.service;

import java.util.List;

import com.wellsfargo.fsd.boot.entity.InterviewDetails;
import com.wellsfargo.fsd.boot.entity.User;
import com.wellsfargo.fsd.boot.exception.InterviewDetailsException;

public interface InterviewDetailsService {
	InterviewDetails add(InterviewDetails interviewDetails) throws InterviewDetailsException;
	InterviewDetails save(InterviewDetails interviewDetails) throws InterviewDetailsException;
	
	boolean deleteInterviewDetails(int interviewId) throws InterviewDetailsException;
	
	InterviewDetails getInterviewDetails(int interviewId) throws InterviewDetailsException;
	List<InterviewDetails> getAllInterviewDetails() throws InterviewDetailsException;
}
