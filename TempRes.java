/**
 * @author Cael O'Flaherty
 * This Class creates an object for the reservations to temporarily be stored in.
 */
public class TempRes {
    int reservationNum;
    String reservationName;
    String reservationType;
    String checkIn;
    String checkOut;
    String numberOfRooms;
    String roomType;

    /**
     * Constructor for TempRes object.
     * @param reservationNum
     * @param reservationName
     * @param reservationType
     * @param checkIn
     * @param checkOut
     * @param numberOfRooms
     * @param roomType
     */
    public TempRes(int reservationNum, String reservationName, String reservationType, String checkIn, String checkOut, String numberOfRooms, String roomType) {
        this.reservationNum = reservationNum;
        this.reservationName = reservationName;
        this.reservationType = reservationType;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numberOfRooms = numberOfRooms;
        this.roomType = roomType;
    }

    /**
     * Getter for Reservation number.
     * @return Reservation Number.
     */
    public int getReservationNum() {
        return reservationNum;
    }

    /**
     * ToString method for the TempRes object.
     * @return A string displaying all data in a TempRes object.
     */
    public String toString() {
        return (reservationNum + "," + reservationName + "," + reservationType + "," + checkIn + "," + checkOut + "," +
                numberOfRooms + "," + roomType + "\n");
    }
}
