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
    private Composite text = new Composite();
    private final String FILE_NAME;
    //private WordFactory wordFactory = new WordFactory();

    public Parser(String fileName) {
        this.FILE_NAME = fileName;
    }

    public void parse1() throws IOException {
        String str = this.readFile();
        List<Component> paragraphs = new ArrayList<>();

        for(String paragraph : getRegexValues(str, Constant.PARAGRAPH_REGEX)) {

            List<Component> sentences = new ArrayList<>();
            for(String sentence : getRegexValues(paragraph, Constant.SENTENCE_REGEX)) {
                List<Component> words = new ArrayList<>();

                for(String word : getRegexValues(sentence, Constant.WORD_REGEX)) {
                    words.add(new Word(WordFactory.getId(word)));
                }
                addComponentList(sentences, words);

            }
            addComponentList(paragraphs, sentences);

        }

        Composite temp = new Composite();
        temp.setComponents(paragraphs);
        this.text.addComponent(temp);

        this.text.print();
    }

    private void addComponentList(List<Component> list, List<Component> toAdd) {
        Composite temp = new Composite();
        temp.setComponents(toAdd);
        list.add(temp);
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

    private List<String> getRegexValues(final String text, final String regex) throws IOException {
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

    private String readFile() throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(FILE_NAME));
        return new String(encoded, Charset.forName("8859_1"));
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
