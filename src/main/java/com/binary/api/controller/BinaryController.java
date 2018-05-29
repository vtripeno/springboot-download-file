package com.binary.api.controller;

import com.binary.api.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class BinaryController {

    @Autowired
    private ArchiveService archiveService;

    @RequestMapping(value = "/binary", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ByteArrayResource> getByte() throws IOException {

        return archiveService.returnArchive();
    }
}
