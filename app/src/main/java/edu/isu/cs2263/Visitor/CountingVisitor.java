package edu.isu.cs2263.Visitor;

public class CountingVisitor implements Visitor{
    private RelationshipNetwork network;
    public CountingVisitor(){}

    public void visit(RelationshipNetwork net){
        this.network = net;
    }

    public String displayCounts(){
        int[] counts = getCounts();

        // Code for table generation from https://stackoverflow.com/questions/18672643/how-to-print-a-table-of-information-in-java
        final Object[][] table = new String[7][];
        table[0] = new String[] { "Relationship Type", "Count"};
        table[1] = new String[] { "-----------------", "-----"};
        table[2] = new String[] { "Family", Integer.toString(counts[0]) };
        table[3] = new String[] { "Coworkers", Integer.toString(counts[1]) };
        table[4] = new String[] { "Friendship", Integer.toString(counts[2]) };
        table[5] = new String[] { "Marriage", Integer.toString(counts[3]) };
        table[6] = new String[] { "School Peer", Integer.toString(counts[4]) };

        String output = "";
        for (final Object[] row : table) {
            output += String.format("%15s%15s%n", row);
        }
        return output;
    }

    private int[] getCounts(){
        int[] typeCounts = new int[5];
        for(Relationship rel: network.getRelationships()){
            switch(rel.toString()){
                case "is family with":
                    typeCounts[0]++;
                    break;
                case "works with":
                    typeCounts[1]++;
                    break;
                case "is friends with":
                    typeCounts[2]++;
                    break;
                case "is married to":
                    typeCounts[3]++;
                    break;
                case "attends school with":
                    typeCounts[4]++;
                    break;
                default:
                    System.out.println("This relationship is not contained by the Counting visitor.");
            }
        }
        return typeCounts;
    }

    public void visit(Relationship rel){

    }


}
