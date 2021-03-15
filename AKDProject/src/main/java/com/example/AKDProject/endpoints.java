package com.example.AKDProject;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin("http://localhost:8080")
@Controller
@RequestMapping("/api/csv")
public class endpoints {

  @Autowired
  saveCsvFile fileService;

  @PostMapping("/upload")
  public ResponseEntity<message> uploadFile(@RequestParam("file") MultipartFile file) {
    String message = "";

    if (csvFormatRead.hasCSVFormat(file)) {
      try {
        fileService.save(file);

        message = "Uploaded the file successfully: " + file.getOriginalFilename();
        
     

        return ResponseEntity.status(HttpStatus.OK).body(new message(message));
      } catch (Exception e) {
        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new message(message));
      }
    }

    message = "Please upload a csv file!";
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new message(message));
  }

 
  }




