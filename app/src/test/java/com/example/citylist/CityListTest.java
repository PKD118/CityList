package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(0).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(0).size());
        assertTrue(cityList.getCities(0).contains(city));
    }
    @Test
    public void testdelete() {
        CityList cityList = mockCityList();
        City home = new City("Sunamgonj", "Sylhet");
        City work = new City("Teligati", "Khulna");
        cityList.add(home);
        cityList.add(work);
        cityList.delete(home);
        assertTrue(!cityList.getCities(0).contains(home));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    @Test
    public void testdeleteException() {
        CityList cityList = mockCityList();
        City home = new City("Sunamgonj", "Sylhet");
        City work = new City("Teligati", "Khulna");
        cityList.add(home);
        cityList.add(work);
        cityList.delete(home);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(home);
        });
    }
    @Test
    public void testcount() {
        CityList cityList = mockCityList();
        City home = new City("Sunamgonj", "Sylhet");
        City work = new City("Teligati", "Khulna");
        cityList.add(home);
        cityList.add(work);
        assertEquals(3,cityList.count());
        cityList.delete(home);
        assertEquals(2,cityList.count());
    }

    @Test
    public void testGetCities() {
        CityList cityList = new CityList();
        City home = new City("Sunamgonj", "Sylhet");
        cityList.add(home);
        assertEquals(0, home.compareTo(cityList.getCities(0).get(0)));
        City work = new City("Teligati", "Khulna");
        cityList.add(work);
        assertEquals(0, home.compareTo(cityList.getCities(0).get(0)));
        assertEquals(0, work.compareTo(cityList.getCities(0).get(1)));
    }
}
