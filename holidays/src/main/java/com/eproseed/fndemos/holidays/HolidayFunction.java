package com.eproseed.fndemos.holidays;

import de.jollyday.HolidayCalendar;
import de.jollyday.HolidayManager;
import de.jollyday.Holiday;

import java.util.Set;

public class HolidayFunction {

    public String handleRequest(String country) {
        
        String countryName = (country == null || country.isEmpty()) ? "SPAIN" : country;
        
        Set<Holiday> holidays = getHoliday(countryName, 2018);
        int numberOfHolidays =  (holidays == null ? -1 : holidays.size());
        return Integer.toString(numberOfHolidays);
    }

    public static void main(String[] args) {
        HolidayFunction oTest = new HolidayFunction();
        
        Set<Holiday>holidays = oTest.getHoliday("NETHERLANDS", 2018);
        for(Holiday oHoliday: holidays){
            System.out.println(oHoliday.toString());
        }
        
        System.out.println(oTest.handleRequest(""));
    }
    
    private Set<Holiday> getHoliday(String country, int year){
     
        HolidayCalendar.valueOf(country);
        HolidayManager hManager = HolidayManager.getInstance(HolidayCalendar.NETHERLANDS);
        Set <Holiday> holidays = hManager.getHolidays(year);
        return holidays;
    }

}
