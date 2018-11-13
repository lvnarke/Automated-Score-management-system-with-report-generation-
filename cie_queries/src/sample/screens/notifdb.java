package sample.screens;

import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import org.bson.Document;
import com.mongodb.MongoCredential;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class notifdb {
   /* public static void main (String args[])
    {
        MongoDatabase database= get_Database("Notifications");
        database.createCollection("Chidroop");
        MongoCollection<Document> collection = database.getCollection("Chidroop");
        //send_Msg(collection,"Lakshmi","Dhanush is a bt");
        //send_Msg(collection,"Lakshmi","Dhanush is not sorry i am so dumb");
        //send_Msg(collection,"Lakshmi","JK JK Jk XD");
        //get_Msgs(collection);

    }*/
   // database and collection are data members of the class.
   public MongoDatabase database;
   public MongoCollection<Document> collection;
   //There are 4 list which will be populated when get_Msgs is called
   public List<String> Senderlist=new ArrayList<String>();
   public List<String> Msglist=new ArrayList<String>();
   public List<String> Prio=new ArrayList<String>();
   public List<String> time=new ArrayList<String>();
   //constructor used to establish the connection
   public notifdb()
   {
       database= get_Database("Notifications");
   }
    public MongoDatabase get_Database(String db_Name)
    {
        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://admin:admin@cie-ehmhq.azure.mongodb.net/test?retryWrites=true");

        MongoClient mongo = new MongoClient(uri);
        MongoDatabase database = mongo.getDatabase(db_Name);
        return database;
    }
    // Function to make a new Collection.
    public void make_Collection( MongoDatabase database,String collection_Name)
    {
        collection = database.getCollection(collection_Name);
    }
    //Function to send a message.
    public void send_Msg (MongoCollection<Document> collection,String Sender,String MSG)
    {   Date dNow = new Date( );
        SimpleDateFormat ft =
                new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        Document document = new Document("Sender", Sender)
                .append("Message", MSG)
                .append("time",ft.format(dNow) )
                .append("Priority", "HIGH");
        collection.insertOne(document);
    }
    //Function that gets your inbox
    public void get_Msgs(MongoCollection<Document> collection)
    {
        FindIterable<Document> iterDoc = collection.find();
       for(Document doc: iterDoc)
       {
          Senderlist.add(doc.getString("Sender"));
          Msglist.add(doc.getString("Message"));
          Prio.add(doc.getString("Priority"));
          time.add(doc.getString("time"));
       }
        int i = 1;
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            i++;
        }
    }

}
