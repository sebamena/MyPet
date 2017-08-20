package cl.sebastian.mypet.models;

import com.orm.SugarRecord;

/**
 * Created by Sebastián Mena on 19/08/2017.
 */

public class Pet extends SugarRecord {

    private String name,type,breed,genre,nameowner,date;
    private int age,phoneowner;

    public Pet() {
    }

    public Pet(String name, String type, String breed, String genre, String nameowner, int age, int phoneowner) {
        this.name = name;
        this.type = type;
        this.breed = breed;
        this.genre = genre;
        this.nameowner = nameowner;
        this.age = age;
        this.phoneowner = phoneowner;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNameowner() {
        return nameowner;
    }

    public void setNameowner(String nameowner) {
        this.nameowner = nameowner;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhoneowner() {
        return phoneowner;
    }

    public void setPhoneowner(int phoneowner) {
        this.phoneowner = phoneowner;
    }
}
