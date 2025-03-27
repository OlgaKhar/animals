package animal;

import counter.Counter;

import java.util.ArrayList;
import java.util.List;

public class AnimalRegistry {
    private List<Animal> animals;
    private Counter counter;

    public AnimalRegistry() {
        animals = new ArrayList<>();
        counter = new Counter();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        counter.add();
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public Counter getCounter() {
        return counter;
    }

    public void trainAnimal(Animal animal, String command) {
        animal.addCommand(command);
    }

    public void listCommands(Animal animal) {
        System.out.println("Команды для " + animal.getName() + ": " + animal.getCommands());
    }
}