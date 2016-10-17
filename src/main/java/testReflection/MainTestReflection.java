package testReflection;

/**
 * Created by Onlin on 17.10.2016.
 */
public class MainTestReflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Dog dog = new Dog();
        System.out.println(dog.getNameDog() + " " + dog.getColor());
        Class clazz = Class.forName(dog.getClass().getName());
        Object obj = clazz.newInstance();
        Dog cloneDog = (Dog) obj;
        System.out.println(cloneDog.getNameDog() + " " + cloneDog.getColor());

        cloneDog.setColor("red");

        System.out.println(dog.getNameDog() + " " + dog.getColor());
        System.out.println(cloneDog.getNameDog() + " " + cloneDog.getColor());


    }
}
