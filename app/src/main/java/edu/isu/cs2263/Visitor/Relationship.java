// This basic abstract class provides the framework for our Relationships

package edu.isu.cs2263.Visitor;

public abstract class Relationship {

    public Relationship(){}

    void accept(Visitor v){
        v.visit(this);
    };
}
