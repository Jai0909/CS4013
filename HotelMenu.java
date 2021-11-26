import java.util.Scanner;
public class HotelMenu {
    private Scanner input = new Scanner(System.in);
    public HotelMenu() {
    }
    public void run() {
        String str = "";
        while(true) {
            System.out.println("1. Add Reservation");
            System.out.println("2. Check-In");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Display");
            System.out.println("0. Quit");
            int command = input.nextInt();
            if (command == 1) {
                System.out.println("Enter Name:\n");
                String name = input.nextLine();
                System.out.println("Enter Type (S or AP):\n");
                String type = input.nextLine();
                System.out.println("Enter Intended Check-in date (format dd-mm-yyyy):\n");
                String checkIn = input.nextLine();
                System.out.println("Enter Intended Check-out date (format dd-mm-yyyy):\n");
                String checkOut = input.nextLine();
                System.out.println("Enter the number of rooms you wish to book:\n");
                int numOfRoom = input.nextInt();
                RequestHandler.newReservation(name, type, checkIn, checkOut, numOfRoom);
                System.out.println("WORKS");
            }
            if (command == 2) {
                System.out.println("WORKS");
            }
            if (command == 3) {
                System.out.println("WORKS");
            }
            if (command == 4) {
                System.out.println("WORKS");
            }
            if (command == 0) {
                break;
            }
        }
    }
}