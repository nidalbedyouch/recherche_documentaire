package database;


import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public abstract class Database {
	private static final String HOSTNAME = "localhost";
	private static final int PORT = 27017;
	private static final String DBNAME = "BDD_INDEX_RD";
	
	private static MongoDatabase mgdb;
	
	public MongoDatabase db() {
		if(mgdb == null) {
			CodecRegistry pojoCodecRegistry = org.bson.codecs.configuration.CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), org.bson.codecs.configuration.CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
			mgdb = MongoClients.create("mongodb://" + HOSTNAME + ":" + PORT).getDatabase(DBNAME).withCodecRegistry(pojoCodecRegistry);
			
		}
		return mgdb;
	} 
}
