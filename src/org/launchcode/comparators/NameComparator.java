package org.launchcode.comparators;

import org.launchcode.City;

import java.util.Comparator;

/**
 * Created by LaunchCode
 */
public class NameComparator implements Comparator<City> {

    @Override
    public int compare(City o1, City o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
