package app.springJPA.service;

import org.hibernate.sql.exec.spi.StandardEntityInstanceResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

@Service
public class FileStorageServiceImpl implements FileStorageService{
    @Value("${fileStorage.image_location}")
    String fileStorageLocation;
    @Override
    public String uploadSingleFile(MultipartFile file) {
        try{
            Path imageStoragePath=Path.of(fileStorageLocation);
            if(!Files.exists(imageStoragePath)){
                Files.createDirectories(imageStoragePath);
            }
            String newFileName= UUID.randomUUID()+"."+file.getOriginalFilename().split("\\.")[1];
            Path imageFullPath=imageStoragePath.resolve(newFileName);
            Files.copy(file.getInputStream(),imageFullPath, StandardCopyOption.REPLACE_EXISTING);
            return newFileName;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> uploadMultipleFile(MultipartFile[] files) {
        return null;
    }
}
