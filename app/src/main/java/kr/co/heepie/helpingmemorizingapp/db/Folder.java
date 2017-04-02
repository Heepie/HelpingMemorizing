package kr.co.heepie.helpingmemorizingapp.db;

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
    private String upperFolder;

    public void setName(String name) {
        this.name = name;
    }

    public void setUpperFolder(String upperFolder) {
        this.upperFolder = upperFolder;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getUpperFolder() {
        return upperFolder;
    }

    public String getDescription() {
        return description;
    }

    public static class FolderBuilder {
        private Folder folder;

        private FolderBuilder() {
            folder = new Folder();
        }

        public static FolderBuilder startBuild() {
            return new FolderBuilder();
        }

        public FolderBuilder setName(String name) {
            folder.setName(name);
            return this;
        }

        public FolderBuilder setUpperFolder(String upperFolder) {
            folder.setUpperFolder(upperFolder);
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
