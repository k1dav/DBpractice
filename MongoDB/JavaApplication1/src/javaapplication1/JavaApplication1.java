package javaapplication1;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
/**
 *
 * @author k1dav
 */
public class JavaApplication1 {
    private final static String HOST = "localhost";
    private final static int PORT = 27017;
    
    public static void main(String[] args) {
        try{
            MongoClient mongoClient = new MongoClient(HOST,PORT);
            DB db = mongoClient.getDB("mydb");
            System.out.println("Connected to MongoDB : OK");
            
            DBCollection coll = db.getCollection("javastuff");
            /*DBObject doc = new BasicDBObject("name","owen")
            .append("age", 47)
            .append("email", "owen@mail.com")
            .append("phone","123-456-789");
            
            coll.insert(doc);
            System.out.println("Insert succeed");*/ //insert
            
            /*DBCursor cursor = coll.find().limit(50);
            try{
                while(cursor.hasNext()){
                    DBObject object =cursor.next();
                    System.out.println(object);
                }
            }
            finally{
                cursor.close();
            }*/ //find
            
            /*BasicDBObject newDocument = new BasicDBObject();
            newDocument.append("$set",new BasicDBObject().append("age",23));
            BasicDBObject searchQuery = new BasicDBObject().append("name","frank");
            coll.update(searchQuery,newDocument,true,true);*/ //update
            
            DBObject document = new BasicDBObject();
            document.put("name", "frank");
            coll.remove(document);
        }
        catch(Exception e){
            System.err.println(e.getClass().getName()+":"+e.getMessage());
        }
    }
    
}
