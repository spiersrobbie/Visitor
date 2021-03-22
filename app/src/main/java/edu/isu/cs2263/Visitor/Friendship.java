package edu.isu.cs2263.Visitor;

public class Friendship extends Relationship{
    private String person1Name;
    private String person2Name;

    public Friendship(String person1, String person2){
        person1Name = person1;
        person2Name = person2;
    }
    public Friendship(){}

    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString(){
        return "is friends with";
    }
}
