package entities;

/**
 * Leaf class from "Composite" pattern.
 * Created by wookie on 6/16/16.
 */
public class Symbol implements TextComponent {
    private char value;

    public Symbol() {

    }

    public Symbol(char value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return Character.toString(value);
    }
}
