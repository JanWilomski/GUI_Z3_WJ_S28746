import VehicleType.VehicleType;

import static VehicleType.VehicleType.*;

public class Client {

    boolean hasAbonament;
    double availableCredit;
    String name;
    private Wishlist wishlist;
    private final Basket basket;

    public Client(String name,  double availableCredit, boolean hasAbonament) {
        this.name = name;
        this.hasAbonament = hasAbonament;
        this.availableCredit = availableCredit;
        this.wishlist = new Wishlist(this);
        this.basket = new Basket(this);
    }

    public Basket getBasket() {
        return basket;
    }

    // Metoda dostępowa do listy życzeń
    public Wishlist getWishlist() {
        return wishlist;
    }

    public void add(Vehicle v){
        wishlist.addVehicle(v);
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }

    public void pack(){
        Pricelist pricelist = Pricelist.getPricelist();
        basket.vehicleList.clear();

        Wishlist newWishlist = new Wishlist(this);
        for(Vehicle v : wishlist.vehicleList){

            boolean found = false;
            int i = 0;
            while(i<pricelist.enteredCars.size()&&!found){
                //sprawdz czy auto na liscie

                if(v.vehicleType==pricelist.enteredCars.get(i).getType()&&v.getName().equals(pricelist.enteredCars.get(i).modelName)){
                    System.out.println("Auto jest na liscie.");
                    if(v.vehicleType==FREE){
                        if(v.getDistance()<pricelist.enteredCars.get(i).distanceTierMark){
                            System.out.println("Dodano do koszyka: "+v);
                            this.getBasket().addVehicle(v);
                            found = true;
                        }else{
                            this.getBasket().addVehicle(new Free(v.getName(),pricelist.enteredCars.get(i).distanceTierMark));
                            System.out.println("Dodano do koszyka: "+new Free(v.getName(),pricelist.enteredCars.get(i).distanceTierMark));
                        }
                    }else{
                        found = true;
                        this.getBasket().addVehicle(v);
                        System.out.println("Dodano do koszyka: "+v);
                    }

                }//TODO usunac dodane do koszyka samochody z wishlisty
                setWishlist(newWishlist);



                i++;
            }

        }


    }

}
