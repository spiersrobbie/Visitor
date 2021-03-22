// SerializableDatabase allows for the persistent storage of a RelationshipNetwork
//      This is necessary since the only field of RelationshipNetwork is a Guava graph, which are NOT serializable
//      Therefore, this workaround is to use the serializable database to decompose the graph into its elements and store those elements to "save"
//      And to "load", the elements are imported from the file, then reconstituted into a RelationshipNetwork

package edu.isu.cs2263.Visitor;

import java.util.ArrayList;
import java.util.Iterator;

public class SerializableDatabase {
    // It is perhaps pertinent to note that these must be ArrayLists rather than Sets, since all contain non-unique objects

    // These are the "elements" of the network mentioned above. Also referred to as the "database"
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

    // Converts a RelationshipNetwork into a database, where the database is just the decomposition of the Network into its elements
    private void networkToDatabase(RelationshipNetwork network){
        for (Relationship rel: network.getRelationships()){
            Person[] people = network.getPersonPair(rel);
            person1.add(people[0]);
            person2.add(people[1]);
            relType.add(getRelationshipType(rel));
        }
    }

    // Converts the database back into a network, reconstituting it with all of its elements
    private RelationshipNetwork databaseToNetwork(){
        RelationshipNetwork net = new RelationshipNetwork();
        Iterator<String> relTypeIterator = relType.iterator();
        Iterator<Person> person1Iterator = person1.iterator();
        Iterator<Person> person2Iterator = person2.iterator();
        while(relTypeIterator.hasNext()){               // This iterates through all of the database objects to reconstitute each relationship
            net.addEdge(person1Iterator.next(), person2Iterator.next(), relTypeIterator.next());
        }
        return net;
    }

    // Determines the string understanding of a relationship given the Relationship object itself
    // This is a great example of polymorphism, since the subclasses each have a different realization of the toString() method
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
