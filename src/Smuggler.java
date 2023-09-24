import java.util.ArrayList;

public class Smuggler {

    private String name;
    public ArrayList<Item> inventory = new ArrayList<>();
    private double balance;
    private City currentCity;//makes sense having the current city here?

    public void Buy(Double amount){ //affects the balance when the smuggler buys a item
        if(this.HasEnoughMoney(amount)){
            balance -= amount;
        }
    }

    public void Sell(Double amount){
        balance = balance + amount;
    }
    public boolean HasEnoughSpace(){ //validate if the smuggler has enough space in his inventory
        return this.inventory.size() < 5;
    }

    public boolean HasEnoughMoney(Double amount){//validate if the smuggler has enough money in his balance
        return this.balance > amount;
    }
    public String getName() {
        return name;
    }
    public City getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    Smuggler(String name){
        this.balance = 1000;//decided that th smuggler will begin the game with 1,000.00
        this.name = name;
    }

    void DisplayCurrentCity(){
        System.out.println(String.format("You are in: %s",
                this.currentCity.getCityName()));
    }
    void DisplayBalance(){
        System.out.printf("Your Balance is: %.2f%n",this.balance);
    }
    void DisplayInventory(){
        System.out.println("---------------USER INVENTORY START----------------\n");
        DisplayCurrentCity();
        DisplayBalance();
        DisplaySmugglerItems();
        System.out.println("---------------USER INVENTORY END------------------");
    }
    void DisplaySmugglerItems(){
        if(!inventory.isEmpty()) {
            System.out.println("You have the following items on your inventory:");
            for (int i = 0; i < inventory.size(); i++) {
                Item item = inventory.get(i);
                System.out.println("---------------------------------------------------");
                System.out.println("Inventory Slot " + (i + 1) + ":");//adding +1 to i because having slot 0 makes no sense to the user
                System.out.println(item.DisplayOnlyItem());
            }

        }else {
            System.out.println("Your inventory is empty\n");
        }
    }
}
