package CrudJava.Użytkownik;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import CrudJava.Baza;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UzytkownikFunkcje {


    public static void DodajUzytkownika(Integer id, String imie, String nazwisko, String Email, String Telefon, String DataUrodzenia) {
        try {
            String dodanieTabeli = "CREATE TABLE IF NOT EXISTS osoba(id INTEGER , imie VARCHAR(20), nazwisko VARCHAR(20), email VARCHAR(20), telefon VARCHAR(20),data VARCHAR(20))";
            Baza.WykonajPolecenieDB(dodanieTabeli);
            String dodanie = "INSERT INTO osoba (id,imie,nazwisko,email,telefon,data) VALUES ('" + id + "','" + imie + "','" + nazwisko + "','" + Email + "','" + Telefon + "','" + DataUrodzenia + "')";
            Baza.WykonajPolecenieDB(dodanie);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Dodano rekord do bazy");
        }
    }

    public static ObservableList<Uzytkownik> WyszukajUzytkownikow() {
        String zapytanie = "Select * FROM osoba";
        ResultSet wynikzBazy = Baza.WyszukajWDB(zapytanie);
        if (wynikzBazy == null) {
            ObservableList<Uzytkownik> u = FXCollections.observableArrayList();
            return u;
        } else {
            ObservableList<Uzytkownik> TabelaUzytkownik = ZmienTyp(wynikzBazy);
            return TabelaUzytkownik;
        }

    }

    public static ObservableList<Uzytkownik> WyszukajUzytkownika(String id) {
        String zapytanie = "Select * FROM osoba where id = " + id;
        ResultSet wynikzBazy = Baza.WyszukajWDB(zapytanie);

        ObservableList<Uzytkownik> TabelaUzytkownik = ZmienTyp(wynikzBazy);
        return TabelaUzytkownik;
    }

    public static ObservableList<Uzytkownik> ZmienTyp(ResultSet wynik) {
        ObservableList<Uzytkownik> uzytkownik = FXCollections.observableArrayList();
        try {
            while (wynik.next()) {
                Uzytkownik u = new Uzytkownik();
                u.setId(wynik.getString("ID"));
                u.setImie(wynik.getString("Imie"));
                u.setNazwisko(wynik.getString("Nazwisko"));
                u.setEmail(wynik.getString("Email"));
                u.setTelefon(wynik.getString("Telefon"));
                u.setDataUrodzenia(wynik.getString("Data"));
                uzytkownik.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Nie można zamienić typu ResultSet na ObervableList" + e);
        }
        return uzytkownik;
    }

    public static void UsunUzytkownika(String id) {
        String zapytanie = "Delete from osoba where id = " + id;
        Baza.WykonajPolecenieDB(zapytanie);
    }

    public static void ZaktualizujUzytkownika(String id, String imie, String nazwisko, String Email, String Telefon, String DataUrodzenia) {
        String zapytanie = "UPDATE osoba SET imie = '" + imie + "' , nazwisko = '" + nazwisko + "' , email = '" + Email + "' , telefon = '" + Telefon + "' WHERE id = " + id;
        Baza.WykonajPolecenieDB(zapytanie);

    }

    public static void ZaktualizujId(String id, int rozmiar) {
        int nowe = Integer.parseInt(id) + 1;
        int biezace = Integer.parseInt(id);
        for (int i = 0; i < rozmiar; i++) {
            String zapytanie = "UPDATE osoba SET id = " + biezace++ + " WHERE id = " + nowe++;
            Baza.WykonajPolecenieDB(zapytanie);
        }
    }

}
