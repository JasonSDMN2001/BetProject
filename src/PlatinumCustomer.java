public class PlatinumCustomer extends Customer{
    public PlatinumCustomer(Builder n) {
        super(n);
    }
    @Override
    public int getMaxStake(){
        return 2000;
    }
}
