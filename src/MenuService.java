import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by melaniejohnson on 9/7/16.
 */
public class MenuService {
    Scanner scanner = new Scanner(System.in);

    public static final int LIST_ANIMAL = 1;
    public static final int CREATE_ANIMAL = 2;
    public static final int VIEW_ANIMAL = 3;
    public static final int EDIT_ANIMAL = 4;
    public static final int DELETE_ANIMAL = 5;
    public static final int QUIT = 6;

    public int promptForMainMenuSelection() {
        System.out.println("\n-- Main Menu --\n" +
                "\n" +
                "1) List animals\n" +
                "2) Create an animal\n" +
                "3) View animal details\n" +
                "4) Edit an animal\n" +
                "5) Delete an animal\n" +
                "6) Quit\n");

        return waitForInt("Please choose an option: ");
    }

    public Animal promptForAnimalData() {
        System.out.println("\n-- Create an Animal --\n");

        String name = waitForString("Name: ", true);
        String type = waitForString("Type: ", true);
        String breed = waitForString("Breed: ", true);
        String description = waitForString("Description: ", true);

        return new Animal(name, type, breed, description);

    }

    public static void listAnimals(List<Animal> animals) {
        System.out.println("\n-- List Animals --\n");

        if (animals.size() <= 0) {
            System.out.println("\nNo Animals were found. \n");

        } else {
            for (int x = 0; x < animals.size(); x++) {
                Animal animal = animals.get(x);
                System.out.printf("%s) %s\n", x, animal.getName());
            }
        }
    }

    private String waitForString(String message, boolean required) {
        System.out.println(message);

        String value = scanner.nextLine();

        if (required && value.trim().length() == 0) {
            System.out.println("\nPlease provide a value.\n");

            value = waitForString(message, required);
        }
        return value.trim();
    }

    public int promptForAnimalID() {
        return waitForInt("Enter ID# of animal: ");
    }

    public void displayNoSuchAnimal() {
        System.out.println("\nSorry, I couldn't find that animal.\n");
    }

    public void displayAnimals(Animal animal) {
        System.out.printf("\n-- View an Animal --\n" +
                        "\n" +
                        "Name: %s\n" +
                        "Type: %s\n" +
                        "Breed: %s\n" +
                        "Description: %s\n",
                animal.getName(),
                animal.getType(),
                animal.getBreed(),
                animal.getDescription());
    }

    public void editAnimal(Animal animal) {
        System.out.println("\n-- Edit an Animal --\n");

        animal.setName(waitForString("Name: ", animal.getName()));
        animal.setType(waitForString("Type: ", animal.getType()));
        animal.setBreed(waitForString("Breed: ", animal.getBreed()));
        animal.setDescription(waitForString("Description: ", animal.getDescription()));

    }

    private String waitForString(String message, String defaultValue) {
        System.out.println(message + "[" + defaultValue + "]: ");

        String value = scanner.nextLine();

        if (value.trim().length() == 0) {
            return defaultValue;
        }
        return value.trim();
    }

    public int waitForInt(String message) {
        System.out.println(message);

        String input = scanner.nextLine();

        int value;
        try {
            value = Integer.parseInt(input);

        } catch (Exception e) {
            System.out.println("\nSorry, that isn't a valid option.\n");
            value = waitForInt(message);
        }
        return value;
    }

    public boolean waitForYN(String message) {
        System.out.println(message);

        String input = scanner.nextLine().trim().toLowerCase();

        boolean valid = (input.equals("no") || (input.equals("yes")));
        while (!valid) {
            System.out.println("\nSorry, that isn't a valid option.\n");
            input = scanner.nextLine().trim().toLowerCase();
            valid = (input.equals("no") || (input.equals("yes")));
        }
        return input.equals("yes");
    }
}


