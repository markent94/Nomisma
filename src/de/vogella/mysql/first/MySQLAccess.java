package de.vogella.mysql.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

//This class holds the JDBC Driver which connects the Java Program to the MySQL
//server. The code being used is built up from the tutorial code used by Vogella
//at http://www.vogella.com/tutorials/MySQLJava/article.html
public class MySQLAccess {
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;

  public void readDataBase() throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost/feedback?"
              + "user=sqluser&password=sqluserpw");

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // Result set get the result of the SQL query
      resultSet = statement
          .executeQuery("select * from feedback.transactions");
      writeResultSet(resultSet);

      // PreparedStatements can use variables and are more efficient
      preparedStatement = connect
          .prepareStatement("insert into  feedback.transactions values (default, ?, ?, ?, ? , ?, ?, ?)");
      // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
      // Parameters start with 1
      preparedStatement.setString(1, "Test");
      preparedStatement.setFloat(2, (float) 3.14);
      preparedStatement.setFloat(3, (float) 3.4);
      preparedStatement.setFloat(4, (float) 7.4);
      preparedStatement.setFloat(5, (float) 3.5);
      preparedStatement.setFloat(6, (float) 4.5);
      preparedStatement.setFloat(7, (float) 6.9);
      preparedStatement.executeUpdate();

      preparedStatement = connect
          .prepareStatement("SELECT * from feedback.transactions");
      resultSet = preparedStatement.executeQuery();
      writeResultSet(resultSet);

      // Remove again the insert comment
      preparedStatement = connect
      .prepareStatement("delete from feedback.transactions where myuser= ? ; ");
      preparedStatement.setString(1, "Test");
      preparedStatement.executeUpdate();
      
      resultSet = statement
      .executeQuery("select * from feedback.transactions");
      writeMetaData(resultSet);
      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }

  private void writeMetaData(ResultSet resultSet) throws SQLException {
    //   Now get some metadata from the database
    // Result set get the result of the SQL query
    
    System.out.println("The columns in the table are: ");
    
    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
    }
  }

  private void writeResultSet(ResultSet resultSet) throws SQLException {
    // ResultSet is initially before the first data set
    while (resultSet.next()) {
      // It is possible to get the columns via name
      // also possible to get the columns via the column number
      // which starts at 1
      // e.g. resultSet.getSTring(2);
      String user = resultSet.getString("myuser");
      float balance = resultSet.getFloat("balance");
      float entertainment = resultSet.getFloat("entertainment");
      float food = resultSet.getFloat("food");
      float transport = resultSet.getFloat("transport");
      float room = resultSet.getFloat("room");
      float emergency = resultSet.getFloat("emergency");
      System.out.println("User: " + user);
      System.out.println("balance: " + balance);
      System.out.println("entertainment: " + entertainment);
      System.out.println("food: " + food);
      System.out.println("transport: " + transport);
      System.out.println("room: " + room);
      System.out.println("emergency: " + emergency);
    }
  }

  // You need to close the resultSet
  private void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (statement != null) {
        statement.close();
      }

      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }

} 
