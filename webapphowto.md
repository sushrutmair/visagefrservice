## Using the Visage.FR Web Application

##### Notes (Read this first!):
* In some screen shots, the lower part of the webpage has been cropped so we can focus on the relevant portions for each step.
* You must provide exactly 2 images as input. No more, no less.
* Supported image types are: JPEG/JPG, PNG and BMP. Other types should work but have not been tested.
* Each image cannot be more than 3 MB in size. In other words, Visage.FR allows a single image to be upto 3 MB in size.
* Visage.FR works best when the faces in the images are frontal, clear and not too low-res. If the image is very large, it needs proportionally larger face sizes in it.
* If you do not have images handy, [here](https://github.com/sushrutmair/visagefrservice/tree/main/clients/testimages) are some to help out!


##### Steps to use the Visage.FR web application:

1. Navigate to the Visage.FR web application [here](https://vfr050-yfc6eivsqq-ue.a.run.app/webapp).

2. You should see the page as shown below. Click on POST (red arrow).

![Step 2](https://github.com/sushrutmair/visagefrservice/blob/main/webappflow/2.jpg)

3. The POST area will now expand and you should see more details. Click on 'Try it Out'.

![Step 3](https://github.com/sushrutmair/visagefrservice/blob/main/webappflow/3.jpg)

4. You should see the below. The 'Add item' button is of interest to us. This button allows us to upload the images to the Visage.FR service.

![Step 4](https://github.com/sushrutmair/visagefrservice/blob/main/webappflow/4.jpg)

5. Click on 'Add item' button TWICE. If this is properly done, the web page should look like below.

![Step 5](https://github.com/sushrutmair/visagefrservice/blob/main/webappflow/5.jpg)

6. Now it is time to upload our images. Click on the first 'Choose File' button. After clicking you will get your OSes 'File Open' dialog and you should select the source image you have. The source image is the image having the known face. Here it is 'Barrack Obama.jpg'. Click on 'Open' in the dialog.

![Step 6](https://github.com/sushrutmair/visagefrservice/blob/main/webappflow/6.jpg)

7. Click on the second 'Choose File' button. The same dialog opens and you should now select the target image. The target image is the image that has unknown faces. Here it is 'u5.jpg'. We are trying to find out if the face in the source image is also appearing in the target image. (The screenshot for the second 'Choose File' flow is not shown as it is more or less similar to the above).

8. At this stage you have selected both images and the web app page should look like this. You would also have noted the 'Execute' button. We are about to use it.

![Step 8](https://github.com/sushrutmair/visagefrservice/blob/main/webappflow/8.jpg)

9. Now click on Execute. Once done, the web app will take both images, upload them to the Visage.FR service, trigger a face recognition request and return back with the results. While the computation is going on, you should see the following screen (after clicking on Execute). Note the 'Loading' indicator which tells you that the service is working and also note the 'Response' section. This section is where the Visage.FR service's response is available after the computation is done and the result is returned back to our browser.

![Step 9](https://github.com/sushrutmair/visagefrservice/blob/main/webappflow/9.jpg)

10. Once a result has been returned, you should see the below (you will need to scroll the web page down). The screenshot explains what you are seeing. Congratulations! You have successfully used the Visage.FR service! A few words on the results: If you are not a programmer, do not worry about interpreting the Location data. All you should focus on is whether there is a match or not. The locations are just the location of the matched face(s) in the source and target image. It is useful for programmers in case they want to extract those faces to use elsewhere or draw over them for visual indication.

Don't forget to read the FAQ's below.


![Step 10](https://github.com/sushrutmair/visagefrservice/blob/main/webappflow/10.jpg)



### FAQ's:

#### I do not have images of my own. Can you provide some?
Sure. Just head over to this [folder](https://github.com/sushrutmair/visagefrservice/tree/main/clients/testimages). You can download them locally and use them to try Visage.FR out.

#### What other results are possible?
Check [this](https://github.com/sushrutmair/visagefrservice/blob/main/results_interpret.md). It shows all the possible results from Visage.FR and their meanings. It is a general listing and not only for programmers.

#### I am not getting a match even though I should. What's up?
On the main Visage.FR [page](https://github.com/sushrutmair/visagefrservice), read the answer to the question 'Does Visage.FR impose any limitations on the inputs?' If you still feel something is amiss, feel free to contact us or file a bug. A bug can be filed using the 'Issues' tab above.
