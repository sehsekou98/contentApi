package Contentapi.config;

import Contentapi.model.Content;
import Contentapi.repository.ContentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final ContentRepository repository;
    private final ObjectMapper objectMapper;

    public DataLoader(ContentRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws  Exception{
        if (repository.count()==0){
            try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/contents.json")){
                repository.saveAll(objectMapper.readValue(inputStream,new TypeReference<List<Content>>(){}));

            }

        }
    }
}
