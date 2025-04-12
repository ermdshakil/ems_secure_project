package com.mohit_project.Controller;

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

import com.mohit_project.Service.ProfileService;
import com.mohit_project.paylode.ApiResponse;

import com.mohit_project.paylode.ProfileDto;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	

	//create
		@PostMapping("/")
		public ResponseEntity<ProfileDto> createProfile(@RequestBody ProfileDto profileDto){
			ProfileDto createProfile=this.profileService.createProfile(profileDto);
			return new ResponseEntity<ProfileDto>(createProfile,HttpStatus.CREATED);
		}
		//update
		@PutMapping("/{profileId}")
		public ResponseEntity<ProfileDto> updateProfile(@RequestBody ProfileDto profileDto,@PathVariable Long profileId){
			ProfileDto updateProfile=this.profileService.updateProfile(profileDto, profileId);
			return ResponseEntity.ok(updateProfile);
		}

		//delete
		@DeleteMapping("/{profileId}")
		public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Long profileId){
			this.profileService.deleteProfile(profileId);
			return new ResponseEntity<ApiResponse>(new ApiResponse("User Dalete Successfully",true),HttpStatus.OK);

		}
		//getCategoryId
		@GetMapping("/{profileId}")
		public ResponseEntity<ProfileDto> getCategoryId(@PathVariable Long profileId){
			return ResponseEntity.ok(this.profileService.getByProfileId(profileId));
		}
		//getAllCategory
		@GetMapping("/")
		public ResponseEntity<List<ProfileDto>> getAllCategory(){
			return ResponseEntity.ok(this.profileService.getAllProfile());
		}

}
