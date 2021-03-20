package edu.isu.cs2263.Visitor;

public class Marriage extends Relationship{
    private String marriageDate;
    private int happiness;

    public Marriage(){}

    public Marriage(String date, int happiness) {
        marriageDate = date;
        this.happiness = happiness;
    }
    public String getMarriageDate() {return marriageDate;}
    public int getHappiness() {return happiness;}

    public String toString(){
        return "is married to";
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
