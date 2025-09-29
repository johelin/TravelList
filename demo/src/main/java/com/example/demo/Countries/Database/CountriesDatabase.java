package com.example.demo.Countries.Database;


import java.sql.*;
import java.util.HashMap;

public class CountriesDatabase {

    private static final String URL = "jdbc:postgresql://localhost:5432/travel_db";
    private static final String USER = "travel_user";
    private static final String PASSWORD = "travel_pass";

    public static HashMap<String, String> loadCountries() {
        HashMap<String, String> countryMap = new HashMap<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT country, abbreviation FROM countries";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                countryMap.put(rs.getString("country"), rs.getString("abbreviation"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return countryMap;
    }

    public static void saveCountry(String country, String abbreviation) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "INSERT INTO countries (country, abbreviation) VALUES (?, ?) " +
                           "ON CONFLICT (country) DO UPDATE SET abbreviation = EXCLUDED.abbreviation";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, country);
            pstmt.setString(2, abbreviation);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
