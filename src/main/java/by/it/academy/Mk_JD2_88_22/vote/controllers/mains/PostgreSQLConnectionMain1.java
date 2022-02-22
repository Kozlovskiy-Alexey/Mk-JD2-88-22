package by.it.academy.Mk_JD2_88_22.vote.controllers.mains;

import java.sql.*;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class PostgreSQLConnectionMain1 {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql:" +
                "//localhost:5433/demo?ApplicationName=TestMyApp", "postgres", "postgre");
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT\n" +
                    "    flight_id,\n" +
                    "    flight_no,\n" +
                    "    scheduled_departure,\n" +
                    "    scheduled_arrival,\n" +
                    "    departure_airport,\n" +
                    "    arrival_airport,\n" +
                    "    status,\n" +
                    "    aircraft_code,\n" +
                    "    actual_departure,\n" +
                    "    actual_arrival\n" +
                    "FROM\n" +
                    "    bookings.flights;\n");
            int count = 0;
            UUID.randomUUID();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("flight_no"));
                count++;
            }
            System.out.println(count);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
