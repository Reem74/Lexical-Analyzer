import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

///First find comments in the input then find integrals then the rest

public class Main {
//    private static String replace(int begin, int end, String input, String replacement) {
//        String returnedString = input.substring(0, begin );
//        returnedString += replacement;
//        returnedString += input.substring(end, input.length() );
//        return  returnedString;
//    }
    public static void main(String[] args) {

        String input = "}}}";
        int inputLenght = input.length();

        int matchedLenght = 0;
        int Id = 0;
        int everyInputCharInteger[] = new int[inputLenght + 5];
        HashMap<Integer, String> map = new HashMap<Integer, String>();

        Pattern pattern = Pattern.compile(Operators.getInstance().arrayOfOperatorsGetIdx(0).regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {

            ++Id;
            int begin = matcher.start();
            int end = matcher.end();

            matchedLenght += (end - begin);

            String matched  = matcher.group();
            String replacement = Operators.getInstance().arrayOfOperatorsGetIdx(0).ID + " :" + matched ;
            String regex = Operators.getInstance().arrayOfOperatorsGetIdx(0).regex;
            for (int i = begin; i < end; ++i) {
                everyInputCharInteger[i] = Id;
            }
            map.put(Id,replacement);
        }
        String output;
        if(matchedLenght != inputLenght) {
            System.out.println("ERROR some values are not matched with a token");
        }
        else {
            everyInputCharInteger[inputLenght] = 0;
            for (int i = 0; i < inputLenght ; ++i) {
                if(everyInputCharInteger[i + 1] != everyInputCharInteger[i]) {
                    System.out.println(map.get(everyInputCharInteger[i]));
                }
            }
        }
    }

}
