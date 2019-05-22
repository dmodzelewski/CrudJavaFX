package CrudJava;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import CrudJava.Użytkownik.Uzytkownik;
import CrudJava.Użytkownik.UzytkownikFunkcje;

import java.util.Optional;

public class ControllerBaza {
    @FXML
    private TextField Imie;
    @FXML
    private TextField Nazwisko;
    @FXML
    private TextField Email;
    @FXML
    private TextField Telefon;
    @FXML
    private TextField DataUrodzenia;
    @FXML
    private TextField Id;
    @FXML
    private Button Anuluj;
    @FXML
    private Button dodajUzytkownika;
    @FXML
    private Button wyszukajWszystkichPrzycisk;
    @FXML
    private Button WyszukajPrzycisk;
    @FXML
    private Button UsuńPrzycisk;
    @FXML
    private Button UaktualnijPrzycisk;
    @FXML
    private Button Potwierdz;
    @FXML
    private TableView Tabela;
    @FXML
    private TableColumn<Uzytkownik, String> idTabela;
    @FXML
    private TableColumn<Uzytkownik, String> ImieTabela;
    @FXML
    private TableColumn<Uzytkownik, String> NazwiskoTabela;
    @FXML
    private TableColumn<Uzytkownik, String> EmailTabela;
    @FXML
    private TableColumn<Uzytkownik, String> TelefonTabela;
    @FXML
    private TableColumn<Uzytkownik, String> DataUrodzeniaTabela;
    @FXML
    private ToolBar noweDane;
    @FXML
    private ToolBar PanelZarzadzania;
    @FXML
    private ToolBar PanelPotwierdzenia;
    @FXML
    private Label LabelId;
    private Integer id = 1;

    @FXML
    public void initialize() {
        dodajUzytkownika.setDisable(true);
        Nazwisko.setDisable(true);
        Email.setDisable(true);
        Telefon.setDisable(true);
        DataUrodzenia.setDisable(true);
        UaktualnijPrzycisk.setDisable(true);
        UsuńPrzycisk.setDisable(true);
        Potwierdz.setVisible(false);
        noweDane.setVisible(false);
        PanelPotwierdzenia.setVisible(false);

        idTabela.setCellValueFactory(cellDara -> cellDara.getValue().idProperty());
        ImieTabela.setCellValueFactory(cellData -> cellData.getValue().imieProperty());
        NazwiskoTabela.setCellValueFactory(cellData -> cellData.getValue().nazwiskoProperty());
        EmailTabela.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        TelefonTabela.setCellValueFactory(cellData -> cellData.getValue().telefonProperty());
        DataUrodzeniaTabela.setCellValueFactory(cellData -> cellData.getValue().dataUrodzeniaProperty());
    }

    @FXML
    public void WpisywanieDanychDoTabeli() {
        String textImie = Imie.getText();
        String textNazwisko = Nazwisko.getText();
        String textEmail = Email.getText();
        String textTelefon = Telefon.getText();
        String textDataurodzenia = DataUrodzenia.getText();

        boolean imiePoprawnosc = textImie.isEmpty() | textImie.trim().isEmpty();
        boolean nazwiskoPoprawnosc = textNazwisko.isEmpty() | textNazwisko.trim().isEmpty();
        boolean emailPoprawnosc = textEmail.isEmpty() | textEmail.trim().isEmpty();
        boolean telefonPoprawnosc = textTelefon.isEmpty() | textTelefon.trim().isEmpty();
        boolean DataUrodzzeniaPoprawnosc = textDataurodzenia.isEmpty() | textDataurodzenia.trim().isEmpty();
        Nazwisko.setDisable(imiePoprawnosc);
        Email.setDisable(nazwiskoPoprawnosc);
        Telefon.setDisable(emailPoprawnosc);
        DataUrodzenia.setDisable(telefonPoprawnosc);
        dodajUzytkownika.setDisable(DataUrodzzeniaPoprawnosc);
    }

