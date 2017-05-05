package kr.co.heepie.helpingmemorizingapp.db;

import java.lang.annotation.Annotation;

import io.realm.annotations.RealmModule;

/**
 * Created by Hee_Ju.M on 2017-05-05.
 */

public class Card extends Component implements RealmModule {
    private String description;

    public Card(String name) {
        super(name);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean library() {
        return false;
    }

    @Override
    public boolean allClasses() {
        return false;
    }

    @Override
    public Class<?>[] classes() {
        return new Class<?>[0];
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    // Builder Pattern
    public static class cardBuilder {
        private Card card;

        public cardBuilder() {
            card = new Card("baisc_name");
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
