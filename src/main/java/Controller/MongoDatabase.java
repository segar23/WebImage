/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Garces
 */
public class MongoDatabase 
{
    @SuppressWarnings("FieldMayBeFinal")
    private DBCollection collection;
    
    public MongoDatabase() throws UnknownHostException {
        MongoClient mongoClient = new MongoClient();
        DB database = mongoClient.getDB("webimage");
        collection = database.getCollection("users");
    }
    
    public void insertUser(String username, String password)
    {
        List<String> images = new ArrayList<>();
        DBObject user = new BasicDBObject("_id", username)
                .append("password", password)
                .append("images", images);
        
        collection.insert(user);
    }
    
    public Boolean getUser (String username, String password)
    {
        DBObject query = new BasicDBObject("username", username);
        DBCursor cursor = collection.find(query);
        String bdPass = (String)cursor.next().get("password");
        return password.equals(bdPass);
    }
    
    public void insertPicture (String pictureName, String username)
    {
        BasicDBObject findQuery = new BasicDBObject("username", username);
        BasicDBObject innerUpdate = new BasicDBObject("images", new BasicDBObject("name", pictureName));
        BasicDBObject updateQuery = new BasicDBObject("$push",innerUpdate);
        collection.update(findQuery, updateQuery);
    }
    
    
}
