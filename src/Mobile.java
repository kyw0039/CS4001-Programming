public class Mobile extends Gadget {

    private int credit;

    public Mobile(String model, double price, int weight, String size, int credit) {
        super(model, price, weight, size);
        this.credit = credit;
    }

    public int getCredit() {
        return credit;
    }

    public void addCredit(int amount) {
        if (amount > 0) {
            credit += amount;
        } else {
            System.out.println("Enter a positive amount");
        }
    }

    public void makeCall(String number, int duration) {
        if (credit >= duration) {
            System.out.println("Calling " + number + " for " + duration + " minutes");
            credit -= duration;
        } else {
            System.out.println("Not enough credit");
        }
    }

    public void display() {
        super.display();
        System.out.println("Credit: " + credit + " minutes");
    }
}