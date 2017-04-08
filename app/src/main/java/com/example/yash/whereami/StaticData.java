package com.example.yash.whereami;


public class StaticData {

    //Storing the static fields here.

    public static int screenWidth;
    public static int screenHeight;
    public static int questionId;

    //TODO : use this array to calculate total score and left problems
    public static boolean booleenArray[] = new boolean[12];

    public final static String[] questionArray = {
            "1. Find the Earth, our home.",
            "2. Spot a butterfly wing.",
            "3. Find the sun that gives us warmth and life.",
            "4. Spot two waiting cats. ",
            "5. Find two swooping owls.",
            "6. Spot a pair of slippers.",
            "7. Find one shy monkey.",
            "8. Spot a book.",
            "9. Find five exploring ants.",
            "10. Spot a hungry caterpillar.",
            "11. Find four red flowers.",
            "12. Spot a kite."
    };

    public final static String[] hintsArray = {
            "The Earth looks like a blue sphere.",
            "Carefully notice the bottom of the screen.",
            "The Sun is yellow.",
            "They're hiding in the grass.",
            "Owls are nocturnal and only come out in the dark.",
            "Look around the humans.",
            "He's there hiding in the tree.",
            "The girl seems to be reading one.",
            "Look on the leaves.",
            "She's eating something on the left.",
            "They are present on the left.",
            "Look in the sky."
    };

}
