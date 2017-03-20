package kr.co.heepie.helpingmemorizingapp.frame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Hee_Ju.M on 2017-03-01.
 */

public class Folder extends RealmObject {
    private String name;
    private RealmList<Card> list = new RealmList<Card>();
    private String description;
    private String color;

    public Folder() {

    }

    public Folder(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public RealmList getSet() {
        return list;
    }

    public void add(Card c) {
        list.add(c);
    }

    public void remove(Card c) {
        list.remove(c);
    }

}