import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String input = "int main() {int reem = 0;} ;" +
                "String found = '0'";
        Pattern pattern = Pattern.compile(Strings.getInstance().arrayOfStringsGetIdx(1).regex);
//        System.out.println(Strings.getInstance().arrayOfStringsGetIdx(0).regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println("Found a match: " + matcher.group());
        }

    }
}
