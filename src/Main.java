import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        var cityItems = new ArrayList<Item>();

        cityItems.add(new Item("Ball", 10.5));
        cityItems.add(new Item("Sac", 10.6));

        var myCity = new City("São Paulo", cityItems);
        myCity.Display();
        var footballHelmet = new Item("Football Helmet", 39.00);
        var soccerBall = new Item("Soccer Ball", 20.0);
        var volleyballBall = new Item("Volleyball Ball", 18.0);
        var basebalHat = new Item("Basebol Hat", 49.00);

        var basebalBat = new Item("Basebal bat", 79.00);
        var towel = new Item("Towel", 10.5);

        var smuggler = new Smuggler();
        smuggler.setCurrentCity(myCity);
        smuggler.inventory.add(basebalBat);
        smuggler.inventory.add(volleyballBall);
        smuggler.inventory.add(basebalHat);
        smuggler.inventory.add(soccerBall);
        smuggler.DisplayInventory();

        System.out.println(smuggler.BuyItem(basebalBat));
        System.out.println(smuggler.BuyItem(basebalBat));
        smuggler.DisplayInventory();
    }
}