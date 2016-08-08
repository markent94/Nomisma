package nomisma.mysql.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.Class;
//import java.util.Date;

//This class holds the JDBC Driver which connects the Java Program to the MySQL
//server. The code being used is built up from the tutorial code used by Vogella
//at http://www.vogella.com/tutorials/MySQLJava/article.html
public class MySQLAccess {
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;
  
  
  private final String nomismaDB = "jdbc:mysql://66.27.203.133:53207/nomisma?user=testnomisma&password=3ghf8wsh36";

  /**
   * authUser
   * 
   * Fetches a user from an "account" table on database "nomisma"
   * (Username can possibly be a primary key)
   * 
   * @param username a given username
   * @param password a given password
   * @throws Exception
   * @return a String array containing a uid and username if there's a match. If nothing is returned, no such matching account exists.
   */
  public int authUser(String username, String password) throws Exception {
      
      try {
          int uid = 0;
          Class.forName("com.mysql.jdbc.Driver");
          connect = DriverManager
          .getConnection(nomismaDB);
          
          preparedStatement = connect.prepareStatement("SELECT id, username FROM nomisma.account WHERE username = ? AND password = ?");
          preparedStatement.setString(1, username);
          preparedStatement.setString(2, password);
          resultSet = preparedStatement.executeQuery();
          
          while (resultSet.next()) {
            uid = resultSet.getInt("id");
          }
          return uid;
      } catch (Exception e) {
          System.out.println("ERROR: Login failed.");
          throw e;
      } finally {
          close();
      }
  }
  
  /**
   * readDataBase
   * 
   * Reads the transactions table for testing purposes
   * 
   * @throws Exception
   */
  public void readDataBase() throws Exception {
    try {
        // This will load the MySQL driver, each DB has its own driver
        Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection(nomismaDB);

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // Result set get the result of the SQL query
      resultSet = statement
          .executeQuery("select * from nomisma.transactions");
      writeResultSet(resultSet);
      
      resultSet = statement
      .executeQuery("select * from nomisma.transactions");
      writeMetaData(resultSet);
      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }
  
    /**
   * readUserTransactions
   * 
   * Displays transactions of the user in specific fields
   * 
   * @param userid ID of the user to be read
   * @throws Exception
   */
  public void readUserTransactions(int userid) throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection(nomismaDB);

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // Result set get the result of the SQL query
      preparedStatement = connect
          .prepareStatement("SELECT * from nomisma.transactions WHERE id = ?");
      preparedStatement.setInt(1, userid);
      resultSet = preparedStatement.executeQuery();
      writeResultSet(resultSet);
      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }
  
    /**
   * reduceBalance
   * 
   * Displays current balance, 
   * 
   * @param userid ID of the user to be read
   * @param cost Amount of money to reduce balance by
   * @return double current balance
   * @throws Exception
   */
  public double reduceBalance(double cost, int userid) throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection(nomismaDB);

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();

      // PreparedStatements can use variables and are more efficient
      preparedStatement = connect
          .prepareStatement("UPDATE transactions SET balance = balance - ? WHERE id = ?");
      // "myuser, webpage, datum, summary, COMMENTS from nomisma.comments");
      // Parameters start with 1
      preparedStatement.setDouble(1, cost);
      preparedStatement.setInt(2, userid);
      preparedStatement.executeUpdate();

