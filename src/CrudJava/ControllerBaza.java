package CrudJava;

import CrudJava.Tabele.Adres;
import CrudJava.Tabele.AdresFunkcje;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import CrudJava.Tabele.Uzytkownik;
import CrudJava.Tabele.UzytkownikFunkcje;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private TextField Miasto;
    @FXML
    private TextField Ulica;
    @FXML
    private TextField NumerDomu;
    @FXML
    private TextField KodPocztowy;
    @FXML
    private TextField idOsoby;
    @FXML
    private TextField Uimie;
    @FXML
    private TextField Unazwisko;
    @FXML
    private TextField UEmail;
    @FXML
    private TextField Utelefon;
    @FXML
    private TextField UDataUrodzenia;
    @FXML
    private TextField UMiasto;
    @FXML
    private TextField UUlica;
    @FXML
    private TextField UNumerDomu;
    @FXML
    private TextField UKodPocztowy;
    @FXML
    private Button Anuluj;
    @FXML
    private Button dodajUzytkownika;
    @FXML
    private Button dodajAdres;
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
    private TableView TabelaOsoba;
    @FXML
    private TableView TabelaAdres;
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
    private TableColumn<Adres, String> idTabela1Adres;
    @FXML
    private TableColumn<Adres, String> MiastoTabela;
    @FXML
    private TableColumn<Adres, String> UlicaTabela;
    @FXML
    private TableColumn<Adres, String> NumerDomuTabela;
    @FXML
    private TableColumn<Adres, String> KodPocztowyTabela;
    @FXML
    private TableColumn<Adres, String> idOsobaIdTabela;
    @FXML
    private ToolBar noweDane;
    @FXML
    private ToolBar noweDane1;
    @FXML
    private ToolBar PanelZarzadzania;
    @FXML
    private ToolBar PanelPotwierdzenia;
    @FXML
    private Label LabelId;
    @FXML
    private MenuItem Osoba;
    @FXML
    private MenuItem Adres;
    @FXML
    private VBox OsobaInfo;
    @FXML
    private VBox OsobaText;
    @FXML
    private VBox AdresInfo;
    @FXML
    private VBox AdresText;
    private Integer idUzytkownik = 1;
    private Integer idAdres = 1;
    private Object NullPointerException;

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
        Unazwisko.setDisable(true);
        UEmail.setDisable(true);
        Utelefon.setDisable(true);
        UDataUrodzenia.setDisable(true);
        dodajUzytkownika.setDisable(true);
        PanelPotwierdzenia.setVisible(false);
        Potwierdz.setDisable(true);

        idTabela.setCellValueFactory(cellDara -> cellDara.getValue().idProperty());
        ImieTabela.setCellValueFactory(cellData -> cellData.getValue().imieProperty());
        NazwiskoTabela.setCellValueFactory(cellData -> cellData.getValue().nazwiskoProperty());
        EmailTabela.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        TelefonTabela.setCellValueFactory(cellData -> cellData.getValue().telefonProperty());
        DataUrodzeniaTabela.setCellValueFactory(cellData -> cellData.getValue().dataUrodzeniaProperty());

        idTabela1Adres.setCellValueFactory(cellDara -> cellDara.getValue().idAdresProperty());
        MiastoTabela.setCellValueFactory(cellData -> cellData.getValue().miastoProperty());
        UlicaTabela.setCellValueFactory(cellData -> cellData.getValue().ulicaProperty());
        NumerDomuTabela.setCellValueFactory(cellData -> cellData.getValue().numerDomuProperty());
        KodPocztowyTabela.setCellValueFactory(cellData -> cellData.getValue().kodPocztowyProperty());
        idOsobaIdTabela.setCellValueFactory(cellData -> cellData.getValue().idOsobaProperty());
    }

    @FXML
    public void WpisywanieDanychDoDodawaniaUzytkownika() {
        String textImie = Imie.getText();
        String textNazwisko = Nazwisko.getText();
        String textEmail = Email.getText();
        String textTelefon = Telefon.getText();
        String textDataurodzenia = DataUrodzenia.getText();
        boolean imiePoprawnosc = textImie.isEmpty() | textImie.trim().isEmpty();
        Walidacja(Imie);
        Walidacja(Nazwisko);
        Walidacja(Telefon);
        boolean nazwiskoPoprawnosc = textNazwisko.isEmpty() | textNazwisko.trim().isEmpty();
        boolean emailPoprawnosc = textEmail.isEmpty() | textEmail.trim().isEmpty();
        boolean telefonPoprawnosc = textTelefon.isEmpty() | textTelefon.trim().isEmpty();
        boolean DataUrodzzeniaPoprawnosc = textDataurodzenia.isEmpty() | textDataurodzenia.trim().isEmpty();
        Nazwisko.setDisable(imiePoprawnosc);
        Email.setDisable(nazwiskoPoprawnosc);
        Telefon.setDisable(emailPoprawnosc);
        DataUrodzenia.setDisable(telefonPoprawnosc);
        dodajUzytkownika.setDisable(DataUrodzzeniaPoprawnosc);
        SwitchField();
    }

    @FXML
    public void WpisywanieDanychDoDodawaniaAdresu() {
        String textMiasto = Miasto.getText();
        String textUlica = Ulica.getText();
        String textNumerDomu = NumerDomu.getText();
        String textKodPocztowy = KodPocztowy.getText();
        String textidOsoba = idOsoby.getText();
        boolean miastoPoprawnosc = textMiasto.isEmpty() | textMiasto.trim().isEmpty();
        Walidacja(idOsoby);
        boolean ulicaPoprawnosc = textUlica.isEmpty() | textUlica.trim().isEmpty();
        boolean numerDomuPoprawnosc = textNumerDomu.isEmpty() | textNumerDomu.trim().isEmpty();
        boolean KodPocztowyPoprawnosc = textKodPocztowy.isEmpty() | textKodPocztowy.trim().isEmpty();
        boolean idOsobyPoprawnosc = textidOsoba.isEmpty() | textidOsoba.trim().isEmpty();
        Ulica.setDisable(miastoPoprawnosc);
        NumerDomu.setDisable(ulicaPoprawnosc);
        KodPocztowy.setDisable(numerDomuPoprawnosc);
        idOsoby.setDisable(KodPocztowyPoprawnosc);
        dodajAdres.setDisable(idOsobyPoprawnosc);
//        SwitchField();
    }

    @FXML
    void Walidacja(TextField textField) {
        if (textField == Imie || textField == Nazwisko) {
            TextFormatter<String> formatSlow = new TextFormatter<String>(change -> {
                change.setText(change.getText().replaceFirst("^[^A-Za-z]+$", ""));
                return change;
            });
            textField.setTextFormatter(formatSlow);
        } else if (textField == Telefon || textField == idOsoby) {
            TextFormatter<String> formatSlow = new TextFormatter<String>(change -> {
                change.setText(change.getText().replaceFirst("^[^0-9]+$", ""));
                return change;
            });
            textField.setTextFormatter(formatSlow);
        }
    }

    @FXML
    void DuzeLitery(TextField textField) {
        String duze = textField.getText();
        textField.setText(duze.substring(0, 1).toUpperCase() + duze.substring(1));
    }

    @FXML
    public void SwitchField() {
        Imie.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                Nazwisko.requestFocus();
                DuzeLitery(Imie);
            }
        });
        Imie.focusedProperty().addListener((arg, stary, zmien) -> {
            if (!zmien) {
                DuzeLitery(Imie);
            }
        });
        Nazwisko.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                Email.requestFocus();
                DuzeLitery(Nazwisko);
            }
        });
        Nazwisko.focusedProperty().addListener((arg, stary, zmien) -> {
            if (!zmien) {
                DuzeLitery(Nazwisko);
            }
        });

        Email.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                Telefon.requestFocus();
            }
        });
        Email.focusedProperty().addListener((arg, stary, zmien) -> {
            if (!zmien) {
                String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
                Pattern pattern;
                Matcher matcher;
                pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
                matcher = pattern.matcher(Email.getText());
                if (!matcher.matches()) {
                    Email.requestFocus();
                    Email.setStyle("-fx-text-fill: red");
                } else {
                    Email.setStyle("-fx-text-fill: green");
                }
            }
        });
        Telefon.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                DataUrodzenia.requestFocus();
            }
        });
        Telefon.focusedProperty().addListener((arg, stary, zmien) -> {
            if (!zmien) {
                String TELEFON_REGEX = "\\(?([0-9]{3})\\)?([ .-]?)([0-9]{3})\\2([0-9]{3})";
                Pattern pattern;
                Matcher matcher;
                pattern = Pattern.compile(TELEFON_REGEX, Pattern.CASE_INSENSITIVE);
                matcher = pattern.matcher(Telefon.getText());
                if (!matcher.matches()) {
                    Telefon.requestFocus();
                    Telefon.setStyle("-fx-text-fill: red");
                } else {
                    Telefon.setStyle("-fx-text-fill: green");
                }
            }
        });
        DataUrodzenia.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                dodajUzytkownika.requestFocus();
            }
        });
    }

    @FXML
    public void WpisywanieDanychDoDzialania() {

        Id.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                WyszukajPrzycisk.requestFocus();
            }
        });
    }

    @FXML
    public void WpisywanieDanychDoUaktualnianiaUzytkownika() {
        String id = Id.getText();
        String textImie = Uimie.getText();
        String textNazwisko = Unazwisko.getText();
        String textEmail = UEmail.getText();
        String textTelefon = Utelefon.getText();
        String textDataurodzenia = UDataUrodzenia.getText();

        boolean imiePoprawnosc = textImie.isEmpty() | textImie.trim().isEmpty();
        boolean nazwiskoPoprawnosc = textNazwisko.isEmpty() | textNazwisko.trim().isEmpty();
        boolean emailPoprawnosc = textEmail.isEmpty() | textEmail.trim().isEmpty();
        boolean telefonPoprawnosc = textTelefon.isEmpty() | textTelefon.trim().isEmpty();
        boolean DataUrodzzeniaPoprawnosc = textDataurodzenia.isEmpty() | textDataurodzenia.trim().isEmpty();
        Unazwisko.setDisable(imiePoprawnosc);
        UEmail.setDisable(nazwiskoPoprawnosc);
        Utelefon.setDisable(emailPoprawnosc);
        UDataUrodzenia.setDisable(telefonPoprawnosc);
        Potwierdz.setDisable(DataUrodzzeniaPoprawnosc);

    }

    @FXML
    public void WpisywanieDanychDoUaktualnianiaAdresu() {
        String textMiasto = UMiasto.getText();
        String textUlica = UUlica.getText();
        String textNumerDomu = UNumerDomu.getText();
        String textKodPocztowy = UKodPocztowy.getText();

        boolean miastoPoprawnosc = textMiasto.isEmpty() | textMiasto.trim().isEmpty();
        Walidacja(idOsoby);
        boolean ulicaPoprawnosc = textUlica.isEmpty() | textUlica.trim().isEmpty();
        boolean numerDomuPoprawnosc = textNumerDomu.isEmpty() | textNumerDomu.trim().isEmpty();
        boolean KodPocztowyPoprawnosc = textKodPocztowy.isEmpty() | textKodPocztowy.trim().isEmpty();
        UUlica.setDisable(miastoPoprawnosc);
        UNumerDomu.setDisable(ulicaPoprawnosc);
        UKodPocztowy.setDisable(numerDomuPoprawnosc);
        Potwierdz.setDisable(KodPocztowyPoprawnosc);

    }

    @FXML
    public void DodajUzytkownika(ActionEvent actionEvent) {
        if (idUzytkownik == 1 && UzytkownikFunkcje.WyszukajUzytkownikow().size() == 0) {
            UzytkownikFunkcje.DodajUzytkownika(idUzytkownik++, Imie.getText(), Nazwisko.getText(), Email.getText(), Telefon.getText(), DataUrodzenia.getText());

        } else {
            idUzytkownik = UzytkownikFunkcje.WyszukajUzytkownikow().size() + 1;
            UzytkownikFunkcje.DodajUzytkownika(idUzytkownik++, Imie.getText(), Nazwisko.getText(), Email.getText(), Telefon.getText(), DataUrodzenia.getText());
        }
        WyswietlWszystkich();
        Imie.deleteText(0, Imie.getText().length());
        Nazwisko.deleteText(0, Nazwisko.getText().length());
        Email.deleteText(0, Email.getText().length());
        Telefon.deleteText(0, Telefon.getText().length());
        DataUrodzenia.deleteText(0, DataUrodzenia.getText().length());
        WpisywanieDanychDoDodawaniaUzytkownika();
        Imie.requestFocus();
    }

    @FXML
    public void DodajAdres(ActionEvent actionEvent) {
        if (idAdres == 1 && AdresFunkcje.WyszukajUzytkownikow().size() == 0) {
            AdresFunkcje.DodajUzytkownika(idAdres++, Miasto.getText(), Ulica.getText(), NumerDomu.getText(), KodPocztowy.getText(), Integer.parseInt(idOsoby.getText()));

        } else {
            idAdres = AdresFunkcje.WyszukajUzytkownikow().size() + 1;
            AdresFunkcje.DodajUzytkownika(idAdres++, Miasto.getText(), Ulica.getText(), NumerDomu.getText(), KodPocztowy.getText(), Integer.parseInt(idOsoby.getText()));
        }
        WyswietlWszystkich();
        Miasto.deleteText(0, Miasto.getText().length());
        Ulica.deleteText(0, Ulica.getText().length());
        NumerDomu.deleteText(0, NumerDomu.getText().length());
        KodPocztowy.deleteText(0, KodPocztowy.getText().length());
        idOsoby.deleteText(0, idOsoby.getText().length());
        WpisywanieDanychDoDodawaniaAdresu();
        Miasto.requestFocus();
    }

    @FXML
    public void WyswietlWszystkich() {
        if (TabelaAdres.isVisible()) {
            ObservableList<CrudJava.Tabele.Adres> dane = AdresFunkcje.WyszukajUzytkownikow();
            TabelaAdres.setItems(dane);

        } else {
            ObservableList<Uzytkownik> dane = UzytkownikFunkcje.WyszukajUzytkownikow();
            TabelaOsoba.setItems(dane);
        }
    }

    @FXML
    public void Wyszukaj() {
        String id = Id.getText();
        if (id.isEmpty()) {
            Alert BrakDanych = new Alert(Alert.AlertType.ERROR, "Wpisz Id!", ButtonType.OK);
            BrakDanych.setTitle("Błąd");
            BrakDanych.show();
            UaktualnijPrzycisk.setDisable(true);
            UsuńPrzycisk.setDisable(true);
        } else {
            if (TabelaAdres.isVisible()) {
                ObservableList<Adres> dane = AdresFunkcje.WyszukajUzytkownika(id);
                if (dane.size() == 1) {
                    UaktualnijPrzycisk.setDisable(false);
                    UsuńPrzycisk.setDisable(false);
                } else {
                    UaktualnijPrzycisk.setDisable(true);
                    UsuńPrzycisk.setDisable(true);
                    Alert BrakDanych = new Alert(Alert.AlertType.ERROR, "Brak adresu o ID równym " + id, ButtonType.OK);
                    BrakDanych.setTitle("Błąd");
                    BrakDanych.show();
                }
                TabelaAdres.setItems(dane);
            } else {
                ObservableList<Uzytkownik> dane = UzytkownikFunkcje.WyszukajUzytkownika(id);
                if (dane.size() == 1) {
                    UaktualnijPrzycisk.setDisable(false);
                    UsuńPrzycisk.setDisable(false);
                } else {
                    UaktualnijPrzycisk.setDisable(true);
                    UsuńPrzycisk.setDisable(true);
                    Alert BrakDanych = new Alert(Alert.AlertType.ERROR, "Brak Użytkownika o ID równym " + id, ButtonType.OK);
                    BrakDanych.setTitle("Błąd");
                    BrakDanych.show();
                }
                TabelaOsoba.setItems(dane);
            }
        }
    }

    @FXML
    public void Usun(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Czy chcesz usunąć użytkownika o idUzytkownik = " + Id.getText(), ButtonType.YES, ButtonType.NO);
        alert.setTitle("Ostrzeżenie");
        alert.setHeaderText("Czy na pewno chcesz usunąć rekord?");
        Optional<ButtonType> wynik = alert.showAndWait();
        if (wynik.get() == ButtonType.YES) {
            if (TabelaAdres.isVisible()) {
                if (AdresFunkcje.WyszukajUzytkownikow().size() > 0) {
                    if (idAdres >= 1 && AdresFunkcje.WyszukajUzytkownikow().size() >= 1) {
                        idAdres--;
                        String id = Id.getText();
                        if (id.isEmpty()) {
                            Alert BrakDanych = new Alert(Alert.AlertType.ERROR, "Nie Mozna usunąć nieistniejącej tabeli!", ButtonType.OK);
                            BrakDanych.setTitle("Błąd");
                            BrakDanych.show();
                        } else {
                            AdresFunkcje.UsunUzytkownika(id);
                            int rozmiar = AdresFunkcje.WyszukajUzytkownikow().size();
                            AdresFunkcje.ZaktualizujId(id, rozmiar);
                        }
                    } else {
                        idAdres = 1;
                    }

                } else {
                    Alert BrakDanych = new Alert(Alert.AlertType.ERROR, "Brak Adresu w tabeli!", ButtonType.OK);
                    BrakDanych.setTitle("Błąd");
                    BrakDanych.show();
                }

            } else {
                if (UzytkownikFunkcje.WyszukajUzytkownikow().size() > 0) {
                    if (idUzytkownik >= 1 && UzytkownikFunkcje.WyszukajUzytkownikow().size() >= 1) {
                        idUzytkownik--;
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
                        idUzytkownik = 1;
                    }

                } else {
                    Alert BrakDanych = new Alert(Alert.AlertType.ERROR, "Brak użytkowników w tabeli!", ButtonType.OK);
                    BrakDanych.setTitle("Błąd");
                    BrakDanych.show();
                }

            }
        }
        WyswietlWszystkich();
    }

    @FXML
    public void Uaktualnij() {
        String id = Id.getText();
        if (TabelaAdres.isVisible()) {
            if (id.isEmpty()) {
                Alert BrakDanych = new Alert(Alert.AlertType.ERROR, "Nie Mozna zaktualizować nieistniejącej tabeli!", ButtonType.OK);
                BrakDanych.setTitle("Błąd");
                BrakDanych.show();
            } else {
                noweDane1.setVisible(true);
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
        } else {
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
    }

    @FXML
    public void Anuluj() {
        if (TabelaAdres.isVisible()) {
            noweDane1.setVisible(false);
            Potwierdz.setVisible(false);
            WyszukajPrzycisk.setVisible(true);
            UsuńPrzycisk.setVisible(true);
            UaktualnijPrzycisk.setVisible(true);
            wyszukajWszystkichPrzycisk.setVisible(true);
            PanelPotwierdzenia.setVisible(false);
            PanelZarzadzania.setVisible(true);
            Id.setVisible(true);
            LabelId.setVisible(true);
        } else {
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

    @FXML
    void ZaktualizujUzytkownika() {
        String id = Id.getText();
        String textImie = Uimie.getText();
        String textNazwisko = Unazwisko.getText();
        String textEmail = UEmail.getText();
        String textTelefon = Utelefon.getText();
        String textDataurodzenia = UDataUrodzenia.getText();
        String textMiasto = UMiasto.getText();
        String textUlica = UUlica.getText();
        String textNumerDomu = UNumerDomu.getText();
        String textKodPocztowy = UKodPocztowy.getText();

        if (TabelaAdres.isVisible()) {
            if (UMiasto == NullPointerException) {
                Alert BrakDanych = new Alert(Alert.AlertType.ERROR, "Nie wpisano miasta!", ButtonType.OK);
                BrakDanych.setTitle("Błąd");
                BrakDanych.show();
            }

            if (UUlica == NullPointerException) {
                Alert BrakDanych = new Alert(Alert.AlertType.ERROR, "Nie wpisano ulicy!", ButtonType.OK);
                BrakDanych.setTitle("Błąd");
                BrakDanych.show();
            }

            if (UNumerDomu == NullPointerException) {
                Alert BrakDanych = new Alert(Alert.AlertType.ERROR, "Nie wpisano adresu numeru domu!", ButtonType.OK);
                BrakDanych.setTitle("Błąd");
                BrakDanych.show();
            }

            if (UKodPocztowy == NullPointerException) {
                Alert BrakDanych = new Alert(Alert.AlertType.ERROR, "Nie wpisano Kodu!", ButtonType.OK);
                BrakDanych.setTitle("Błąd");
                BrakDanych.show();
            }
            if (UMiasto == NullPointerException && UUlica == NullPointerException && UNumerDomu == NullPointerException && UKodPocztowy == NullPointerException) {
                Alert BrakDanych = new Alert(Alert.AlertType.ERROR, "Nie wprowadzono danych do aktualizacji", ButtonType.OK);
                BrakDanych.setTitle("Błąd");
                BrakDanych.show();
            } else {
                AdresFunkcje.ZaktualizujUzytkownika(id, textMiasto, textUlica, textNumerDomu, textKodPocztowy);
            }
        } else {
            if (Uimie == NullPointerException) {
                Alert BrakDanych = new Alert(Alert.AlertType.ERROR, "Nie wpisano imienia!", ButtonType.OK);
                BrakDanych.setTitle("Błąd");
                BrakDanych.show();
            }

            if (Unazwisko == NullPointerException) {
                Alert BrakDanych = new Alert(Alert.AlertType.ERROR, "Nie wpisano nazwiska!", ButtonType.OK);
                BrakDanych.setTitle("Błąd");
                BrakDanych.show();
            }

            if (UEmail == NullPointerException) {
                Alert BrakDanych = new Alert(Alert.AlertType.ERROR, "Nie wpisano adresu email!", ButtonType.OK);
                BrakDanych.setTitle("Błąd");
                BrakDanych.show();
            }

            if (Utelefon == NullPointerException) {
                Alert BrakDanych = new Alert(Alert.AlertType.ERROR, "Nie wpisano Telefonu!", ButtonType.OK);
                BrakDanych.setTitle("Błąd");
                BrakDanych.show();
            }

            if (UDataUrodzenia == NullPointerException) {
                Alert BrakDanych = new Alert(Alert.AlertType.ERROR, "Nie wpisano Daty urodzenia!", ButtonType.OK);
                BrakDanych.setTitle("Błąd");
                BrakDanych.show();
            }

            if (Uimie == NullPointerException && Unazwisko == NullPointerException && UEmail == NullPointerException && Utelefon == NullPointerException && UDataUrodzenia == NullPointerException) {
                Alert BrakDanych = new Alert(Alert.AlertType.ERROR, "Nie wprowadzono danych do aktualizacji", ButtonType.OK);
                BrakDanych.setTitle("Błąd");
                BrakDanych.show();
            } else {
                UzytkownikFunkcje.ZaktualizujUzytkownika(id, textImie, textNazwisko, textEmail, textTelefon, textDataurodzenia);
            }
        }
        Anuluj();
        WyswietlWszystkich();
    }

    //----------------------------------------------------Panel--------------------------------------------------------//
    @FXML
    public void ZamknijAplikacje(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void WybierzOsoba() {
        TabelaOsoba.setVisible(true);
        OsobaInfo.setVisible(true);
        OsobaText.setVisible(true);
        AdresInfo.setVisible(false);
        TabelaAdres.setVisible(false);
        AdresText.setVisible(false);
        dodajUzytkownika.setVisible(true);
        dodajAdres.setVisible(false);
    }

    @FXML
    public void WybierzAdres() {
        TabelaOsoba.setVisible(false);
        OsobaInfo.setVisible(false);
        OsobaText.setVisible(false);
        AdresInfo.setVisible(true);
        TabelaAdres.setVisible(true);
        AdresText.setVisible(true);
        dodajUzytkownika.setVisible(false);
        dodajAdres.setVisible(true);
    }

    @FXML
    public void Informacje(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacje o Programie");
        alert.setHeaderText("To jest aplikacja CRUD z wykorzystaniem javaFX oraz sqlite");
        alert.setContentText("Po więcej informacji spytaj twórcę");
        alert.show();
    }
}


