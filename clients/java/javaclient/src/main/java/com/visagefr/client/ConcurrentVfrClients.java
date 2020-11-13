package com.visagefr.client;

import java.util.ArrayList;

/**
 * Encapsulates a mechanism to make concurrent calls to the VFR service.
 * Achieves this via multithreading. Uses VisageFr_v1_client class. The job of
 * this class is to make n concurrent calls to the Visage FR service. It can be
 * configured for concurrency limits, delays and load testing.
 */
public class ConcurrentVfrClients {

    private String serverUrl;
    private String sourceImg;
    private String targetImg;
    private Integer concurrencyFactor;
    private Integer timeDelayPerReq;

    private ArrayList<ThreadedVfrClient> clientInstances;

    /**
     * 
     * @param srvUrl - Visage FR service endpoint url
     * @param srcImg - source image
     * @param tgtImg - target image
     * @param concurrency - how many requests to send in parallel
     * @param timeDelay - delay in secs before starting upload. If 0, no delay is injected.
     * @return True/False - if False, should not proceed without fixing the issue.
     */
    public Boolean prepareClients(String srvUrl, String srcImg, String tgtImg,
        Integer concurrency, Integer timeDelay){
        if(srvUrl.isEmpty() || srcImg.isEmpty() || tgtImg.isEmpty())
            return false;
        serverUrl = srvUrl;
        sourceImg = srcImg;
        targetImg = tgtImg;
        concurrencyFactor = concurrency;
        timeDelayPerReq = timeDelay;

        if(concurrencyFactor <= 1)
            concurrencyFactor = 1;

        try
        {
            clientInstances = new ArrayList<ThreadedVfrClient>(concurrencyFactor);
            for(int i=0; i<concurrencyFactor;i++)
            {
                ThreadedVfrClient clientInstance = new ThreadedVfrClient();
                clientInstance.setRuntimeArgs(serverUrl,sourceImg,targetImg, timeDelayPerReq);
                clientInstances.add(clientInstance);
            }
        }
        catch(Exception ex){
            System.out.println("Error - Exception in preparing client instances. " + 
                ex.getMessage());
            return false;
        }

        return true;
    }

    /**
     * 
     * @return - True / False indicating success / failure. Non blocking call.
     */
    public Boolean postRequests(){

        if(clientInstances.size()<=0)
            return false;
        
        try
        {
            for(int j = 0; j<concurrencyFactor; j++){
                clientInstances.get(j).start();
            }
        }
        catch(Exception ex){
            System.out.println("Error - Exception in posting requests. " + 
                ex.getMessage());
            return false;
        }

        return true;

    }
}