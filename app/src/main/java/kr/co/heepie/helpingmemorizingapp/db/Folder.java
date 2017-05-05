package kr.co.heepie.helpingmemorizingapp.db;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Hee_Ju.M on 2017-03-01.
 */

public class Folder extends RealmObject {
    @PrimaryKey
    @Required
    private String name;

    private String description;
    private RealmList<Component> list = new RealmList<>();

    private void setName(String name) {
        this.name = name;
    }

    private Folder addComponent(Component obj) {
        list.add(obj);
        return this;
    }

    private void setDescription(String description) {
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public RealmList<Component> getList() {
        return list;
    }


    public String getDescription() {
        return description;
    }

    // Builder Pattern
    public static class FolderBuilder {
        private Folder folder;

        public FolderBuilder() {
            folder = new Folder();
        }

        public static FolderBuilder startBuild() {
            return new FolderBuilder();
        }

        public FolderBuilder setName(String name) {
            folder.setName(name);
            return this;
        }

        public FolderBuilder setDescription(String description) {
            folder.setDescription(description);
            return this;
        }

        public Folder finishBuild() {
            return folder;
        }
    }















/*
    public Folder() { }

    public Folder(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) { this.description = description; }

    public String getDescription() {
        return description;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public RealmList<Card> getSet() {
        return list;
    }

    public void add(Card c) {
        list.add(c);
    }

    public void remove(Card c) {
        list.remove(c);
    }
*/

}
