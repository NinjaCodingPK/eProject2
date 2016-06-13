package entities;

import java.util.List;

/**
 * Created by wookie on 6/13/16.
 */
public class Sentence extends Composite {
    public Sentence() {

    }

    public Sentence(List<Component> components) {
        super(components);
    }

    @Override
    public String getValue(){
        StringBuilder str = new StringBuilder();
        for(Component c : components) {
            str.append(c.getValue());
            str.append(" ");
        }
        str.setCharAt(str.length()-1, '.');
        str.append(" ");

        return str.toString();
    }
}
