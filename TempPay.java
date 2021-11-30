/**
 * @author Cael O'Flaherty
 * This Class creates an object for the payment details to be temporarily stored in.
 */
public class TempPay {
    int resNum;
    String checkInDate;
    String checkOutDate;
    String roomTypeForHotel;
    double totalCost;

    /**
     * Constructor for TempPay object.
     *
     * @param resNum int, reservation number.
     * @param checkInDate String, date of check in.
     * @param checkOutDate String, date of check out.
     * @param roomTypeForHotel String, type of room to be booked e.g. deluxe standard.
     * @param totalCost double, the total cost of the reservation.
     */
    public TempPay(int resNum, String checkInDate, String checkOutDate, String roomTypeForHotel, double totalCost) {
        this.resNum = resNum;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomTypeForHotel = roomTypeForHotel;
        this.totalCost = totalCost;
    }

    /**
     * Getter for Reservation number.
     *
     * @return int Reservation Number.
     */
    public int getReservationNum() {

        return resNum;
    }

    /**
     * Getter for the check in date.
     *
     * @return String check in date.
     */
    public String getCheckInDate() {
        return checkInDate;
    }

    /**
     * Getter for the check out date.
     *
     * @return String check out date.
     */
    public String getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * Getter for the room type. Used to determine what hotel is selected.
     *
     * @return String room type.
     */
    public String getRoomTypeForHotel() {
        return roomTypeForHotel;
    }

    /**
     * Getter for the total cost of a payment.
     *
     * @return double total cost.
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * ToString method for the TempPay object.
     *
     * @return string displaying all data in a TempPay object.
     */
    public String toString() {
        return (resNum + "," + checkInDate + "," + checkOutDate + "," + roomTypeForHotel + "," + totalCost + "\n");
    }
}