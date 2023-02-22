// package fr.quarkus.openshift.database;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.ArrayList;

// public class DatabaseManager {

// private Connection connection;
// private String url = "jdbc:mariadb://localhost:3306/Gods";
// private String user = "root";
// private String password = "root";

// public DatabaseManager() throws SQLException {
// try {
// this.connection = DriverManager
// .getConnection("jdbc:mariadb://localhost:3306/DB?user=root&password=myPassword");
// } catch (SQLException e) {
// e.printStackTrace();
// }
// System.out.println("Connection established");
// }

// public Connection getConnection() {
// return connection;
// }

// public ArrayList<God> getAllGods() throws SQLException {
// ArrayList<God> gods = new ArrayList<God>();
// String query = "select name,place,country from Gods";
// try (Statement stmt = connection.createStatement()) {
// ResultSet rs = stmt.executeQuery(query);
// while (rs.next()) {
// String name = rs.getString("name");
// String place = rs.getString("place");
// String country = rs.getString("country");
// // String divinityGroup = rs.getString("divinityGroup");
// gods.add(new God(name, place, country, "divinityGroup"));
// }
// } catch (SQLException e) {
// e.printStackTrace();
// }

// return gods;
// }

// public void addGod(God god) throws SQLException {
// String query = "insert into Gods (name,place,country,divinityGroup) values
// ('" + god.getName() + "','"
// + god.getPlace() + "','" + god.getCountry() + "','" + god.getDivinityGroup()
// + "')";
// try (Statement stmt = connection.createStatement()) {
// ResultSet rs = stmt.execute(query);
// while (rs.next()) {
// String name = rs.getString("name");
// String place = rs.getString("place");
// String country = rs.getString("country");
// String divinityGroup = rs.getString("divinityGroup");
// }
// } catch (SQLException e) {
// e.printStackTrace();
// }
// }
// }
