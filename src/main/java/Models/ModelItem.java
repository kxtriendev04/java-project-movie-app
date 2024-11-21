
package Models;

import javax.swing.Icon;

public class ModelItem {
    int itemID;
    String itemName;
    String desc;
    double price;
    String brand;
    Icon image;

    public ModelItem() {
    }

    public ModelItem(int itemID, String itemName, String desc, double price, String brand, Icon image) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.desc = desc;
        this.price = price;
        this.brand = brand;
        this.image = image;
    }

    public int getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDesc() {
        return desc;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public Icon getImage() {
        return image;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setImage(Icon image) {
        this.image = image;
    }
    
}
