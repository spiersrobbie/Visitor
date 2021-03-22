package edu.isu.cs2263.Visitor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SerializableDatabase {
    private ArrayList<Person> person1 = new ArrayList<>();
    private ArrayList<Person> person2 = new ArrayList<>();
    private ArrayList<String> relType= new ArrayList<>();

    public SerializableDatabase(){}

    public SerializableDatabase(RelationshipNetwork net){
        networkToDatabase(net);
    }

    public RelationshipNetwork getNetwork(){
        return databaseToNetwork();
    }

    private void networkToDatabase(RelationshipNetwork network){
        for (Relationship rel: network.getRelationships()){
            Person[] people = network.getPersonPair(rel);
            person1.add(people[0]);
            person2.add(people[1]);
            relType.add(getRelationshipType(rel));
        }
    }

    private RelationshipNetwork databaseToNetwork(){
        RelationshipNetwork net = new RelationshipNetwork();
        Iterator<String> relTypeIterator = relType.iterator();
        Iterator<Person> person1Iterator = person1.iterator();
        Iterator<Person> person2Iterator = person2.iterator();
        while(relTypeIterator.hasNext()){
            net.addEdge(person1Iterator.next(), person2Iterator.next(), relTypeIterator.next());
        }
        return net;
    }

    public String getRelationshipType(Relationship rel){
        String relType = "";
        switch(rel.toString()){
            case "is family with":
                relType = "BloodRelationship";
                break;
            case "works with":
                relType = "Colleagueship";
                break;
            case "is friends with":
                relType = "Friendship";
                break;
            case "is married to":
                relType = "Marriage";
                break;
            case "attends school with":
                relType = "Peership";
                break;
            default:
                System.out.println("The relationship " + rel.toString() + " is not contained by the Serializable database.");
        }
        return relType;
    }

}
