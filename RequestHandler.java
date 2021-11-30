import java.io.IOException;

/**
 * @author Jai
 * Class calls 2 methods both for handling options from menu
 */
public class RequestHandler {

    /**
     * Method makes new reservation to be added to csv
     * @param name
     * @param type
     * @param checkIn
     * @param checkOut
     * @param numberOfRooms
     */
    public static void newReservation(String name, String type, String checkIn, String checkOut, int numberOfRooms){
        Reservation reservation = new Reservation(name, type, checkIn, checkOut, numberOfRooms);
        reservation.getRoomTypeList();
        reservation.getTotalCost();
        reservation.addOccupancy();
        String rooms = "";
        rooms = reservation.getRoomType(0);
        for(int i = 1; i < reservation.getNumberOfRooms(); i++){
            rooms = rooms + "/" + reservation.getRoomType(i);
        }
        try {
            //writes to 2 files 
            if(reservation.getAvaiablility()){
                FileWriter newWrite = new FileWriter(reservation.getReservationNum(), name,  type, checkIn, checkOut, numberOfRooms, rooms);
                FileWriter writePayments = new FileWriter(reservation.getReservationNum(),checkIn, checkOut, rooms, reservation.getTotalCost());
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    /**
     * method displays reservations
     */
    public static void displayReservations(){
        //gets reservation as String
        String reservationList = FileReader.readReservations();
        String[] tokens = reservationList.split("%");
        //prints each reservation one at a time
        for(int i = 0; i < FileReader.getListSize(); i++){
            System.out.println(tokens[i]);
        }
    }
}
