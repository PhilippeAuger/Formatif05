package formatif5.cell;

import formatif5.model.Personne;
import javafx.fxml.FXML;
import javafx.scene.Parent;
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
public class PersonneListCell {

	// private Personne personne = null;

	@FXML
	private TextField nomTextField;

	@FXML
	private TextField prenomTextField;

	@FXML
	private TextField ageTextField;

	private Parent cellRoot;// pour recevoir la racine du fichier FXML

	public PersonneListCell() throws IOException {

	}


	public void updateItem(Personne personne, boolean empty) {

	}

}
