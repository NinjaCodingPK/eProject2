package constants;

/**
 * Created by wookie on 6/12/16.
 */
public interface Constant {
    String REAPLECE_SYMBOLS = "(\\s{2,})|(\t)";
    String CHANGE_TO_CHARACTER = " ";
    String PARAGRAPH_REGEX = ".+((\u2029$)|(\\z)|(\\n))";
    String SENTENCE_REGEX = "[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?[\\s]*+[\\n]*+";
    String WORD_REGEX = "(\\w*[a-zA-Z]+\\w*)|([a-zA-Z_]+\\w*)|(\\p{Punct}+)|(\\p{Blank}+)|(\\n)";
    String SIGN_REGEX = "(\\p{Punct}+)|(\\p{Blank}+)|(\\n)";
    String LETTER_REGEX = "(\\w{1}+)";
}
