package com.readandwrite.readwritedemo.service;

//src/main/java/com/example/demo/service/FileService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.readandwrite.readwritedemo.model.FileContent;
import com.readandwrite.readwritedemo.repository.FileRepository;

@Service
public class FileService {
 private final FileRepository fileRepository;

 @Autowired
 public FileService(FileRepository fileRepository) {
     this.fileRepository = fileRepository;
 }

 public FileContent readFile(long id) {
     return fileRepository.findById(id).orElse(null);
 }

 public void writeFile(FileContent fileContent) {
     fileRepository.save(fileContent);
 }
}
