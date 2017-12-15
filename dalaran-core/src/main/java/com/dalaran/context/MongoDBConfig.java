package com.dalaran.context;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

@Configuration
@PropertySource("classpath:/mongodb.properties")
public class MongoDBConfig extends AbstractMongoConfiguration {

	private static String MAPPING_BASE_PACKAGE = "com.dalaran.dalaran.model.mongo";

	@Value("${mongodb.addresses}")
	private String addresses;
	@Value("${mongodb.databaseName}")
	private String databaseName;
	@Value("${mongodb.username}")
	private String mongoUsername;
	@Value("${mongodb.password}")
	private String mongoPassword;

	@Override
	public Mongo mongo() throws Exception {
		List<ServerAddress> seeds = new ArrayList<>();
		for (String address : addresses.split(",")) {
			String[] addressInfo = address.split(":");
			seeds.add(new ServerAddress(addressInfo[0], Integer
					.parseInt(addressInfo[1])));
		}
		MongoClient mongoClient = new MongoClient(seeds);
		mongoClient.setWriteConcern(WriteConcern.UNACKNOWLEDGED);
		return mongoClient;
	}

	@Override
	protected String getDatabaseName() {
		return databaseName;
	}

	@Override
	protected UserCredentials getUserCredentials() {
		return new UserCredentials(mongoUsername, mongoPassword);
	}

	@Override
	protected String getMappingBasePackage() {
		return MAPPING_BASE_PACKAGE;
	}

}
