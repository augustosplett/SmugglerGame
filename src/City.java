import java.util.ArrayList;
public class City {
    String name;
    ArrayList<Item> items; //I think it would be better to receive a list of possible  products and generate the prices randomly
    City(String name, ArrayList<Item> items){
        this.name = name;
        this.items = items;
    }

    String getCityName(){
        return this.name;
    }
    public void Display(){

        System.out.println("Items in the city:");
        for( Item el : items){
            el.Display();
        }
    }
}
