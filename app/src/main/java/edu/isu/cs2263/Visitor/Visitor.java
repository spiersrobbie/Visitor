package edu.isu.cs2263.Visitor;

public interface Visitor {
    void visit(Relationship r);

    void visit(RelationshipNetwork net);
}
