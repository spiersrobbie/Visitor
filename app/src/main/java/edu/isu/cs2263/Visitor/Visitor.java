// This visitor interface allows for the two implementations of the interface: PrintingVisitor and CountingVisitor
// The interface allows for the accept() method in the inheritance hierarchy to not depend on the specific implementation of the visitor.

package edu.isu.cs2263.Visitor;

public interface Visitor {

    void visit(Relationship rel);

    void visit(RelationshipNetwork net);
}
