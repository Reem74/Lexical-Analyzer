import java.util.ArrayList;

public class Constants {
    private ArrayList<Token> arrayOfConstants = new ArrayList<Token>();
    private Constants() {
        arrayOfConstants.add(new Token("[+-]?[0-9]*\\.[0-9]+","<FLOAT_LITERAL>"));
        arrayOfConstants.add(new Token("[+-]?[0-9]+" , "<INTEGRAL_LITERAL>" ));
    }
    private static final Constants instance = new Constants();

    public static Constants getInstance() {
        return instance;
    }
    public Token arrayOfConstantsGetIdx(int idx) {
        return arrayOfConstants.get(idx);
    }
    public ArrayList<Token> getArrayOfConstants() {
        return arrayOfConstants;
    }
}
