import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

//Η συγκεκριμένη κλάση χρησιμοποιείται κατά την εκτέλεση του προγράμματος, για την τυχαία παραγωγή των αποτελεσμάτων των αγώνων.
public class GameEmulator {
    //singleton instance
    private static GameEmulator instance = null;
    //Αντικείμενο που μπορεί να χρησιμοποιηθεί για την παραγωγή τυχαίων αριθμών
    Random r = new Random();
    //Η συγκεκριμένη δομή HashMap θα μας βοηθήσει να αντιστοιχήσουμε κάθε αγώνα με ένα αποτέλεσμα.
    //Συγκεκριμένα, για κάθε μοναδικό όνομα αγώνα (πρώτη παράμετρος String),
    //θα αντιστοιχούμε ένα μονάδικο αποτέλεσμα (1-Χ-2) ή (1-2), ανάλογα με το είδος του αγώνα (ποδόσφαιρο ή μπάσκετ)
    private final Map<String,String> emulatedGamesResults = new HashMap<>();
    //Διαθέσιμες επιλογές για ποδόσφαιρο
    private final String[] footballChoices = FootballBet.getChoices().toArray(new String[0]);
    //Διαθέσιμες επιλογές για μπάσκετ
    private final String[] basketballChoices = BasketballBet.getChoices().toArray(new String[0]);
    //Η μέθοδος αυτή παράγει τα δεδομένα του HashMap "emulatedGamesResults"
    //π.χ. ότι στον αγώνα ποδοσφαίρου "Βραζιλία-Ν.Κορέα" αντιστοιχεί το αποτέλεσμα "1"
    public void doGameEmulation(){
        //Για κάθε στοίχημα που υπάρχει στο σύστημα
        for (Bet bet : BetOrganization.getInstance().getBetList()){
            //Αν ο αγώνας είναι ποδόσφαιρο
            if (bet instanceof FootballBet){
                //Τότε επιλέγουμε τυχαία ένα αποτέλεσμα από τα διαθέσιμα αποτελέσματα ποδοσφαίρου
                String result = footballChoices[r.nextInt(footballChoices.length)];
                //Και το αντιστοιχούμε με το όνομα του αγώνα
                emulatedGamesResults.put(bet.getGame(),result);
            }
            //Αν ο αγώνας είναι μπάσκετ
            else if (bet instanceof BasketballBet){
                //Τότε επιλέγουμε τυχαία ένα αποτέλεσμα από τα διαθέσιμα αποτελέσματα μπάσκετ
                String result = basketballChoices[r.nextInt(basketballChoices.length)];
                //Και το αντιστοιχούμε με το όνομα του αγώνα
                emulatedGamesResults.put(bet.getGame(),result);
            }
        }
    }
    private GameEmulator(){}
    public Map<String, String> getEmulatedGamesResults() {
        return emulatedGamesResults;
    }
    //Η μέθοδος επιστρέφει το μοναδικό αντικείμενο της κλάσης GameEmulator
    public static GameEmulator getInstance() {
        // thread safe and lazy implementation
        if (instance == null) {
            synchronized (GameEmulator.class) {
                if (instance == null) {
                    instance = new GameEmulator();
                }
            }
        }
        return instance;
    }
}
