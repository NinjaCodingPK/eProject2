package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wookie on 6/12/16.
 */
public abstract class Composite implements Component{
    protected List<Component> components = new ArrayList<>();

    public Composite() {

    }

    public Composite(List<Component> components) {
        this.components = components;
    }

    /**
     * Method build value of component with values of his components.
     * @return stringed value.
     */
    @Override
    public abstract String getValue();

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
