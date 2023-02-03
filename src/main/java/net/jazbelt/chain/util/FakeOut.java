package net.jazbelt.chain.util;

public class FakeOut {
    private static String output;

    public static void print(String s) {
        output = s;
        System.out.println("[FakeOut]: " + s);
    }

    public static String read() {
        return output;
    }
}
