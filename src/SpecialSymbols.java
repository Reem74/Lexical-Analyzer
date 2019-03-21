import java.util.ArrayList;

public class SpecialSymbols {
    private ArrayList<Token> arrayOfSpecialSymbols = new ArrayList<Token>();
    private SpecialSymbols() {
        arrayOfSpecialSymbols.add(new Token("}" ,"<LEFT_CURLY_B>"));
        arrayOfSpecialSymbols.add(new Token("\\{" ,"<RIGHT_CURLY_B>"));
        arrayOfSpecialSymbols.add(new Token("]" ,"<LEFT_SQUARE_B>"));
        arrayOfSpecialSymbols.add(new Token("\\[" ,"<RIGHT_SQUARE_B>"));
        arrayOfSpecialSymbols.add(new Token("\\)" ,"<LEFT_ROUND_B>"));
        arrayOfSpecialSymbols.add(new Token("\\(" ,"<RIGHT_ROUND_B>"));
        arrayOfSpecialSymbols.add(new Token("," ,"<COMMA>"));
        arrayOfSpecialSymbols.add(new Token(";" ,"<SEMICOLON>"));
        arrayOfSpecialSymbols.add(new Token("\\." ,"<DOT>"));
        /*
        back Slash not working btdrb
        //arrayOfSpecialSymbols.add(new Token("\\" ,"<BACKWARD_SLASH>"));
        */

    }
    private static final SpecialSymbols instance = new SpecialSymbols();

    public static SpecialSymbols getInstance() {
        return instance;
    }
    public Token arrayOfSpecialSymbolsGetIdx(int idx) {
        return arrayOfSpecialSymbols.get(idx);
    }
    public ArrayList<Token> getArrayOfSpecialSymbols() {
        return arrayOfSpecialSymbols;
    }
}
