import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        var cityItems = new ArrayList<Item>();

        cityItems.add(new Item("Ball", 10.5));
        cityItems.add(new Item("Sac", 10.6));

        var myCity = new City("São Paulo", cityItems);
        myCity.Display();
        //cityItems.Display();
    }
}