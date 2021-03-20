package edu.isu.cs2263.Visitor;

public class BloodRelationship extends Relationship{
    public BloodRelationship(){}

    public String toString(){
        return "is family with";
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
