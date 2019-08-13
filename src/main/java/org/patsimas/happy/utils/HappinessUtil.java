package org.patsimas.happy.utils;

import org.patsimas.happy.domain.Happiness;

public class HappinessUtil {

	public static Happiness setHappinessByRating(Double rating) {
		
		if(rating <= 100 && rating >=95) {
    		return Happiness.SUPERB;
    	}
    	else if(rating <= 94 && rating >=85) {
    		return Happiness.VERY_GOOD;
    	}
    	else if(rating <= 84 && rating >=75) {
    		return Happiness.GOOD;
    	}
    	else if(rating <= 74 && rating >=65) {
    		return Happiness.FAIRLY_GOOD;
    	}
    	else if(rating <= 64 && rating >=55) {
    		return Happiness.FAIRLY_POOR;
    	}
    	else if(rating <= 54 && rating >=45) {
    		return Happiness.POOR;
    	}
    	else if(rating <= 44 && rating >=35) {
    		return Happiness.VERY_POOR;
    	}
    	else if(rating <= 34) {
    		return Happiness.AWFUL;
    	}
    	else {
    		return null;
    	}
	}
	
	
}
