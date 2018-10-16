package sample;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.net.ssl.HttpsURLConnection;

/*
 * Gson: https://github.com/google/gson
 * Maven info:
 *     groupId: com.google.code.gson
 *     artifactId: gson
 *     version: 2.8.1
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/* NOTE: To compile and run this code:
1. Save this file as Translate.java.
2. Run:
    javac Translate.java -cp .;gson-2.8.1.jar -encoding UTF-8
3. Run:
    java -cp .;gson-2.8.1.jar Translate
*/

public class Main4 {

// **********************************************
// *** Update or verify the following values. ***
// **********************************************

    // Replace the subscriptionKey string value with your valid subscription key.
    static String subscriptionKey = "e9fe6631397a472d94a388a15a527e87";

    static String host = "https://api.cognitive.microsofttranslator.com";
    static String path = "/translate?api-version=3.0";

    // Translate to German and Italian.
    static String params = "&to=de&to=it&to=hi";

    static String text = "\n" +
            "Republic of India\n" +
            "Bhārat Gaṇarājya\n" +
            "Horizontal tricolor flag bearing, from top to bottom, deep saffron, white, and green horizontal bands. In the centre of the white band is a navy-blue wheel with 24 spokes.\n" +
            "Flag\n" +
            "Three lions facing left, right, and toward viewer, atop a frieze containing a galloping horse, a 24-spoke wheel, and an elephant. Underneath is a motto: \"सत्यमेव जयते\".\n" +
            "State emblem\n" +
            "Motto: \"Satyameva Jayate\" (Sanskrit)\n" +
            "\"Truth Alone Triumphs\"[1]\n" +
            "Anthem: \"Jana Gana Mana\" (Hindi)[2]\n" +
            "\"Thou Art the Ruler of the Minds of All People\"[3][2]\n" +
            "MENU0:00\n" +
            "National song\n" +
            "\"Vande Mataram\" (Sanskrit)\n" +
            "\"I Bow to Thee, Mother\"[a][1][2]\n" +
            "Image of a globe centred on India, with India highlighted.\n" +
            "Area controlled by India shown in dark green;\n" +
            "claimed but uncontrolled regions shown in light green.\n" +
            "Capital\tNew Delhi\n" +
            "28°36′50″N 77°12′30″E\n" +
            "Largest city\tMumbai\n" +
            "18°58′30″N 72°49′40″E\n" +
            "Official languages\t\n" +
            "HindiEnglish[b][6]\n" +
            "Recognised regional languages\t\n" +
            "State level and\n" +
            "Eighth Schedule[7][show]\n" +
            "National language\tNone[8][9][10]\n" +
            "Religion\t\n" +
            "79.8% Hinduism\n" +
            "14.2% Islam\n" +
            "2.3% Christianity\n" +
            "1.7% Sikhism\n" +
            "0.7% Buddhism\n" +
            "0.4% Jainism\n" +
            "0.9% others[c][11]\n" +
            "Demonym\tIndian\n" +
            "Membership\tUN, WTO, BRICS, SAARC, SCO, G8+5, G20, Commonwealth of Nations\n" +
            "Government\tFederal parliamentary\n" +
            "constitutional socialist[12]\n" +
            "republic[1]\n" +
            "• President\n" +
            "Ram Nath Kovind\n" +
            "• Vice President\n" +
            "Venkaiah Naidu\n" +
            "• Prime Minister\n" +
            "Narendra Modi\n" +
            "• Chief Justice\n" +
            "Ranjan Gogoi\n" +
            "• Speaker of the Lok Sabha\n" +
            "Sumitra Mahajan\n" +
            "Legislature\tParliament\n" +
            "• Upper house\n" +
            "Rajya Sabha\n" +
            "• Lower house\n" +
            "Lok Sabha\n" +
            "Independence from the United Kingdom\n" +
            "• Dominion\n" +
            "15 August 1947\n" +
            "• Republic\n" +
            "26 January 1950\n" +
            "Area\n" +
            "• Total\n" +
            "3,287,263[5] km2 (1,269,219 sq mi)[d] (7th)\n" +
            "• Water (%)\n" +
            "9.6\n" +
            "Population\n" +
            "• 2016 estimate\n" +
            "Increase1,324,171,354[13] (2nd)\n" +
            "• 2011 census\n" +
            "1,210,854,977[14][15] (2nd)\n" +
            "• Density\n" +
            "398.6/km2 (1,032.4/sq mi) (31st)\n" +
            "GDP (PPP)\t2018 estimate\n" +
            "• Total\n" +
            "$10.401 trillion[16] (3rd)\n" +
            "• Per capita\n" +
            "$7,795[16] (116th)\n" +
            "GDP (nominal)\t2018 estimate\n" +
            "• Total\n" +
            "$2.690 trillion[16] (6th)\n" +
            "• Per capita\n" +
            "$2,016[16] (133rd)\n" +
            "Gini (2013)\t33.9[17]\n" +
            "medium · 79th\n" +
            "HDI (2017)\tIncrease 0.640[18]\n" +
            "medium · 130th\n" +
            "Currency\tIndian rupee (₹) (INR)\n" +
            "Time zone\tUTC+05:30 (IST)\n" +
            "DST is not observed\n" +
            "Date format\tdd-mm-yyyy\n" +
            "Driving side\tleft\n" +
            "Calling code\t+91\n" +
            "ISO 3166 code\tIN\n" +
            "Internet TLD\t.in (others)\n" +
            "India (IAST: Bhārat), also known as the Republic of India (IAST: Bhārat Gaṇarājya),[19][e] is a country in South Asia. It is the seventh-largest country by area, the second-most populous country (with over 1.2 billion people), and the most populous democracy in the world. Bounded by the Indian Ocean on the south, the Arabian Sea on the southwest, and the Bay of Bengal on the southeast, it shares land borders with Pakistan to the west;[f] China, Nepal, and Bhutan to the northeast; and Bangladesh and Myanmar to the east. In the Indian Ocean, India is in the vicinity of Sri Lanka and the Maldives, while its Andaman and Nicobar Islands share a maritime border with Thailand and Indonesia.";

    public static class RequestBody {
        String Text;

        public RequestBody(String text) {
            this.Text = text;
        }
    }

    public static String Post (URL url, String content) throws Exception {
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Content-Length", content.length() + "");
        connection.setRequestProperty("Ocp-Apim-Subscription-Key", subscriptionKey);
        connection.setRequestProperty("X-ClientTraceId", java.util.UUID.randomUUID().toString());
        connection.setDoOutput(true);

        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        byte[] encoded_content = content.getBytes("UTF-8");
        wr.write(encoded_content, 0, encoded_content.length);
        wr.flush();
        wr.close();

        StringBuilder response = new StringBuilder ();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        String line;
        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();

        return response.toString();
    }

    public static String Translate () throws Exception {
        URL url = new URL (host + path + params);

        List<RequestBody> objList = new ArrayList<RequestBody>();
        objList.add(new RequestBody(text));
        String content = new Gson().toJson(objList);

        return Post(url, content);
    }

    public static String prettify(String json_text) {
        JsonParser parser = new JsonParser();
        JsonElement json = parser.parse(json_text);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(json);
    }

    public static void main(String[] args) {
        try {
            String response = Translate ();
            System.out.println (prettify (response));
        }
        catch (Exception e) {
            System.out.println (e);
        }
    }
}