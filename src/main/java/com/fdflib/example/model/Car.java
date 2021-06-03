package com.fdflib.example.model;

import com.fdflib.annotation.FdfIgnore;
import com.fdflib.model.state.CommonState;

public class Car extends CommonState {

    public CarMake make = null;
    public String model = "";
    public Integer year = 0;
    public String color = "";
    public String name = "";
    public String description = "";
    public Boolean isInNeedOfRepair = true;
    public Boolean isOnCall = true;
    public Boolean isOutWorking = false;
    public long currentDriverId = -1L; // Instead we want this to represent our foreign key in the database

    @FdfIgnore // Compiler reads this and knows to ignore it (this prevents FdfLib from inserting the complex obj into the DB). 
    public Driver currentDriver = null;
    // When we RETRIEVE the Car object from our DB, we want the ability to create the current Driver based on what we fetch from the 
    // currentDriverId (FK pointing to ACUTAL Driver object).
    // We can then query the Driver table to grab the Driver object and then sent the object here.

    public Car() {
        super();
    }

}
