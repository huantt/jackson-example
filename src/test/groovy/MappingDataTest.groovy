import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import model.People
import spock.lang.Specification

class MappingDataTest extends Specification {

    def "Write object to json"() {
        given:
        People people = new People(null, 22, "Tat Huan")
        String json = objectMapper.writeValueAsString(people)

        expect:
        json.equals(expectationResult)

        where:
        objectMapper || expectationResult
        //Option 1: Indent output
        new ObjectMapper().with {
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
            setSerializationInclusion(JsonInclude.Include.NON_NULL)
            enable(SerializationFeature.INDENT_OUTPUT)
        }            || new File("src/test/resources/indented-data.json").getText()
        //Option 2: Do not indent ouput
        new ObjectMapper().with {
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
            setSerializationInclusion(JsonInclude.Include.NON_NULL)
        }            || new File("src/test/resources/data.json").getText()
    }

    def "Read object from json"() {
        given:
        ObjectMapper objectMapper = new ObjectMapper().with {
            configure(JsonParser.Feature.ALLOW_COMMENTS, true)
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
        }

        People people = objectMapper.readValue(jsonInput, People.class)

        expect:
        people.equals(expectationResult)

        where:
        jsonInput                                                   || expectationResult
        new File("src/test/resources/indented-data.json").getText() || new People(null, 22, "Tat Huan")
        new File("src/test/resources/data.json").getText()          || new People(null, 22, "Tat Huan")

    }

    def "Read object from yml"() {
        given:
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory()).with {
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
            configure(JsonParser.Feature.ALLOW_COMMENTS, true)
        }
        People expectationResult = new People("Huan", 22, "Tat Huan")
        People people = objectMapper.readValue(new File("src/test/resources/data.yml"), People.class)

        expect:
        people.equals(expectationResult)


    }
}

