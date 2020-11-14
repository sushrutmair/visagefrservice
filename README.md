# The Visage.FR Face Recognition Service


![Visage.FR Logo](https://raw.githubusercontent.com/sushrutmair/visagefrservice/main/logo_small.png)



### Privacy First. Fast and Easy Face Recognition for any application! 

### No sign-up / registration needed!

### And it's !! FREE !!

---

## About Visage.FR

Visage.FR is a publically available cloud service that allows you to build face recognition into any type of application. It guarantees privacy of your data by a) not requesting uneeded information, b) not asking for any PII (Personally Identifiable Information) like names or even labels, and c) maintaining ephemeral environments for each request and destroying them as soon as the request has been processed.

### What is face recognition? Why should I be excited about it?

Face recognition is the ability to match a human face to various unknown faces. It opens up a plethora of use cases:
 - Have 1000s of personal photos? Only want to retain photos having certain people and delete the rest? Use Visage.FR!
 - Build a system that can unlock your front door by just looking at your face!
 - Find friends or family in long forgotten trip / meet  photos!
 - Build an entry system that only allows certain people to enter a specific area.
 - Build an ID verification system that allows you to confirm someone's identity.
 - Recognize faces in a video (livestream or from a file)!
 - ... and many more! Use your imagination!

### Sounds interesting. Tell me more about how you guarantee privacy?

By way of input all Visage.FR needs are two images. Other face recognition services typically store the images and derived data on their servers (at least for sometime if not permanently). Visage.FR does nothing of this sort. As soon as you receive the service's response, you can be assured that all your data in the service has been destroyed. Visage.FR has been designed from the ground up with privacy as one of the primary driving goals.

### Cool. Does this affect the quality and responsiveness of Visage.FR?

No. Visage.FR is very fast and strives to beat, or be at par with other free as well as commercial face recognition solutions in the market.

### This all sounds too good to be true. What's the catch?

There's a catch. Yep. And here it is: Since we give away the service for free, we need to ensure that our cloud operational costs are kept as low as possible. How does this affect you? In two ways: 1) At times, you might see a slower response in the first request you make (~8-10 sec). This is because the service is kept dormant until it starts seeing requests and the first request bears the brunt of that cold start. Subsequent requests are blazingly fast. 2) The service scalability is artificially throttled (somewhat). You might get a HTTP response that says something like, "Service capacity consumed for now. Please try in a few hours." The service is smart enough to auto-scale its capacity (driven by a goal to lower costs) and after sometime your requests are again served.

### Are the limits above baked into Visage.FR? What if my use case requires more scale than what is available?

