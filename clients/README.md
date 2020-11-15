# Visage.FR Clients


![Visage.FR Logo](https://raw.githubusercontent.com/sushrutmair/visagefrservice/main/logo_small.png)


##### Notes (Read this first!):
* The code below assumes a path to the testimages locally (see testimages dir in this same 'clients' folder). You might need to modify it, especially when running it from inside an IDE.
* In some screen shots, the lower part of the webpage has been cropped so we can focus on the relevant portions for each step.
* You must provide exactly 2 images as input. No more, no less.
* Supported image types are: JPEG/JPG, PNG and BMP. Other types should work but have not been tested.
* Each image cannot be more than 3 MB in size. In other words, Visage.FR allows a single image to be upto 3 MB in size.
* Visage.FR works best when the faces in the images are frontal, clear and not too low-res. If the image is very large, it needs proportionally larger face sizes in it.
* If you do not have images handy, [here](https://github.com/sushrutmair/visagefrservice/tree/main/clients/testimages) are some to help out!


This repo hosts clients of the Visage.FR service:
* clients/java/__javaclient__ - A __JAVA__ client. This is the most full featured client (compared to the others) using which you can explore the service as well as build automation tests. Needs JDK/JRE 11 installed (openjdk 11.0.9 2020-10-20). App.java is the main file and it calls the ConcurrentVfrClients class which is just a wrapper to handle concurrent requests. If you do not need all this, look at VisageFR_v1_client.java file - this is the class that actually posts to the Visage.FR service.

* clients/__python3__ - A simple __Python__ client. Shows how to use the requests module to make a Visage.FR face recognition call. Needs Python 3.6+ minimum and requests module v2.22.0. This is a very straightforward code and easy to understand.

* clients/__csharp__ - A simple __C#__ client. It also includes a project file + a VSCode dir, in case you want to reuse it. However, you can get by using only the .cs file to build and run in your development / test environment. Needs NET Core v3.1.403 minimum and Flurl.Http v3.0.0. Again, extremely simple to use.



In case you do not want to program clients right away, you can use one of the following methods to interact with the Visage.FR service.

* clients/__cURL__ -  A few examples showing how to use cURL to invoke the Visage.FR face recognition functionality.

* the web app - See [this](https://github.com/sushrutmair/visagefrservice/blob/main/webapphowto.md)

If you are looking for the Open API 3.0 spec, get it [here](https://vfr050-yfc6eivsqq-ue.a.run.app/visagefr/v1.0/openapi.json). A note here: Not all of the custom results are spec'd out yet (primarily for HTTP results 200 and 500).
