// This is our first visitor. It visits the RelationshipNetwork and formats a specific relationship into a string

package edu.isu.cs2263.Visitor;

public class PrintingVisitor implements Visitor{
    private RelationshipNetwork network;

    public PrintingVisitor(){}

    public void visit(RelationshipNetwork network){
        this.network = network;
    }

    public String printEdge(int edgeNum){
        Relationship relationship = network.getRelationships().toArray(new Relationship[10])[edgeNum];
        Person[] involvedPeople = network.getPersonPair(relationship);
        return involvedPeople[0].getName() + " " + relationship.toString() + " " + involvedPeople[1].getName();
    }

    public void visit(Relationship rel) {}
}
