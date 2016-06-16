package model;

import constants.Constant;
import entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wookie on 6/12/16.
 */
public class Parser {
    private TextComposite text = new TextComposite();
    private String strText;

    /**
     * Constructor for parser class.
     * @param strText text which will be parsed.
     */
    public Parser(String strText) {
        this.strText = strText;
    }

    /**
     * Method cast input string into entities.
     */
    public void parse() {
        List<TextComponent> paragraphs = new ArrayList<>();

        for(String paragraph : getRegexValues(strText, Constant.PARAGRAPH_REGEX)) {

            List<TextComponent> sentences = new ArrayList<>();
            for(String sentence : getRegexValues(paragraph, Constant.SENTENCE_REGEX)) {
                 List<TextComponent> sentence_parts = new ArrayList<>();

                for(String word : getRegexValues(sentence, Constant.WORD_REGEX)) {
                    for(String ch : getRegexValues(word, Constant.SIGN_REGEX)) {
                        sentence_parts.add(SymbolFactory.getSymbol(ch.charAt(0)));
                    }

                    List<TextComponent> sentence_word = new ArrayList<>();
                    for(String ch : getRegexValues(word, Constant.LETTER_REGEX)) {
                        sentence_word.add(SymbolFactory.getSymbol(ch.charAt(0)));
                    }
                    if (!sentence_word.isEmpty())
                        sentence_parts.add(new TextComposite(sentence_word));
                }
                sentences.add(new TextComposite(sentence_parts));
            }
            paragraphs.add(new TextComposite(sentences));
        }

        this.text.setComponents(paragraphs);
    }

    /**
     * Method divide text using regular expressions.
     * @param text text to split.
     * @param regex a regular expression.
     * @return List of divided strings.
     */
    private List<String> getRegexValues(final String text, final String regex) {
        List<String> tagValues = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            tagValues.add(matcher.group());
        }

        return tagValues;
    }

    public TextComposite getText() {
        return text;
    }


}
