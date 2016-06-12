package entities;

/**
 * Class "Leaf" in Composite pattern.
 * Created by wookie on 6/12/16.
 */
public class Word implements Component {
    private int value;

    public Word(int value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return WordFactory.get(value);
    }

    public void setValue(int value) {
        this.value = value;
    }
}
