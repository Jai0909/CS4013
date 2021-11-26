import java.util.Scanner;
import java.util.ArrayList;
public class HotelMenu {
  private Scanner input;
  private ArrayList<Reservation> confirmed;
  public HotelMenu() {
    input = new Scanner(System.in);
  }
  public void run() {
    while(true) {
      System.out.println("1. Add Reservation");
      System.out.println("2. Check-In");
      System.out.println("3. Check-Out");
      System.out.println("4. Cancel Reservation");
      System.out.println("0. Quit");
      int command = input.nextInt();
      if (command == 1) {
        System.out.println("Reservation Number");
        int resnumber = input.nextInt();
        System.out.println("Reservation Name");
        String resname = input.nextLine();
        System.out.println("Reservation Type");
        char restype = input.next().char.At(0);
        if (!restype = 'S') {
          restype = 'AP';
        }
        System.out.println("Check-In Date");
        String chkindate = input.nextLine();
        System.out.println("Check-Out Date");
        String chkoutdate = input.nextLine();
        Reservation res = new Reservation();     // to be checked
        res.addreservation();                    // to be checked // make reservationsarraylist public
      }
      if (command == 2) {
        System.out.println("Reservation Number");
        int resnumber = input.nextInt();
        for (int i = 0; i<reservations.size(); i++) {
          if (resnumber == reservations.get(i).getreservationnumber()) {
            confirmed.add(reservations.get(i));
            System.out.println("Check-In Successful");
        }
          else {
            System.out.println("Sorry, Check-In Unsuccessful. Could not identify Reservation Number");
        }
      }
      }
      if (command == 3) {
        System.out.println("Reservation Number");
        int resnumber = input.nextInt();
        for (int i = 0; i<confirmed.size(); i++) {
          if (resnumber == confirmed.get(i).getreservationnumber()) {
            confirmed.remove(reservations.get(i));
            System.out.println("Check-Out Successful");
            }
            else {
            System.out.println("Sorry, Check-Out Unsuccessful. Could not identify Reservation Number");
            }
            }
      }
      if (command == 4) {
        System.out.println("Reservation Number");
        int resnumber = input.nextInt();
        Reservation res = new Reservation();     // to be checked
        res.cancelreservation();                    // to be checked // make reservationsarraylist public
      }
      if (command == 5) {
        break;
      }
  }
}
