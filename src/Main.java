import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

///First find comments in the input then find integrals then the rest

public class Main {
    private static ArrayList<Token> getAllTokens() {
        ArrayList<Token> tokens = new ArrayList<Token>();
        tokens.addAll(Comments.getInstance().getArrayOfComments());
        tokens.addAll(Strings.getInstance().getArrayOfStrings());
        tokens.addAll(Identifiers.getInstance().getArrayOfIdentifiers());
        tokens.addAll(Operators.getInstance().getArrayOfOperators());

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
        ArrayList<Token> tokens = getAllTokens();

        String input = "}}}";
        int inputLenght = input.length();

        int matchedLenght = 0;
        int Id = 0;
        int everyInputCharEquivelantInteger[] = new int[inputLenght + 5];
        HashMap<Integer, String> map = new HashMap<Integer, String>();

        for(Token token:tokens) {
            Pattern pattern = Pattern.compile(token.regex);
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
        else {
            everyInputCharEquivelantInteger[inputLenght] = 0;
            for (int i = 0; i < inputLenght ; ++i) {
                if(everyInputCharEquivelantInteger[i + 1] != everyInputCharEquivelantInteger[i]) {
                    System.out.println(map.get(everyInputCharEquivelantInteger[i]));
                }
            }
        }
    }
}
