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
        animals.add(new Animal("Fido", "dog", "mutt", "old, but good"));
        animals.add(new Animal("Felix", "cat", "calico", "okay for a cat"));
        animals.add(new Animal("Charlie", "fish", "tuna", "Sorry! He's not good enough for StarKist"));
        animals.add(new Animal("Slithering", "reptile", "snake", "watch out for this guy - he's sneaky"));
    }

//    public ArrayList<Animal> listAnimals() {
//        return animals;
//    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
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
