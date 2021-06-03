package com.fdflib.example.model;

import com.fdflib.model.state.CommonState;

public class Driver extends CommonState { // Both Driver and Car extend CommonState...
	// Since we are including the 4DFLib Dependency, we have access to its jar files.
	
	// All Classes that extend CommonState have these attributes.
	// rid is a Row Id (an always unique value that represents any row in a table.  Something that has a unique 
	// current flag is set as true meaning that it is the most recent record (tuple) in a database
	// if a row has some element that was changed and you deleted it, that data actually remains in history, but its df is set to true.
	// arsd is a start date (the time at which you created the record)
	// ared is the end date (the time at which you edited the record
		/*
		 * the second (updated) record would have a start arsd that's == to the ared of the first record 
		 * The current record always has a NULL end date and the current record flag (cf) is set to true 
		 */
	// euid is the user id that edited the Tuple
	// esid is the system id (in what system is the record being edited)
		/*
		 * imagine that you haev an API that can be used by multiple devices or systems.  You can apply a system id to identify ('oh an android is accessing the api now')
		 */
	// tid is tenant id which represents a group of users
	
    public String firstName = "";
    public String lastName = "";
    public String phoneNumber = "";

    public Driver() {
        super();
    }
}
