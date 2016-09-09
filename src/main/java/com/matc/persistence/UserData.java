package com.matc.persistence;

import com.matc.entity.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Access users in the user table.
 *
 * @author pwaite
 */
public class UserData {
    private final Logger logger = Logger.getLogger(this.getClass());


    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;
        //String sql = "SELECT *, truncate(datediff(curdate(), date_of_birth)/365.25,0) as age FROM users";
        String sql = "SELECT * FROM users";

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
            System.out.println("SearchUser.getAllUsers()...SQL Exception: " + e);
        } catch (Exception e) {
            System.out.println("SearchUser.getAllUsers()...Exception: " + e);
        }
        return users;
    }

    public List<User> getUserByLastName(String lastName) {
        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;

        String sql = "SELECT * FROM users WHERE last_name = '" + lastName + "' limit 1";

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
            System.out.println("SearchUser.getUserByLastName()...SQL Exception: " + e);
        } catch (Exception e) {
            System.out.println("SearchUser.getUserByLastName()...Exception: " + e);
        }
        return users;
    }

    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setLastName(results.getString("last_name"));
        user.setFirstName(results.getString("first_name"));
        user.setUserid(results.getString("id"));
        //user.setDateOfBirthAsString(results.getString("date_of_birth"));
        user.setDateOfBirth((results.getDate("date_of_birth").toLocalDate()));
        logger.info("hi nataliya user.getlastname is: " + user.getLastName());
        return user;
    }


}
