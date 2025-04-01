package com.example.java_sql_connect.BasicControllers;

import com.example.java_sql_connect.Entities.LimitRules;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BaseController {


    public static Map<String, Object> sucessMeta(List<LimitRules> rules){
        Map<String,Object> meta=new LinkedHashMap<>();
        meta.put("Code",000);
        meta.put("Description","Succesfully executed");
        meta.put("Status",0);

        Map<String, Object> data=new LinkedHashMap<>();
        data.put("Data", rules);
        Map<String, Object> response=new LinkedHashMap<>();
        response.put("meta",meta);
        response.put("data",data);

        return response;
    }
    public static Map<String, Object> sucessMeta2(){
        Map<String,Object> meta=new LinkedHashMap<>();
        meta.put("Code",000);
        meta.put("Description","Succesfully executed");
        meta.put("Status",0);

        Map<String, Object> data=new LinkedHashMap<>();
        data.put("isSuccessful",true);
        Map<String, Object> response=new LinkedHashMap<>();
        response.put("meta",meta);
        response.put("data",data);

        return response;
    }
    public static Map<String, Object> failure(){
        Map<String,Object> meta=new LinkedHashMap<>();
        meta.put("Code",404);
        meta.put("Description","NOT ABLE TO EXECUTE ");
        meta.put("Status",0);

        Map<String, Object> data=new LinkedHashMap<>();
        data.put("isSuccessful",false);
        Map<String, Object> response=new LinkedHashMap<>();
        response.put("meta",meta);
        response.put("data",data);

        return response;
    }

    public static Map<String, Object> alreadyExistMeta(){
        Map<String,Object> meta=new LinkedHashMap<>();
        meta.put("code", "1045");
        meta.put("description", "RULECODE ALREADY EXISTS");
        meta.put("status", 0);

        Map<String, Object> data=new LinkedHashMap<>();
        data.put("isSuccessful",false);
        Map<String,Object> response1=new LinkedHashMap<>();
        response1.put("meta",meta);
        response1.put("data",data);
        return response1;
    }
    public static Map<String, Object> deleteMeta(){
        Map<String,Object> meta=new LinkedHashMap<>();
        meta.put("Code","000");
        meta.put("Description","Successfully executed");
        meta.put("Status",0);
        meta.put("EXECUTION","DATA DELETED SUCCESSFULLY");
        Map<String,Object> data=new LinkedHashMap<>();
        data.put("isSuccessful",true);
        Map<String,Object> response2=new LinkedHashMap<>();
        response2.put("meta",meta);
        response2.put("data",data);
        return response2;
    }

    public static Map<String, Object> updateMeta(){
        Map<String,Object> meta=new LinkedHashMap<>();
        meta.put("Code","000");
        meta.put("Description","Successfully executed");
        meta.put("Status",0);
        meta.put("EXECUTION","DATA UPDATED SUCCESSFULLY");
        Map<String,Object> data=new LinkedHashMap<>();
        data.put("isSuccessful",true);
        Map<String,Object> response2=new LinkedHashMap<>();
        response2.put("meta",meta);
        response2.put("data",data);
        return response2;
    }
}