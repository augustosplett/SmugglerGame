import java.util.ArrayList;
public class City {
    private final String name;
    ArrayList<Item> items = new ArrayList<>(); //I think it would be better to receive a list of possible  products and generate the prices randomly
    City(String name){
        this.name = name;
    }
    String getCityName(){
        return this.name;
    }
    public void DisplayItemsWithSellPrice(){

        System.out.println("===================");
        System.out.println("Items in the city:");
        System.out.println("===================");
        for (int i = 0; i < items.size(); i++) {
            Item el = items.get(i);
            System.out.println("Item Number: " + (i + 1));
            System.out.println(el.DisplayOnlyItem());
            System.out.println(el.DisplaySellPrice());
            System.out.println("===================");
        }
    }

    public void DisplayItemsWithBuyPrice(){
        System.out.println("===================");
        System.out.println("Items in the city:");
        System.out.println("===================");
        for( Item el : items){
            System.out.println(el.DisplayOnlyItem());
            System.out.println(el.DisplayBuyPrice());
            System.out.println("===================");
        }
    }
}
