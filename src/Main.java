import java.util.regex.Matcher;
import java.util.regex.Pattern;
///First find comments in the input then find integrals then the rest
public class Main {
    public static void main(String[] args) {
        String input = "int main() {int reem = ++;}} ;" +
                "String found = '0'";

        Pattern pattern = Pattern.compile(Operators.getInstance().arrayOfOperatorsGetIdx(0).regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println("Found a match: " + matcher.group());
        }

    }
}
