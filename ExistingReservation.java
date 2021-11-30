import java.util.Date;

/**
 * @author Rohan Arya
 * This class stores reservation rooms for use in checkVaccancy()
 */
public class ExistingReservation {
    private Date reservationDate;
    private int reservedTotal;

    /**
     * Constructor creates reservations to be used by the checkVaccancy() method in the DataChecker class
     * @param reservationDate Date, date of reservation
     * @param reservedTotal int, number or reserved rooms
     */
    public ExistingReservation(Date reservationDate, int reservedTotal) {
        this.reservationDate = reservationDate;
        this.reservedTotal = reservedTotal;
    }

    /**
     * gets reservation date
     * @return reservation date
     */
    public Date getReservationDate() {
        return reservationDate;
    }

    /**
     * sets reservation date
     * @param reservationDate Date, reservation date
     */
    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    /**
     * returns total rooms reserved for a particular date
     * @return total reserved rooms
     */
    public int getReservedTotal() {
        return reservedTotal;
    }

    /**
     * sets total rooms reserved for a particular date
     * @param reservedTotal int, total reserved rooms
     */
    public void setReservedTotal(int reservedTotal) {
        this.reservedTotal = reservedTotal;
    }

    /**
     * increments total rooms reserved on a day by one
     */
    public void incrementTotal() {
        this.reservedTotal++;
    }
}
