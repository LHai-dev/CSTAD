package com.example.spring4mbankingapisasu.file;

import com.example.spring4mbankingapisasu.file.web.FileDto;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {


    /**
     *  use to upload a single file
     * @param file request form data from client
     * @return fileDto
     */
    FileDto uploadSingle(MultipartFile file);

    /**
     *
     * @param file uploadMultiple upload with api postman
     * @return List<FileDto>
     */

    List<FileDto> uploadMultiple(List<MultipartFile> file);

    /**
     *  removeAllFile with have in your folder in driver
     * @return  Boolean removeAllFile()
     */

    Boolean removeAllFile();

    /**
     *  deleteSingleFile with postman
     * @param fileName
     * @return FileDto deleteSingleFile
     */

    FileDto deleteSingleFile(String fileName);


    /**
     *  select all file that we have
     * @return List<FileDto>
     */
    List<FileDto>AllFiles();

    /**
     *      find file by name with name .png
     * @param name
     * @return  FileDto findByName
     * @throws IOException
     */
    FileDto findByName(String name) throws IOException;

    /**
     * delete by name that we have when we upload in api postman
     * @param name
     */
    void deleteByName( String name);

    /**
     *  download file phone png jpg in api postman
     * @param name
     * @return  Resource download
     */

    Resource download(String name);

}
