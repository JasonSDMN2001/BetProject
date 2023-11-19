public class PlatinumCustomer extends Customer{
    public PlatinumCustomer(Builder n) {
        super(n);
    }
    @Override
    public int getMaxStake(){
        return 2000;
    }
    public static class Builder extends Customer.Builder {

        public Builder(String n) {
            super(n);
        }

        @Override
        public PlatinumCustomer build() {
            return new PlatinumCustomer(this);
        }
    }
}
