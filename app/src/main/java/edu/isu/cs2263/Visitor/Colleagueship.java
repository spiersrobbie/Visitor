// Subclass and type of Relationship, this one is for two people who work together

package edu.isu.cs2263.Visitor;

public class Colleagueship extends Relationship{
    private String person1Name;
    private String person2Name;

    public Colleagueship(String person1, String person2){
        person1Name = person1;
        person2Name = person2;
    }
    public Colleagueship(){}

    public String toString(){
        return "works with";
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
