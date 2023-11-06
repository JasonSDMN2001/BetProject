public class GoldCustomer extends Customer{

    public GoldCustomer(String n) {
        super(n);
    }
    @Override
    public int getMaxStake(){
        return 1000;
    }

}