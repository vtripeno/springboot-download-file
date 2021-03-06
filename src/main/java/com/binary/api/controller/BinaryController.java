package com.binary.api.controller;

import com.binary.api.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class BinaryController {

    @Value("${file.location}")
    private String path;

    @Autowired
    private ArchiveService archiveService;

    @RequestMapping(value = "/file", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    ResponseEntity getFile(
            @RequestParam(value = "type", required = true) String type,
            @RequestParam(value = "file", required = true) String file) throws IOException {
        StringBuilder builder = new StringBuilder(path)
                .append(type)
                .append("/")
                .append(file);
        return archiveService.returnArchive(builder.toString());
    }

    @RequestMapping(value = "/paths", method = RequestMethod.GET)
    @ResponseBody
    public List<String> getPaths(@RequestParam(value = "type", required = true) String type) {
        System.out.println(path);
        StringBuilder builder = new StringBuilder(path).append(type);
        return archiveService.getPathFiles(builder.toString());
    }
}
