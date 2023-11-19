import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BetOrganization {
    //singleton class
    private static BetOrganization instance = null;
    //Λίστα με τους διαθέσιμους παίχτες
    private final List<Customer> cList = new ArrayList<>();
    //Λίστα με τα διαθέσιμα στοιχήματα για αγώνες ποδοσφαίρου και μπάσκετ
    private final List<Bet> betList = new ArrayList<>();
    private final GameEmulator gameEmulator = GameEmulator.getInstance(); // Assuming you have a getInstance() method in GameEmulator

    public boolean checkCustomerBetInList(CustomerBet customerBet){
        for (Bet bet : betList){
            if (bet.getGame().equals(customerBet.getBetName()))
                return true;
        }
        return false;
    }
    public List<Bet> getBetList() {
        return betList;
    }

    private BetOrganization(){}
    public void addCustomer(Customer customer) {
        cList.add(customer);
    }
    public void addBet(Bet bet) {
        betList.add(bet);
    }
    //Η μέθοδος υπολογίζει τα κέρδη του παίχτη που δίδεται ως παράμετρoς της.
    //Πιο συγκεκριμένα, η παράμετρος αφορά στη λίστα στοιχημάτων του εκάστοτε παίχτη
    private double calculateGainsPerCustomer(IGiveBetList customer) {
        double gains = 0;

        // Get simulated game results
        for (Map.Entry<String, String> gameResult : gameEmulator.getEmulatedGamesResults().entrySet()) {
            for (CustomerBet customerBet : customer.getCustomerBetList()) {
                if (customerBet.getBetName().equals(gameResult.getKey())) {
                    Bet bet = getBetByName(customerBet.getBetName());
                    if (customerBet.getChoice().equals(gameResult.getValue())) {
                        assert bet != null; //if bet.getOdd is null
                        gains += customerBet.getStake() * bet.getOdd();
                    }
                }
            }
        }

        return gains;
    }
    public void showCustomersResults(){
        System.out.println("------------------Results-------------------");
        for (Customer customer : cList){
            System.out.println("####################################");
            System.out.println("Customer name: "+customer.getName());
            System.out.println("Customer money paid: "+customer.getMoneyPlayed());
            System.out.println("Customer gains: "+String.valueOf(calculateGainsPerCustomer(customer)));
        }
        System.out.println("--------------End-of-Results----------------");
    }
    // Helper method to get the Bet instance by name
    private Bet getBetByName(String betName) {
        for (Bet bet : getBetList()) {
            if (bet.getGame().equals(betName)) {
                return bet;
            }
        }
        return null;
    }
    //Εγγραφή των αποτελεσμάτων των παιχτών στο αρχείο κειμένου "bet-results.txt"
    //Το αρχείο αυτό θα αντικαθίσταται από νέο αρχείο, κάθε φορά που εκτελείται το πρόγραμμα (δεν κρατάμε τα προηγούμενα δεδομένα)
    //Το format του αρχείου να είναι ίδιο με την εκτύπωση των αποτελεσμάτων (showCustomersResults)
    public void printCustomersResultsToTextFile(){
        //Το αρχείο που θα δημιουργηθεί θα έχει το όνομα "bet-results.txt"

    }
    //Η μέθοδος επιστρέφει το μοναδικό αντικείμενο της κλάσης BetOrganization
    public static BetOrganization getInstance() {
        //thread safe lazy implementation
        if (instance == null) {
            synchronized (BetOrganization.class) {
                if (instance == null) {
                    instance = new BetOrganization();
                }
            }
        }
        return instance;
    }
}
