import java.io.IOException;

public class RequestHandler {
    public static void newReservation(String name, String type, String checkIn, String checkOut, int numberOfRooms){
        Reservation reservation = new Reservation(name, type, checkIn, checkOut, numberOfRooms);
        reservation.getRoomTypeList();
        reservation.getTotalCost();
        reservation.addOccupancy();
        String rooms = "";
        rooms = reservation.getRoomType(0);
        for(int i = 1; i < reservation.getNumberOfRooms(); i++){
            rooms = rooms + "|" + reservation.getRoomType(i);
        }
        try {
        FileWriter newWrite = new FileWriter(reservation.getReservationNum(), name,  type, checkIn, checkOut, numberOfRooms, rooms);
        FileWriter writePayments = new FileWriter("Payed", reservation.getTotalCost());
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public static void displayReservations(){
        String reservationList = FileReader.readReservations();
        String[] tokens = reservationList.split("%");
        for(int i = 0; i < FileReader.getListSize(); i++){
            System.out.println(tokens[i]);
        }
    }
}
