import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class BetMain {

    public static void main(String[] args) {
        BetOrganization noviBet = BetOrganization.getInstance();

        //Κατά την προσομοίωση ΔΕ ζητούνται δεδομένα εισόδου στο πρόγραμμα
        //Όλα τα δεδομένα είναι hardcoded μέσα στον κώδικά σας
        //1.Δημιουργία διαθέσιμων στοιχημάτων για το ποδόσφαιρο

        FootballBet footballBet = new FootballBet("Liverpool-Panathinaikos", 2);
        FootballBet footballBet2 = new FootballBet("Panathinaikos-Olympiakos", 2);
        FootballBet footballBet3 = new FootballBet("Panathinaikos-Makabi_Haifa", 2);


        //2.Δημιουργία διαθέσιμων στοιχημάτων για το μπάσκετ
        BasketballBet basketballBet = new BasketballBet("Barcelona-Panathinaikos", 2);
        BasketballBet basketballBet2 = new BasketballBet("Real_Madrid-Panathinaikos", 2);
        //add the football and basketball bets to the betList
        noviBet.addBet(footballBet); //so that the customers can "see" the available bets
        noviBet.addBet(footballBet2); //when creating CustomerBets
        noviBet.addBet(footballBet3);
        noviBet.addBet(basketballBet);
        noviBet.addBet(basketballBet2);
        //3.Δημιουργία παιχτών
        Customer customer = new Customer.Builder("John")
                .build();
        Customer customer2 = new Customer.Builder("George")
                .build();
        Customer customer3 = new Customer.Builder("Jason")
                .build();
        Customer customer4 = new Customer.Builder("Marios")
                .build();
        GoldCustomer goldCustomer = (GoldCustomer) new GoldCustomer.Builder("GoldCustomer")
                .build();
        PlatinumCustomer platinumCustomer = (PlatinumCustomer) new PlatinumCustomer.Builder("PlatinumCustomer")
                .build();
        //4.Δημιουργία στοιχημάτων των παιχτών
        customer.addCustomerBet(new CustomerBet.Builder() //anonymous class for speed
                .betName("Liverpool-Panathinaikos")
                .stake(10)
                .choice("X")
                .betType("Football")
                .build());
        customer2.addCustomerBet(new CustomerBet.Builder()
                .betName("Barcelona-Panathinaikos")
                .stake(5)
                .choice("2")
                .betType("Basketball")
                .build());
        customer3.addCustomerBet(new CustomerBet.Builder()
                .betName("Panathinaikos-Makabi_Haifa")
                .stake(50)
                .choice("1")
                .betType("Football")
                .build());
        customer4.addCustomerBet(new CustomerBet.Builder()
                .betName("Real_Madrid-Panathinaikos")
                .stake(10)
                .choice("2")
                .betType("Basketball")
                .build());
        goldCustomer.addCustomerBet(new CustomerBet.Builder()
                .betName("Panathinaikos-Olympiakos")
                .stake(1000)
                .choice("1")
                .betType("Football")
                .build());
        platinumCustomer.addCustomerBet(new CustomerBet.Builder()
                .betName("Panathinaikos-Olympiakos")
                .stake(2000)
                .choice("1")
                .betType("Football")
                .build());
        //5.Προσθήκη παιχτών στο σύστημα
        noviBet.addCustomer(customer);
        noviBet.addCustomer(customer2);
        noviBet.addCustomer(customer3);
        noviBet.addCustomer(customer4);
        noviBet.addCustomer(goldCustomer);
        noviBet.addCustomer(platinumCustomer);
        //6.Προσομοίωση αγώνων
        GameEmulator gameEmulator = GameEmulator.getInstance();


        gameEmulator.doGameEmulation();

        //7.Προβολή συνολικών αποτελεσμάτων παιχτών
        noviBet.showCustomersResults();

        //8.Και εγγραφή αυτών σε αρχείο κειμένου

    }
}

//TODO make a db for highest bets won in one game, or total bets won