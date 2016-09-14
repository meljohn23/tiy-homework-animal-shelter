package service;

import entity.Animal;
import repository.AnimalRepository;

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



}
