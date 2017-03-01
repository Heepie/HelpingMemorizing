package kr.co.heepie.helpingmemorizingapp.frame;

import java.util.ArrayList;

/**
 * Created by Hee_Ju.M on 2017-03-01.
 */

public class Folder extends Component {
    private ArrayList<Component> list = new ArrayList<>();
    private String description;
    private int color;

    public Folder(String name) {
        super(name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void add(Component c) {
        list.add(c);
    }

    public void remove(Component c) {
        int idx = list.indexOf(c);
        list.remove(idx);
    }
}
