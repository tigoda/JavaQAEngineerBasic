import animals.Animal;
import animals.exceptions.AnimalNotSupported;
import data.AnimalData;
import data.CommandsData;
import factory.AnimalFactory;
import utils.EnumConverter;
import utils.Validators;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {
    public void consoleCall() throws AnimalNotSupported {
        List<Animal> animals = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Validators validators = new Validators();
        EnumConverter enumConverter = new EnumConverter();


        while (true) {
            System.out.printf("Введите нужную команду: %s\n ", enumConverter.getNamesFromEnum(CommandsData.class,
                    "/"));
            String commandStr = scanner.next().toUpperCase().trim();
            if (!validators.checkValueInEnum(CommandsData.class, commandStr)) {
                System.out.printf("Такой команды не существует %s\n", commandStr);
                continue;
            }

            CommandsData commandsData = CommandsData.valueOf(commandStr);

            switch (commandsData) {
                case ADD: {
                    String animalTypeStr = "";

                    while (true) {
                        System.out.printf("Введите тип животного: %s\n", enumConverter.getNamesFromEnum(AnimalData.class,
                                "/"));
                        animalTypeStr = scanner.next().toUpperCase().trim();

                        if (validators.checkValueInEnum(AnimalData.class, animalTypeStr)) {
                            break;
                        }
                        System.out.printf("Такого типа животного не существует %s\n", animalTypeStr);
                    }
                    Animal animal = new AnimalFactory(scanner).create(animalTypeStr);

                    animal.setName();
                    animal.setAge();
                    animal.setColor();
                    animal.setWeight();

                    animals.add(animal);
                }
                case LIST: {
                    if (animals.isEmpty()) {
                        System.out.printf("Список животных пустой");
                        break;
                    }

                    animals.forEach((Animal animal) -> System.out.println(animal.toString()));
                    break;
                }
                case EXIT:
                    System.exit(0);
            }
        }
    }
}
