package model

import com.fasterxml.jackson.annotation.JsonProperty

class People {

    private String name
    private String fullName
    private int age

    String getName(){
        return name
    }

    int getAge(){
        return age
    }

    String getFullName(){
        return fullName
    }

    People(){
        super()
    }

    People(String name, int age,String fullName){
        this.name = name
        this.age = age
        this.fullName = fullName
    }

    @Override
    String toString() {
        return "Name: $name \nAge: $age\n$fullName"
    }
}
