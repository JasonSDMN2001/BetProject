// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class BetMain {

    public static void main(String[] args) {
        BetOrganization bo = BetOrganization.getInstance();

        //Κατά την προσομοίωση ΔΕ ζητούνται δεδομένα εισόδου στο πρόγραμμα
        //Όλα τα δεδομένα είναι hardcoded μέσα στον κώδικά σας
        //1.Δημιουργία διαθέσιμων στοιχημάτων για το ποδόσφαιρο

        FootballBet footballBet = new FootballBet("Liverpool-Panathinaikos", 2);

        //2.Δημιουργία διαθέσιμων στοιχημάτων για το μπάσκετ
        BasketballBet basketballBet = new BasketballBet("Barcelona-Panathinaikos", 2);

        //3.Δημιουργία παιχτών

        //4.Δημιουργία στοιχημάτων των παιχτών
        CustomerBet bet = new CustomerBet.Builder()
                .betName("Liverpool-Panathinaikos")
                .stake(100)
                .choice("2")
                .betType("Football")
                .build();
        //5.Προσθήκη παιχτών στο σύστημα

        //6.Προσομοίωση αγώνων

        //7.Προβολή συνολικών αποτελεσμάτων παιχτών

        //8.Και εγγραφή αυτών σε αρχείο κειμένου

    }
}

//TODO make a db for highest bets won in one game, or total bets won