package com.example.Project.WordGeneration.Data;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ReadData {
    public static ReadData rd=null;
    private static HashMap<String,Integer> hashMap= new HashMap<String,Integer>();

    private ReadData()
    {

    }

    public static ReadData getInstance()
    {

        if(rd==null)
        {
            rd= new ReadData();
        }
        return rd;
    }

    public void readJson()
    {

    }
}
