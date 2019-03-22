import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
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
        System.out.println(Comments.getInstance().arrayOfCommentsGetIdx(0).regex);
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

        System.out.println("input is : " + input);
        int inputLenght = input.length();

        int matchedLenght = 0;
        int Id = 0;
        int everyInputCharEquivelantInteger[] = new int[inputLenght + 5];
        HashMap<Integer, String> map = new HashMap<Integer, String>();

        for(Token token:tokens) {
            Pattern pattern = Pattern.compile(token.regex,Pattern.MULTILINE);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                ++Id;
                int begin = matcher.start();
                int end = matcher.end();

                matchedLenght += (end - begin);

                String matched = matcher.group();
                String replacement = token.ID + " :" + matched;
                String regex = token.regex;
                for (int i = begin; i < end; ++i) {
                    everyInputCharEquivelantInteger[i] = Id;
                }
                map.put(Id, replacement);
                input = replace(begin, end, input);
            }
        }
        Print(input, matchedLenght, everyInputCharEquivelantInteger, map);

    }
    static void Print(String input , int matchedLenght, int everyInputCharEquivelantInteger[], HashMap<Integer, String> map) {
        int inputLenght = input.length();
        if(matchedLenght != input.length()) {
            System.out.println("ERROR some values are not matched with a token");
        }

            everyInputCharEquivelantInteger[inputLenght] = 0;
            for (int i = 0; i < inputLenght ; ++i) {
                if(everyInputCharEquivelantInteger[i + 1] != everyInputCharEquivelantInteger[i]) {
                    System.out.println(map.get(everyInputCharEquivelantInteger[i]));
                }
            }

    }
}
