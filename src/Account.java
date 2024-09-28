class Account {
    private String accountId;
    private Customer customer;
    private static int accountCounter = 1000;

    public Account(Customer customer) {
        this.customer = customer;
        this.accountId = "ACC" + accountCounter++;
    }

    public String getAccountId() {
        return accountId;
    }

    public Customer getCustomer() {
        return customer;
    }

    //@Override
    public String toString() {
        return "Account [Account ID=" + accountId + ", " + customer.toString() + "]";
    }

}