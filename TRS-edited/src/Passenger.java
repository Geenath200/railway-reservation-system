import java.util.Scanner;

class Passenger {
    String name;
    long tele;
    String address;

    public Passenger(String name, long tele, String address) {
        this.name = name;
        this.tele = tele;
        this.address = address;
    }

    public Passenger() {

    }

    public void displayPassengerDetails() {
        System.out.println("Name: " + name);
        System.out.println("Contact number: " + tele);
        System.out.println("Home address: " + address);
    }

   public void gettingDetails(){
        Scanner input1 = new Scanner(System.in);
        System.out.println("Enter the Name : ");
        String name = input1.nextLine();
        Scanner input2 = new Scanner(System.in);
        System.out.println("Enter the contact number : ");
        long tele = input2.nextInt();
       Scanner input3 = new Scanner(System.in);
       System.out.println("Enter the address : ");
       String address = input3.nextLine();
   }
}