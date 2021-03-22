package edu.isu.cs2263.Visitor;

public class Marriage extends Relationship{
    private String person1Name;
    private String person2Name;

    public Marriage(String person1, String person2){
        person1Name = person1;
        person2Name = person2;
    }

    public Marriage(){}

    public String toString(){
        return "is married to";
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
