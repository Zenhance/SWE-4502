package utilities;

public class StringFormatter {
    public String replaceSpaces(String inputString) {
        String formattedString = "";
        for (char character : inputString.toCharArray()) {
            formattedString += (character == ' ') ? "%20" : character;
        }
        return formattedString;
    }
}