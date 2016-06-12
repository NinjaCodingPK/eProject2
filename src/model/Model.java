package model;

import com.sun.org.apache.xpath.internal.operations.Mod;
import entities.*;

import java.util.Map;
import java.util.stream.Collectors;


/**
 * Created by wookie on 6/12/16.
 */
public class Model {
    private Composite text;

    public Model() {

    }

    public Model(Composite text) {
        this.text = text;
    }

    /**
     * Method finds the biggest count of sentences in which some words are equals.
     * @return int value - count of sentences
     */
    public int findMostRepeats() {
        int max = 0;
        int currentMax;

        for(Component paragraph : text.getComponents()) {
            for(Component sentence : ((Composite)paragraph).getComponents()) {

                currentMax = 0;
                for(Map.Entry<Integer, String> word : WordFactory.getWords().entrySet()) {
                    if(this.findRepeatsInSentence((Composite) sentence, word.getValue()))
                        currentMax++;
                }
                if(currentMax > max)
                    max = currentMax;
            }
        }

        return max;
    }

    /**
     * Method checks if some word has repeats in sentence.
     * @param sentence Composite class which defines a single sentence.
     * @param word a word, repeats of which the method will check.
     * @return true - if word has a repeats. False - if not.
     */
    private boolean findRepeatsInSentence(Composite sentence, String word) {
                return (sentence.getComponents().stream()
                        .filter(f -> f.getValue().equals(word))
                        .collect(Collectors.toList()).size() > 1);
    }

    public void setText(Composite text) {
        this.text = text;
    }
}
