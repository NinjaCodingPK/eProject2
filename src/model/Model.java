package model;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import entities.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Class provides methods for working with parsed text.
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

        for(Map.Entry<Integer, String> word : WordFactory.getWords().entrySet()) {
            currentMax = 0;
            for(Component paragraph : text.getComponents()) {
                for(Component sentence : ((Composite)paragraph).getComponents()) {
                    if(this.findRepeatsInSentence((Composite) sentence, word.getValue()))
                        currentMax++;
                }
            }
            if(currentMax > max)
                max = currentMax;
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
