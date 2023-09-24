import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class Game {

    ArrayList<City> cities = new ArrayList<>(); //List of the cities that are available on the game
    Smuggler player;

    public void NewGame(){
    //Creating the game's elements
        Scanner scanner = new Scanner(System.in);//create the object to capture user input

        CreateCitiesList();//creating the cities into the game
        CreateCitiesItemsList(); //creating the items into the cities

        //Welcoming message
        System.out.println("WELCOME TO THE SMUGGLER GAME!");
        System.out.print("ENTER YOUR CHARACTER NAME: ");
        var playerName = String.valueOf(scanner.next()); //capturing User's name
        CreatePlayer(playerName);//creating the player using the User's name

    }

    public void GameMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------------");
        System.out.println("You are in: " + player.getCurrentCity().getCityName());
        System.out.println("1 - See my inventory");
        System.out.println("2 - Buy items");
        System.out.println("3 - Sell items");
        System.out.println("4 - Travel to other city");
        System.out.println("5 - Quit Game");
        System.out.print("Enter you choice: ");
        var userChoice = Integer.parseInt(scanner.next());
        handleMenuChoice(userChoice);
    }

    private void handleMenuChoice(int choice){

        switch (choice) {
            case 1 -> {
                player.DisplayInventory();
                WaitUserInputToReturnToMenu();
            }
            case 2 -> {
                BuyItems();
                WaitUserInputToReturnToMenu();
            }
            case 3 -> {
                SellItems();
                WaitUserInputToReturnToMenu();
            }
            case 5 -> System.exit(1);
        }
    }

    private void SellItems() {
        //here, we need to sell the items in the smuggler's inventory and sell them to the city but using the city's price
        if(player.inventory.size() > 0) {//check if the user has any item in his inventory
            player.DisplaySmugglerItems();//display the items into Smuggler inventory
            var option = ChooseItemToMove("sell"); //take the number item the user wants to sell
            var itemToSell = player.inventory.get(option); //take the item itself from the user inventory
            double price = 0;
            for(Item item : player.getCurrentCity().items ){ //as the item have different prices in different cities we need to get the prince into the specific city.
               if (Objects.equals(itemToSell.name, item.name)) price = item.BuyPrice;//If the chosen item has the same name as an Item into the city's inventory, returns its price
            }
            player.inventory.remove(itemToSell);//remove the item from user's inventory
            player.Sell(price);//add balance into user's balance.
        }else{
            System.out.println("Your inventory is empty");
        }

    }

    private void BuyItems(){
        player.getCurrentCity().DisplayItemsWithSellPrice();//display the items available into the smuggler's current city

        var item = ChooseItemToMove("buy"); //ask which item the smuggler wants to buy

        var itemToMove = player.getCurrentCity().items.get(item);  //get the item into the city's items' array

        if(player.HasEnoughSpace()){ //validate if the smuggler has enough space in his inventory
            if(player.HasEnoughMoney(itemToMove.SellPrice)){ //validate if the smuggler has enough money in his balance
                player.inventory.add(itemToMove); //add the item to the smuggler's inventory
                player.Buy(itemToMove.SellPrice); //Update smuggler's balance
                //player.getCurrentCity().items.remove(itemToMove); //If we Remove the item from cities' items, we would lost the original city's price.
                return;
            }
            System.out.println("*****You don't have enough money!****");
            return;
        }
        System.out.println("*****You inventory is full!****");
    }
    private int ChooseItemToMove(String typeOfTransaction){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Please, inform the number of the item you want to %s: ", typeOfTransaction);
        return Integer.parseInt(scanner.next()) -1;

    }
    private void WaitUserInputToReturnToMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type any letter to return to menu: ");
        scanner.next();
        GameMenu();
    }
    private void CreatePlayer(String name){
        this.player = new Smuggler(name);//create and assign the nem player
        player.setCurrentCity(cities.get(1));//sending the player to the first city
        //need to create the initial inventory
    }

    private void CreateCitiesList(){
        var citiesToCreate = ReadFile("src\\Cities.txt");//load all cities from the file
        for (String city: citiesToCreate){
            cities.add(new City(city)); //create an object city and insert into the game cities' list
        }
    }
    private void CreateCitiesItemsList(){
        //create the items with different prices to each city
        var myItems = ReadFile("src\\Items.txt");//load all items

        for(City city: cities){ //for each city
            for(String item : myItems){//loop in each item in the loaded item from the file
                var price = RandomPrice();//generate random price to each item
                city.items.add(new Item(item, price, (price * 0.8)));//create the item object and insert the item into the city
            }
        }
    }

    private double RandomPrice(){
        // define the range
        int max = 200;
        int min = 1;
        int range = max - min + 1;

        return (Math.random() * range) + min;
    }

    //read each line of the file and returns into an array
    private ArrayList<String> ReadFile(String filePath) {
        ArrayList<String> results = new ArrayList<>();
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                results.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return results;
    }
}
