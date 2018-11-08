package testSel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MapReduceOutput;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class TestSel 
{
	public static boolean testTrans(String key,String value)
	{	
		boolean decision=false;
		MongoClient db=new MongoClient("localhost",27017);
		MongoDatabase data=db.getDatabase("yrms") ;
		DBObject allQuery = new BasicDBObject(); 
		FindIterable<Document> dataa=data.getCollection("transactionDocument").find();
		if(dataa != null)
		{
			for(Document e:dataa)
			{
				if(key.equalsIgnoreCase("addressLine1"))
				{
					//System.out.println(e.get("mAccountHolder"));
					Document mAccountHolderDocuments=(Document) e.get("mAccountHolder");
					Document addressDocument=(Document) mAccountHolderDocuments.get("address");
					String address=addressDocument.getString(key);
					if(address.equalsIgnoreCase(value))
					{
						decision=true;
						break;
					}
				}
			}
		}
		return decision;
	}
	public static boolean ifCustomerHolderId(String key,String value)
	{	
		boolean decision=false;
		String primaryPhone=null;
		MongoClient db=new MongoClient("localhost",27017);
		MongoDatabase data=db.getDatabase("yrms") ;
		FindIterable<Document> dataa=data.getCollection("customerDocument").find();
		if(dataa != null)
		{
			for(Document e:dataa)
			{
				//if(key.equalsIgnoreCase("addressLine1"))
				//{
					//System.out.println(e.get("mAccountHolder"));
					System.out.println(e.get("accountHolder"));
					Document accountHolderDocument=(Document) e.get("accountHolder");
					Document contactDocument=(Document) accountHolderDocument.get("contact");
					try
					{
						primaryPhone=contactDocument.getString("primaryPhone");
					}
					catch(NullPointerException ex)
					{
						decision=false;
						System.out.println(ex);
					}
					if(primaryPhone!=null&&primaryPhone.equalsIgnoreCase(value))
					{
						decision=true;
						break;
					}
				//}
			}
		}
		return decision;
	}
	public static void main(String args[])
	{
		boolean test=testTrans("addressLine1", "3817 forest avenue");
		System.out.println(ifCustomerHolderId("holderId", "9876517691"));
	}
}
