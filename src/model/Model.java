package model;

import entities.*;

import java.util.stream.Collectors;


/**
 * Class provides methods for working with parsed text.
 * Created by wookie on 6/12/16.
 */
public class Model {
    private TextComposite text;

    public Model() {

    }

    public Model(TextComposite text) {
        this.text = text;
    }

    /**
     * Method finds the biggest count of sentences in which some words are equals.
     * @return int value - count of sentences
     */
    public int findMostRepeats() {
        int max = 0;
        int currentMax;

            for(TextComponent paragraph : text.getComponents()) {
                for(TextComponent sentence : ((TextComposite)paragraph).getComponents()) {
                    currentMax = 0;
                    for(TextComponent word : ((TextComposite)sentence).getComponents()) {
                        if(!(word instanceof Symbol))
                            if(this.findRepeatsInSentence((TextComposite) sentence, word.getValue()))
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
     * @param sentence TextComposite class which defines a single sentence.
     * @param word a word, repeats of which the method will check.
     * @return true - if word has a repeats. False - if not.
     */
    private boolean findRepeatsInSentence(TextComposite sentence, String word) {
        return (sentence.getComponents().stream()
            .filter(f -> f.getValue().equals(word))
            .collect(Collectors.toList()).size() > 1);
    }

    public void setText(TextComposite text) {
        this.text = text;
    }
}
