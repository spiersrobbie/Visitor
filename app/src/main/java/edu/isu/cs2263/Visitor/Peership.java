// Subclass and type of Relationship. This one is for two people who attend school together

package edu.isu.cs2263.Visitor;

public class Peership extends Relationship{
    private String person1Name;
    private String person2Name;

    public Peership(String person1, String person2){
        person1Name = person1;
        person2Name = person2;
    }
    public Peership(){}

    public String toString(){
        return "attends school with";
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
