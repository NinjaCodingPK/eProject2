package model;

import constants.Constant;
import entities.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wookie on 6/12/16.
 */
public class Parser {
    private Composite text = new Text();
    private String strText;
    //private WordFactory wordFactory = new WordFactory();

    public Parser(String strText) {
        this.strText = strText;
    }

    /**
     * Method cast input string into entities.
     */
    public void parse() {
        List<Component> paragraphs = new ArrayList<>();

        for(String paragraph : getRegexValues(strText, Constant.PARAGRAPH_REGEX)) {

            List<Component> sentences = new ArrayList<>();
            for(String sentence : getRegexValues(paragraph, Constant.SENTENCE_REGEX)) {
                List<Component> words = new ArrayList<>();

                for(String word : getRegexValues(sentence, Constant.WORD_REGEX)) {
                    words.add(new Word(WordFactory.getId(word)));
                }
                sentences.add(new Sentence(words));
            }
            paragraphs.add(new Paragraph(sentences));
        }

        this.text.setComponents(paragraphs);
    }

//    private List<Component> parseStep(String text, String regex) throws IOException {
//        List<Component> list = new ArrayList<>();
//
//        for(String s : getRegexValues(text, regex)) {
//
//        }
//
//        Composite temp = new Composite();
//        temp.setComponents(s);
//        sentences.add(temp);
//    }

    /**
     * Method divide text using regular expressions.
     * @param text text to split.
     * @param regex a regular expression.
     * @return List of divided strings.
     */
    private List<String> getRegexValues(final String text, final String regex) {
        List<String> tagValues = new ArrayList<>();
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(text);
//
//        while (matcher.find()) {
//            tagValues.add(matcher.group(1).trim());
//        }

        String[] words = text.trim().split(regex);
        for(String s : words) {
            if(!s.equals(""))
                tagValues.add(s);
        }

        return tagValues;
    }

    public Composite getText() {
        return text;
    }

//    private CharSequence fromFile() throws IOException {
//        FileInputStream fis = new FileInputStream(FILE_NAME);
//        FileChannel fc = fis.getChannel();
//
//        // Create a read-only CharBuffer on the file
//        ByteBuffer bbuf;
//        CharBuffer cbuf;
//
//        bbuf = fc.map(FileChannel.MapMode.READ_ONLY, 0, (int) fc.size());
//        cbuf =  Charset.forName("8859_1").newDecoder().decode(bbuf);
//        fis.close();
//        return cbuf;
//    }
}
