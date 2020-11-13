package com.visagefr.client;

/**
 * Implements the threaded VFR REST API client.
 * 
 */
public class ThreadedVfrClient extends Thread {

    private String serverUrl;
    private String srcimg;
    private String tgtimg;
    private Integer delay;

    public void ThreadedVfrClient() {
        serverUrl = "";
        srcimg = "";
        tgtimg = "";
    }

    /**
     * 
     * @param url        - serverUrl URL of the Visage FR server's REST endpoint to
     *                   trigger face recognition
     * @param srcimgpath - full path to source image
     * @param tgtimgpath - full path to target image
     * @param timeDelay  - time to pause before POST request, in seconds
     */
    public void setRuntimeArgs(String url, String srcimgpath, String tgtimgpath, Integer timeDelay) {
        serverUrl = url;
        srcimg = srcimgpath;
        tgtimg = tgtimgpath;
        delay = timeDelay;
    }

    /**
     * Runs the thread for this request. The thread takes in the passed in details
     * from object creation (server url, src img path, tgt img path), and tries to
     * call the server's face recognition REST API call. Once the call returns, the
     * response is captured and printed out to the console. It is mandatory to set
     * runtime arguments before calling the thread's run method.
     */
    public void run() {
        String myName = Thread.currentThread().getName();

        if (serverUrl.isEmpty() || srcimg.isEmpty() || tgtimg.isEmpty()) {
            System.out.println("Thread::" + myName + ": Error - Runtime args are not set");
            return;
        }

        try
        {
            Thread.sleep(delay*1000);
            VisageFR_v1_client clientInstance = new VisageFR_v1_client();
            VisageFR_v1_Response resp = clientInstance.uploadFiles(serverUrl, srcimg, tgtimg);
            showResponse(resp, myName);
        }
        catch (Exception ex) {
            System.out.println("Thread::" + myName + ": Error - Exception during uploading files.");
            System.out.println(ex.getMessage() + ex.getStackTrace().toString());
        }

        System.out.println("Thread::" + myName + ": Exiting thread.");
    }

    private void showResponse(VisageFR_v1_Response resp, String myName) {
        System.out.println("Thread::" + myName + ": Response HTTP Code and Body, for: " + srcimg + 
        " and: " + tgtimg);
        System.out.println("    Thread::" + myName + ": HTTP Response Code: " + resp.getCode());
        System.out.println("    Thread::" + myName + ": HTTP Response Body: \n"+ resp.getBody());
    }
}
