package com.wellsfargo.fsd.boot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.wellsfargo.fsd.boot.dao.InterviewDetailsRepository;
import com.wellsfargo.fsd.boot.dao.UserRepository;
import com.wellsfargo.fsd.boot.dto.AttendeeDto;
import com.wellsfargo.fsd.boot.dto.InterviewDetailsDto;
import com.wellsfargo.fsd.boot.dto.UserDto;
import com.wellsfargo.fsd.boot.entity.InterviewDetails;
import com.wellsfargo.fsd.boot.entity.User;
import com.wellsfargo.fsd.boot.exception.InterviewDetailsException;


@Service
public class InterviewDetailsServiceImpl implements InterviewDetailsService {
	@Autowired
	private InterviewDetailsRepository interviewDetailsRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	private InterviewDetails toInterviewDeatils(InterviewDetailsDto interviewDetailsDto) {
		if(interviewDetailsDto.getAttendees()==null) {
			return new InterviewDetails(interviewDetailsDto.getInterviewId(),interviewDetailsDto.getInterviewName(),interviewDetailsDto.getInterviewerName(),
					interviewDetailsDto.getUsersSkill(),interviewDetailsDto.getTime(),interviewDetailsDto.getDate(),interviewDetailsDto.getInterviewStatus(),
					interviewDetailsDto.getRemarks());
		}
		else {
			return new InterviewDetails(interviewDetailsDto.getInterviewId(),interviewDetailsDto.getInterviewName(),interviewDetailsDto.getInterviewerName(),
					interviewDetailsDto.getUsersSkill(),interviewDetailsDto.getTime(),interviewDetailsDto.getDate(),interviewDetailsDto.getInterviewStatus(),
					interviewDetailsDto.getRemarks(),toUserEntities(interviewDetailsDto.getAttendees()));
		}
				
	}
	
	private InterviewDetailsDto toInterviewDeatilsDto(InterviewDetails interviewDetails) {
		if(interviewDetails.getAttendees()==null) {
			return new InterviewDetailsDto(interviewDetails.getInterviewId(),interviewDetails.getInterviewerName(),interviewDetails.getInterviewName(),
					interviewDetails.getInterviewStatus(),interviewDetails.getTime(),interviewDetails.getDate(),interviewDetails.getUsersSkill(),
					interviewDetails.getRemarks());
		}
		else {
			return new InterviewDetailsDto(interviewDetails.getInterviewId(),interviewDetails.getInterviewerName(),interviewDetails.getInterviewName(),
					interviewDetails.getUsersSkill(),interviewDetails.getTime(),interviewDetails.getDate(),interviewDetails.getInterviewStatus(),
					interviewDetails.getRemarks(),toUserDeatilsModels(interviewDetails.getAttendees()));
		}
				
	}
	
	

