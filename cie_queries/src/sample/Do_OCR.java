package sample;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.jayway.jsonpath.JsonPath;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.FileEntity;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.http.Header;
import org.json.JSONObject;

public class Do_OCR {
    // **********************************************
    // *** Update or verify the following values. ***
    // **********************************************

    // Replace <Subscription Key> with your valid subscription key.
    private static final String subscriptionKey = "7c9a6a30f1d44f1692c6635f2e1c7e6c";

    // You must use the same region in your REST call as you used to get your
    // subscription keys. For example, if you got your subscription keys from
    // westus, replace "westcentralus" in the URI below with "westus".
    //
    // Free trial subscription keys are generated in the westcentralus region. If you
    // use a free trial subscription key, you shouldn't need to change this region.
    private static final String uriBase =
            "https://westcentralus.api.cognitive.microsoft.com/vision/v2.0/recognizeText";

    private static final String imageToAnalyze =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/dd/" +
                    "Cursive_Writing_on_Notebook_paper.jpg/800px-Cursive_Writing_on_Notebook_paper.jpg";
    public  int src (ArrayList<String> al,String key)

    { int count=0;
        for(String obj:al)
        {
            if(obj.equals(key))
                return count;
            count++;
        }
        return -1;
    }
    public  void do_OCR(String path) {
        //CloseableHttpClient httpTextClient = HttpClientBuilder.create().build();
        // CloseableHttpClient httpResultClient = HttpClientBuilder.create().build();;
        HttpClient httpTextClient = new DefaultHttpClient();
        HttpClient httpResultClient = new DefaultHttpClient();
        try {
            // This operation requires two REST API calls. One to submit the image
            // for processing, the other to retrieve the text found in the image.

            URIBuilder builder = new URIBuilder(uriBase);

            // Request parameter.
            // Note: The request parameter changed for APIv2.
            // For APIv1, it is "handwriting", "true".
            builder.setParameter("mode", "Handwritten");

            // Prepare the URI for the REST API call.
            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);

            // Request headers.
            request.setHeader("Content-Type", "application/octet-stream");
            request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);

            // Request body.
           // System.out.println("Enter");
            //Scanner in = new Scanner(System.in);
            String url=path;
            File file = new File(url);
            FileEntity reqEntity = new FileEntity(file, "application/octet-stream");
            request.setEntity(reqEntity);
            //StringEntity requestEntity =
            //       new StringEntity("{\"url\":\"" + imageToAnalyze + "\"}");
            //request.setEntity(requestEntity);

            // Make the first REST API call to detect the text.
            HttpResponse response = httpTextClient.execute(request);

            // Check for success.
            if (response.getStatusLine().getStatusCode() != 202) {
                // Format and display the JSON error message.
                HttpEntity entity = response.getEntity();
                String jsonString = EntityUtils.toString(entity);
                JSONObject json = new JSONObject(jsonString);
                System.out.println("Error:\n");
                System.out.println(json.toString(2));
                return;
            }

            // Stores the URI where you can get the text recognition operation result.
            String operationLocation = null;

            // 'Operation-Location' in the response contains the URI to
            // retrieve the recognized text.
            Header[] responseHeaders = response.getAllHeaders();
            for (Header header : responseHeaders) {
                if (header.getName().equals("Operation-Location")) {
                    operationLocation = header.getValue();
                    break;
                }
            }

            if (operationLocation == null) {
                System.out.println("\nError retrieving Operation-Location.\nExiting.");
                System.exit(1);
            }

            // Note: The response may not be immediately available. Handwriting
            // recognition is an asynchronous operation, which takes a variable
            // amount of time dependent on the length of the text analyzed. You
            // may need to wait or retry the Get operation.

            System.out.println("\nHandwritten text submitted.\n" +
                    "Waiting 10 seconds to retrieve the recognized text.\n");
            Thread.sleep(10000);

            // Make the second REST API call and get the response.
            HttpGet resultRequest = new HttpGet(operationLocation);
            resultRequest.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);

            HttpResponse resultResponse = httpResultClient.execute(resultRequest);
            HttpEntity responseEntity = resultResponse.getEntity();

            if (responseEntity != null) {
                // Format and display the JSON response.
                String jsonString = EntityUtils.toString(responseEntity);
                JSONObject json = new JSONObject(jsonString);
                System.out.println("Text recognition result response: \n");
                //System.out.println(json.toString(2));
                System.out.println(JsonPath.read(jsonString,"$.recognitionResult.lines[*].text").toString());
                ArrayList<String> al =new ArrayList<String>();
                al=JsonPath.read(jsonString,"$.recognitionResult.lines[*].text");
                int pos=src(al,"Quiz - 1");
                System.out.println("quiz 1 marks picked up"+al.get(pos+1));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
