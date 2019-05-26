package CrudJava;

import java.sql.*;

public class Baza {

    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:bb.db";

    private static Connection conn;
    private static Statement stmt;

    public static void PolaczenieDB() {

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem połączenia");
            e.printStackTrace();
        }
    }

    public static void WylaczenieDB() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet WyszukajWDB(String sql) {
        Statement stmt = null;
        ResultSet wynik = null;
        try {
            PolaczenieDB();
            stmt = conn.createStatement();
            wynik = stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Dodano pierwszego Uzytkownika");
            return wynik;
        }
        return wynik;
    }

    public static void WykonajPolecenieDB(String sql) {
        Statement stmt = null;
        try {
            PolaczenieDB();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println("Problem z zapytaniem" + e);
        } finally {
            WylaczenieDB();
            System.out.println("Wykonano");
        }
    }


}
