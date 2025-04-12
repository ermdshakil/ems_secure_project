package com.mohit_project.Service;

import java.util.List;

import com.mohit_project.paylode.ProfileDto;

public interface ProfileService {
	
	ProfileDto createProfile(ProfileDto profileDto);
	ProfileDto updateProfile(ProfileDto profileDto,Long profileId);
	void deleteProfile(Long profileId);
	ProfileDto getByProfileId(Long profileId);
	List<ProfileDto> getAllProfile();

}
