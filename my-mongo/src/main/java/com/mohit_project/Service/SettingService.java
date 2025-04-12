package com.mohit_project.Service;

import java.util.List;

import com.mohit_project.paylode.SettingDto;




public interface SettingService {
	
	SettingDto createSetting(SettingDto settingDto);
	SettingDto updateSetting(SettingDto settingDto,Long settingId);
	void deleteSetting(Long settingId);
	SettingDto getSettingId(Long settingId);
	List<SettingDto> getAllSetting();

}
