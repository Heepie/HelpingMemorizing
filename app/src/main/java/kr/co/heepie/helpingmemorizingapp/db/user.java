package kr.co.heepie.helpingmemorizingapp.db;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Hee_Ju.M on 2017-03-13.
 */

public class user extends RealmObject {
    @PrimaryKey
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
