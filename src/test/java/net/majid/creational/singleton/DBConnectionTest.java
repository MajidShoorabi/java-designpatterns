package net.majid.creational.singleton;

import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.*;

/**
 * @author majid.shoorabi
 * @created 2021-29-August
 * @project PeySaz
 */

public class DBConnectionTest {

    @Test
    public void getInstance() {
        DBConnection instance = DBConnection.getInstance();
        Connection connection = instance.getConnection();

        String createQuery = "CREATE TABLE PERSON(id int primary key, name varchar(255))";
        try(Statement statement = connection.createStatement()){
            statement.execute(createQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String insertQuery = "INSERT INTO PERSON (id, name) values(?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2,"Test1");
            preparedStatement.executeUpdate();

            preparedStatement.setInt(1,2);
            preparedStatement.setString(2,"Test2");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String selectQuery ="SELECT COUNT(*) FROM PERSON";
        try(Statement query = connection.createStatement()){
            try(ResultSet resultSet = query.executeQuery(selectQuery)) {
                if(resultSet.next()){
                    System.out.println("THE COUNT IS : "+resultSet.getInt(1));
                    Assert.assertEquals(resultSet.getInt(1),2);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void performanceTest() {
        long time = System.currentTimeMillis();
        System.out.println(DBConnection.getInstance());
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        System.out.println(DBConnection.getInstance());
        System.out.println(System.currentTimeMillis() - time);
    }
}