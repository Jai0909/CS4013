import java.util.Date;

/**
 * @author Dennis Kolomiyets
 * This class stores reservation rooms for use in checkVaccancy()
 */
public class ExistingReservation {
    private Date reservationDate;
    private int reservedTotal;

    /**
     * Constructor creates reservations to be used by the checkVaccancy() method in the DataChecker class
     * @param reservationDate
     * @param reservedTotal
     */
    public ExistingReservation(Date reservationDate, int reservedTotal) {
        this.reservationDate = reservationDate;
        this.reservedTotal = reservedTotal;
    }

    /**
     * gets reservation date
     * @return
     */
    public Date getReservationDate() {
        return reservationDate;
    }

    /**
     * sets reservation date
     * @param reservationDate
     */
    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    /**
     * returns total rooms reserved for a particular date
     * @return
     */
    public int getReservedTotal() {
        return reservedTotal;
    }

    /**
     * sets total rooms reserved for a particular date
     * @param reservedTotal
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
