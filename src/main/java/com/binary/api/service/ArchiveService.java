package com.binary.api.service;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArchiveService {

    public ResponseEntity returnArchive(String filePath) throws IOException {
        File file2Upload = new File(filePath);
        int lastIndxBar = filePath.lastIndexOf('/');
        StringBuilder contentDisposition = new StringBuilder("attachment; filename=").append(filePath.substring(lastIndxBar + 1));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add(HttpHeaders.CONTENT_DISPOSITION, contentDisposition.toString());

        Path path = Paths.get(file2Upload.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file2Upload.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }

    public List<String> getPathFiles(String folderPath) {
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();
        List<String> files = new ArrayList<>();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                StringBuilder builder = new StringBuilder(folderPath);
                builder.append("/").append(file.getName());
                System.out.println(builder.toString());
                files.add(file.getName());
            }
        }
        return files;
    }

}
