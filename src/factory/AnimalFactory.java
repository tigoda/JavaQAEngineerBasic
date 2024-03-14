package factory;

import animals.Animal;
import animals.birds.Duck;
import animals.exceptions.AnimalNotSupported;
import animals.pets.Cat;
import animals.pets.Dog;
import data.AnimalData;
import java.util.Scanner;

public class AnimalFactory {
    public AnimalFactory(Scanner scanner) {
        this.scanner = scanner;
    }

    private Scanner scanner = null;

    public Animal create(String animalData) throws AnimalNotSupported {
        switch (animalData.toLowerCase().trim()) {
            case "cat": {
                return new Cat(scanner);
            }
            case "dog": {
                return new Dog(scanner);
            }
            case "duck": {
                return new Duck(scanner);
            }
        }
        throw new AnimalNotSupported(AnimalData.valueOf(animalData));
    }
}
