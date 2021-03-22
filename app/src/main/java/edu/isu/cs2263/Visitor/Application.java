// This is the client file that tests the corresponding methods and visiting system
// To run the program, simply execute this file from the main() class. Further information present in the README

package edu.isu.cs2263.Visitor;

import com.google.gson.Gson;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Application {
    public static void main(String[] args){
        RelationshipNetwork net;
        if(args.length == 0){
            net = populateDatabase();                       // User has the option to specify an existing database. If none exists, it is created here randomly
        } else {
            net = loadGraph(args[0]);                       // If user specified an existing file, the database is extracted from the file here
        }

        // First visitor implementation. This one reads the information from a specific edge and prints its information
        PrintingVisitor v = new PrintingVisitor();
        net.accept(v);
        System.out.println(v.printEdge(7));         // This number can be changed to less than 63, and it will print out the relationship in that location

        // Second visitor implementation. This one traverses the graph and counts the number of occurrences of relationships
        CountingVisitor v2 = new CountingVisitor();
        net.accept(v2);
        System.out.print(v2.displayCounts());

        // Saves the graph for possible future usage
        saveGraph(net, "savedNetwork");
    }

    // Static method to save the graph to storage. It is important to note that Guava graphs are NOT serializable
    // therefore this implementation stores the information so that the graph can be recreated in the future with all requisite data
    public static void saveGraph(RelationshipNetwork net, String path){
        Gson gson = new Gson();
        SerializableDatabase db = new SerializableDatabase(net);        // Converts the network into a serializable data type. See the Serializable class for more info.
        String jsonOut = gson.toJson(db);

        try {
            Files.writeString(Paths.get(path + ".json"), jsonOut);
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }

    // Loads the database from storage and converts it back into a graph
    public static RelationshipNetwork loadGraph(String path){
        // First, reads the json of the database into memory
        String json = "";
        try {
            json = Files.readString(Paths.get(path + ".json"));
        } catch(IOException ex){
            ex.printStackTrace();
        }

        Gson gson = new Gson();
        SerializableDatabase db = gson.fromJson(json, SerializableDatabase.class);
        // This line converts the database back into a network. See the documentation in the SerializableDatabase class.
        RelationshipNetwork net = db.getNetwork();
        return net;
    }

    // Populates the database from a list of names. All possible combinations of names are given random relationships.
    public static RelationshipNetwork populateDatabase(){
        // First, create People out of the names
        String[] names = {"James", "Miranda", "Jennifer", "Dave", "Tanner", "Wendy", "Scott", "Cody", "Shivank", "Lauren", "Culley", "Jenny"};
        Person[] people = new Person[names.length];
        for(int i = 0; i < names.length; i++){
            people[i] = new Person(names[i]);
        }

        // Next, populate a RelationshipNetwork with these names (all possible combinations, random names)
        RelationshipNetwork net = new RelationshipNetwork();

        for(int i = 0; i < names.length; i++){
            for(int j = i+1; j < names.length; j++){
                net.addEdge(people[i], people[j], getRandomRelationship());
            }
        }
        return net;

    }

    // Gets a random relationship type for use in populateDatabase()
    public static String getRandomRelationship(){
        String[] relationships = {"Marriage", "BloodRelationship", "Friendship", "Peership", "Colleagueship"};
        Random rand = new Random();
        int randInt = rand.nextInt(relationships.length);
        return relationships[randInt];
    }

}
