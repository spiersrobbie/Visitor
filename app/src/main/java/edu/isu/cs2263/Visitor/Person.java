// General class for the people (nodes) in this network. Note that for this implementation only names are used, however one could modify the Application class and include more information about the People

package edu.isu.cs2263.Visitor;

public class Person {
    private String name;
    private int age;
    private int heightInInches;

    public Person(String name, int age, int height){
        this.name = name;
        this.age = age;
        heightInInches = height;
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Person(String name){
        this.name = name;
    }

    public String getName(){return name;}
    public int getAge(){return age;}
}
