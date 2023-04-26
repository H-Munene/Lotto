package LottoCompany;


import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

public class DbConnection {

    public static void main(String[] args){

        String connectionString = "mongodb+srv://hezekiahmunene:12345@cluster1.gfdfvl8.mongodb.net/?retryWrites=true&w=majority";
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();
        // Create a new client and connect to the server
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                // Send a ping to confirm a successful connection
                MongoDatabase database = mongoClient.getDatabase("admin");
                database.runCommand(new Document("ping", 1));
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");


                /*try (MongoClient mongoClients = MongoClients.create(System.getProperty("mongodb.uri"))) {

                    MongoDatabase sampleTrainingDB = mongoClients.getDatabase("LottoDB");
                    MongoCollection<Document> gradesCollection = sampleTrainingDB.getCollection("LottoPlayers");


                    Document student = new Document("_id", new ObjectId());
                    student.append("username", "Sammy Musangi")
                            .append("ID", "34456883");

                    gradesCollection.insertOne(student);

                }*/


            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }
}

