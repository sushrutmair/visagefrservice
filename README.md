# The Visage.FR Face Recognition Service


![Visage.FR Logo](https://raw.githubusercontent.com/sushrutmair/visagefrservice/main/logo_small.png)



## Privacy First. Fast and Easy Face Recognition for any application! 

## No sign-up / registration needed!

## And it's !! FREE !!

---

## About Visage.FR

Visage.FR is a publically available cloud service that allows you to build face recognition into any type of application. It guarantees privacy of your data by a) not requesting uneeded information, b) not asking for any PII (Personally Identifiable Information) like names or even labels, and c) maintaining ephemeral environments for each request and destroying them as soon as the request has been processed.

### Sounds interesting. Tell me more about how you guarantee privacy?

Visage.FR has a single REST API that is to be called when you want to perform face recognition in your application. All that it needs is two images, one that has the face of interest (one that you want to recognize) and the other image that might have your face of interest. Other face recognition services typically store the faces and derived data on their servers (for sometime if not permanently). Visage.FR does nothing of this sort. As soon as you receive the REST API's response, you can be assured that all your data in the service has been destroyed.

### Cool. Does this affect the quality and responsiveness of Visage.FR?

No. Visage.FR is very fast and strives to beat, or be at par with other free as well as commercial face recognition solutions in the market.

### This all sounds too good to be true. What's the catch?

There's a catch. Yep. And here it is: Since we give away the service for free, we need to ensure that our cloud operational costs are kept as low as possible. How does this affect you? In two ways: 1) At times, you might see a slower response in the first request you make (~7-8 seconds, usually). This is because the service is kept dormant until it starts seeing requests and the first request bears the brunt of that cold start. Subsequent requests are blazingly fast. 2) The service scalability is artificially throttled (somewhat). You might get a HTTP response that says something like, "Service capacity consumed for now. Please try in a few hours." The service is smart enough to auto-scale its capacity (driven by a goal to lower costs) and after sometime your requests are again served.

### I want to take Visage.FR for a spin but I am not a programmer. Can you help?

Yes, of course. Visage.FR ships with a simple integrated web application that non programmers (or programmers wanting to sample it) can use. [Here](https://github.com/sushrutmair/visagefrservice/blob/main/webapphowto.md) is an easy pictorial guide that shows you how to use that web application. In fact, we usually suggest first timers to use the web app irrespective of whether they are programmers or not.

## For developers wanting to integrate Visage.FR into their own applications

### I like it and want to try integrating Visage.FR with my application! Can you help?

Thought you would never ask. We have a bunch of working client applications available across multiple programming languages. In addition, we also have provided cURL command lines to call it. Just head over to the [clients](https://github.com/sushrutmair/visagefrservice/tree/main/clients) folder and you are good to go! We currently have a Java, C# and Python client that work seamlessly with the Visage.FR service!

### Can I call Visage.FR from any application?

Yes. You just need to confirm to the contract (the REST API). The best way to do this is use one of the existing client code. Feel free to copy / fork that code and use it in your applications (even commercial)!

### Can I call Visage.FR from a mobile application?

Yes, of course. While currently we have not shared a mobile client, the currently available clients are useful to understand how to call the Visage.FR service. If you are looking for the simplest client, try the Python client code.

### Can I call Visage.FR from within an embedded system?

Yes, as long as the system supports calling a HTTPS based cloud service (which most systems do nowadays). You can use either the Java or Python clients to test your embedded system with it (or write your own - just follow the pattern in the existing clients). (At some point in the future, we plan to showcase Visage.FR integration with a RPi based or similar board)

