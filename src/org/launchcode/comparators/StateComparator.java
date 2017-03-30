package org.launchcode.comparators;

import org.launchcode.City;

import java.util.Comparator;

/**
 * Created by LaunchCode
 */
public class StateComparator implements Comparator<City> {

    @Override
    public int compare(City o1, City o2) {
        return o1.getState().compareTo(o2.getState());
    }
}
