package com.mohit_project.email;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequest {
	    private List<String> to;
	    private String subject;
	    private String body;
	    private boolean track = true;


}
