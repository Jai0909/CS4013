import java.util.Scanner;

/**
 * @author Jai
 * @author Dennis Kolomiyets
 * Class makes reservations
 */
public class Reservation {
    private int reservationNum;
    private String reservationName;
    private String reservationType;
    private String checkIn;
    private String checkOut;
    private int numberOfRooms;
    private String[] roomType;
    private int[] numOfPeople;
    private double totalCost;
    private boolean available = true;


    /**
     * Constructor for reservations
     * @param name String, reservation name
     * @param type String, reservation type
     * @param checkIn String, start date
     * @param checkOut String, end date
     * @param numberOfRooms int, number or rooms
     */
    public Reservation(String name, String type, String checkIn, String checkOut, int numberOfRooms){

        this.reservationNum = FileReader.checkLastNumber();
        this.reservationName = name;
        this.reservationType = type;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numberOfRooms = numberOfRooms;
        this.roomType = new String[numberOfRooms];
        this.numOfPeople = new int[numberOfRooms];
    }

    /**
     * This method uses gets the user to pick out all the rooms to be reserved
     */
    public void getRoomTypeList(){
        Scanner scanner = new Scanner(System.in);
        String option = "";
        System.out.println("Choose the hotel to book your rooms in\na) 5 Star\nb) 4 Star\nc) 3 Star\n");
        String outcome = scanner.nextLine();
        while(!outcome.equals("a") && !outcome.equals("b") && !outcome.equals("c")){
            System.out.println("Incorrect input try again\n");
            outcome = scanner.nextLine();
        }
        for(int i = 0; i < this.numberOfRooms; i++) {
            if (outcome.equals("a")) {
                System.out.println("Choose Room\na) Double\nb) Twin\nc) Single\nd) Family");
                option = scanner.nextLine();
                while(!option.equals("a") && !option.equals("b") && !option.equals("c") && !option.equals("d")){
                    System.out.println("Incorrect input try again");
                    option = scanner.nextLine();
                }
                if (option.equals("a")) {
                    if(DateChecker.checkVacancy("Deluxe Double", this.checkIn, this.checkOut)) {
                        this.roomType[i] = "Deluxe Double";
                        System.out.println(DateChecker.checkVacancy("Deluxe Double", this.checkIn, this.checkOut));
                    } else {
                        System.out.println("Maximum number of rooms exceeded");
                        setAvailablility(false);
                    }
                } else if (option.equals("b")) {
                    if(DateChecker.checkVacancy("Deluxe Twin", this.checkIn, this.checkOut)) {
                        this.roomType[i] = "Deluxe Twin";
                    } else {
                        System.out.println("Maximum number of rooms exceeded");
                        setAvailablility(false);
                    }
                } else if (option.equals("c")) {
                    if(DateChecker.checkVacancy("Deluxe Single", this.checkIn, this.checkOut)) {
                        this.roomType[i] = "Deluxe Single";
                    } else {
                        System.out.println("Maximum number of rooms exceeded");
                        setAvailablility(false);
                    }
                } else if (option.equals("d")) {
                    if(DateChecker.checkVacancy("Deluxe Family", this.checkIn, this.checkOut)) {
                        this.roomType[i] = "Deluxe Family";
                        } else {
                        System.out.println("Maximum number of rooms exceeded");
                        setAvailablility(false);
                    }
                }
            } else if (outcome.equals("b")) {
                System.out.println("Choose Room\na) Double\nb) Twin\nc) Single");
                option = scanner.nextLine();
                while(!option.equals("a") && !option.equals("b") && !option.equals("c")){
                    System.out.println("Incorrect input try again");
                    option = scanner.nextLine();
                }
                if (option.equals("a")) {
                    if(DateChecker.checkVacancy("Executive Double", this.checkIn, this.checkOut)) {
                        this.roomType[i] = "Executive Double";
                    }
                } else if (option.equals("b")) {
                    if(DateChecker.checkVacancy("Executive Twin", this.checkIn, this.checkOut)) {
                        this.roomType[i] = "Executive Twin";
                    } else {
                        System.out.println("Maximum number of rooms exceeded");
                        setAvailablility(false);
                    }
                } else if (option.equals("c")) {
                    if(DateChecker.checkVacancy("Executive Single", this.checkIn, this.checkOut)) {
                        this.roomType[i] = "Executive Single";
                    } else {
                        System.out.println("Maximum number of rooms exceeded");
                        setAvailablility(false);
                    }
                }
            } else if (outcome.equals("c")) {
                System.out.println("Choose Room\na) Double\nb) Twin\nc) Single");
                option = scanner.nextLine();
                while(!option.equals("a") && !option.equals("b") && !option.equals("c")){
                    System.out.println("Incorrect input try again");
                    option = scanner.nextLine();
                }
                if (option.equals("a")) {
                    if(DateChecker.checkVacancy("Classic Double", this.checkIn, this.checkOut)) {
                        this.roomType[i] = "Classic Double";
                    }  else {
                        System.out.println("Maximum number of rooms exceeded");
                        setAvailablility(false);
                    }
                } else if (option.equals("b")) {
                    if(DateChecker.checkVacancy("Classic Twin", this.checkIn, this.checkOut)) {
                        this.roomType[i] = "Classic Twin";
                    }  else {
                        System.out.println("Maximum number of rooms exceeded");
                        setAvailablility(false);
                    }
                } else if (option.equals("c")) {
                    if(DateChecker.checkVacancy("Classic Single", this.checkIn, this.checkOut)) {
                        this.roomType[i] = "Classic Single";
                    } else {
                        System.out.println("Maximum number of rooms exceeded");
                        setAvailablility(false);
                    }
                }
            }
        }
    }

    /**
     * sets number of people per room
     */
    public void addOccupancy(){
        for(int i = 0; i < this.numberOfRooms; i++){
            this.numOfPeople[i] = FileReader.getMaxOccupancy(roomType[i]);
        }
    }

    /**
     * returns total cost for a reservation. Applies discount if reservation is an "Advanced purchased"
     * @return total cost for reservation applies to advanced purchase with discount
     */
    public double getTotalCost(){
        double result = 0;
        for(int i = 0; i < numberOfRooms; i++){
            result = result + FileReader.getPrice(checkIn, checkOut, roomType[i]);
        }
        if(this.reservationType.equals("AP")){
            return result * 0.95;
        }
        return result;
    }

    /**
     * returns reservation name
     * @return gets reservation name
     */
    public String getReservationName() {
        return reservationName;
    }

    /**
     * gets reservation number
     * @return gets reservation number
     */

    public int getReservationNum() {
        return reservationNum;
    }

    /**
     * gets check in date
     * @return gets check in or start date
     */
    public String getCheckIn() {
        return checkIn;
    }

    /**
     * gets check out date
     * @return check out or end date
     */
    public String getCheckOut() {
        return checkOut;
    }

    /**
     * gets room type
     * @param i int, number
     * @return roomtype at i
     */
    public String getRoomType(int i) {
        return roomType[i];
    }

    /**
     * gets number of rooms from reservation
     * @return number of rooms
     */
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    /**
     * gets number of people list
     * @return number of people per specific room
     */
    public int[] getNumOfPeople() {
        return numOfPeople;
    }

    /**
     * gets reservation type list but as a string
     * @return reservation type
     */
    public String getReservationType() {
        return reservationType;
    }

    /**
     * sets avaibility variable
     * @param available boolean, availability
     */
    public void setAvailablility(boolean available) {
        this.available = available;
    }

    /**
     * gets availability variable
     * @return true or false
     */
    public boolean getAvaiablility() {
        return available;
    }
}