      preparedStatement = connect
          .prepareStatement("SELECT * from nomisma.transactions WHERE id = ?");
      preparedStatement.setInt(1, userid);
      resultSet = preparedStatement.executeQuery();
      double balance = 0;
      while (resultSet.next()) {
        balance = resultSet.getDouble("balance");
        System.out.println("New balance: " + balance);  
      }
      return balance;
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }

   /**
   * incEntertainment
   * 
   * Displays current entertainment expenses 
   * 
   * @param userid ID of the user to be read
   * @param cost Amount of money to add to entertainment expenses
   * @return double entertainment balance
   * @throws Exception
   */
  public double incEntertainment(double cost, int userid) throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection(nomismaDB);

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();

      // PreparedStatements can use variables and are more efficient
      preparedStatement = connect
          .prepareStatement("UPDATE transactions SET entertainment = entertainment + ? WHERE id = ?");
      // "myuser, webpage, datum, summary, COMMENTS from nomisma.comments");
      // Parameters start with 1
      preparedStatement.setDouble(1, cost);
      preparedStatement.setInt(2, userid);
      preparedStatement.executeUpdate();

      preparedStatement = connect
          .prepareStatement("SELECT * from nomisma.transactions WHERE id = ?");
      preparedStatement.setInt(1, userid);
      resultSet = preparedStatement.executeQuery();
      double expense = 0;
      while (resultSet.next()) {
        expense = resultSet.getDouble("entertainment");
        System.out.println("New entertainment expenses: " + expense);  
      }
      return expense;
      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }
  
  /**
   * incFood
   * 
   * Displays current entertainment expenses 
   * 
   * @param userid ID of the user to be read
   * @param cost Amount of money to add to food expenses
   * @return food balance
   * @throws Exception
   */
  public double incFood(double cost, int userid) throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection(nomismaDB);

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();

      // PreparedStatements can use variables and are more efficient
      preparedStatement = connect
          .prepareStatement("UPDATE transactions SET food = food + ? WHERE id = ?");
      // "myuser, webpage, datum, summary, COMMENTS from nomisma.comments");
      // Parameters start with 1
      preparedStatement.setDouble(1, cost);
      preparedStatement.setInt(2, userid);
      preparedStatement.executeUpdate();

      preparedStatement = connect
          .prepareStatement("SELECT * from nomisma.transactions WHERE id = ?");
      preparedStatement.setInt(1, userid);
      resultSet = preparedStatement.executeQuery();
      double expense = 0;
      while (resultSet.next()) {
        expense = resultSet.getDouble("food");
        System.out.println("New food expenses: " + expense);  
      }
      return expense;
      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }
  
  /**
   * incTransport
   * 
   * Displays current transport expenses 
   * 
   * @param userid ID of the user to be read
   * @param cost Amount of money to add to transport expenses
   * @return transport expense
   * @throws Exception
   */
  public double incTransport(double cost, int userid) throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection(nomismaDB);

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();

      // PreparedStatements can use variables and are more efficient
      preparedStatement = connect
          .prepareStatement("UPDATE transactions SET transport = transport + ? WHERE id = ?");
      // "myuser, webpage, datum, summary, COMMENTS from nomisma.comments");
      // Parameters start with 1
      preparedStatement.setDouble(1, cost);
      preparedStatement.setInt(2, userid);
      preparedStatement.executeUpdate();

      preparedStatement = connect
          .prepareStatement("SELECT * from nomisma.transactions WHERE id = ?");
      preparedStatement.setInt(1, userid);
      resultSet = preparedStatement.executeQuery();
      double expense = 0;
      while (resultSet.next()) {
        expense = resultSet.getDouble("transport");
        System.out.println("New transport expenses: " + expense);  
      }
      return expense;
      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }
  
  /**
   * incRoom
   * 
   * Displays current room expenses 
   * 
   * @param userid ID of the user to be read
   * @param cost Amount of money to add to room expenses
   * @return room expense
   * @throws Exception
   */
  public double incRoom(double cost, int userid) throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection(nomismaDB);

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();

      // PreparedStatements can use variables and are more efficient
      preparedStatement = connect
          .prepareStatement("UPDATE transactions SET room = room + ? WHERE id = ?");
      // "myuser, webpage, datum, summary, COMMENTS from nomisma.comments");
      // Parameters start with 1
      preparedStatement.setDouble(1, cost);
      preparedStatement.setInt(2, userid);
      preparedStatement.executeUpdate();

      preparedStatement = connect
          .prepareStatement("SELECT * from nomisma.transactions WHERE id = ?");
      preparedStatement.setInt(1, userid);
      resultSet = preparedStatement.executeQuery();
      double expense = 0;
      while (resultSet.next()) {
        expense = resultSet.getDouble("room");
        System.out.println("New room expenses: " + expense);  
      }
      return expense;
      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }
  
  /**
   * incEmergency
   * 
   * Displays current emergency expenses 
   * 
   * @param userid ID of the user to be read
   * @param cost Amount of money to add to emergency expenses
   * @return emergency expense
   * @throws Exception
   */
  public double incEmergency(double cost, int userid) throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection(nomismaDB);

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();

      // PreparedStatements can use variables and are more efficient
      preparedStatement = connect
          .prepareStatement("UPDATE transactions SET emergency = emergency + ? WHERE id = ?");
      // "myuser, webpage, datum, summary, COMMENTS from nomisma.comments");
      // Parameters start with 1
      preparedStatement.setDouble(1, cost);
      preparedStatement.setInt(2, userid);
      preparedStatement.executeUpdate();

      preparedStatement = connect
          .prepareStatement("SELECT * from nomisma.transactions WHERE id = ?");
      preparedStatement.setInt(1, userid);
      resultSet = preparedStatement.executeQuery();
      double expense = 0;
      while (resultSet.next()) {
        expense = resultSet.getDouble("emergency");
        System.out.println("New emergency expenses: " + expense);  
      }
      return expense;
      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }
  
  /**
   * writeMetaData
   * 
   * Writes table data - used for readDataBase
   * 
   * @param resultset data set to be read
   * @throws Exception
   */
  private void writeMetaData(ResultSet resultSet) throws SQLException {
    //   Now get some metadata from the database
    // Result set get the result of the SQL query
    
    System.out.println("The columns in the table are: ");
    
    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
    }
  }

  /**
   * writeResultSet
   * 
   * Writes user data - used by readUserTransactions() 
   * 
   * @param writeResultSet data set to gather information from
   * @throws Exception
   */
  private void writeResultSet(ResultSet resultSet) throws SQLException {
    // ResultSet is initially before the first data set
    while (resultSet.next()) {
      // It is possible to get the columns via name
      // also possible to get the columns via the column number
      // which starts at 1
      // e.g. resultSet.getSTring(2);
      String user = resultSet.getString("myuser");
      double balance = resultSet.getDouble("balance");
      double entertainment = resultSet.getDouble("entertainment");
      double food = resultSet.getDouble("food");
      double transport = resultSet.getDouble("transport");
      double room = resultSet.getDouble("room");
      double emergency = resultSet.getDouble("emergency");
      System.out.println("User: " + user);
      System.out.println("balance: " + balance);
      System.out.println("entertainment expenses: " + entertainment);
      System.out.println("food expenses: " + food);
      System.out.println("transport expenses: " + transport);
      System.out.println("room expenses: " + room);
      System.out.println("emergency expenses: " + emergency);
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
