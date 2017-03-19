package kr.co.heepie.helpingmemorizingapp.frame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Hee_Ju.M on 2017-03-01.
 */

public class Folder extends Component {
    private Set<Card> list = new HashSet<Card>();
    private String description;
    private String color;

    public Folder(String name) {
        super(name);
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

    public Set getSet() {
        return list;
    }

    public void add(Card c) {
        list.add(c);
    }

    public void remove(Card c) {
        list.remove(c);
    }

}
