package formatif5.cell;

import formatif5.Controller;
import formatif5.model.Personne;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * La cellule custom est un contrôleur javaFX et une cellule de liste. Elle
 * utilise un fichier FXML
 * 
 * @author martin
 *
 */
//Une cellule de personne qui est aussi le contrôleur du fichier FXML
public class PersonneListCell extends ListCell<Personne> {

	// private Personne personne = null;

	@FXML
	private TextField nomTextField;

	@FXML
	private TextField prenomTextField;

	@FXML
	private TextField ageTextField;

	private Parent cellRoot;// pour recevoir la racine du fichier FXML

	public PersonneListCell() {
		super();
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../personne2.fxml"));
		try {
			loader.setController(this);
			loader.load();
			cellRoot = loader.getRoot();
			setEditable(false);
		} catch (IOException e) {
			System.out.println("erreur de fichier");
		}
	}

@Override
	public void updateItem(Personne personne, boolean empty) {
		super.updateItem(personne, empty);
		if (personne != null && !empty) {
			nomTextField.setText(personne.getNom());
			prenomTextField.setText(personne.getPrenom());
			ageTextField.setText(Integer.toString(personne.getAge()));

			setItem(personne);
			setGraphic(cellRoot);
		} else {
			setItem(null);
			setGraphic(null);
		}
	}

}
