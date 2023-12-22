package com.job_room.annoouncement_service.rest.restcontroller;

import com.job_room.annoouncement_service.rest.message.BaseApiResponse;
import com.job_room.annoouncement_service.rest.message.ErrorResponse;
import com.job_room.annoouncement_service.rest.message.MessageProperties;
import com.job_room.annoouncement_service.service.FilesStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class FileUploadController {

    @Value(value = "${file.upload.server.path}")
    private String serverPath;

    @Value("${file.base.url}")
    private String imageUrl;

    @Autowired
    FilesStorageService storageService;

    private MessageProperties messageProperties;

    @Autowired
    public void setMessageProperties(MessageProperties messageProperties) {
        this.messageProperties = messageProperties;
    }

    //TODO: Exception =========================================================
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex){

        Map<String, String> objectError = new HashMap<>();
        ErrorResponse response = new ErrorResponse();
        List<Object> errors = new ArrayList<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            objectError.put("field", fieldName);
            objectError.put("message", errorMessage);
            errors.add(objectError);
        });

        response.setMessage(messageProperties.insertError("File"));
        response.setError(errors);
        response.setStatus(HttpStatus.BAD_REQUEST);
        response.setTime(new Timestamp(System.currentTimeMillis()));

        return ResponseEntity.ok(response);
    }


    //TODO: Upload files =========================================================
    @RequestMapping(value = "/uploads", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> uploadFile(@RequestParam("files") MultipartFile[] files) {

        Map<String, Object> res = new HashMap<>();

        int i=0;

        try {
            for(MultipartFile file : files)
            {
                i++;
                String fileName = storageService.save(file);

                if(i==1){
                    res.put("message","File have been saved successfully");
                    res.put("status","Ok");
                }
                res.put("file"+i,(imageUrl+fileName));
            }

            res.put("time",new Timestamp(System.currentTimeMillis()));

            return ResponseEntity.status(HttpStatus.OK).body(res);

        } catch (Exception e) {

            res.put("message","Could not upload the file:");
            res.put("status",false);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(res);
        }
    }

    //TODO: Get Files =========================================================
    @GetMapping("/files")
    public ResponseEntity<BaseApiResponse<ArrayList<String>>> getAllFiles(HttpServletResponse response) {

        try{
            BaseApiResponse<ArrayList<String>> baseApiResponse = new BaseApiResponse<>();

            Set<String> fileNames = storageService.listFilesUsingJavaIO(serverPath);

            ArrayList<String> nameWithAddress= new ArrayList<>();

            for(String string : fileNames){
                nameWithAddress.add(imageUrl+string);
            }

            baseApiResponse.setData(nameWithAddress);
            baseApiResponse.setTime(new Timestamp(System.currentTimeMillis()));
            baseApiResponse.setStatus(HttpStatus.OK);
            baseApiResponse.setMessage(messageProperties.selected("Files"));


            return ResponseEntity.ok(baseApiResponse);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //TODO: Get File By Name =========================================================
    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<BaseApiResponse<String>> getFileByName(@PathVariable String filename) {

        BaseApiResponse<String> baseApiResponse  = new BaseApiResponse<>();

        try{

            Set<String> fileNames = storageService.listFilesUsingJavaIO(serverPath);
            String nameWithAddress= "";

            for(String string : fileNames){

                if(string.equals(filename))
                    nameWithAddress = imageUrl+string;
            }

            baseApiResponse.setData(nameWithAddress);
            baseApiResponse.setTime(new Timestamp(System.currentTimeMillis()));
            baseApiResponse.setStatus(HttpStatus.OK);
            baseApiResponse.setMessage("You have selected the images");

            return ResponseEntity.ok(baseApiResponse);

        }catch (Exception e){

            baseApiResponse.setData("");
            baseApiResponse.setTime(new Timestamp(System.currentTimeMillis()));
            baseApiResponse.setStatus(HttpStatus.NOT_FOUND);
            baseApiResponse.setMessage("No image");

            return null;
        }
    }

}