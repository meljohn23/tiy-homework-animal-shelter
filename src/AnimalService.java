import java.beans.Statement;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by melaniejohnson on 9/7/16.
 */
public class AnimalService {
    //methods --animals -- getAnimals
//create arraylist of all instances of animals
    ArrayList<Animal> animals = new ArrayList();

    public AnimalService() {
        animals.add(new Animal("Fido", "dog", "mutt", "brown with black spots"));
        animals.add(new Animal("Felix", "cat", "calico", "biege, brown & taupe"));
        animals.add(new Animal("Charlie", "fish", "tuna", "silver"));
        animals.add(new Animal("Slithering", "reptile", "snake", "grey"));
    }

//    public ArrayList<Animal> listAnimals() {
//        return animals;
//    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void updateAnimal(int index, Animal animal) {
        animals.set(index, animal);
    }
    public void deleteAnimal(int index) {
        animals.remove(index);
    }
    public Animal getAnimal(int index) {
        if (index >= animals.size() || index < 0) {
            return null;
        }
        return animals.get(index);
    }
}
