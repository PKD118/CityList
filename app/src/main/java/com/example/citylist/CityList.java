package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }
    /**
     * This deletes a city from the list
     * @param city
     * if any city doesnot exist it throws an exception
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        else
        {
            cities.remove(city);
        }
    }

    /**
     * this is used to count total number of cities
     * @return item count returns size of Cities-List
     *
     */
    public int count() {
        return cities.size();
    }
    /**
     * this is used to present the list of cities
     * @return a list of city sorted by city name or province name
     *
     */

    public List<City> getCities(int num) {
        List<City> cityList = cities;
        if(num==0) {
            Collections.sort(cityList);
            return cityList;
        }
        else {
            Collections.sort(cityList, new Comparator<City>() {
                        @Override
                        public int compare(City o1, City o2) {
                            return o1.getProvinceName().compareTo(o2.getProvinceName());
                        }
                    });
        }
        return cityList;
    }
}
