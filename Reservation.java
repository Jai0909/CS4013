import javax.lang.model.util.SimpleElementVisitor14;
import java.io.File;
import java.util.Scanner;

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



    public Reservation(String name, String type, String checkIn, String checkOut, int numberOfRooms){
        this.reservationNum = FileReader.getListSize()+1;
        this.reservationName = name;
        this.reservationType = type;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numberOfRooms = numberOfRooms;
        this.roomType = new String[numberOfRooms];
        this.numOfPeople = new int[numberOfRooms];
    }

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
                    this.roomType[i] = "Deluxe Double";
                } else if (option.equals("b")) {
                    this.roomType[i] = "Deluxe Twin";
                } else if (option.equals("c")) {
                    this.roomType[i] = "Deluxe Single";
                } else if (option.equals("d")) {
                    this.roomType[i] = "Deluxe Family";
                }
            } else if (outcome.equals("b")) {
                System.out.println("Choose Room\na) Double\nb) Twin\nc) Single");
                option = scanner.nextLine();
                while(!option.equals("a") && !option.equals("b") && !option.equals("c")){
                    System.out.println("Incorrect input try again");
                    option = scanner.nextLine();
                }
                if (option.equals("a")) {
                    this.roomType[i] = "Executive Double";
                } else if (option.equals("b")) {
                    this.roomType[i] = "Executive Twin";
                } else if (option.equals("c")) {
                    this.roomType[i] = "Executive Single";
                }
            } else if (outcome.equals("c")) {
                System.out.println("Choose Room\na) Double\nb) Twin\nc) Single");
                option = scanner.nextLine();
                while(!option.equals("a") && !option.equals("b") && !option.equals("c")){
                    System.out.println("Incorrect input try again");
                    option = scanner.nextLine();
                }
                if (option.equals("a")) {
                    this.roomType[i] = "Classic Double";
                } else if (option.equals("b")) {
                    this.roomType[i] = "Classic Twin";
                } else if (option.equals("c")) {
                    this.roomType[i] = "Classic Single";
                }
            }
        }
    }

    public void addOccupancy(){
        for(int i = 0; i < this.numberOfRooms; i++){
            this.numOfPeople[i] = FileReader.getMaxOccupancy(roomType[i]);
            System.out.println("number of people " + numOfPeople[i]);
        }
    }

    public double getTotalCost(){
        double result = 0;
        for(int i = 0; i < numberOfRooms; i++){
            result = result + FileReader.getPrice(checkIn, checkOut, roomType[i]);
        }
        if(this.reservationType.equals("AP")){
            System.out.println(result * 0.95);
            return result * 0.95;
        }
        System.out.println(result);
        return result;
    }

    public String getReservationName() {
        return reservationName;
    }

    public int getReservationNum() {
        return reservationNum;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public String getRoomType(int i) {
        return roomType[i];
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int[] getNumOfPeople() {
        return numOfPeople;
    }

    public String getReservationType() {
        return reservationType;
    }
}
