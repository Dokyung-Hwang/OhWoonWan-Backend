package com.oww.OhWoonWanBackend.service;

import com.oww.OhWoonWanBackend.dto.file.FileUploadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FileUploadService {

    private String fileDir;

    public FileUploadService() {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            this.fileDir = "window dir";
        } else if (os.contains("mac")) {
            this.fileDir = "/Users/cheoljin/cheoljin-workspace/web-workspace/oww_files/";
        } else if (os.contains("linux")) {
            this.fileDir = "linux dir";
        }
    }

    public List<FileUploadDto> storeFiles(List<MultipartFile> multipartFileList) {

        List<FileUploadDto> fileUploadDtoList = new ArrayList<>();

        multipartFileList.stream()
                .filter(multipartFile -> !multipartFile.isEmpty())
                .collect(Collectors.toList())
                .forEach(multipartFile -> fileUploadDtoList.add(storeFile(multipartFile)));

        return fileUploadDtoList;
    }

    public FileUploadDto storeFile(MultipartFile multipartFile) {

        String originalFilename = multipartFile.getOriginalFilename();
        String storeFileName = createStoreName(originalFilename);
        try {
            multipartFile.transferTo(new File(fileDir + storeFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileUploadDto fileUploadDto = FileUploadDto.builder()
                .uploadName(originalFilename)
                .storeName(storeFileName)
                .build();

        return fileUploadDto;
    }

    private String createStoreName(String originalFileName) {
        String ext = extractExt(originalFileName);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }

    private String extractExt(String originalFileName) {
        int pos = originalFileName.lastIndexOf(".");
        return originalFileName.substring(pos + 1);
    }
}
