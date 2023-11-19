public class GoldCustomer extends Customer{

    public GoldCustomer(Builder n) {
        super(n);
    }
    @Override
    public int getMaxStake(){
        return 1000;
    }
    public static class Builder extends Customer.Builder {

        public Builder(String n) {
            super(n);
        }

        @Override
        public GoldCustomer build() {
            return new GoldCustomer(this);
        }
    }
}