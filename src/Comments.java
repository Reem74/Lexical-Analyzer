import java.util.ArrayList;

public class Comments {

    private ArrayList<Token> arrayOfComments = new ArrayList<Token>();
    private Comments() {
        arrayOfComments.add(new Token("/\\*.\\*/" ,"<MULTI_COMMENT>"));
        arrayOfComments.add(new Token("//.*\\n" ,"<SINGLE_COMMENT>"));
    }
    private static final Comments instance = new Comments();

    public static Comments getInstance() {
        return instance;
    }
    public Token arrayOfCommentsGetIdx(int idx) {
        return arrayOfComments.get(idx);
    }

    public ArrayList<Token> getArrayOfComments() {
        return arrayOfComments;
    }
}
