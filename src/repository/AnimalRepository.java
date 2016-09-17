package repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entity.Animal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by melaniejohnson on 9/13/16.
 */
public class AnimalRepository {

    private final Path filePath;
    private final Gson gson;

    private ArrayList<Animal> animals = new ArrayList();

    public AnimalRepository(String file) throws IOException {

        gson = new GsonBuilder().setPrettyPrinting().create();

        filePath = Paths.get(file);

        if (Files.exists(filePath)) {
            String json = new String(Files.readAllBytes(filePath));
            Type listType = new TypeToken<ArrayList<Animal>>(){}.getType();

            animals = gson.fromJson(json, listType);

//            animals.add(new Animal("Fido", "dog", "mutt", "brown with black spots"));
//            animals.add(new Animal("Felix", "cat", "calico", "biege, brown & taupe"));
//            animals.add(new Animal("Charlie", "fish", "tuna", "silver"));
//            animals.add(new Animal("Slithering", "reptile", "snake", "grey"));
        }
    }

    public void createAnimal(Animal animal) throws IOException {
        animals.add(animal);

        persist();
    }

    public List<Animal> listAnimals() {
        return animals;
    }

    public void persist() throws IOException {
        String json = gson.toJson(animals);
        Files.write(filePath, json.getBytes());
    }

    public void updateAnimal(int index, Animal animal) throws IOException {
        animals.set(index, animal);

        persist();
    }

    public void deleteAnimal(int index) throws IOException {
        animals.remove(index);

        persist();
    }

    public Animal getAnimal(int index) throws IOException {
        if (index >= animals.size() || index < 0) {
            return null;
        }
        return animals.get(index);
    }
}
