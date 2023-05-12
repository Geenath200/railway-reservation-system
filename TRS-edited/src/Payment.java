import java.util.Scanner;

abstract class Payment {
    abstract void pay(double amount);
}

class Cash extends Payment {
    public Cash() {
    }

    void pay(double amount) {
        System.out.println("You can Pay Rs " + amount + " with cash at the station.");
    }
}

class Card extends Payment {
    String cardNumber;
    String expiryDate;
    String cvv;

    Card(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    public Card() {

    }

    void pay(double amount) {
        boolean finished= true;
        while (finished) {
            Scanner input1 = new Scanner(System.in);
            System.out.println("Enter the card number without spaces:");
            String cardNumber = input1.nextLine();
            if (cardNumber.length() == 16) {
                Scanner input2 = new Scanner(System.in);
                System.out.println("Enter the expiry date (MM/YYYY)):");
                String expiryDate = input2.nextLine();
                Scanner input3 = new Scanner(System.in);
                System.out.println("Enter the cvv on the otherside: ");
                String cvv = input3.nextLine();
                finished = false;

            } else {
                System.out.println("Enter a valid card number");
            }
        }
        System.out.println("Paid " + amount + " with card.");
    }
}