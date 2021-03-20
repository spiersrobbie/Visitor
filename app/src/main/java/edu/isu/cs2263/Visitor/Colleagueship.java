package edu.isu.cs2263.Visitor;

public class Colleagueship extends Relationship{
    public Colleagueship(){}

    public String toString(){
        return "works with";
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
