public class Item {

    String name;
    Double price;

    Item(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public String Display(){
        return String.format("Item: %s\nPrice: %.2f", this.name, this.price);
    }
}
//association -> the object is created outside the object
//composition -> when the object is created inside another object