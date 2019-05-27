package CrudJava.Tabele;

import javafx.beans.property.SimpleStringProperty;

public class Adres {
    private final SimpleStringProperty idAdres;
    private final SimpleStringProperty miasto;
    private final SimpleStringProperty ulica;
    private final SimpleStringProperty numerDomu;
    private final SimpleStringProperty kodPocztowy;
    private final SimpleStringProperty idOsoba;

    public Adres() {
        this.idAdres = new SimpleStringProperty();
        this.miasto = new SimpleStringProperty();
        this.ulica = new SimpleStringProperty();
        this.numerDomu = new SimpleStringProperty();
        this.kodPocztowy = new SimpleStringProperty();
        this.idOsoba = new SimpleStringProperty();
    }

    public String getId() {
        return idAdres.get();
    }

    public SimpleStringProperty idAdresProperty() {
        return idAdres;
    }

    public void setId(String id) {
        this.idAdres.set(id);
    }

    public String getMiasto() {
        return miasto.get();
    }

    public SimpleStringProperty miastoProperty() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto.set(miasto);
    }

    public String getUlica() {
        return ulica.get();
    }

    public SimpleStringProperty ulicaProperty() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica.set(ulica);
    }

    public String getNumerDomu() {
        return numerDomu.get();
    }

    public SimpleStringProperty numerDomuProperty() {
        return numerDomu;
    }

    public void setNumerDomu(String numerDomu) {
        this.numerDomu.set(numerDomu);
    }

    public String getKodPocztowy() {
        return kodPocztowy.get();
    }

    public SimpleStringProperty kodPocztowyProperty() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy.set(kodPocztowy);
    }

    public String getIdOsoba() {
        return idOsoba.get();
    }

    public SimpleStringProperty idOsobaProperty() {
        return idOsoba;
    }

    public void setIdOsoba(String idOsoba) {
        this.idOsoba.set(idOsoba);
    }
}
