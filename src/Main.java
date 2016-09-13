
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by melaniejohnson on 9/7/16.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        MenuService menuService = new MenuService();
        AnimalService animalService = new AnimalService();

        while (true) {
            int action = menuService.promptForMainMenuSelection();

            if (action == MenuService.CREATE_ANIMAL) {
                Animal animal = menuService.promptForAnimalData();

                animalService.addAnimal(animal);

            } else if (action == MenuService.LIST_ANIMAL) {
                List<Animal> animals = animalService.animals;

                menuService.listAnimals(animals);

            } else if (action == MenuService.VIEW_ANIMAL) {

                int index = menuService.promptForAnimalID();

                Animal animal = animalService.getAnimal(index);

                if (animal != null) {
                    menuService.displayAnimals(animal);

                } else {
                    menuService.displayNoSuchAnimal();
                }

            } else if (action == MenuService.EDIT_ANIMAL) {

                int index = menuService.promptForAnimalID();

                Animal animal = animalService.getAnimal(index);

                if (animal != null) {
                    menuService.editAnimal(animal);

                    animalService.updateAnimal(index, animal);

                } else {
                    menuService.displayNoSuchAnimal();
                }



            } else if (action == MenuService.DELETE_ANIMAL) {

                boolean doRemove = false;

                int index = menuService.promptForAnimalID();

                Animal animal = animalService.getAnimal(index);

                while (animal == null) {
                    menuService.displayNoSuchAnimal();
                    index = menuService.promptForAnimalID();
                    animal = animalService.getAnimal(index);
                }
                menuService.displayAnimals(animal);
                  doRemove = menuService.waitForYN("Are you sure you want to delete this animal? (yes / no)");

                if (doRemove) {
                    animalService.deleteAnimal(index);
                    menuService.showDeleteSuccess();
                }

            } else if (action == MenuService.QUIT) {
                boolean quit = menuService.waitForYN("Are you sure you want to quit?");
                if (quit) {
                    break;
                }
            }
        }
        System.out.println("Bye!");
    }
}
