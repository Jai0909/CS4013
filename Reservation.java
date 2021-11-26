public class Reservation {
    private String arrival;
    private String departure;
    private int reservationnumber;
    private String reservationname;
    private char reservationtype;
    private int numberofrooms;
    private Room room;
    private int totalcost;
    private RoomType roomtype;

    public String getarrivaldate(){
    return this.arrival;
    }

    public String getdeparturedate(){
        return this.departure;
    }
    
    public int getreservationnumber(){
        return this.reservationnumber;
    }
    
    public String getreservationname(){
        return this.reservationname;
    }
    
    public char getreservationtype(){
        return this.reservationtype;
    }
    
    public int getnumberofrooms(){
        return this.numberofrooms;
    }
    
    public Room getroom(){
        return this.room;
    }
    
    public int gettotalcost(){
        return this.totalcost;
    }
    
    public void setarrivaldate(String arrival){
        this.arrival=arrival;
    }
    
    public void setdeparturedate(String departure){
        this.departure=departure;
    }
    
    public void setreservationnumber(int reservationnumber){
        this.reservationnumber=reservationnumber;
    }
    
    public void setreservationname(String reservationname){
        this.reservationname=reservationname;
    }
    
    public void setreservationtype(char reservationtype){
        this.reservationtype=reservationtype;
    }
    
    public void setnumberofrooms(int numberofrooms){
        this.numberofrooms=numberofrooms;
    }
    
    public void setroom(Room room){
        this.room=room;
    }
    
    public void settotalcost(int totalcost){
        this.totalcost=totalcost;
    }
    
    public Reservation(String arrival,String departure,int reservationnumber,char reservationtype,Room room){
        this.arrival=arrival;
        this.departure=departure;
        this.reservationnumber=reservationnumber;
        this.reservationname=reservationname;
        this.reservationtype=reservationtype;
        this.numberofrooms=numberofrooms;
        this.room=room;
        this.totalcost=totalcost;
    }
    
}