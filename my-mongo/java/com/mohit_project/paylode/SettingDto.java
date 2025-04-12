package com.mohit_project.paylode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SettingDto {
	
	private long settingId;
	private String name;
	private String username;
	private String email;

}
