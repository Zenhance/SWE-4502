package utilities;

public class StringManager {
    public String fillSpaceWithSymbol(String location){
        String ChangedLocation = "";
        for (char ch : location.toCharArray()) {
            if (ch != ' ') {
                ChangedLocation += ch;
            } else {
                ChangedLocation += "%20";
            }
        }
        return ChangedLocation;
    }
}