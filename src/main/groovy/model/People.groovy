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

    @Override
    boolean equals(Object people) {
        people = (People) people
        boolean isEquals = this.name.equals(people.name) && this.age == people.age && this.fullName.equals(people.fullName)
        return isEquals
    }

}
