package testReflection;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Onlin on 17.10.2016.
 */
public class Dog {
    public String nameDog = "ruddi";
    private String color = "black";

    public Dog() {

    }

    public Dog(String nameDog, String color) {
        this.nameDog = nameDog;
        this.color = color;
    }

    public String getNameDog() {
        return nameDog;
    }

    public void setNameDog(String name) {
        this.nameDog = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
