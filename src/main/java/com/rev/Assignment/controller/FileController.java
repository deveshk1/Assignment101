package com.rev.Assignment.controller;

import com.rev.Assignment.Main;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FileController {


    @PostMapping("/single")
    public ResponseEntity single(@RequestParam("file") MultipartFile file) throws IOException {
        String fName = StringUtils.cleanPath(file.getOriginalFilename());
        //Path path = Paths.get(String.valueOf(Path.of(fName))+fName);
        String fileBasePath = "res/files/";
        Path path = Paths.get(fileBasePath + fName);

        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        File f = new File(path.toString());
        File compressedFile = new Main().FileRead(f);

        // System.out.println("-->"+path.toString());
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/")
                .path(compressedFile.getName())
                .toUriString();

        return ResponseEntity.ok(fileDownloadUri);

    }

    @PostMapping("/multi")
    public ResponseEntity upload(@RequestParam("files") MultipartFile[] files) throws IOException {

        List<Object> fileUrl = new ArrayList<>();

//    for (MultipartFile file : Arrays.asList(files)) {
//        fileUrl.add(single(file).getBody());
//    }

        String fileBasePath = "res/files/";
        for (MultipartFile f : Arrays.asList(files)) {
            File file = new File(fileBasePath + f.getOriginalFilename());
            f.transferTo(file);
        }
        System.out.println("--len" + files.length);
        return ResponseEntity.ok(fileUrl);
    }


}
