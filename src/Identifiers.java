import java.util.ArrayList;

public class Identifiers {
    private ArrayList<Token> arrayOfIdentifiers = new ArrayList<Token>();
    private Identifiers() {
        arrayOfIdentifiers.add(new Token("\\b([a-zA-Z]| _)\\w*","<ID>"));
        arrayOfIdentifiers.add(new Token("\\bwhile\\b","<WHILE>"));
        arrayOfIdentifiers.add(new Token("\\bvolatile\\b","<VOLATILE>"));
        arrayOfIdentifiers.add(new Token("\\bvoid\\b","<VOID>"));
        arrayOfIdentifiers.add(new Token("\\bunsigned\\b","<UNSIGNED>"));
        arrayOfIdentifiers.add(new Token("\\btypedef\\b","<TYPEDEF>"));
        arrayOfIdentifiers.add(new Token("\\bswitch\\b","<SWITCH>"));
        arrayOfIdentifiers.add(new Token("\\bstruct\\b","<STRUCT>"));
        arrayOfIdentifiers.add(new Token("\\bstatic\\b","<STATIC>"));
        arrayOfIdentifiers.add(new Token("\\bsizeof\\b","<SIZEOF>"));
        arrayOfIdentifiers.add(new Token("\\bsigned\\b","<SIGNED>"));
        arrayOfIdentifiers.add(new Token("\\bshort\\b","<SHORT>"));
        arrayOfIdentifiers.add(new Token("\\breturn\\b","<RETURN>"));
        arrayOfIdentifiers.add(new Token("\\bregister\\b","<REGISTER>"));
        arrayOfIdentifiers.add(new Token("\\blong\\b","<LONG>"));

        arrayOfIdentifiers.add(new Token("\\bint\\b","<INT>"));
        arrayOfIdentifiers.add(new Token("\\bif\\b","<IF>"));

        arrayOfIdentifiers.add(new Token("\\bgoto\\b","<GOTO>"));
        arrayOfIdentifiers.add(new Token("\\bfor\\b","<FOR>"));
        arrayOfIdentifiers.add(new Token("\\bfloat\\b","<FLOAt>"));
        arrayOfIdentifiers.add(new Token("\\bextern\\b","<EXTERN>"));
        arrayOfIdentifiers.add(new Token("\\belse\\b","<ELSE>"));
        arrayOfIdentifiers.add(new Token("\\bdouble\\b","<DOUBLE>"));

        arrayOfIdentifiers.add(new Token("\\bdo\\b","<DO>"));
        arrayOfIdentifiers.add(new Token("\\bdefault\\b","<DEFAULT>"));
        arrayOfIdentifiers.add(new Token("\\bcontinue\\b","<CONTINUE>"));
        arrayOfIdentifiers.add(new Token("\\bconst\\b","<CONST>"));
        arrayOfIdentifiers.add(new Token("\\bchar\\b","<CHAR>"));
        arrayOfIdentifiers.add(new Token("\\bcase\\b","<CASE>"));

        arrayOfIdentifiers.add(new Token("\\bbool\\b","<BOOL>"));
        arrayOfIdentifiers.add(new Token("\\bbreak\\b","<BREAK>"));
        arrayOfIdentifiers.add(new Token("\\bfalse\\b","<FALSE>"));
        arrayOfIdentifiers.add(new Token("\\b0$","<EOF>"));
        arrayOfIdentifiers.add(new Token("\\bnew\\b","<NEW>"));
        arrayOfIdentifiers.add(new Token("\\bauto\\b","<AUTO>"));


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
