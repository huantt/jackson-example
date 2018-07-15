package io

class MongoDB {

    String uri

    MongoDB(String uri){
        this.uri = uri
        println "Created new instance with uri: $uri"
    }

    String getUri() {
        return uri
    }
}
