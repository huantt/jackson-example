package app

import com.fasterxml.jackson.databind.ObjectMapper
import model.People

class Runner {
    static void main(String[] args) {
        writeObject()
        readObject()

    }

    static void writeObject() {
        ObjectMapper objectMapper = new ObjectMapper()
        People people = new People("Huan", 22)
        objectMapper.writeValue(new File("src/main/resources/people.json"), people)
    }

    static void readObject() {
        ObjectMapper objectMapper = new ObjectMapper()
        People people = objectMapper.readValue(new File("src/main/resources/people.json"), People.class)

        println people.toString()
    }
}
