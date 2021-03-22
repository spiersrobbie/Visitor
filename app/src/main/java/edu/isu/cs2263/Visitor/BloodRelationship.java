// Subclass of the relationship, this one is a familiar relationship, that is, they are related by blood

package edu.isu.cs2263.Visitor;

public class BloodRelationship extends Relationship{
    private String person1Name;
    private String person2Name;

    public BloodRelationship(String person1, String person2){
        person1Name = person1;
        person2Name = person2;
    }
    public BloodRelationship(){}

    public String toString(){
        return "is family with";
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
