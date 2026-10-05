package eu.happycoders.final_means_final.demo_1;

import eu.happycoders.final_means_final.shared.ApparentlyHarmlessThirdPartyLibrary;

public class TwoPlusTwoComplete {

    public static void main(String[] args) {
        // The application only wants to check a string with the library...
        ApparentlyHarmlessThirdPartyLibrary.isEmpty("foo");

        int a = 2;
        int b = 2;
        Integer sum = a + b;
        System.out.println("2 + 2 = " + sum);
    }
}
