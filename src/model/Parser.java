package model;

import constants.Constant;
import entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
     *
     * @return function for forming symbols from some text.
     */
    private Function<String, TextComponent> getSymbolFunction() {
        return ch -> SymbolFactory.getSymbol(ch.charAt(0));
    }

    /**
     *
     * @return function for forming sentences from some text.
     */
    private Function<String, TextComponent> getSentenceFunction() {
        return sentence -> new TextComposite(parseSentence(sentence));
    }

    /**
     *
     * @return function for forming paragraphs from some text.
     */
    private Function<String, TextComponent> getParagraphFunction() {
        return paragraph -> new TextComposite(parseStep(paragraph, Constant.SENTENCE_REGEX, getSentenceFunction()));
    }

    /**
     * Method parse an input text in a way which provides input function.
     * @param text text for parse.
     * @param regex regular expression which will be used for parsing a text.
     * @param f function which will be used for parsing an input text.
     * @return List of parsed components.
     */
    private List<TextComponent> parseStep(String text, String regex, Function<String, TextComponent> f) {
        return getRegexValues(text, regex).stream().
                map(f).
                collect(Collectors.toList());
    }

    /**
     * Method form a "sentence" components with "word" components and "symbol" components.
     * @param sentence sentence to parse.
     * @return List of Components which include current sentence,
     */
    private List<TextComponent> parseSentence(String sentence) {
        List<TextComponent> sentence_parts = new ArrayList<>();

        for(String word : getRegexValues(sentence, Constant.WORD_REGEX)) {
            if(!getRegexValues(word, Constant.SIGN_REGEX).isEmpty())
                sentence_parts.addAll(parseStep(word, Constant.SIGN_REGEX, getSymbolFunction()));
            else
                sentence_parts.add(new TextComposite(parseStep(word, Constant.LETTER_REGEX, getSymbolFunction())));
        }

            return  sentence_parts;
    }

    /**
     * Method cast input string into entities.
     */
    public void parse() {
        this.text.setComponents(parseStep(strText, Constant.PARAGRAPH_REGEX, getParagraphFunction()));
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
