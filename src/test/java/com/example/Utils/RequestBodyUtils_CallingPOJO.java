package com.example.Utils;
import com.example.POJO.Friends_CallmePOJO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class RequestBodyUtils_CallingPOJO {

    static ObjectMapper objectMapper=new ObjectMapper();
    //ObjectMapper is a class of Jakson library
    public static String CreateBodyForFriend_withPojo() throws JsonProcessingException {
        Friends_CallmePOJO friend=new Friends_CallmePOJO(1, "post_with_json_shcema", "pojo_lastname", 65, "pojo@pojo.com");


        //(serializing) friend object is a java object  -> with the help of objectMapper object -> get s converted to JSON string

        return objectMapper.writeValueAsString(friend);
    }

}

