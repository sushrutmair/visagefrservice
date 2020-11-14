## Visage.FR Service results and interpretation:

Visage.FR's results would have the following HTTP Response code:
* 200 - this implies that the request was handled successfully.
* 400, 500 - this implies that an error was encountered.

A few screenshots have been also shown to give a better idea of the structure of the Response body.

### Response body under various conditions for HTTP Response 200:

1. One match is found:

![One match](https://github.com/sushrutmair/visagefrservice/blob/main/errscreens/200_1_match.jpg)

2. More than one match is found:

![Multiple matches](https://github.com/sushrutmair/visagefrservice/blob/main/errscreens/200_more1_match.jpg)

3. No match is found:

![No match](https://github.com/sushrutmair/visagefrservice/blob/main/errscreens/200_nomatch.jpg)

4. No match found because zero faces were found in at least one of the images:

![Zero faces](https://github.com/sushrutmair/visagefrservice/blob/main/errscreens/200_zerofaces.jpg)



### Response body under various conditions for HTTP Response 400, 500:

#### 400

1. Number of uploaded images was not 2 

![Not2_1](https://github.com/sushrutmair/visagefrservice/blob/main/errscreens/400_not_2.jpg)

![More_2](https://github.com/sushrutmair/visagefrservice/blob/main/errscreens/400_3_or_more.jpg)

2. Size of one or more images is > 3 MB 


| error | errstring |
|------ | ----------|
| "-1027" | "Max allowed file size exceeded. Allowed size upto: 3 MB"|


#### 500

3. There was a resource allocation error in the server

| error | errstring |
|------ | ----------|
| "-1025" | "Resource allocation error. Please try after some time."|


4. Unsupported image type was uploaded

| error | errstring |
|------ | ----------|
| "-1028" | "Error in processing uploaded images. Please check the images."|

5. The Service is out of capacity. This is a temporary condition.

| error | errstring |
|------ | ----------|
| "-1039" | "Service capacity consumed for now. Please try in a few hours."|

6. There was an internal Visage.FR server error

| error | errstring | possible reason |
|------ | ----------| --------------- |
| "-1029" | "Error. Please check returned error code."| Problem creating resources for request body|
| "-1031" | "Error. Please check returned error code."| Filesystem error |
| "-1032" | "Error. Please check returned error code."| One or more input image types are unsupported |
| "-1033" | "Error. Please check returned error code."| Error during locating faces in one of the images |
| "-1034" | "Error. Please check returned error code."| Error during processing face encodings |




