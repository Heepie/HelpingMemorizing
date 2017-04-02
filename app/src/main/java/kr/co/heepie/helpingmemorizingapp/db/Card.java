package kr.co.heepie.helpingmemorizingapp.db;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Hee_Ju.M on 2017-03-01.
 */

public class Card extends RealmObject {

    @PrimaryKey
    @Required
    private String name;

    private String description;
    private String upperFolder;

    // Alarm Period
    //private Object alarmPeriod;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUpperFolder(String upperFolder) {
        this.upperFolder = upperFolder;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUpperFolder() {
        return upperFolder;
    }

    public static class cardBuilder {
        private Card card;

        private cardBuilder() {
            card = new Card();
        }

        public static cardBuilder startBuild() {
            return new cardBuilder();
        }

        public cardBuilder setName(String name) {
            card.setName(name);
            return this;
        }

        public cardBuilder setDescription(String description) {
            card.setDescription(description);
            return this;
        }

        public cardBuilder setUpperFolder(String upperFolder) {
            card.setUpperFolder(upperFolder);
            return this;
        }

        public Card finishBuild() {
            return card;
        }
    }
}