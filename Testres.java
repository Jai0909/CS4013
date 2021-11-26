public class Testres
{
    
    public static void main(String[] args){
        RoomType dd= new RoomType("room1",2,75,75,75,80,90,90,74,35);
        bookreservation("25-11-2021","30-11-2021",dd,'A');
        bookreservation("25-11-2021","30-11-2021",dd,'A');
    }
    public static void bookreservation(String arrival,String departure,RoomType roomtype,char type){
        Room a = new Room(roomtype);
        if(a.checkvaccancy(arrival,departure)){
            System.out.println("OK");
            Reservation b=new Reservation(arrival,departure,1,'A',a);
        }
        else{
            System.out.println("Fail");
        }
    }
}