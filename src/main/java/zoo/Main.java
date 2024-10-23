package zoo;

public class Main {
    public static void main(String[] args) {
        // Створення об'єкта HealthStatus
        HealthStatus healthyStatus = new HealthStatus.HealthStatusBuilder()
                .setStatus("Healthy") // Використання Builder
                .build();

        // Створення об'єкта Section
        Section section = new Section.SectionBuilder()
                .setSectionName("Savannah") // Використання Builder
                .setLocation("Africa Zone")  // Використання Builder
                .build();

        // Створення об'єкта Animal
        Animal lion = new AnimalBuilder()
                .setName("Lion")
                .setGender("Male")
                .setBirthDate("2020-03-15")
                .setArrivalDate("2021-05-20")
                .setHealthStatus(healthyStatus) // Використання вже створеного об'єкта
                .setSection(section) // Використання вже створеного об'єкта
                .setFoodName("Meat")
                .build();

        // Вивід даних про тварину
        System.out.println("Animal created: " + lion.getName());
    }
}
