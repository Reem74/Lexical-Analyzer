import java.util.ArrayList;

public class Keywords {
    private ArrayList<Token> arrayOfKeywords = new ArrayList<Token>();
    private Keywords() {
    }
    private static final Keywords instance = new Keywords();

    public static Keywords getInstance() {
        return instance;
    }
        public Token arrayOfKeywordsGetIdx(int idx) {
        return arrayOfKeywords.get(idx);
    }
    public ArrayList<Token> getArrayOfKeywords() {
        return arrayOfKeywords;
    }
}
