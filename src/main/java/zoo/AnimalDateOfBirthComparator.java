package zoo;

import java.util.Comparator;

public class AnimalDateOfBirthComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal animal1, Animal animal2) {
        return animal1.getBirthDate().compareTo(animal2.getBirthDate());
    }
}
