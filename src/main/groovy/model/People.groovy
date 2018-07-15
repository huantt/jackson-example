package model

class People {

    private String name
    private String fullName
    private int age

    People() {
        super()
    }

    People(String name, int age, String fullName) {
        this.name = name
        this.age = age
        this.fullName = fullName
    }

    String getName() {
        return name
    }

    int getAge() {
        return age
    }

    String getFullName() {
        return fullName
    }

    @Override
    String toString() {
        return "Name: $name \nFull Name: $fullName\nAge: $age"
    }
}
