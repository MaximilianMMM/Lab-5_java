package zoo;

import java.util.*;
import java.util.stream.Collectors;

public class AnimalService {

    // 1. Метод для сортування тварин за іменем (за замовчуванням, через Comparable)
    public List<Animal> sortAnimalsByName(List<Animal> animals) {
        return animals.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // 2. Метод для сортування тварин за датою народження через Comparator
    public List<Animal> sortAnimalsByBirthDate(List<Animal> animals) {
        return animals.stream()
                .sorted(new AnimalDateOfBirthComparator())
                .collect(Collectors.toList());
    }

    // 3. Метод для фільтрації тварин за їжею через Stream API
    public List<Animal> filterAnimalsByFood(List<Animal> animals, String food) {
        return animals.stream()
                .filter(animal -> animal.getFoodName().equals(food))
                .collect(Collectors.toList());
    }
}
