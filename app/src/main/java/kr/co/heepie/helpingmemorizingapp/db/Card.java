package kr.co.heepie.helpingmemorizingapp.db;

import io.realm.RealmObject;

/**
 * Created by Hee_Ju.M on 2017-03-01.
 */

public class Card extends RealmObject {
    private String name;
    private String concept;
    private String description;

    public Card() { }

    public Card(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public String getConcept() { return concept; }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object obj) {
        Card c = (Card)obj;
        if (c.getConcept() == concept)
            return true;
        else
            return false;
    }
}