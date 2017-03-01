package kr.co.heepie.helpingmemorizingapp.frame;

/**
 * Created by Hee_Ju.M on 2017-03-01.
 */

public class Card extends Component {
    private String concept;
    private String description;

    public Card(String name) {
        super(name);
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
