package formatif5;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import formatif5.cell.PersonneListCell;
import formatif5.model.Personne;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

public class Controller implements Initializable {

    @FXML
    private TableView<Personne> tableView;

    @FXML
    private TableColumn<Personne, String> nomColumn;

    @FXML
    private TableColumn<Personne, String> prenomColumn;

    @FXML
    private TableColumn<Personne, Integer> ageColumn;

    @FXML
    private ListView<Personne> personneList;

    // L'interface Initilizable est une alternative à la méthode @FXML initialize()
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createTableView();
        createListView();

    }

    @FXML
    void ajoute(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("personne.fxml"));
        Personne personne;
        try {
            Parent root = loader.load();

            TextField nomTextField = (TextField) loader.getNamespace().get("nomTextField");
            TextField prenomTextField = (TextField) loader.getNamespace().get("prenomTextField");
            TextField ageTextField = (TextField) loader.getNamespace().get("ageTextField");

            Alert alerte  = new Alert(Alert.AlertType.CONFIRMATION);
            alerte.getDialogPane().setContent(root);
            alerte.showAndWait();

            personne = new Personne(Integer.parseInt(ageTextField.getText()), nomTextField.getText(), prenomTextField.getText());

            tableView.getItems().add(personne);
            personneList.getItems().add(personne);
        } catch (Exception e) {
            System.out.println("erreur de fichier");
        }
    }

    @FXML
    void efface(ActionEvent event) {
        Personne personne = tableView.getSelectionModel().getSelectedItem();

        tableView.getItems().remove(personne);
    }

    @FXML
    void modifie(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("personne.fxml"));
        try {
            GridPane root = loader.load();
            Personne personne = tableView.getSelectionModel().getSelectedItem();
            int index = tableView.getSelectionModel().getSelectedIndex();

            TextField nomTextField = (TextField) loader.getNamespace().get("nomTextField");
            nomTextField.setText(personne.getNom());
            TextField prenomTextField = (TextField) loader.getNamespace().get("prenomTextField");
            prenomTextField.setText(personne.getPrenom());
            TextField ageTextField = (TextField) loader.getNamespace().get("ageTextField");
            ageTextField.setText(Integer.toString(personne.getAge()));

            Alert alerte  = new Alert(Alert.AlertType.CONFIRMATION);
            alerte.getDialogPane().setContent(root);
            alerte.showAndWait();

            Personne personne1 = new Personne(Integer.parseInt(ageTextField.getText()), nomTextField.getText(), prenomTextField.getText());

            tableView.getItems().set(index, personne1);
            
        } catch (Exception e) {
            System.out.println("erreur de fichier");
        }

    }

    public void createTableView() {
        // TableColumn<Personne, String> nomColumn = (TableColumn<Personne, String>)
        // tableView.getColumns().get(0);// nom


        // Conversion de l'objet à la colonne
        nomColumn.setCellValueFactory(new PropertyValueFactory<Personne, String>("nom"));
        prenomColumn.setCellValueFactory(new PropertyValueFactory<Personne, String>("prenom"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<Personne, Integer>("age"));

        // On ajoute 3 personne par défaut
        tableView.getItems().add(new Personne(16, "nom", "prenom"));
        tableView.getItems().add(new Personne(40, "bhbh", "adfnjiqlaBVDK"));
        tableView.getItems().add(new Personne(500, "cassé", "poignet"));


    }

    private void createListView() {
        // on règle la fabrique de cellules.
        personneList.setCellFactory(new Callback<ListView<Personne>, ListCell<Personne>>() {
            @Override
            public ListCell<Personne> call(ListView<Personne> param) {
                return new PersonneListCell();
            }
        });

    }

}
