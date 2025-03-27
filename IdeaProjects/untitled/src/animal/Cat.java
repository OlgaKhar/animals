package animal;

public class Cat extends Animal {
    public Cat(String name) {
        super(name, "animal.Cat");
    }

    @Override
    public String toString() {
        return "animal.Cat{" +
                "name='" + getName() + '\'' +
                ", commands=" + getCommands() +
                '}';
    }
}
