package sample.screens;
// // This sample uses the Apache HTTP client from HTTP Components (http://hc.apache.org/httpcomponents-client-ga/)
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Main5
{
    public static void main(String[] args)
    {
        HttpClient httpclient = new DefaultHttpClient();

        try
        {
            URIBuilder builder = new URIBuilder("https://southcentralus.api.cognitive.microsoft.com/customvision/v2.0/Prediction/677606d1-5c9e-4f54-98a1-0bd14e96f550/url?iterationId=caf76157-26ad-432a-b9a2-c91d4e860f2e");

            //builder.setParameter("iterationId", "{string}");
            //builder.setParameter("application", "{string}");

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Prediction-Key", "9c67732cb9614b04848b92838d651e19");
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Prediction-key", "9c67732cb9614b04848b92838d651e19");


            // Request body
            StringEntity reqEntity = new StringEntity("{\"Url\": \"http://denimatour.ru/upload/image/scan0027.jpg\"}");
            System.out.println(reqEntity.toString());
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null)
            {
                System.out.println(EntityUtils.toString(entity));


            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
