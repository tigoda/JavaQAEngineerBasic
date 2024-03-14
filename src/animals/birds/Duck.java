package animals.birds;

import animals.Animal;
import java.util.Scanner;

public class Duck extends Animal implements IFlying {

    public Duck(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void say() {
        System.out.println("Кря");
    }

    @Override
    public void fly() {
        System.out.println("Я лечу");

    }
}