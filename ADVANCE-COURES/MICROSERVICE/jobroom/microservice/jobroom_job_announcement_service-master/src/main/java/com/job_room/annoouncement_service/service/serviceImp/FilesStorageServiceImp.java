package com.job_room.annoouncement_service.service.serviceImp;

import com.job_room.annoouncement_service.service.FilesStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FilesStorageServiceImp implements FilesStorageService {

    private final Path root = Paths.get("src/main/resources/static/image/");

    @Value("${file.upload.server.path}")
    private String serverPath;

    //TODO: Create directory =========================================================
    @Override
    public void init() {

        try {
            Files.createDirectory(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    //TODO: Save file =========================================================
    @Override
    public String save(MultipartFile file) {

        String fileName = "";
        String fileDownloadUri = "";

        if(!file.isEmpty()) {
            fileName = file.getOriginalFilename();
            fileDownloadUri = UUID.randomUUID() + "." + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            try {
                Files.copy(file.getInputStream(), Paths.get(serverPath, fileDownloadUri));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileDownloadUri;

    }

    //TODO: Load file =========================================================
    @Override
    public Resource load(String filename) {

        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    //TODO: Delete all files =========================================================
    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    //TODO: Load all files =========================================================
    @Override
    public Stream<Path> loadAll() {

        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }

    //TODO: Load all files =========================================================
    @Override
    public Set<String> listFilesUsingJavaIO(String dir) {

        return Stream.of(new File(dir).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
    }

}
