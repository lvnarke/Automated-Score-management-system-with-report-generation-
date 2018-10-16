// // This sample uses the Apache HTTP client from HTTP Components (http://hc.apache.org/httpcomponents-client-ga/)
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
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.http.Header;
import org.json.JSONObject;
import org.json.JSONString;

public class Main2
{
    public static void main(String[] args)
    {
        HttpClient httpclient = new DefaultHttpClient();

        try
        {
            URIBuilder builder = new URIBuilder("https://eastus.api.cognitive.microsoft.com/text/analytics/v2.0/languages");


            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", "6a1b731f9314492c82a6eda63746fc41");

            JSONObject json = new JSONObject();

            json.put("test1", "value1");
            // Request body
            StringEntity reqEntity = new StringEntity("{\"documents\": [{\"language\": \"en\",\"id\": \"1\",\"text\": \"Hello world. This is some input text that I love.\"},{\"language\": \"fr\",\"id\": \"2\",\"text\": \"Bonjour tout le monde\"},{\"language\": \"es\",\"id\": \"3\",\"text\": \"La carretera estaba atascada. Había mucho tráfico el día de ayer.\"}]}");
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
