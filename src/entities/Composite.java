package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wookie on 6/12/16.
 */
public class Composite implements Component{
    protected List<Component> components = new ArrayList<>();

    public Composite() {

    }

    public Composite(List<Component> components) {
        this.components = components;
    }

    @Override
    public String getValue(){
        StringBuilder str = new StringBuilder();
        for(Component c : components) {
            str.append(c.getValue());
            str.append(" ");
        }
        str.setCharAt(str.length()-1, '.');
        //str.append(".");

        return str.toString();
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public List<Component> getComponents() {
        return components;
    }
}
