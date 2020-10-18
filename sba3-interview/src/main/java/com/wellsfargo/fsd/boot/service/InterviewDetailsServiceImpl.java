package com.wellsfargo.fsd.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wellsfargo.fsd.boot.dao.InterviewDetailsRepository;
import com.wellsfargo.fsd.boot.entity.InterviewDetails;
import com.wellsfargo.fsd.boot.exception.InterviewDetailsException;


@Service
public class InterviewDetailsServiceImpl implements InterviewDetailsService {
	@Autowired
	private InterviewDetailsRepository interviewDetailsRepo;
	
	@Override
	@Transactional
	public InterviewDetails add(InterviewDetails interviewDetails) throws InterviewDetailsException {
		if(interviewDetails!=null) {
			if(interviewDetailsRepo.existsById(interviewDetails.getInterviewId())) {
				throw new InterviewDetailsException("Interview Id already in use!");
			}
			/*
			 * if(userRepo.existsByMobile(user.getMobile())) { throw new
			 * UserException("Mobile Number is already in use!"); }
			 */
			interviewDetailsRepo.save(interviewDetails);
		}
		return interviewDetails;
	}

	@Override
	@Transactional
	public InterviewDetails save(InterviewDetails interviewDetails) throws InterviewDetailsException {
		if(interviewDetails!=null) {
			if(!interviewDetailsRepo.existsById(interviewDetails.getInterviewId())) {
				throw new InterviewDetailsException("Interview Id is not found!");
			}
			interviewDetailsRepo.save(interviewDetails);
		}
		return interviewDetails;
	}

	@Override
	@Transactional
	public boolean deleteInterviewDetails(int interviewId) throws InterviewDetailsException {
		if(!interviewDetailsRepo.existsById(interviewId)) {
			throw new InterviewDetailsException("Interview Id is not found!");
		}
		interviewDetailsRepo.deleteById(interviewId);
		return true;
	}

	@Override
	public InterviewDetails getInterviewDetails(int interviewId) throws InterviewDetailsException {
		return interviewDetailsRepo.findById(interviewId).orElse(null);
	}

	@Override
	public List<InterviewDetails> getAllInterviewDetails() throws InterviewDetailsException {
		return interviewDetailsRepo.findAll();
	}

}
