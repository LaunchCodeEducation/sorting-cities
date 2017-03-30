package org.launchcode;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LaunchCode
 */
public class CityData {

    private static final String DATA_FILE = "resources/city_data.csv";

    static ArrayList<City> loadData() {

        ArrayList<City> cities = new ArrayList<>();

        try {

            // Open the CSV file and set up pull out column header info and records
            Reader in = new FileReader(DATA_FILE);
            CSVParser parser = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
            List<CSVRecord> records = parser.getRecords();
            Integer numberOfColumns = records.get(0).size();
            String[] headers = parser.getHeaderMap().keySet().toArray(new String[numberOfColumns]);

            // Put the records into a more friendly format
            for (CSVRecord record : records) {

                cities.add(new City(
                        record.get("City"),
                        record.get("State"),
                        Integer.parseInt(record.get("Population")),
                        Double.parseDouble(record.get("Area"))
                ));
            }

        } catch (IOException e) {
            System.out.println("Failed to load data");
            e.printStackTrace();
        }

        return cities;
    }

}
