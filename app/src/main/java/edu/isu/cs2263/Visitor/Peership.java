package edu.isu.cs2263.Visitor;

public class Peership extends Relationship{
    public Peership(){}

    public String toString(){
        return "attends school with";
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
