package com.visagefr.client;

/**
 * Main entrypoint for the client code. Test scenarios are coded in separate methods and
 * are called from Main. You can combine test scenarios or run them on their own. Just
 * ensure that your system has enough resources to run those.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Test Visage FR Service!");

        /**
         * Set the Visage.FR server URL
         */
        String srvUrl1 = "https://vfr050-yfc6eivsqq-ue.a.run.app/visagefr/v1.0/fr"; //cloud server

        /**
         * Now you can call the tests. The methods below testScenario*(..) all encapsulate a
         * range of test conditions. Feel free to experiment with it in your local repo.
         */
        testScenario1(srvUrl1);

        try {
            testScenario3(srvUrl1);
            testScenario2(srvUrl1);
        } catch (InterruptedException e) {
            System.out.println("Error - exception in testScenario2/3");
            e.printStackTrace();
        }

    }

    /**
     * Various Test Scenarios follow to give an idea of how the service can be tested.
     * The key steps are: a) Create an instance of ConcurrentVfrClients b) call its prepare
     * method which allows you to specify a server Url and a source + target image each.
     * You can also provide how many concurrent requests you want to send after what kind of
     * delay c) Call the post request method and you are done. This call is non blocking. The
     * post method internally will print the Visage.FR service's response to the console.
     * If you are interested in the HTTP Response itself, you can go deeper into the various
     * classes and change / update per your needs.
     * 
     */

    private static void testScenario1(String srvUrl){

        /**
         * vfrClient1 spawns reqConc1 concurrent requests and waits delay1 sec
         * before POSTing. At end of delay1 seconds, all reqConc1 are POSTed to
         * the endpoint at srvUrl. You can use this to setup a variety of testing
         * scenarios. See next sets for other combinations.
         */
        //Example 1 - Should find 1 match in these images.
        {
            System.out.println("********    1st Example Setup Start.   ********");
            Integer reqConc1 = 10;
            Integer delay1 = 1;
            ConcurrentVfrClients vfrClient1 = new ConcurrentVfrClients();
            if(vfrClient1.prepareClients(srvUrl, 
                "testimages/bp1.jpg", 
                "testimages/bp2.jpg", 
                reqConc1, delay1)) {
                    vfrClient1.postRequests();
                }
            System.out.println("********    1st Example Setup End.   ********");
            }
    
            //Example 2 - Should find 2 matches in these images
            {
            System.out.println("********    2nd Example Setup Start.   ********");
            Integer reqConc2 = 30;
            Integer delay2 = 5;
            ConcurrentVfrClients vfrClient2 = new ConcurrentVfrClients();
            if(vfrClient2.prepareClients(srvUrl, 
                "testimages/ag1.jpg", 
                "testimages/ag5.jpg", 
                reqConc2, delay2)) {
                    vfrClient2.postRequests();
                }
            System.out.println("********    2nd Example Setup End.   ********");
            }
    
            //Example 3 - No matches should be seen in these two images.
            {
            System.out.println("********    3rd Example Setup Start.   ********");
            Integer reqConc3 = 100;
            Integer delay3 = 7;
            ConcurrentVfrClients vfrClient3 = new ConcurrentVfrClients();
            if(vfrClient3.prepareClients(srvUrl, 
                "testimages/u2.jpg", 
                "testimages/ws3.jpg", 
                reqConc3, delay3)) {
                    vfrClient3.postRequests();
                }
            System.out.println("********    3rd Example Setup End.   ********");
            }

    }

    private static void testScenario2(String srvUrl) throws InterruptedException {

        /**
         * Shows how you can simulate a slow burn rate of POST requests to the server.
         * Here you keep concurrency to 1 (so that the ConcurrentVfrClients class creates
         * only a single thread), give 0 delay (immediate send of the request on calling
         * of postRequests). We do this multiple times in a loop to simulate a lot diff-
         * erent clients calling the service from a single IP.
         */
        System.out.println("********    Test Scenario 2 Setup Start.   ********");
        Integer reqConc3 = 1;
        Integer delay3 = 0;
        Integer clients = 200;
        for(int x=0; x<clients;x++){
            ConcurrentVfrClients vfrClient3 = new ConcurrentVfrClients();
            if(vfrClient3.prepareClients(srvUrl, 
                "testimages/jc-cw1.jpg", 
                "testimages/cw1.jpeg", 
                reqConc3, delay3)) {
                    vfrClient3.postRequests();
                    Thread.sleep(3000);
            }
        }
        
        System.out.println("********    Test Scenario 2 Setup End.   ********");

    }

    private static void testScenario3(String srvUrl) throws InterruptedException {

        /**
         * Similar to testScenario2, just differs in timings of the calls.
         */

        System.out.println("********    Test Scenario 3 Setup Start.   ********");
        Integer reqConc3 = 1;
        Integer delay3 = 0;
        Integer clients = 250;
        for(int x=0; x<clients;x++){
            ConcurrentVfrClients vfrClient3 = new ConcurrentVfrClients();
            if(vfrClient3.prepareClients(srvUrl, 
                "testimages/sd1.jpg", 
                "testimages/nm-sd1.jpg", 
                reqConc3, delay3)) {
                    vfrClient3.postRequests();
                    Thread.sleep(750);
            }
        }
        
        System.out.println("********    Test Scenario 3 Setup End.   ********");

    }
}
