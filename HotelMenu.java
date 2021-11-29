import java.util.Scanner;

/**
 * @author Rohan Arya
 * This class is the home menu for the user, from here you can use all the systems functionality
 */
public class HotelMenu {
    private Scanner input = new Scanner(System.in);
    public HotelMenu() {
    }

    /**
     * This method runs the menu
     */
    public void run() {
        String resName = "";
        while(true) {
            System.out.println("1. Add Reservation");
            System.out.println("2. Check-In");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Display");
            System.out.println("5. Analytics");
            System.out.println("0. Quit");
            int command = input.nextInt();
            input.nextLine();
            if (command == 1) {
                System.out.println("Enter Name:\n");
                resName = input.nextLine();
		String type;
		while(true){
			System.out.println("Enter Type (S or AP):\n");
                	type = input.nextLine();
			if(type.equals("S")||type.equals("AP")){
				break;
			}
			else{
				System.out.println("Invalid Input\n");
			}
		}
		String checkIn;
		String checkOut;
		while(true){
			System.out.println("Enter Intended Check-in date (format dd-mm-yyyy):\n");
                	checkIn = input.nextLine();
                	System.out.println("Enter Intended Check-out date (format dd-mm-yyyy):\n");
                	checkOut = input.nextLine();
			if(DateChecker.checkformat(checkIn) && DateChecker.checkformat(checkOut)){
				break;
			}
			else{
				System.out.println("Invalid Input\n");
			}
		}
                System.out.println("Enter the number of rooms you wish to book:\n");
                int numOfRoom = input.nextInt();
                RequestHandler.newReservation(resName, type, checkIn, checkOut, numOfRoom);
            }
            if (command == 2) {
                System.out.println(FileReader.checkIn());
            }
            if (command == 3) {
                System.out.println("Enter the Reservation number of the Reservation you want to cancellation:\n");
                int number = input.nextInt();
                if(DateChecker.findDifference(DateChecker.getLocalDate(), FileReader.getCheckIn(number)) <= 2 || FileReader.getType(number).equals("AP") || FileReader.getType(number).equals("ap")){
                    System.out.println("\n\nNot Applicable for refund as it is less than 2 days til reservation date or reservation was an advanced purchase\n\n");
                } else {
                    System.out.println("\n\nCost Refunded\n\n");
                }
                FileWriter.removeReservation(number);
            }
            if (command == 4) {
                RequestHandler.displayReservations();
            }
            if (command == 5) {
                String hotel = "";
                int number = 0;
                int analyticChoice = 0;
                while(analyticChoice != 1 && analyticChoice != 2){
                    System.out.println("Check the analytics for \n1) Income\n2) Occupancy");
                    analyticChoice = input.nextInt();
                }

                while (number != 1 && number != 2 && number != 3) {
                    System.out.println("Enter the hotel which you want to view:\n1) 5-Star\n2) 4-Star\n3) 3-Star");
                    number = input.nextInt();
                }
                if(number == 1){
                    hotel = "deluxe";
                } else if(number == 2){
                    hotel = "executive";
                } else if(number == 3){
                    hotel = "classic";
                }
                System.out.println("\nEnter Start Date (dd-mm-yyyy)\n");
                String start_date = input.nextLine();
                start_date = input.nextLine();
                System.out.println("\nEnter End Date (dd-mm-yyyy)\n");
                String end_date = input.nextLine();
                if(analyticChoice == 1){
                    System.out.println("Total income from (" + start_date + ") to (" + end_date + ") is :" + Analytics.income(start_date,end_date,hotel));
                }
                if(analyticChoice == 2){
                    System.out.println("Total Occupancy from (" + start_date + ") to (" + end_date + ") is :" + Analytics.occupancy(start_date,end_date,hotel));
                }
            }
            if (command == 0) {
                break;
            }
        }
    }
}