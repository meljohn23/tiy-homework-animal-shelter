package repository;

import entity.Animal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by melaniejohnson on 9/13/16.
 */
public class AnimalRepository {

    ArrayList<Animal> animals = new ArrayList();

    public AnimalRepository() {
        animals.add(new Animal("Fido", "dog", "mutt", "brown with black spots"));
        animals.add(new Animal("Felix", "cat", "calico", "biege, brown & taupe"));
        animals.add(new Animal("Charlie", "fish", "tuna", "silver"));
        animals.add(new Animal("Slithering", "reptile", "snake", "grey"));
    }

    public void addAnimal(Animal animal) throws IOException {
        animals.add(animal);
    }

    public List<Animal> listAnimals() {
        return animals;
    }

    public void persist() throws IOException {
//        String json = gson.to
    }

    public void updateAnimal(int index, Animal animal) {
        animals.set(index, animal);
    }

    public void deleteAnimal(int index) throws IOException {
        animals.remove(index);
    }

    public Animal getAnimal(int index) throws IOException {
        if (index >= animals.size() || index < 0) {
            return null;
        }
        return animals.get(index);
    }
}
