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
}
