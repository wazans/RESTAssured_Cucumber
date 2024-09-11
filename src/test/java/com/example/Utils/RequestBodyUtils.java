package com.example.Utils;

import java.util.Random;

public class RequestBodyUtils {

    public static String createRequestBodyForFriends() {
        Random random = new Random();
        String firstname = "John" + random.nextInt(1000);
        String lastname = "Doe" + random.nextInt(1000);
        String id = String.valueOf(random.nextInt(1000));
        String age = String.valueOf(random.nextInt(100));

        return String.format("""
        {
            "firstname": "%s",
            "lastname": "%s",
            "id": "%s",
            "age": "%s"
        }
        """, firstname, lastname, id, age);
    }

    public static String createRequestBodyForIPL() {
        Random random = new Random();
        int id = random.nextInt(1000);
        String[] players = {"Rohit Sharma", "Virat Kohli", "Shikhar Dhawan", "MS Dhoni", "KL Rahul"};
        String[] teams = {"Mumbai Indians", "Royal Challengers Bangalore", "Punjab Kings", "Chennai Super Kings", "Lucknow Super Giants"};
        int matches = random.nextInt(250);
        int runs = random.nextInt(7000);
        double average = 20 + (random.nextDouble() * 30);
        double strikeRate = 100 + (random.nextDouble() * 50);

        String player = players[random.nextInt(players.length)];
        String team = teams[random.nextInt(teams.length)];

        return String.format("""
                {
                  "id": "%d",
                  "player": "%s",
                  "team": "%s",
                  "matches": %d,
                  "runs": %d,
                  "average": %.2f,
                  "strikeRate": %.2f
                }
                """, id, player, team, matches, runs, average, strikeRate);
    }
}
