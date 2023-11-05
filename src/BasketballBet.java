import java.util.List;

public class BasketballBet{
    //Η κλάση περιέχει τις διαθέσιμες εκβάσεις ενός αγώνα μπάσκετ. 
    //1:Νικήτρια η πρώτη ομάδα, 2:Νικήτρια η δεύτερη ομάδα
    static List<String> choices = List.of("1", "2");
    //Η μέθοδος επιστρέφει τη λίστα των διαθέσιμων επιλογών για έναν αγώνα μπάσκετ
    public static List<String> getChoices() {
        return choices;
    }
}