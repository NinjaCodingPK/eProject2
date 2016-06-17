package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite class from "Composite" pattern.
 * Created by wookie on 6/12/16.
 */
public class TextComposite implements TextComponent {
    private List<TextComponent> components = new ArrayList<>();

    public TextComposite() {

    }

    public TextComposite(List<TextComponent> components) {
        this.components = components;
    }

    /**
     * Method build value of component with values of his components.
     * @return stringed value.
     */
    @Override
    public String getValue() {
        StringBuilder str = new StringBuilder();
        for(TextComponent c : components) {
            str.append(c.getValue());
        }

        return str.toString();
    }

    /**
     * Method add a component into list of components.
     * @param component a component to add.
     */
    public void addComponent(TextComponent component) {
        components.add(component);
    }

    /**
     * Method remove component from list of components.
     * @param component a component to remove.
     */
    public void removeComponent(TextComponent component) {
        components.remove(component);
    }

    public void setComponents(List<TextComponent> components) {
        this.components = components;
    }

    public List<TextComponent> getComponents() {
        return components;
    }
}
