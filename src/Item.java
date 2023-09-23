public class Item {

    String name;
    Double SellPrice; //this is the highest price of the item, when the smuggler wants to buy an item from the city, he will pay this value
    Double BuyPrice; //this is the lowest price of the item, when the smuggler wants to sell an item to the city, he will receive this value

    Item(String name, Double sellPrice, Double buyPrice){
        this.name = name;
        this.SellPrice = sellPrice;
        this.BuyPrice = buyPrice;
    }

    public String DisplayOnlyItem(){
        return String.format("Item: %s", this.name);
    }

    public String DisplaySellPrice(){
        return String.format("Price: %.2f", this.SellPrice);
    }

    public String DisplayBuyPrice(){
        return String.format("Price: %.2f", this.BuyPrice);
    }
}
//association -> the object is created outside the object
//composition -> when the object is created inside another object