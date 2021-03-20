package edu.isu.cs2263.Visitor;

public interface Visitor {

    void visit(Relationship rel);

    void visit(RelationshipNetwork net);
}
