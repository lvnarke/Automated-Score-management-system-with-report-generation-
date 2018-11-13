package sample.screens;
import java.awt.Desktop;
import java.net.URI;
public class Main6 {
    public static void main (String  args[])
    {
        Desktop d= Desktop.getDesktop();
        try{
            d.browse(new URI("https://app.powerbi.com/groups/me/reports/9af94c13-530a-4773-82c6-5012f8b534dd/ReportSection362b06cab2c677099aa5"));
        }
        catch (java.net.URISyntaxException e)
        {}
        catch(java.io.IOException e2)
        {}
        notifdb con =new notifdb();
        con.collection=con.database.getCollection("lakshmi");
        con.send_Msg(con.collection,"Dhanush","Please help with the selfstudy it is due tmrw");
        con.send_Msg(con.collection,"Chidroop","Try to implement this queue scalabliby");
        con.send_Msg(con.collection,"Aditya","Some random text to fill");
        con.send_Msg(con.collection,"Gagan","the power of the number is not depected correctly");
        con.send_Msg(con.collection,"Pushpa","All the methods used here are not available to the public");
        con.send_Msg(con.collection,"Ashritha","Please help with the selfstudy it is due tmrw");
        con.send_Msg(con.collection,"Heido","Hello just trying the messaging feature");
        con.send_Msg(con.collection,"Rob","Please help with the selfstudy it is due tmrw");
        con.send_Msg(con.collection,"Prakash","Please help with the selfstudy it is due tmrw");
        }
}
