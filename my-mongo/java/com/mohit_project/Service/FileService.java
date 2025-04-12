package com.mohit_project.Service;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	String uplodeImage(String path,MultipartFile file)throws IOException;
	
	InputStream getResource(String path,String fileName)throws FileNotFoundException;

}
