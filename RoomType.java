public class RoomType
{
    private String name;
    private int max;
    private int priceMon;
    private int priceTue;
    private int priceWed;
    private int priceThu;
    private int priceFri;
    private int priceSat;
    private int priceSun;
    private int noofrooms;
    public RoomType(String name, int max, int priceMon, int priceTue, int priceWed, int priceThu, int priceFri, int priceSat, int priceSun, int noofrooms ) {
        this.name = name;
        this.max = max;
        this.priceMon = priceMon;
        this.priceTue = priceTue;
        this.priceWed = priceWed;
        this.priceThu = priceThu;
        this.priceFri = priceFri;
        this.priceSat = priceSat;
        this.priceSun = priceSun;
        this.noofrooms = noofrooms;
    }
    
    public RoomType(){
    }
    
    public void setname(String name){
        this.name=name;
    }
    
    public void setmax(int max){
        this.max=max;
    }
    
    public void setpriceMon(int priceMon){
        this.priceMon=priceMon;
    }
    
    public void setpriceTue(int priceTue){
        this.priceTue=priceTue;
    }
    
    public void setpriceWed(int priceWed){
        this.priceWed=priceWed;
    }
    
    public void setpriceThu(int priceThu){
        this.priceThu=priceThu;
    }
    
    public void setpriceFri(int priceFri){
        this.priceFri=priceFri;
    }
    
    public void setpriceSat(int priceSat){
        this.priceSat=priceSat;
    }
    
    public void setpriceSun(int priceSun){
        this.priceSun=priceSun;
    }
    
    public String getname(){
        return this.name;
    }
    
    public int getmax(){
        return this.max;
    }
    
    public int getpriceMon(){
        return this.priceMon;
    }
    
    public int getpriceTue(){
        return this.priceTue;
    }
    
    public int getpriceWed(){
        return this.priceWed;
    }
    
    public int getpriceThu(){
        return this.priceThu;
    }
    
    public int getpriceFri(){
        return this.priceFri;
    }
    
    public int getpriceSat(){
        return this.priceSat;
    }
    
    public int getpriceSun(){
        return this.priceSun;
    }
    
}
