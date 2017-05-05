package kr.co.heepie.helpingmemorizingapp.db;

import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;
import io.realm.annotations.Required;

/**
 * Created by Hee_Ju.M on 2017-05-05.
 */

// Composite Pattern
public abstract class Component implements RealmModel {
    private String name;

    public Component(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
