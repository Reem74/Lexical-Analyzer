import java.util.ArrayList;

public class Strings {
    ArrayList<Token> arrayOfStrings = new ArrayList<Token>();
    private Strings() {
        arrayOfStrings.add(new Token("\".*\"" ,"<STRING_LITERAL>"));
        arrayOfStrings.add(new Token("'[a-zA-Z]'" ,"<STRING_LITERAL>"));
    }
    private static final Strings instance = new Strings();

    public static Strings getInstance() {
        return instance;
    }
    public Token arrayOfStringsGetIdx(int idx) {
        return arrayOfStrings.get(idx);
    }

}