Visage.FR is highly scalable. The limits above are artificial and to remove them is just a configuration on the cloud service. Please get in touch with us at *visagefr* at *gmail* dot *com*. To avoid getting signed up by bots, the email id is somewhat obfuscated. Should be easy to reconstruct it. Or you can also hit up the creator of Visage.FR at LinkedIn [here](https://in.linkedin.com/in/sushrut-mair-3769b62). Please do include brief details about yourself and a brief note on how you want to use Visage.FR.

### I want to take Visage.FR for a spin but I am not a programmer. Can you help?

Yes, of course. Visage.FR ships with a simple integrated web application that non programmers (or programmers wanting to sample it) can use. [Here](https://github.com/sushrutmair/visagefrservice/blob/main/webapphowto.md) is an easy pictorial guide that shows you how to use that web application. In fact, we usually suggest first timers to use the web app irrespective of whether they are programmers or not. Plese do go through the section titled 'Understanding Visage.FR results and behavior' before using it.

### I want to try on images other than my own. Would you have any?

Yes. Just look into our [test images folder](https://github.com/sushrutmair/visagefrservice/tree/main/clients/testimages) and you can use any from within that!

### I have a custom request for an application on top of Visage.FR. Can you  help?

Of course. Just drop us a line at *visagefr* at *gmail* dot *com*. To avoid getting signed up by bots, the email id is somewhat obfuscated. Should be easy to reconstruct it. Or you can also hit up the creator of Visage.FR at LinkedIn [here](https://in.linkedin.com/in/sushrut-mair-3769b62). Please do include brief details about yourself and a brief note on how you want to use Visage.FR.

### I think I may have found a bug in Visage.FR. What next?

Let us know! File a bug by using the 'Issues' tab above.

## Understanding Visage.FR results and behavior

### What inputs does Visage.FR ask for?

Visage.FR requires 2 images as input. One is the source image: the image that contains one or more known faces (known to you or your application). The second image is the target image: it contains one or more unknown faces, i.e., faces that you want to recognize. Once you send these to Visage.FR, it attempts to match faces in the known image with faces in the unknown image.

### How do I send the inputs to Visage.FR?

If you are not a programmer, the web application is a very quick and easy way to try Visage.FR. Any one can use it without any knowledge of programming! A quick tutorial on the webapp is available [here](https://github.com/sushrutmair/visagefrservice/blob/main/webapphowto.md).

If you are a programmer, look at the section below titled, 'For developers wanting to integrate Visage.FR into their own applications'.

### What are Visage.FR's outputs?

Visage.FR returns a result for each request you send to it. The result indicates: a) whether or not a match was found, and, b) if a match (or multiple matchs) have been found, the locations in both images for all the matches. The locations are just co-ordinates in the images where the matching faces have been found. You can use the locations to crop or build a bounding box in the images to visually show matches.

This [page](https://github.com/sushrutmair/visagefrservice/blob/main/results_interpret.md) gives more details on all of the possible results from Visage.FR and their meaning.

### Does Visage.FR impose any limitations on the inputs?

Visage.FR strives to be as reasonable as possible in restricting inputs. Here they are:
* You must provide exactly 2 images as input. No more, no less.
* Supported image types are: JPEG/JPG, PNG and BMP. Other types should work but have not been tested.
* Each image cannot be more than 3 MB in size. In other words, as long as both images are < 3 MB in size, Visage.FR will process them.
* Visage.FR works best when the faces in the images are frontal, clear and not too low-res. If the image is very large, it needs proportionally larger face sizes in it.


## For developers wanting to integrate Visage.FR into their own applications

### I like it and want to try integrating Visage.FR with my application! Can you help?

Thought you would never ask. We have a bunch of working client applications available across multiple programming languages. In addition, we also have provided cURL command lines to call it. Just head over to the [clients](https://github.com/sushrutmair/visagefrservice/tree/main/clients) folder and you are good to go! We currently have a Java, C# and Python client that work seamlessly with the Visage.FR service!

Visage.FR is also OpenAPI 3.0 compliant. The README in the client folder has more details on where to get the spec.

### Can I call Visage.FR from any application?

Yes. You just need to confirm to the contract (the REST API). The best way to do this is use one of the existing client code. Feel free to copy / fork that code and use it in your applications (even commercial)!

### Can I call Visage.FR from a mobile application?

Yes, of course. While currently we have not shared a mobile client, the currently available clients are useful to understand how to call the Visage.FR service. If you are looking for the simplest client, try the Python client code.

### Can I call Visage.FR from within an embedded system?

Yes, as long as the system supports calling a HTTPS based cloud service (which most systems do nowadays). You can use either the Java or Python clients to test your embedded system with it (or write your own - just follow the pattern in the existing clients). (At some point in the future, we plan to showcase Visage.FR integration with a RPi based or similar board)

### Can Visage.FR recognize faces in a video?

Yes. For this to work, you would need to grab the frames from the video (it can also be a live streaming video). Send those frames (as images) to Visage.FR and you are done! When matches are found, Visage.FR also gives you the location of matched faces in the video. You can use something like OpenCV or PIL to draw bounding boxes on those faces in the video stream!