    @FXML
    public void DodajUzytkownika(ActionEvent actionEvent) {
        if (id == 1 && UzytkownikFunkcje.WyszukajUzytkownikow().size() == 0) {
            UzytkownikFunkcje.DodajUzytkownika(id++, Imie.getText(), Nazwisko.getText(), Email.getText(), Telefon.getText(), DataUrodzenia.getText());

        } else {
            id = UzytkownikFunkcje.WyszukajUzytkownikow().size() + 1;
            UzytkownikFunkcje.DodajUzytkownika(id++, Imie.getText(), Nazwisko.getText(), Email.getText(), Telefon.getText(), DataUrodzenia.getText());
        }
    }

    @FXML
    public void Wyswietl(ActionEvent actionEvent) {
        ObservableList<Uzytkownik> dane = UzytkownikFunkcje.WyszukajUzytkownikow();
        Tabela.setItems(dane);
    }

    @FXML
    public void Wyszukaj() {
        String id = Id.getText();
        if (id.isEmpty()) {
            Alert BrakDanych = new Alert(Alert.AlertType.ERROR, "Wpisz Id!", ButtonType.OK);
            BrakDanych.setTitle("Błąd");
            BrakDanych.show();
        } else {
            ObservableList<Uzytkownik> dane = UzytkownikFunkcje.WyszukajUzytkownika(id);
            if (dane.size() == 1) {
                UaktualnijPrzycisk.setDisable(false);
                UsuńPrzycisk.setDisable(false);
            } else {
                UaktualnijPrzycisk.setDisable(true);
                UsuńPrzycisk.setDisable(true);
            }
            Tabela.setItems(dane);
        }
    }

    @FXML
    public void Usun(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Czy chcesz usunąć użytkownika o id = " + Id.getText(), ButtonType.YES, ButtonType.NO);
        alert.setTitle("Ostrzeżenie");
        alert.setHeaderText("Czy na pewno chcesz usunąć rekord?");
        Optional<ButtonType> wynik = alert.showAndWait();
        if (wynik.get() == ButtonType.YES) {
            if (UzytkownikFunkcje.WyszukajUzytkownikow().size() > 0) {
                if (id >= 1 && UzytkownikFunkcje.WyszukajUzytkownikow().size() >= 1) {
                    id--;
                    String id = Id.getText();
                    if (id.isEmpty()) {
                        Alert BrakDanych = new Alert(Alert.AlertType.ERROR, "Nie Mozna usunąć nieistniejącej tabeli!", ButtonType.OK);
                        BrakDanych.setTitle("Błąd");
                        BrakDanych.show();
                    } else {
                        UzytkownikFunkcje.UsunUzytkownika(id);
                        int rozmiar = UzytkownikFunkcje.WyszukajUzytkownikow().size();
                        UzytkownikFunkcje.ZaktualizujId(id, rozmiar);
                    }
                } else {
                    id = 1;
                }

            } else {
                Alert BrakDanych = new Alert(Alert.AlertType.ERROR, "Brak użytkowników w tabeli!", ButtonType.OK);
                BrakDanych.setTitle("Błąd");
                BrakDanych.show();
            }

        }
    }

    @FXML
    public void Uaktualnij() {
        String id = Id.getText();
        if (id.isEmpty()) {
            Alert BrakDanych = new Alert(Alert.AlertType.ERROR, "Nie Mozna zaktualizować nieistniejącej tabeli!", ButtonType.OK);
            BrakDanych.setTitle("Błąd");
            BrakDanych.show();
        } else {
            noweDane.setVisible(true);
            Potwierdz.setVisible(true);
            WyszukajPrzycisk.setVisible(false);
            UsuńPrzycisk.setVisible(false);
            UaktualnijPrzycisk.setVisible(false);
            wyszukajWszystkichPrzycisk.setVisible(false);
            PanelPotwierdzenia.setVisible(true);
            PanelZarzadzania.setVisible(false);
            Id.setVisible(false);
            LabelId.setVisible(false);
        }
    }

    @FXML
    public void Anuluj() {
        noweDane.setVisible(false);
        Potwierdz.setVisible(false);
        WyszukajPrzycisk.setVisible(true);
        UsuńPrzycisk.setVisible(true);
        UaktualnijPrzycisk.setVisible(true);
        wyszukajWszystkichPrzycisk.setVisible(true);
        PanelPotwierdzenia.setVisible(false);
        PanelZarzadzania.setVisible(true);
        Id.setVisible(true);
        LabelId.setVisible(true);
    }
}


