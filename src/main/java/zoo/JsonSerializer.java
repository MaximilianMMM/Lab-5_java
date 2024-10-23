package zoo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonSerializer implements SerializableEntity<Animal> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void serialize(Animal animal, File file) throws Exception {
        objectMapper.writeValue(file, animal);
    }

    @Override
    public Animal deserialize(File file) throws Exception {
        return objectMapper.readValue(file, Animal.class);
    }
}
