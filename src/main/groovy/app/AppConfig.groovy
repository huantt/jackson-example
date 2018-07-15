package app

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import io.MongoDB


class AppConfig {

    @JsonProperty("mongodb.uri")
    MongoDB mongoDB

    static AppConfig newInstance(File appConfigFile) {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory()).with {
            setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        }

        AppConfig appConfig = objectMapper.readValue(appConfigFile, AppConfig.class)
        return appConfig

    }

    MongoDB getMongoDB() {
        return mongoDB
    }
}
