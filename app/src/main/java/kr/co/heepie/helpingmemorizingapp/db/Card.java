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

    // Alarm Period
    //private Object alarmPeriod;
    private void setName(String name) {
        this.name = name;
    }

    private void setDescription(String description) {
        this.description = description;
    }


    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }

    // Builder Pattern
    public static class cardBuilder {
        private Card card;

        public cardBuilder() {
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

        public Card finishBuild() {
            return card;
        }
    }
}