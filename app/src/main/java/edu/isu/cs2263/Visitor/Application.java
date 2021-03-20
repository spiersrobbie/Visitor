package edu.isu.cs2263.Visitor;

public class Application {
    public static void main(String[] args){
        RelationshipNetwork net = new RelationshipNetwork();
        Person p1 = new Person("Dave", 18);
        Person p2 = new Person("Tanner");
        net.addEdge(p1, p2, "Marriage");

        PrintingVisitor v = new PrintingVisitor();
        net.accept(v);
        System.out.println(v.printEdge(0));

        // TODO: make the database much larger and add a CountingVisitor class to count the instances of each type of edge, also persistent data storage

        CountingVisitor v2 = new CountingVisitor();
        net.accept(v2);
        System.out.print(v2.displayCounts());
    }

    public static void saveGraph(RelationshipNetwork net, String path){

    }

    public static RelationshipNetwork loadGraph(String path){
        return null;
    }

}
