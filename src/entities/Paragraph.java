package entities;

import java.util.List;

/**
 * Created by wookie on 6/13/16.
 */
public class Paragraph extends Composite {
    public Paragraph() {

    }

    public Paragraph(List<Component> components) {
        super(components);
    }

    @Override
    public String getValue(){
        StringBuilder str = new StringBuilder();
        for(Component c : components) {
            str.append(c.getValue());
        }
        str.append("\n");

        return str.toString();
    }
}
