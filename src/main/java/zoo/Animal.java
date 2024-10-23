package zoo;

public class Animal {
    private int id; // Додаємо поле id
    private String name;
    private String gender;
    private String birthDate;
    private String arrivalDate;
    private HealthStatus healthStatus;
    private Section section;
    private String foodName;

    // Конструктор для Builder
    public Animal(AnimalBuilder builder) {
        this.id = builder.id; // Додаємо ідентифікатор
        this.name = builder.name;
        this.gender = builder.gender;
        this.birthDate = builder.birthDate;
        this.arrivalDate = builder.arrivalDate;
        this.healthStatus = builder.healthStatus;
        this.section = builder.section;
        this.foodName = builder.foodName;
    }

    public int getId() { // Геттер для id
        return id;
    }

    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getBirthDate() { return birthDate; }
    public String getArrivalDate() { return arrivalDate; }
    public HealthStatus getHealthStatus() { return healthStatus; }
    public Section getSection() { return section; }
    public String getFoodName() { return foodName; }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
