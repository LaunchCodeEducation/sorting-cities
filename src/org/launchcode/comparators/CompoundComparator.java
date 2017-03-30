package org.launchcode.comparators;

import org.launchcode.City;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by LaunchCode
 */
public class CompoundComparator implements Comparator<City> {

    private List<Comparator<City>> comparators = new ArrayList<>();

    public void add(Comparator<City> comparator) {
        comparators.add(comparator);
    }

    @Override
    public int compare(City o1, City o2) {

        int comparison = 0;
        int numComparisons = 0;

        while (comparison == 0 && numComparisons < comparators.size()) {
            comparison = comparators.get(numComparisons).compare(o1, o2);
            numComparisons++;
        }

        return comparison;
    }
}
