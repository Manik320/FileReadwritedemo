package com.readandwrite.readwritedemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.readandwrite.readwritedemo.model.FileContent;

public interface FileRepository extends JpaRepository<FileContent, Long> {
}
