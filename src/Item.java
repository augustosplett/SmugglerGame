public class Item {

    String name;
    Double price;

    Item(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public void Display(){
        System.out.printf("Item: %s \t Price: %f%n", this.name, this.price);
    }
}
//association -> the object is created outside the object
//composition -> when the object is created inside another object