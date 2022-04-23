package com.example.Project.WordGeneration.helper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class ResponseHandler {


    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object data)
    {
        HashMap<String,Object> hm= new HashMap<String,Object>();
        hm.put("Words",data);
        hm.put("message",message);
        hm.put("Status",status);


        return new ResponseEntity<Object>(hm,status);
    }
}
