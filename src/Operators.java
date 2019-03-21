import java.util.ArrayList;

public class Operators{
    private ArrayList<Token> arrayOfOperators = new ArrayList<Token>();
    private Operators() {
        arrayOfOperators.add(new Token("!" ,"<NOT>"));
        arrayOfOperators.add(new Token("=" ,"<ASSIGN_OPERATOR>"));
        arrayOfOperators.add(new Token("#" ,"<PREPROCESSOR>"));
        arrayOfOperators.add(new Token("\\+" ,"<PLUS>"));
        arrayOfOperators.add(new Token("\\-" ,"<MINUS>"));
        arrayOfOperators.add(new Token("/" ,"<DIVIDE>"));
        arrayOfOperators.add(new Token("%" ,"<MOD>"));
        arrayOfOperators.add(new Token("<" ,"<LESSTHAN>"));
        arrayOfOperators.add(new Token(">" ,"<GREATERTHAN>"));
        arrayOfOperators.add(new Token("<=" ,"<LESS_EQ>"));
        arrayOfOperators.add(new Token(">=" ,"<GREAT_EQ>"));
        arrayOfOperators.add(new Token("=" ,"<EQUAL>"));
        arrayOfOperators.add(new Token("!=" ,"<NOT_EQUAL>"));
        arrayOfOperators.add(new Token("&" ,"<BITWISE_AND>"));
        arrayOfOperators.add(new Token("\\|" ,"<BITWISE_OR>"));
        arrayOfOperators.add(new Token("\\^" ,"<BITWISE_XOR>"));
        arrayOfOperators.add(new Token(">>" ,"<LEFT_SHIFT>"));
        arrayOfOperators.add(new Token("<<" ,"<RIGHT_SHIFT>"));
        arrayOfOperators.add(new Token("&&" ,"<AND>"));
        arrayOfOperators.add(new Token("\\|\\|" ,"<OR>"));
    }
    private static final Operators instance = new Operators();

    public static Operators getInstance() {
        return instance;
    }
    public Token arrayOfOperatorsGetIdx(int idx) {
        return arrayOfOperators.get(idx);
    }
    public ArrayList<Token> getArrayOfOperators() {
        return arrayOfOperators;
    }
}
