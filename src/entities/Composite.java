package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wookie on 6/12/16.
 */
public class Composite implements Component{
    private List<Component> components = new ArrayList<>();

    @Override
    public void print() {
        for(Component c : components) {
            c.print();
        }
        System.out.println(". ");
    }

    @Override
    public String getValue() {
        StringBuilder str = new StringBuilder();
        for(Component c : components) {
            str.append(c.getValue());
        }

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
