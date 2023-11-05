import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BetOrganization {
    //Λίστα με τους διαθέσιμους παίχτες
    private final List<Customer> cList = new ArrayList<>();
    //Λίστα με τα διαθέσιμα στοιχήματα για αγώνες ποδοσφαίρου και μπάσκετ
    private final List<Bet> betList = new ArrayList<>();
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
    public void addCustomer(Customer customer) {
        cList.add(customer);
    }
    public void addBet(Bet bet) {
        betList.add(bet);
    }
    //Η μέθοδος υπολογίζει τα κέρδη του παίχτη που δίδεται ως παράμετρός της.
    //Πιο συγκεκριμένα, η παράμετρος αφορά στην λίστα στοιχημάτων του εκάστοτε παίχτη
    private double calculateGainsPerCustomer(IGiveBetList customer) {
        //Για κάθε ένα στοίχημα που έχει κάνει ο παίχτης
        //Ψάχνουμε να το αντιστοιχήσουμε με τη λίστα των στοιχημάτων του BetOrganization
        //Στη συνέχεια, εφόσον το βρούμε, κοιτάζουμε αν έχει κερδίσει η επιλογή του παίχτη
        //και αν ναι, προσθέτουμε το ποσό στα κέρδη (επιστρεφόμενη τιμή της μεθόδου)
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
    //Εγγραφή των αποτελεσμάτων των παιχτών στο αρχείο κειμένου "bet-results.txt"
    //Το αρχείο αυτό θα αντικαθίσταται από νέο αρχείο, κάθε φορά που εκτελείται το πρόγραμμα (δεν κρατάμε τα προηγούμενα δεδομένα)
    //Το format του αρχείου να είναι ίδιο με την εκτύπωση των αποτελεσμάτων (showCustomersResults)
    public void printCustomersResultsToTextFile(){

    }
}
