package edu.isu.cs2263.Visitor;

import com.google.common.graph.EndpointPair;
import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;

import java.util.Set;

public class RelationshipNetwork {
    private MutableNetwork<Person, Relationship> graph = NetworkBuilder.undirected()
            .allowsParallelEdges(false)
            .expectedNodeCount(100)
            .expectedEdgeCount(100)
            .build();

    public RelationshipNetwork(){}

    public void addEdge(Person p1, Person p2, String relationshipType){
        Relationship rel;
        switch (relationshipType) {
            case "Marriage":
                rel = new Marriage();
                break;
            case "BloodRelationship":
                rel = new BloodRelationship();
                break;
            case "Colleagueship":
                rel = new Colleagueship();
                break;
            case "Friendship":
                rel = new Friendship();
                break;
            case "Peership":
                rel = new Peership();
                break;
            default:
                System.out.println("Relationship type " + relationshipType + " is not interpretable by the graph. Please use a different relationship definition.");
                return;
        }

        graph.addEdge(p1, p2, rel);
    }

    public Set<Relationship> getRelationships(){
        return graph.edges();
    }

    public Set<Person> getPeople(){
        return graph.nodes();
    }

    public Person[] getPersonPair(Relationship rel){
        EndpointPair<Person> people = graph.incidentNodes(rel);
        return new Person[]{people.nodeU(), people.nodeV()};
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
