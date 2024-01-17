package com.readandwrite.readwritedemo.controller;

//src/main/java/com/example/demo/controller/FileController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.readandwrite.readwritedemo.model.FileContent;
import com.readandwrite.readwritedemo.service.FileService;

@Controller
@RequestMapping("/files")
public class FileController {
 private final FileService fileService;

 @Autowired
 public FileController(FileService fileService) {
     this.fileService = fileService;
 }

 @GetMapping("/{id}")
 public String readFile(@PathVariable long id, Model model) {
     FileContent fileContent = fileService.readFile(id);
     model.addAttribute("fileContent", fileContent);
     return "file/read";
 }

 @GetMapping("/write")
 public String showWriteForm(Model model) {
     model.addAttribute("fileContent", new FileContent());
     return "file/write";
 }

 @PostMapping("/write")
 public String writeFile(@ModelAttribute FileContent fileContent) {
     fileService.writeFile(fileContent);
     return "redirect:/files/" + fileContent.getId();
 }
}
