package net.jazbelt.chain.model;

public class Circle {
    private final String color;

    public Circle() {
        color = "white";
    }

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle [" + color + "]";
    }
}
