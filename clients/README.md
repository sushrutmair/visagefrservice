# Visage.FR Clients

![Visage.FR Logo]((https://raw.githubusercontent.com/sushrutmair/visagefrservice/main/logo_small.png))

This repo hosts clients of the Visage.FR service:
* clients/java/__javaclient__ - A __JAVA__ client. This is the most full featured client (compared to the others) using which you can explore the service as well as build automation tests. Needs JDK/JRE 11 installed (openjdk 11.0.9 2020-10-20).

* clients/__python3__ - A simple __Python__ client. Shows how to use the requests module to make a Visage.FR face recognition call. Needs Python 3.6+ minimum and requests module v2.22.0.

* clients/__csharp__ - A simple __C#__ client. It also includes a project file + a VSCode dir, in case you want to reuse it. However, you can get by using only the .cs file to build and run in your development / test environment. Needs NET Core v3.1.403 minimum and Flurl.Http v3.0.0.



In case you do not want to program clients right away, you can use one of the following methods to interact with the Visage.FR service.

* clients/__cURL__ -  A few examples showing how to use cURL to invoke the Visage.FR face recognition functionality. 