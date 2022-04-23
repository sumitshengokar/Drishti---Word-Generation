package com.example.Project.WordGeneration.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Component
public class WordService {

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${dictionary.path}")
    private String path;

    private static HashSet<String> hashSet= new HashSet<String>();

    private JsonNode jsonNode=null;
    public void readJson()
    {
        File jsonFile = new File(path).getAbsoluteFile();

        try {
            jsonNode=objectMapper.readTree(jsonFile);
        } catch (JsonProcessingException e ) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Iterator<String> itr = jsonNode.fieldNames();
        while(itr.hasNext())
        {
//            System.out.println(itr.next());
            hashSet.add(itr.next());
        }
        System.out.println("Running! Stored Data into the data structure by reading JSON File");
    }

    public boolean isContains(String str)
    {
        if(hashSet.contains(str)==true)
        {
            return true;
        }
        return false;
    }

    public HashSet<String> generateStrings(String word1, String word2) {
        HashSet<String> res = new HashSet<String>();
        int prefix=0,suffix=word2.length();
        for(int i=0;i<word1.length();i++)
        {
            String pre = word1.substring(prefix,i+1);
            for(int j=word2.length()-1;j>=0;j--)
            {
                String suff = word2.substring(j,suffix);
                String temp=pre+suff;
                System.out.println("prefix is "+pre + " suffix "+suff);
                if(isContains(temp)==true)
                {
                    res.add(temp);
                }
            }

        }
        return res;
    }
}
