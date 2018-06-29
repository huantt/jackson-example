package app

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import model.People

class Runner {

    static void main(String[] args) {
        writeObjectToJson()
        readObjectFromJson()
        redObjectFromYML()
    }

    static void writeObjectToJson() {
        ObjectMapper objectMapper = new ObjectMapper().with {
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
        }

        People people = new People("Huan", 22,"Tat Huan")
        objectMapper.writeValue(new File("src/main/resources/people.json"), people)
    }

    static void readObjectFromJson() {
        ObjectMapper objectMapper = new ObjectMapper().with {
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
        }

        People people = objectMapper.readValue(new File("src/main/resources/people.json"), People.class)
        println people.toString()
    }

    static void redObjectFromYML() {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory()).with {
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
        }

        println objectMapper
                .readValue(new File("src/main/resources/people.yml"), People.class)
                .toString()
    }
}
