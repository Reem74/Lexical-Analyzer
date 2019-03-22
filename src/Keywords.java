import java.util.ArrayList;

public class Keywords {
    private ArrayList<Token> arrayOfKeywords = new ArrayList<Token>();
    private Keywords() {
        arrayOfKeywords.add(new Token("\\bwhile\\b","<WHILE>"));
        arrayOfKeywords.add(new Token("\\bvolatile\\b","<VOLATILE>"));
        arrayOfKeywords.add(new Token("\\bvoid\\b","<VOID>"));
        arrayOfKeywords.add(new Token("\\bunsigned\\b","<UNSIGNED>"));
        arrayOfKeywords.add(new Token("\\btypedef\\b","<TYPEDEF>"));
        arrayOfKeywords.add(new Token("\\bswitch\\b","<SWITCH>"));
        arrayOfKeywords.add(new Token("\\bstruct\\b","<STRUCT>"));
        arrayOfKeywords.add(new Token("\\bstatic\\b","<STATIC>"));
        arrayOfKeywords.add(new Token("\\bsizeof\\b","<SIZEOF>"));
        arrayOfKeywords.add(new Token("\\bsigned\\b","<SIGNED>"));
        arrayOfKeywords.add(new Token("\\bshort\\b","<SHORT>"));
        arrayOfKeywords.add(new Token("\\breturn\\b","<RETURN>"));
        arrayOfKeywords.add(new Token("\\bregister\\b","<REGISTER>"));
        arrayOfKeywords.add(new Token("\\blong\\b","<LONG>"));

        arrayOfKeywords.add(new Token("\\bint\\b","<INT>"));
        arrayOfKeywords.add(new Token("\\bif\\b","<IF>"));

        arrayOfKeywords.add(new Token("\\bgoto\\b","<GOTO>"));
        arrayOfKeywords.add(new Token("\\bfor\\b","<FOR>"));
        arrayOfKeywords.add(new Token("\\bfloat\\b","<FLOAt>"));
        arrayOfKeywords.add(new Token("\\bextern\\b","<EXTERN>"));
        arrayOfKeywords.add(new Token("\\belse\\b","<ELSE>"));
        arrayOfKeywords.add(new Token("\\bdouble\\b","<DOUBLE>"));

        arrayOfKeywords.add(new Token("\\bdo\\b","<DO>"));
        arrayOfKeywords.add(new Token("\\bdefault\\b","<DEFAULT>"));
        arrayOfKeywords.add(new Token("\\bcontinue\\b","<CONTINUE>"));
        arrayOfKeywords.add(new Token("\\bconst\\b","<CONST>"));
        arrayOfKeywords.add(new Token("\\bchar\\b","<CHAR>"));
        arrayOfKeywords.add(new Token("\\bcase\\b","<CASE>"));

        arrayOfKeywords.add(new Token("\\bbool\\b","<BOOL>"));
        arrayOfKeywords.add(new Token("\\bbreak\\b","<BREAK>"));
        arrayOfKeywords.add(new Token("\\bfalse\\b","<FALSE>"));
        arrayOfKeywords.add(new Token("\\b0$","<EOF>"));
        arrayOfKeywords.add(new Token("\\bnew\\b","<NEW>"));
        arrayOfKeywords.add(new Token("\\bauto\\b","<AUTO>"));

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
