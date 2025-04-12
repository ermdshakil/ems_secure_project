package com.mohit_project.Controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mohit_project.Service.SettingService;
import com.mohit_project.paylode.ApiResponse;
import com.mohit_project.paylode.SettingDto;



//@CrossOrigin("*")
@RestController
@RequestMapping("/api/setting")
public class SettingContro {
	
	@Autowired
	private SettingService settingService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<SettingDto> createSetting(@RequestBody SettingDto settingDto){
		SettingDto createSetting=this.settingService.createSetting(settingDto);
		return new ResponseEntity<SettingDto>(createSetting,HttpStatus.CREATED);
		
	}
	
	//update
	@PutMapping("/{settingId}")
	public ResponseEntity<SettingDto> updateSetting(@RequestBody SettingDto settingDto,@PathVariable Long settingId){
		SettingDto updateSetting=this.settingService.updateSetting(settingDto, settingId);
		return ResponseEntity.ok(updateSetting);
		
	}
	
	//delete
	@DeleteMapping("/{settingId}")
	public ResponseEntity<ApiResponse> deleteSetting(@PathVariable Long settingId){
		this.settingService.deleteSetting(settingId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Dalete Successfully",true),HttpStatus.OK);

	}
	//getSettingId
	@GetMapping("/{settingId}")
	public ResponseEntity<SettingDto> getSettingId(@PathVariable Long settingId){
		return ResponseEntity.ok(this.settingService.getSettingId(settingId));
	}
	//getAllSetting
	@GetMapping("/")
	public ResponseEntity<List<SettingDto>> getAllSetting(){
		return ResponseEntity.ok(this.settingService.getAllSetting());
	}

}
