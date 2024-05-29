package org.example;
import java.util.*;


public class MatchList {
    private List<Match1> matches;
    public List<Match1> fetchMatchesFromDatabase() {

        List<Match1> matches = new ArrayList<>();
        matches.add(new Match1("User 1"));
        matches.add(new Match1("User 2"));

        return matches;
    }


    public void open() {

        matches = fetchMatchesFromDatabase();


        if (matches.isEmpty()) {
            System.out.println("You have no matches.");
        } else {
            System.out.println("Your matches:");
            for (Match1 match : matches) {
                System.out.println("- " + match.getName());
            }
        }
    }
}
