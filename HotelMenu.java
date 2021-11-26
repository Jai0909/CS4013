import java.util.Scanner;
public class HotelMenu {
  public HotelMenu() {
  }
  public void run() {
    while(true) {
      System.out.println("1. Add Reservation");
      System.out.println("2. Check-In");
      System.out.println("3. Cancel Reservation");
      System.out.println("4. Display");
      System.out.println("0. Quit");
      int command = input.nextInt();
      if (command == 1) {
        System.out.println("WORKS")
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
