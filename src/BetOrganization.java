import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BetOrganization {
    //singleton class
    private static BetOrganization instance = null;
    //Λίστα με τους διαθέσιμους παίχτες
    private final List<Customer> cList = new ArrayList<>();
    //Λίστα με τα διαθέσιμα στοιχήματα για αγώνες ποδοσφαίρου και μπάσκετ
    private final List<Bet> betList = new ArrayList<>();
    private final GameEmulator gameEmulator = GameEmulator.getInstance();

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
        for (Map.Entry<String, String> gameResult : gameEmulator.getEmulatedGamesResults().entrySet()) {
            for (CustomerBet customerBet : customer.getCustomerBetList()) {
                if (customerBet.getBetName().equals(gameResult.getKey())) {
                    Bet bet = getBetByName(customerBet.getBetName()); // για να πάρουμε το odd
                    if (customerBet.getChoice().equals(gameResult.getValue())) {
                        assert bet != null; //if bet.getOdd is null
                        gains += customerBet.getStake() * bet.getOdd();
                    }
                }
            }
        }

        return gains;
    }
    public String showCustomersResults() {
        StringBuilder results = new StringBuilder("------------------Results-------------------\n");

        for (Customer customer : cList) {
            results.append("####################################\n");
            results.append("Customer name: ").append(customer.getName()).append("\n");
            results.append("Customer money paid: ").append(customer.getMoneyPlayed()).append("\n");
            results.append("Customer gains: ").append(calculateGainsPerCustomer(customer)).append("\n");
        }

        results.append("--------------End-of-Results----------------\n");
        return results.toString();
    }

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
        String workingDir = System.getProperty("user.dir");
        Path binPath = Paths.get(workingDir, "out");
        String filePath = binPath.resolve("bet-results.txt").toString();
        try (FileWriter writer = new FileWriter(filePath,true)) { // append το αρχείο
            writer.write(showCustomersResults());
        } catch (IOException e) {
            e.printStackTrace();
        }
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
