package menu;

import animal.*;
import counter.Counter;

import java.util.Scanner;

public class AnimalRegistryMenu {
    private AnimalRegistry registry;
    private Scanner scanner;

    public AnimalRegistryMenu(AnimalDAO dao) {
        registry = new AnimalRegistry();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("Меню:");
            System.out.println("1. Завести новое животное");
            System.out.println("2. Обучить животное новой команде");
            System.out.println("3. Посмотреть список команд животного");
            System.out.println("4. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    addAnimal();
                    break;
                case 2:
                    trainAnimal();
                    break;
                case 3:
                    listCommands();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Неправильный выбор. Попробуйте снова.");
            }
        }
    }

    private void addAnimal() {
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();

        System.out.println("Выберите тип животного (1 - Собака, 2 - Кошка):");
        int type = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        Animal animal = null;
        switch (type) {
            case 1:
                animal = new Dog(name);
                break;
            case 2:
                animal = new Cat(name);
                break;
            default:
                System.out.println("Неправильный выбор типа животного.");
                return;
        }

        try (Counter counter = registry.getCounter()) {
            registry.addAnimal(animal);
        } catch (Exception e) {
            System.out.println("Ошибка при добавлении животного: " + e.getMessage());
        }
    }

    private void trainAnimal() {
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();

        Animal animal = findAnimal(name);
        if (animal == null) {
            System.out.println("Животное не найдено.");
            return;
        }

        System.out.println("Введите команду для обучения:");
        String command = scanner.nextLine();

        registry.trainAnimal(animal, command);
        System.out.println("Животное успешно обучено новой команде.");
    }

    private void listCommands() {
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();

        Animal animal = findAnimal(name);
        if (animal == null) {
            System.out.println("Животное не найдено.");
            return;
        }

        registry.listCommands(animal);
    }

    private Animal findAnimal(String name) {
        for (Animal animal : registry.getAnimals()) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;
    }


}
