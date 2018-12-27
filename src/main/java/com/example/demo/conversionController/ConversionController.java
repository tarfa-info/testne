package com.example.demo.conversionController;

import com.example.demo.converionService.ConverionService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@RestController
public class ConversionController   {

    @Autowired
    private ConverionService converionService;
    List<String> files = new ArrayList<String>();

    @CrossOrigin("*")
    @GetMapping("/")
    private String index() {
        return "works";
    }


    @Async
    @JsonFormat
    @CrossOrigin("*")
    @PostMapping("/upload")
    public CompletableFuture<Map<String, String>> startConversion(@RequestParam MultipartFile file) throws InterruptedException, ExecutionException {
         Map<String, String> value =converionService.store(file);
         return CompletableFuture.completedFuture(value);
    }



}
