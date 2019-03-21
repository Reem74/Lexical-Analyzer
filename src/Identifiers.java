import java.util.ArrayList;

public class Identifiers {
    private ArrayList<Token> arrayOfIdentifiers = new ArrayList<Token>();
    private Identifiers() {
        arrayOfIdentifiers.add(new Token("\\s([a-zA-Z]| _)\\w*","<ID>"));
    }
    private static final Identifiers instance = new Identifiers();

    public static Identifiers getInstance() {
        return instance;
    }
    public Token arrayOfIdentifiersGetIdx(int idx) {
        return arrayOfIdentifiers.get(idx);
    }
    public ArrayList<Token> getArrayOfIdentifiers() {
        return arrayOfIdentifiers;
    }
}
