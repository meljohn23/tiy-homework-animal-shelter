package service;

import entity.Animal;
import repository.AnimalRepository;

import java.io.IOException;
import java.util.List;

/**
 * Created by melaniejohnson on 9/7/16.
 */
public class AnimalService {

    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> listAnimals() {
        return animalRepository.listAnimals();
    }

    public void createAnimal(Animal animal) throws IOException {
        animalRepository.createAnimal(animal);
    }

    public Animal getAnimal(int index) throws IOException {
        return animalRepository.getAnimal(index);
    }

    public void updateAnimal(int index, Animal animal) throws IOException {
        animalRepository.updateAnimal(index, animal);
    }

    public void deleteAnimal(int index) throws IOException {
        animalRepository.deleteAnimal(index);
    }
}
