package animals.pets;

import animals.Animal;
import java.util.Scanner;

public class Dog extends Animal {
    public Dog(Scanner scanner) {
        super(scanner);
    }

        @Override
        public void say() {
            System.out.println("Гав");

        }
    }
