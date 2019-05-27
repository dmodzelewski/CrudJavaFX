package CrudJava.Tabele;

import CrudJava.Baza;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdresFunkcje {
    public static void DodajUzytkownika(Integer id, String miasto, String ulica, String nrDomu, String kodPocztowy, Integer idOsoby) {
        try {
            String dodanieTabeli = "CREATE TABLE IF NOT EXISTS adres(id INTEGER , miasto VARCHAR(20), ulica VARCHAR(20), nrDomu VARCHAR(20), KodPocztowy VARCHAR(20),idOsoby INTEGER , FOREIGN KEY(idOsoby) REFERENCES osoba(id))";
            Baza.WykonajPolecenieDB(dodanieTabeli);
            String dodanie = "INSERT INTO adres (id,miasto,ulica,nrDomu,kodPocztowy,idOsoby) VALUES ('" + id + "','" + miasto + "','" + ulica+ "','" + nrDomu+ "','" + kodPocztowy+ "','" + idOsoby+ "')";
            Baza.WykonajPolecenieDB(dodanie);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Dodano rekord do bazy");
        }
    }

    public static ObservableList<Adres> WyszukajUzytkownikow() {
        String zapytanie = "Select * FROM adres";
        ResultSet wynikzBazy = Baza.WyszukajWDB(zapytanie);
        if (wynikzBazy == null) {
            ObservableList<Adres> u = FXCollections.observableArrayList();
            return u;
        } else {
            ObservableList<Adres> TabelaAdres = ZmienTyp(wynikzBazy);
            return TabelaAdres;
        }

    }

    public static ObservableList<Adres> WyszukajUzytkownika(String id) {
        String zapytanie = "Select * FROM adres where id = " + id;
        ResultSet wynikzBazy = Baza.WyszukajWDB(zapytanie);

        ObservableList<Adres> TabelaAdres = ZmienTyp(wynikzBazy);
        return TabelaAdres;
    }

    public static ObservableList<Adres> ZmienTyp(ResultSet wynik) {
        ObservableList<Adres> adres = FXCollections.observableArrayList();
        try {
            while (wynik.next()) {
                Adres u = new Adres();
                u.setId(wynik.getString("ID"));
                u.setMiasto(wynik.getString("Miasto"));
                u.setUlica(wynik.getString("Ulica"));
                u.setNumerDomu(wynik.getString("nrDomu"));
                u.setKodPocztowy(wynik.getString("kodPocztowy"));
                u.setIdOsoba(wynik.getString("idOsoby"));
                adres.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Nie można zamienić typu ResultSet na ObervableList" + e);
        }
        return adres;
    }

    public static void UsunUzytkownika(String id) {
        String zapytanie = "Delete from adres where id = " + id;
        Baza.WykonajPolecenieDB(zapytanie);
    }

    public static void ZaktualizujUzytkownika(String id, String imie, String nazwisko, String Email, String Telefon) {
        String zapytanie = "UPDATE adres SET miasto = '" + imie + "' , ulica = '" + nazwisko + "' , nrDomu = '" + Email + "' , KodPocztowy = '" + Telefon + "' WHERE id = " + id;
        Baza.WykonajPolecenieDB(zapytanie);

    }

    public static void ZaktualizujId(String id, int rozmiar) {
        int nowe = Integer.parseInt(id) + 1;
        int biezace = Integer.parseInt(id);
        for (int i = 0; i < rozmiar; i++) {
            String zapytanie = "UPDATE adres SET id = " + biezace++ + " WHERE id = " + nowe++;
            Baza.WykonajPolecenieDB(zapytanie);
        }
    }

}


