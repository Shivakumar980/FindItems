package com.webdevproject.finditem.model;

public class LostItemDetails {
    Integer id;
    String itemName;
    String itemPic;
    String areaFound;
    String pinCode;
    String details;
    String userId;

    public LostItemDetails() {
    }

    // Parameterized constructor
    public LostItemDetails(Integer id,String itemName, String itemPic, String areaFound, String pinCode, String details, String userId) {
        this.id = id;
        this.itemName = itemName;
        this.itemPic = itemPic;
        this.areaFound = areaFound;
        this.pinCode = pinCode;
        this.details = details;
        this.userId = userId;  // Initialize new field
    }

    // Getter and setter for itemName
    public String getItemName() {
        return itemName;
    }

    public Integer getId() {
        return id;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    // Getter and setter for itemPic
    public String getItemPic() {
        return itemPic;
    }

    public void setItemPic(String itemPic) {
        this.itemPic = itemPic;
    }

    // Getter and setter for areaFound
    public String getAreaFound() {
        return areaFound;
    }

    public void setAreaFound(String areaFound) {
        this.areaFound = areaFound;
    }

    // Getter and setter for pinCode
    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    // Getter and setter for contactId
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    // Getter and setter for userId
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    // toString method
    @Override
    public String toString() {
        return "Item{" +
        "id='" + id + '\'' +
               "itemName='" + itemName + '\'' +
               ", itemPic='" + itemPic + '\'' +
               ", areaFound='" + areaFound + '\'' +
               ", pinCode='" + pinCode + '\'' +
               ", details='" + details + '\'' +
               ", userId='" + userId + '\'' +
               '}';
    }
}
