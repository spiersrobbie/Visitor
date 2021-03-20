package edu.isu.cs2263.Visitor;

public abstract class Relationship {
    void accept(Visitor v){
        v.visit(this);
    };
}
