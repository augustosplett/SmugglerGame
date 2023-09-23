import java.util.ArrayList;

public class Smuggler {


    private String name;
    public ArrayList<Item> inventory = new ArrayList<>();
    private double balance;
    private City currentCity;//makes sense having the current city here?

    public void Buy(Double amount){
        if(this.HasEnoughMoney(amount)){
            balance -= amount;
        }
    }
    public boolean HasEnoughSpace(){
        return this.inventory.size() < 5;
    }

    public boolean HasEnoughMoney(Double amount){
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
        this.balance = 10;//decided that th smuggler will begin the game with 1,000.00
        this.name = name;
    }

//    String SellItem(Item itemToSell){
//        //validate if the smuggler has this item on his inventory
//        if(inventory.contains(itemToSell)) {
////            balance += itemToSell.price;  //add the value of the sold item to the balance
//            inventory.remove(itemToSell); //remove the item from the inventory
//            return  "Item Sold!";
//        }
//        return "Item not sold";
//    }

//    String BuyItem(Item itemToBuy){
//        //validate if the smuggler inventory has enough space (max 5 slots)
//        if(inventory.size() < 5){
//            //validate if the smuggler has enough money to buy the item
//            if(this.balance >= itemToBuy.price){
//                this.balance -= itemToBuy.price; //reduce the amount of money
//                inventory.add(itemToBuy);        //adding the item to the inventory
//                return "Item added to your inventory";
//            }
//            return "You can't buy this item, your money is not enough";
//        }
//        return "You can't buy more items, your inventory is full";
//    }

    void DisplayInventory(){
        System.out.println("---------------USER INVENTORY START----------------\n");
        System.out.println(String.format("You are in: %s",
                this.currentCity.getCityName()));
        System.out.printf("Your Balance is: %.2f%n",this.balance);
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
        System.out.println("---------------USER INVENTORY END------------------");
    }

}
