package com.mohit_project.serviceIpml;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit_project.Entity.Profile;
import com.mohit_project.Repositry.ProfileREpo;
import com.mohit_project.Service.ProfileService;
import com.mohit_project.exception.ResourceNotFoundException;
import com.mohit_project.paylode.ProfileDto;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileREpo profileREpo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProfileDto createProfile(ProfileDto profileDto) {
		// TODO Auto-generated method stub
		
		Profile profile=this.modelMapper.map(profileDto, Profile.class);
		
		return this.modelMapper.map(this.profileREpo.save(profile), ProfileDto.class);
	}

	@Override
	public ProfileDto updateProfile(ProfileDto profileDto, Long profileId) {
		// TODO Auto-generated method stub
		Profile profile=this.profileREpo.findById(profileId).orElseThrow(()-> new ResourceNotFoundException("Profile", "ID", profileId));
		
		profile.setEmployeeId(profileDto.getEmployeeId());
		profile.setJoinDate(profileDto.getJoinDate());
		profile.setPhoneNo(profileDto.getPhoneNo());
		profile.setAddress(profileDto.getAddress());
		profile.setNotes(profileDto.getNotes());
		return this.modelMapper.map(this.profileREpo.save(profile), ProfileDto.class);
	}

	@Override
	public void deleteProfile(Long profileId) {
		// TODO Auto-generated method stub
		Profile profile=this.profileREpo.findById(profileId).orElseThrow(()-> new ResourceNotFoundException("Profile", "ID", profileId));
 
		this.profileREpo.delete(profile);
		
	}

	@Override
	public ProfileDto getByProfileId(Long profileId) {
		// TODO Auto-generated method stub
		Profile profile=this.profileREpo.findById(profileId).orElseThrow(()-> new ResourceNotFoundException("Profile", "ID", profileId));

		return this.modelMapper.map(profile, ProfileDto.class);
	}

	@Override
	public List<ProfileDto> getAllProfile() {
		// TODO Auto-generated method stub
		List<Profile> profiles=this.profileREpo.findAll();
		List<ProfileDto> profileDtos=profiles.stream().map((pro)->this.modelMapper.map(pro, ProfileDto.class)).collect(Collectors.toList());
		return profileDtos;
	}

}
