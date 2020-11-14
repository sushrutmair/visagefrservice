'''
A very simple python REST client to interact with the Visage.FR service.

Dependencies:
python3.6+
requests 2.22.0
'''

import requests

'''
Does the actual face recognition call POST to the Visage.FR service.
'''
def process_facerecog(serviceUrl: str, sourceimg: str, targetimg: str):

    if(serviceUrl is None or sourceimg is None or targetimg is None):
        print("Error - Method one or more method parameters are empty.")
        return

    #Visage.FR requires the images as multipart/form-data content in the POST request
    # body. Set this up first. Use 'files' as the key to pass on the images.
    request_body = [
        ('files', ('src.jpg',open(sourceimg, 'rb'), 'image/jpg')),
        ('files', ('tgt.jpg',open(targetimg, 'rb'), 'image/jpg'))
    ]

    #POST the request. This is a blocking call
    result = requests.post(serviceUrl, files = request_body)

    #print the result.
    print("\nService Response: \n", result.text, "\n")


    return

def main():

    print("Test Visage.FR! Python Client.")

    '''
    Provide the Visage.FR service public url and the source and target image paths.
    Any faces detected in the source image shall be compared to faces detected in the
    target image. If there are matches, then a match shall be returned alongwith the
    locations of the matching faces.
    '''
    svcUrl = "https://vfr050-yfc6eivsqq-ue.a.run.app/visagefr/v1.0/fr" #cloud service
    srcImg = "testimages/ws2.jpg"
    tgtImg = "testimages/ws3.jpg"

    process_facerecog(svcUrl,srcImg,tgtImg)

    print("Ending python client.")


if __name__=="__main__":
    main()

