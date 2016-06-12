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
    public void print() {
        //System.out.print(FlyWeight.words.get(value) + " ");
        System.out.print(WordFactory.get(value) + " ");
    }

    public String getValue() {
        return WordFactory.get(value);
    }

    public void setValue(int value) {
        this.value = value;
    }
}
