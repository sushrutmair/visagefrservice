package com.visagefr.client;

/**
 * A simple encapsulation of the actual REST API's response object.
 * Makes it easy to sguffle it around classes and threads.
 */
public class VisageFR_v1_Response {
   
    private int responseCode;
    private String responseBody;

    public void setCode(int code){
        responseCode = code;
    }

    public void setBody(String body){
        responseBody = body;
    }

    public int getCode(){
        return responseCode;
    }

    public String getBody(){
        return responseBody;
    }

}
