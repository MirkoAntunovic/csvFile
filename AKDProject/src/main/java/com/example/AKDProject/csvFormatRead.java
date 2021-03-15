package com.example.AKDProject;



import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;

import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import org.apache.commons.csv.CSVRecord;

import org.springframework.web.multipart.MultipartFile;



public class csvFormatRead {
  public static String TYPE = "text/csv";
  static String[] HEADERs = { "ime", "prezime", "godinaRodjenja"};

  public static boolean hasCSVFormat(MultipartFile file) {
    if (TYPE.equals(file.getContentType())
    		|| file.getContentType().equals("application/vnd.ms-excel")) {
      return true;
    }

    return false;
  }

  public static List<createDB> csvdata(InputStream is) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(reader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<createDB> mainLIst = new ArrayList<>();

      Iterable<CSVRecord> records = csvParser.getRecords();

      for (CSVRecord record : records) {
    	  createDB main = new createDB(
    			  record.get("ime"),
    			  Integer.parseInt(record.get("godinaRodjenja")),
    			  record.get("prezime")
           
             );
              

    	  mainLIst.add(main);
      }

      return mainLIst;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }


}
