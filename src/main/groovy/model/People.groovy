package model

class People {

    private String name
    private int age

    String getName(){
        return name
    }

    int getAge(){
        return age
    }

    People(){
        super()
    }

    People(String name, int age){
        this.name = name
        this.age = age
    }

    @Override
    String toString() {
        return "Name: $name \nAge: $age"
    }
}
