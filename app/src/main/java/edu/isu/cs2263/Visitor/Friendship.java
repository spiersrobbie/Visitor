package edu.isu.cs2263.Visitor;

public class Friendship extends Relationship{
    public Friendship(){}

    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString(){
        return "is friends with";
    }
}
