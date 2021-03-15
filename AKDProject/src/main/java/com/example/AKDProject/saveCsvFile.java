package com.example.AKDProject;



import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class saveCsvFile {
  @Autowired
  storageCSV repository;

  public void save(MultipartFile file) {
    try {
      List<createDB> podaci = csvFormatRead.csvdata(file.getInputStream());
      repository.saveAll(podaci);
    } catch (IOException e) {
      throw new RuntimeException("Error to store csv data: " + e.getMessage());
    }
  }
  
	}
 

