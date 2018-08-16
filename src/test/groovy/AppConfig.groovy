import spock.lang.Specification

class AppConfig extends Specification {

    def "Create appConfig"() {
        given:
        app.AppConfig appConfig = app.AppConfig.newInstance(new File("src/main/resources/config.json"))
        String mongoUri = appConfig.getMongoDB().uri
        String expectationMongoUri = "mongodb://localhost:57017"

        expect:
        mongoUri.equals(expectationMongoUri)
    }
}
