package com.mohammad.obeidat.client;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Expense {
    // Format Current Date & Time Using Specific Pattern.

    DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    // Get Current Date & Time.

    LocalDateTime currentDate = LocalDateTime.now();



    // Instance Variables.

    private String name, description, date;

    private CATEGORIES category;

    private int value;



    // Constructor to initialize expense data.

    public Expense(String name, int value, String description, CATEGORIES category) {

        this.name = name;

        this.value = value;

        this.description = description;

        this.category = category;

        this.setDate(formattedDate.format(currentDate));

    }





    // Setters And Getters.

    public String getName() {

        return name;

    }



    public void setName(String name) {

        this.name = name;

    }





    public int getValue() {

        return value;

    }



    public void setValue(int value) {

        this.value = value;

    }





    public String getDescription() {

        return description;

    }



    public void setDescription(String description) {

        this.description = description;

    }





    public CATEGORIES getCategory() {

        return category;

    }



    public void setCategory(CATEGORIES category) {

        this.category = category;

    }





    public String getDate() {

        return date;

    }



    public void setDate(String date) {

        this.date = date;

    }

}
