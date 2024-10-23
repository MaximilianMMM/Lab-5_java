package zoo;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;

public class YamlSerializer implements SerializableEntity<Animal> {
    private final YAMLMapper yamlMapper = new YAMLMapper();

    @Override
    public void serialize(Animal animal, File file) throws Exception {
        yamlMapper.writeValue(file, animal);
    }

    @Override
    public Animal deserialize(File file) throws Exception {
        return yamlMapper.readValue(file, Animal.class);
    }
}
