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
            net = populateDatabase();
        } else {
            net = loadGraph(args[0]);
        }

        PrintingVisitor v = new PrintingVisitor();
        net.accept(v);
        System.out.println(v.printEdge(7));

        CountingVisitor v2 = new CountingVisitor();
        net.accept(v2);
        System.out.print(v2.displayCounts());

        saveGraph(net, "savedNetwork");
    }

    public static void saveGraph(RelationshipNetwork net, String path){
        Gson gson = new Gson();
        SerializableDatabase db = new SerializableDatabase(net);
        String jsonOut = gson.toJson(db);

        try {
            Files.writeString(Paths.get(path + ".json"), jsonOut);
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static RelationshipNetwork loadGraph(String path){
        String json = "";
        try {
            json = Files.readString(Paths.get(path + ".json"));
        } catch(IOException ex){
            ex.printStackTrace();
        }

        Gson gson = new Gson();
        SerializableDatabase db = gson.fromJson(json, SerializableDatabase.class);
        RelationshipNetwork net = db.getNetwork();
        return net;
    }

    public static RelationshipNetwork populateDatabase(){
        String[] names = {"James", "Miranda", "Jennifer", "Dave", "Tanner", "Wendy", "Scott", "Cody", "Shivank", "Lauren", "Culley", "Jenny"};
        Person[] people = new Person[names.length];
        for(int i = 0; i < names.length; i++){
            people[i] = new Person(names[i]);
        }

        RelationshipNetwork net = new RelationshipNetwork();

        for(int i = 0; i < names.length; i++){
            for(int j = i+1; j < names.length; j++){
                net.addEdge(people[i], people[j], getRandomRelationship());
            }
        }
        return net;

    }

    public static String getRandomRelationship(){
        String[] relationships = {"Marriage", "BloodRelationship", "Friendship", "Peership", "Colleagueship"};
        Random rand = new Random();
        int randInt = rand.nextInt(relationships.length);
        return relationships[randInt];
    }

}
