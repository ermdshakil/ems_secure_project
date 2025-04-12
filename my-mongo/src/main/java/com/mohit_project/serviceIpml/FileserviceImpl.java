package com.mohit_project.serviceIpml;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mohit_project.Service.FileService;





@Service
public class FileserviceImpl implements FileService {

	@Override
	public String uplodeImage(String path, MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		//file name
		String name=file.getOriginalFilename();
		//ransam id genreted
		String randomId=UUID.randomUUID().toString();
		String fileName1=randomId.concat(name).substring(name.lastIndexOf("."));
		
		//full path
		String filePath=path+ File.separator+name;
		//create folder if not createed
		File f=new File(path);
		if(!f.exists())
		{
			f.mkdir();
		}
		//file copy
		Files.copy(file.getInputStream(), Paths.get(filePath));
		return name;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String fullPath=path+File.separator+fileName;
		InputStream is=new FileInputStream(fullPath);
		return is;
	}

}
