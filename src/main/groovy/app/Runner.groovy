package app

import com.fasterxml.jackson.core.JsonParser
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
        createAppConfig()
    }

    static void writeObjectToJson() {
        ObjectMapper objectMapper = new ObjectMapper().with {
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
        }

        People people = new People("Huan", 22, "Tat Huan")
        String json = objectMapper.writeValueAsString(people)
        println json
    }

    static void readObjectFromJson() {
        ObjectMapper objectMapper = new ObjectMapper().with {
            configure(JsonParser.Feature.ALLOW_COMMENTS, true)
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)

        }

        File jsonFile = new File("src/main/resources/people.json")
        People people = objectMapper.readValue(jsonFile, People.class)
        println people.toString()
    }

    static void redObjectFromYML() {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory()).with {
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
            configure(JsonParser.Feature.ALLOW_COMMENTS, true)
        }

        println objectMapper
                .readValue(new File("src/main/resources/people.yml"), People.class)
                .toString()
    }

    static void createAppConfig() {
        AppConfig appConfig = AppConfig.newInstance(new File("src/main/resources/config.json"))
        println appConfig.getMongoDB().getUri()
    }
}
