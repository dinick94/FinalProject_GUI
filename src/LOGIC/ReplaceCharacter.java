import java.util.Arrays;
import java.util.List;

public class ReplaceCharacter {

    List<Character> badCharacters = Arrays.asList('}', '/', ')');

    public String noX(String str) {

        if (str.equals("")) {
            return str;

        } else {
            if (this.badCharacters.contains(str.charAt(0))) {
                return this.noX(str.substring(1));
            } else {
                return str.charAt(0) + this.noX(str.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        ReplaceCharacter replaceInstance = new ReplaceCharacter();

        String result = replaceInstance.noX("som/e sentence with bad charact)ers in} it");

        System.out.println(result);

    }

}