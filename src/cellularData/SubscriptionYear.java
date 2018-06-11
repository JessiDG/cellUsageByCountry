package cellularData;

/**
 *  Objects of this class contain a year and the number of subscriptions from that year
 * @author Foothill College, Jessica Dickinson Goodman
 */
public class  SubscriptionYear {
    private int year;
    private double subscriptions;

    /**
     * This is the class constructor
     * @param year                  This is the year associated with the number of subscriptions
     * @param subscriptions         This is the number of subscriptions associated with the given year
     */
    public SubscriptionYear(int year, double subscriptions) {
        this.year = year;
        this.subscriptions = subscriptions;
//        out.println("year: " + this.year + " | subscriptions: " + this.subscriptions);
    }

    public SubscriptionYear(SubscriptionYear sy){
        year = sy.year;
        subscriptions = sy.subscriptions;
    }

    /**
     * This is the accessor for year
     * @return      returns the year of this particular object's subscriptions
     */
    public int getYear() {
        return year;
    }

    /**
     * this is the mutator for year
     * @param year      This is the year information the user inputs
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * This is accessor for subscriptions
     * @return      This returns the number of subscriptions associated with the given year
     */
    public double getSubscriptions() {
        return subscriptions;
    }

    /**
     * This is the mutator for subscriptions
     * @param subscriptions     This is the subscription information the user inputs
     */
    public void setSubscriptions(double subscriptions) {
        this.subscriptions = subscriptions;
    }

    /**
     * This is the toString, returning just the double of the number of subscriptions
     * @return      This returns a string of the number of subscriptions
     */
    public String toString(){
        String returnString = Double.toString(subscriptions);
        return returnString;
    }
}
