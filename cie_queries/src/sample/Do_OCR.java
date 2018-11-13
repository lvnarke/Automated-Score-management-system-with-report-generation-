package sample;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jayway.jsonpath.JsonPath;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
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

    static  Stage stage2 = new Stage();

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
    public static    Float quiz_1,quiz_2,quiz_3,test_1,test_2,test_3,assignment,lab,selfstudy;

    public static String usn="",ccode="";

    public static String reg1="1rv16cs[0-9][0-9][0-9]",reg2="16cs[0-9][0-9]";
    static String e1="",e2="",e3="",e4="";
    public static boolean b1=true,b2=true,b3=true,b4=true,b5=true,b6=true,b7=true;

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
           // Dialog d = new Alert(Alert.AlertType.INFORMATION, "Wait for some time to retrieve the recognized text.");
            //d.show();
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
                System.out.println("Here now");
                int pos=0;


                    usn="1rv16cs004";

                    ccode="16cs54";
                    pos=src(al,"Quiz - 1");
                    quiz_1=Float.parseFloat(""+al.get(pos+2));

                    pos=src(al,"Quiz - 2");
                    quiz_2=Float.parseFloat(""+al.get(pos+2));

                    pos=src(al,"Quiz - 3");
                    quiz_3=Float.parseFloat(""+al.get(pos+2));

                    pos=src(al,"Test - 1");
                    test_1=Float.parseFloat(""+al.get(pos+1));

                    pos=src(al,"Test - 2");
                    test_2=Float.parseFloat(""+al.get(pos+1));

                    pos=src(al,"Test - 3");
                    test_3=Float.parseFloat(""+al.get(pos+1));

                    pos=src(al,"Selfstudy");
                    selfstudy=Float.parseFloat(""+al.get(pos+2));

                    pos=src(al,"Assignment");
                    assignment=Float.parseFloat(""+al.get(pos+1));

                    pos=src(al,"Laboratory");
                    lab=Float.parseFloat(""+al.get(pos+1));

                    System.out.println("I'm printing this: "+quiz_1+" "+quiz_2+" "+quiz_3+" "+test_1+" "+test_2+" "+test_3+" "+assignment+" "+selfstudy+" "+lab);



                Insert insert = new Insert();

                usn=usn.toLowerCase();
                ccode=ccode.toLowerCase();

                Pattern pat=Pattern.compile(reg1);
                Matcher matcher = pat.matcher(usn);

               Pattern pat1 = Pattern.compile(reg2);
               Matcher matcher1 = pat1.matcher(ccode);

                b1=matcher.matches();
                b2=matcher1.matches();


                if(quiz_1>10 || quiz_2 >10|| quiz_3 >10)
                { b3=false;


                }
                if((test_1 > 25 || test_2 >25 || test_3 >25 )&&( assignment > 0)) {
                    b4 = false;

                }
                if(lab >50){
                    b5=false;

                }
                if(selfstudy>20){
                    b6=false;

                }
                if(assignment >10){
                    b7=false;

                }
                if(!b1){
                    //System.out.println("Incorrect USN");
                    e1+="Incorrect USN.Re-enter USN"+"\n";
                }
                if(!b2){
                   // System.out.println("Incorrect Course-code");
                    e2+="Incorrect Course-code.Re-enter Course-code"+"\n";
                }
                if(!b3){
                   // System.out.println("Incorrect Quiz marks");
                    e3+="Incorrect Quiz marks.Re-enter Quiz marks"+"\n";
                }
                if(!b4){
                    e4+="Incorrect Test marks.Re-enter Test marks"+"\n";
                }
                System.out.println("Printing the flags: "+b1+" "+b2+" "+b3+" "+b4+" "+b5+" "+b6+" "+b7);
                if(b1==false || b2==false|| b3==false || b4==false || b5==false || b6==false || b7==false){
                    Parent root = FXMLLoader.load(getClass().getResource("error.fxml"));
                    stage2.setScene(new Scene(root, 1250, 653));
                    stage2.setResizable(false);
                    stage2.show();
                }






            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
