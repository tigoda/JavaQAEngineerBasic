package animals.pets;

import animals.Animal;
import java.util.Scanner;

public class Cat extends Animal {
    public Cat(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void say() {
        System.out.println("Мяу");

    }
}
