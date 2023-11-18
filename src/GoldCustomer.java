public class GoldCustomer extends Customer{

    public GoldCustomer(Builder n) {
        super(n);
    }
    @Override
    public int getMaxStake(){
        return 1000;
    }

}