/*
* Simple C# program to interact with the Visage.FR service.
*
* Dependencies:
* .NET Core v3.1.403
* Flurl.Http v3.0.0.
*/


using System;

using Flurl.Http;

namespace csharp
{
    class VisageFR_CS_Client
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Test Visage.FR! .NET (C#) Client.");

            /*
            Provide the Visage.FR service public url and the source and target image paths.
            Any faces detected in the source image shall be compared to faces detected in the
            target image. If there are matches, then a match shall be returned alongwith the
            locations of the matching faces.
            */
            String svcUrl = "https://vfr050-yfc6eivsqq-ue.a.run.app/visagefr/v1.0/fr";
            String srcImg = "..\\testimages\\ws2.jpg";
            String tgtImg = "..\\testimages\\ws3.jpg";

            //actual method that POSTs to the Visage.FR service
            System.Threading.Tasks.Task task = processFaceRecogAsync(svcUrl, srcImg, tgtImg);
            task.Wait();

            Console.WriteLine("Ending .NET (C#) Client.");

        }

        /*
        Makes the actual POST call to the Visage.FR server.
        */
        private static async System.Threading.Tasks.Task processFaceRecogAsync(String strSvcUrl, 
            String strSrcImg, String strTgtImg){

            if(string.IsNullOrWhiteSpace(strSvcUrl) || string.IsNullOrWhiteSpace(strSrcImg) ||
                string.IsNullOrWhiteSpace(strTgtImg)){
                    Console.WriteLine("Error - Method's one or more method parameters are empty.");
                    return;
                }

                var resp = await strSvcUrl.PostMultipartAsync(mp => mp
                    .AddFile("files", strSrcImg)
                    .AddFile("files",strTgtImg));

            int iHTTPStatusCode = resp.StatusCode;
            System.Threading.Tasks.Task<string> taskGetResponseBody = resp.GetStringAsync();
            taskGetResponseBody.Wait();

            Console.WriteLine("HTTP Response code: " + iHTTPStatusCode + " and Body: " + 
                taskGetResponseBody.Result.ToString());
            return;
        }
    }
}
