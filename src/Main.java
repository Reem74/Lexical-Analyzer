import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

///First find comments in the input then find integrals then the rest

public class Main {
    private static ArrayList<Token> addAllTokens() {
        ArrayList<Token> tokens = new ArrayList<Token>();
        /// comments must be added first
        tokens.addAll(Comments.getInstance().getArrayOfComments());
        ///keywords must be added second
        tokens.addAll(Keywords.getInstance().getArrayOfKeywords());
        tokens.addAll(Strings.getInstance().getArrayOfStrings());
        tokens.addAll(Identifiers.getInstance().getArrayOfIdentifiers());
        tokens.addAll(Operators.getInstance().getArrayOfOperators());
        tokens.addAll(Constants.getInstance().getArrayOfConstants());
        tokens.addAll(SpecialSymbols.getInstance().getArrayOfSpecialSymbols());

        return tokens;
    }

    private static String replace(int begin, int end, String input) {
        String returnedString = input.substring(0, begin );
        for (int i = begin; i < end; ++i) {
            returnedString += '@';
        }
        returnedString += input.substring(end, input.length() );
        return  returnedString;
    }

    public static void main(String[] args) {
        ArrayList<Token> tokens = addAllTokens();
        File f = new File("/Users/abdo/Desktop/data/FCI/Compilers/Project/Lexical-Analyzer/input.txt");
        String input = "";
        Boolean firstLine = true;
        try {
            Scanner sc = new Scanner(f);
            while(sc.hasNext()){
                if(!firstLine)
                    input += "\n";
                firstLine = false;
                input += sc.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int inputLenght = input.length();

        int matchedLenght = 0;
        int Id = 0;
        int everyInputCharEquivelantInteger[] = new int[inputLenght + 5];
        HashMap<Integer, String> map = new HashMap<Integer, String>();

        ArrayList<ResultToken> results = new ArrayList<ResultToken>();
        for(Token token:tokens) {
            Pattern pattern = Pattern.compile(token.regex,Pattern.MULTILINE);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                ++Id;
                int begin = matcher.start();
                int end = matcher.end();

                matchedLenght += (end - begin);

                String matched = matcher.group();
                ResultToken result = new ResultToken(begin,end,token.getID(),matched);
                results.add(result);
//                String replacement = token.ID + " :" + matched;
//                String regex = token.regex;
//                for (int i = begin; i < end; ++i) {
//                    everyInputCharEquivelantInteger[i] = Id;
//                }
//                map.put(Id, replacement);
//                input = replace(begin, end, input);
            }
        }

        printResult(filterResult(results));

       // Print(input, matchedLenght, everyInputCharEquivelantInteger, map);

    }
    static ArrayList<ResultToken> filterResult(ArrayList<ResultToken> initialResult) {
        ArrayList<ResultToken> finalResult = new ArrayList<ResultToken>();
        Collections.sort(initialResult);
        ResultToken cur = new ResultToken(0,0,"","");
        if(initialResult.size() > 0){
            cur = initialResult.get(0);
        }
        for(int i=1;i<initialResult.size();++i){
            if(initialResult.get(i).begin > cur.end){
                finalResult.add(initialResult.get(i));
                cur = initialResult.get(i);
            }
        }
        return finalResult;
    }

    static void printResult(ArrayList<ResultToken> result) {
        for (ResultToken res:
             result) {
            System.out.println(res.label +": "+res.match);
        }
    }

    static void Print(String input , int matchedLenght, int everyInputCharEquivelantInteger[], HashMap<Integer, String> map) {
        int inputLenght = input.length();
        if(matchedLenght != input.length()) {
            System.out.println("ERROR some values are not matched with a token");
        }
        else {
            everyInputCharEquivelantInteger[inputLenght] = 0;
            for (int i = 0; i < inputLenght; ++i) {
                if (everyInputCharEquivelantInteger[i + 1] != everyInputCharEquivelantInteger[i]) {
                    System.out.println(map.get(everyInputCharEquivelantInteger[i]));
                }
            }
        }
    }
}
