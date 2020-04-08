package com.example.playlist;

public class ItemObject {
    //instance fields
    private String isSold;
    private String title, artist, country, company, year;
    private String price;

    // papaD's constuctor
    public ItemObject( String title, String year, String artist){
        this.title = title;
        this.year = year;
        this.artist = artist;
    }

    // perameterized constructor
    public ItemObject(String isSold, String title, String artist, String country, String company, String year, String price) {
        this.isSold = isSold;
        this.title = title;
        this.artist = artist;
        this.country = country;
        this.company = company;
        this.year = year;
        this.price = price;
    }

    //methods

    //getters and setters below
    public String isSold() {
        return isSold;
    }

    public void setSold(String sold) {
        isSold = sold;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
