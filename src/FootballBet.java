import java.util.List;

public class FootballBet extends Bet{

    public FootballBet(String game, double odd) {
        super(game, odd);
    }
    //Η κλάση περιέχει τις διαθέσιμες εκβάσεις ενός αγώνα ποδοσφαίρου.
    //1:Νικήτρια η πρώτη ομάδα, Χ:Ισοπαλία, 2:Νικήτρια η δεύτερη ομάδα
    static List<String> choices = List.of("1", "X", "2");

    //Η μέθοδος επιστρέφει τη λίστα των διαθέσιμων επιλογών για έναν αγώνα ποδοσφαίρου
    public static List<String> getChoices() {
        return choices;
    }
}
