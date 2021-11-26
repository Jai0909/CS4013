public class RequestHandler {
    public static void newReservation(String name, String type, String checkIn, String checkOut, int numberOfRooms){
        Reservation reservation = new Reservation(name, type, checkIn, checkOut, numberOfRooms);
        reservation.getRoomTypeList();
        reservation.getTotalCost();
        reservation.addOccupancy();
    }
}
