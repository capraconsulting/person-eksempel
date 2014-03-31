package no.capra.person;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import no.capra.person.endpoint.PersonResource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Profile("test")
@Configuration
@EnableMongoRepositories
public class MongoDbTestConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "person-test";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient();
    }
}