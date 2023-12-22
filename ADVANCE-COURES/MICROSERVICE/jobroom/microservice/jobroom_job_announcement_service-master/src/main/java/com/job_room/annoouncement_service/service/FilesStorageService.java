package com.job_room.annoouncement_service.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Stream;

public interface FilesStorageService {

    //TODO: Create directory =========================================================
    public void init();

    //TODO: Save file =========================================================
    public String save(MultipartFile file);

    //TODO: Load file =========================================================
    public Resource load(String filename);

    //TODO: Delete all files =========================================================
    public void deleteAll();

    //TODO: Load all files =========================================================
    public Stream<Path> loadAll();

    //TODO: Load all files =========================================================
    Set<String> listFilesUsingJavaIO(String dir);
}
