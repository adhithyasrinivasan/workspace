package com.yantra.auto.yrms.driver;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.yantra.auto.yrms.driver.GlobalSettings;

public class MongoDBConnector extends AutomationBase
{
	public final static String db_url=GlobalSettings.getProperty(GlobalKeys.mongoDbUrl);
	public final static String db_port=GlobalSettings.getProperty(GlobalKeys.mongoDbPort);
	public final static String dbname=GlobalSettings.getProperty(GlobalKeys.mongoDbName);
	private static int dbport=Integer.parseInt(db_port);
	private static MongoClient mongo;
	private static MongoDatabase database;
	public static MongoDatabase connectMongoDb()
	{
		mongo=new MongoClient(db_url,dbport);
		return database=mongo.getDatabase(dbname);
	}
	
}