	private User toUserEntity(UserDto userDto) {
		return new User(userDto.getUserId(),userDto.getFirstName(),userDto.getLastName(),userDto.getEmail(),userDto.getMobile());
	}
	private List<User> toUserEntities(List<UserDto> userDto) {
		List<User> entities = null;
		entities = userDto.stream().map(e -> toUserEntity(e)).collect(Collectors.toList());
		return entities;
	}
	private UserDto toUserDeatilsModel(User user) {
		return new UserDto(user.getUserId(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getMobile());
	}
	private List<UserDto> toUserDeatilsModels(List<User> user) {
		List<UserDto> models = null;
		models = user.stream().map(e -> toUserDeatilsModel(e)).collect(Collectors.toList());
		return models;
	}
	
	private InterviewDetailsDto getInterviewDetailsDto(InterviewDetails interviewDetailsDto) {
		return new InterviewDetailsDto(interviewDetailsDto.getInterviewId(),interviewDetailsDto.getInterviewName(),interviewDetailsDto.getInterviewerName(),
				interviewDetailsDto.getInterviewStatus(),interviewDetailsDto.getTime(),interviewDetailsDto.getDate(),interviewDetailsDto.getUsersSkill(),
				interviewDetailsDto.getRemarks()
				);
	}
	
	@Override
	@Transactional
	public InterviewDetailsDto addInterviewDetails(InterviewDetailsDto interviewDetailsDto) throws InterviewDetailsException {
		if(interviewDetailsDto!=null) {
			if(interviewDetailsRepo.existsById(interviewDetailsDto.getInterviewId())) {
				throw new InterviewDetailsException("Interview Id already in use!");
			}
			interviewDetailsDto = toInterviewDeatilsDto(interviewDetailsRepo.save(toInterviewDeatils(interviewDetailsDto)));
		}
		return interviewDetailsDto;
	}

	@Override
	@Transactional
	public InterviewDetailsDto updateInterviewStatus(int interviewId, String status) throws InterviewDetailsException {
		if(!interviewDetailsRepo.existsById(interviewId)) {
			throw new InterviewDetailsException("Interview Id is not present!");
		}
		InterviewDetailsDto	interviewDetailsDto = getInterviewDetailsById(interviewId);
		interviewDetailsDto.setInterviewStatus(status);
		interviewDetailsRepo.save(toInterviewDeatils(interviewDetailsDto));
		return getInterviewDetailsDto(toInterviewDeatils(interviewDetailsDto));
	}
	
	public List<InterviewDetailsDto> searchInterviewDetails(String interviewName,String interviewerName ) throws InterviewDetailsException{
		List<InterviewDetails> interviewDetails = interviewDetailsRepo.findByInterviewerName(interviewName, interviewerName);
		List<InterviewDetailsDto> interviewDetailsDto = null;
		if(interviewDetails!=null && !interviewDetails.isEmpty()) {
			interviewDetailsDto = interviewDetails.stream().map(e -> getInterviewDetailsDto(e)).collect(Collectors.toList());
		}
		return interviewDetailsDto;
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
	public List<InterviewDetailsDto> getAllInterviewDetails() throws InterviewDetailsException {
		List<InterviewDetails> interviewDetails = interviewDetailsRepo.findAll();
		List<InterviewDetailsDto> interviewDetailsDto = null;
		if(interviewDetails!=null && !interviewDetails.isEmpty()) {
			interviewDetailsDto = interviewDetails.stream().map(e -> getInterviewDetailsDto(e)).collect(Collectors.toList());
		}
		return interviewDetailsDto;
	}
	
	@Override
	public InterviewDetailsDto getInterviewDetailsById(int interviewId) throws InterviewDetailsException{
		InterviewDetails interviewDetails = interviewDetailsRepo.findById(interviewId).orElse(null);
		return interviewDetails!=null?toInterviewDeatilsDto(interviewDetails):null;
	}
	
	@Override
	public String getAllInterviewDetailsCount() throws InterviewDetailsException{
		List<InterviewDetails> interviewDetails = interviewDetailsRepo.findAll();
		if(interviewDetails!=null) {
			return "Total no of interviews are: "+interviewDetails.size();
		}
		return "No interview scheduled yet";
	}
	
	@Override
	public List<UserDto> showUsers(int  interviewId) throws InterviewDetailsException {
		if(!interviewDetailsRepo.existsById(interviewId)) {
			throw new InterviewDetailsException("Interview Id is not found!");
		}
		return toUserDeatilsModels(interviewDetailsRepo.findById(interviewId).orElse(null).getAttendees());
	}
	
	public UserDto getUserById(int userId) {
		User user = userRepo.findById(userId).orElse(null);
		return user!=null?toUserDeatilsModel(user):null;
	}
	@Override
	@Transactional
	public String addAttendee(AttendeeDto attendeeDto) throws InterviewDetailsException{
		if(attendeeDto!=null){
			if(!userRepo.existsById(attendeeDto.getUserId())) {
				throw new InterviewDetailsException("User Id is not found!");
			}
			if(!interviewDetailsRepo.existsById(attendeeDto.getInterviewId())) {
				throw new InterviewDetailsException("Interview Id is not found!");
			}
			InterviewDetailsDto interviewDetailsDto = getInterviewDetailsById(attendeeDto.getInterviewId());
			for(UserDto userDto: interviewDetailsDto.getAttendees()) {
				if(userDto.getUserId()==attendeeDto.getInterviewId()) {
					throw new InterviewDetailsException("User Id with same interviewId already exist!");
				}
			}
			List<UserDto> userDto = interviewDetailsDto.getAttendees();
			userDto.add(getUserById(attendeeDto.getUserId()));
			interviewDetailsDto.setAttendees(userDto);
			interviewDetailsRepo.save(toInterviewDeatils(interviewDetailsDto));
			return "User with id: "+getUserById(attendeeDto.getUserId()) +" added successfully to interview ";
		}
		return "Error adding user with id: "+attendeeDto.getUserId();
	}
	
}
