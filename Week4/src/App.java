package src;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) { 
        System.out.println("App is running");

        Player player1 = new Player("Chris");
        player1.addSport("Soccer");
        player1.addSport("Hockey");
        player1.addSport("Rugby");

        Player player2 = new Player("Jane");
        player1.addSport("Golf");
        player2.addSport("Soccer");
        player2.addSport("Hockey");
        player1.addSport("Cricket");

        Player player3 = new Player("Joe");
        player1.addSport("Rugby");
        player2.addSport("Cricket");
        player2.addSport("Soccer");

        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);

        String[] listOfSports = {"Soccer", "Hockey", "Rugby", "Golf", "Cricket"};

        for(String sport:listOfSports) {
            for (Player player: players) {
                ArrayList<String> sports = player.getSports();
                if (sports.contains(sport)) {
                    System.out.println(player.name + " plays " + sport);
                }
            }
        }
        

    }
}