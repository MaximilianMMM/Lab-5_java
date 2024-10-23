package zoo;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;

public class XmlSerializer implements SerializableEntity<Animal> {
    private final XmlMapper xmlMapper = new XmlMapper();

    @Override
    public void serialize(Animal animal, File file) throws Exception {
        xmlMapper.writeValue(file, animal);
    }

    @Override
    public Animal deserialize(File file) throws Exception {
        return xmlMapper.readValue(file, Animal.class);
    }
}
