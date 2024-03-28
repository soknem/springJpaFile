package app.springJPA.restconroller;

import app.springJPA.service.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/files")
public class FileStorageRestController {
    private final FileStorageService fileStorageService;
    @PostMapping(value = "/",consumes = "multipart/form-data")
    public HashMap<String,Object> uploadFile(@RequestBody MultipartFile file){
        fileStorageService.uploadSingleFile(file);
        return null;
    }
}
