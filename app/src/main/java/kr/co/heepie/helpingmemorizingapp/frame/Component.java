package kr.co.heepie.helpingmemorizingapp.frame;

/**
 * Created by Hee_Ju.M on 2017-03-01.
 */

public abstract class Component {
    private String name;
    private String date;

    public Component(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
