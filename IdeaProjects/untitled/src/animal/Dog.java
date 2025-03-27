package animal;

public class Dog extends Animal {
    public Dog(String name) {
        super(name, "animal.Dog");
    }

    @Override
    public String toString() {
        return "animal.Dog{" +
                "name='" + getName() + '\'' +
                ", commands=" + getCommands() +
                '}';
    }
}