/**
 * Author: Sushrut J Mair, Oct 2020.
 */
package com.visagefr.client;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * The main class that exercises the Visage FR service. As of v0.5.0 (of Visage FR
 * service), there is a single REST API supported that allows face recognition 
 * between two images uploaded to the server. 
 * Use an instance of this class for each request. You can reuse the instance if
 * needed.
 */
public class VisageFR_v1_client {
    
    /**
     * 
     * @param serverUrl URL of the Visage FR server's REST endpoint to trigger face recognition
     * @param file1path source image full path
     * @param file2path target image full path
     * @return A VisageFR_v1_Response that contains POJO versions of the server's response.
     */
    public VisageFR_v1_Response uploadFiles(String serverUrl, String file1path, String file2path) {

        //create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        //specify files (images) to be uploaded in the body
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("files", getTestFile(file1path));
        body.add("files", getTestFile(file2path));

        //form the overall req and post it
        HttpEntity<MultiValueMap<String, Object>> requestEntity
             = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.postForEntity(
            serverUrl, requestEntity, String.class);

        return translateResponse(response);
        
    }

    /**
     * Converts the image file to a FileSystemResource type
     * @param filenamepath - full path to the image
     * @return a FileSystemResource type of the image file
     */
    private FileSystemResource getTestFile(String filenamepath){
        return new FileSystemResource(filenamepath);
    }

    /**
     * Translates the Server Response to a local type
     * 
     * @param response - HTTP Response object returned by the Visage.FR server
     * @return - object of type VisageFR_v1_Response converting the HTTP Response
     * to a simpler POJO object where the response body can be treated as JSON.
     */
    private VisageFR_v1_Response translateResponse(ResponseEntity<String> response){

        VisageFR_v1_Response appResponse = null;

        if(response!=null){
            appResponse = new VisageFR_v1_Response();

            appResponse.setCode(response.getStatusCodeValue());
            appResponse.setBody(response.getBody()); //is JSON
        }

        return appResponse;

    }
}
