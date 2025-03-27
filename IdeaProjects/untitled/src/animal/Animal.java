package animal;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String name;
    private String species;
    private List<String> commands;

    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
        this.commands = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public List<String> getCommands() {
        return commands;
    }

    @Override
    public String toString() {
        return "animal.Animal{" +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", commands=" + commands +
                '}';
    }
}

