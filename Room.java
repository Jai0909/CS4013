import java.util.ArrayList;

public class Room{
    private ArrayList<RoomType> rooms=new ArrayList<RoomType>();
    private RoomType a=new RoomType();
    private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
    private String checkindate;
    private String checkoutdate;
    public void addroom(RoomType a){
         rooms.add(a);
    }
    
    public void removeroom(RoomType a){
         rooms.remove(a);
    }
    
    public Room(RoomType a) {
        this.a = a;
    }
    
    public boolean checkvaccancy(String checkindate, String checkoutdate){
        for(int i=0;i<reservations.size();i++){
            String currentArrival=this.reservations.get(i).getarrivaldate();
            String currentDeparture=this.reservations.get(i).getdeparturedate();
            if ((!(checkindate.equals(currentArrival)) || !(checkoutdate.equals(currentArrival)))&& (!(checkindate.equals(currentDeparture)) || !(checkoutdate.equals(currentDeparture)))) {
                return false;
            }
        }
        return true;
    }
}