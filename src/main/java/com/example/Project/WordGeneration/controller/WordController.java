package com.example.Project.WordGeneration.controller;

import com.example.Project.WordGeneration.helper.ResponseHandler;
import com.example.Project.WordGeneration.service.WordService;
import org.apache.catalina.LifecycleState;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;

@RestController
public class WordController {

    @Autowired
    private WordService wordService;

    @GetMapping(value = "/api/{word1}/{word2}")
    public ResponseEntity<Object> getData(@PathVariable String word1,@PathVariable  String word2)
    {
        HashSet<String> l = wordService.generateStrings(word1,word2);
        if(l.size()==0)
        {
            return ResponseHandler.generateResponse("No words found", HttpStatus.BAD_REQUEST,null);
        }
        else
        {
            return ResponseHandler.generateResponse("Data found",HttpStatus.OK,l);
        }
    }
}
