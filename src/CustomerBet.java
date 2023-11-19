import java.util.List;

public class CustomerBet {
    //Λίστα που περιέχει τις δύο διαθέσιμες επιλογές αγώνα, ποδοσφαίρου και μπάσκετ αντίστοιχα
    private final List<String> availableBetTypes = List.of("Football", "Basketball");
    //Το μοναδικό όνομα του αγώνα
    //Κατά τη δημιουργία αντικειμένων της εν λόγω κλάσης, δεν ελέγχουμε αν το όνομα αγώνα που έδωσε το παίχτης είναι σωστό.
    //Αυτό θα ελεγχθεί αργότερα από την κλάση BetOrganization
    private final String betName;
    //Το ποσό του πονταρίσματος σε ευρώ (χωρίς δεκαδικά)
    private final int stake;
    //Η επιλογή πονταρίσματος του παίχτη. Όπως αναφέρθηκε και παραπάνω πρέπει να ελεγχθεί, ανάλογα με τον τύπο του αγώνα.
    //Οι διαθέσιμες εκβάσεις ενός αγώνα μπάσκετ είναι, 1:Νικήτρια η πρώτη ομάδα, 2:Νικήτρια η δεύτερη ομάδα
    //Οι διαθέσιμες εκβάσεις ενός αγώνα ποδοσφαίρου είναι, 1:Νικήτρια η πρώτη ομάδα, Χ:Ισοπαλία, 2:Νικήτρια η δεύτερη ομάδα
    private final String choice;

    /*public CustomerBet(String betName, String betType, int stake, String choice) {

    }*/
    private CustomerBet(Builder builder) {
        validateBetType(builder.betType, builder.choice);
        this.betName = builder.betName;
        this.stake = builder.stake;
        this.choice = builder.choice;
        //Η παράμετρος "betType" είναι ο τύπος του αγώνα. Μπορεί να πάρει μόνο μια εκ των 2 τιμών: "Football" ή "Basketball"
        //Η δοθείσα τιμή του String betType που δίνεται κατά την προσομοίωση θα ελέγχεται στον constructor της κλάσης CustomerBet
        //και παράλληλα θα ελέγχεται αν η επιλογή, "choice", αφορά στις διαθέσιμες επιλογές του εκάστοτε τύπου αγώνα.
        String betType = builder.betType;
    }
    public String getBetName() {
        return betName;
    }
    public int getStake() {
        return stake;
    }
    public String getChoice() {
        return choice;
    }
    private void validateBetType(String betType, String choice) {
        if ("Football".equals(betType) && !List.of("1", "X", "2").contains(choice)) {
            throw new IllegalArgumentException("Invalid choice for Football bet type");
        } else if ("Basketball".equals(betType) && !List.of("1", "2").contains(choice)) {
            throw new IllegalArgumentException("Invalid choice for Basketball bet type");
        }
    }
    public static class Builder {
        private String betName;
        private int stake;
        private String choice;
        private String betType;

        public Builder betName(String betName) {
            this.betName = betName;
            return this;
        }

        public Builder stake(int stake) {
            this.stake = stake;
            return this;
        }

        public Builder choice(String choice) {
            this.choice = choice;
            return this;
        }

        public Builder betType(String betType) {
            this.betType = betType;
            return this;
        }

        public CustomerBet build() {
            return new CustomerBet(this);
        }

    }
}
