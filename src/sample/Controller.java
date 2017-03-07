package sample;

import javafx.fxml.FXML;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Controller {

    @FXML public TableView<Notas> notasTableView;
    @FXML public TableColumn<Notas, String> materiaTableColumn;
    @FXML public TableColumn<Notas, Double> av1TableColumn;
    @FXML public TableColumn<Notas, Double> av2TableColumn;
    @FXML public TableColumn<Notas, Double> av3TableColumn;
    @FXML public TextField materiaTextField;
    @FXML public TextField av1TextField;
    @FXML public TextField av2TextField;
    @FXML public Button adicionarButton;
    @FXML public Button excluirButton;

    // APLICAR
    @FXML public Button exportarButton;

    @FXML public void initialize() {

        materiaTableColumn.setCellValueFactory(param -> {
            return new SimpleStringProperty(param.getValue().getNomeMateria());
        });

        av1TableColumn.setCellValueFactory(param -> {
            return new SimpleObjectProperty<>(param.getValue().getAv1());
        });

        av2TableColumn.setCellValueFactory(param -> {
            return new SimpleObjectProperty<>(param.getValue().getAv2());
        });

        av3TableColumn.setCellValueFactory(param -> {
            return new SimpleObjectProperty<>(param.getValue().getAv3());
        });


    }

    @FXML public void adicionarMateria() {
        Notas notas = new Notas();

        String nome = notas.setNomeMateria(materiaTextField.getText());
        Double av1 = notas.setAv1(Double.parseDouble(av1TextField.getText()));
        Double av2 = notas.setAv2(Double.parseDouble(av2TextField.getText()));
        Double av3 = notas.setAv3((60 - (av1*3) - (av2*3)) / 4);

        double av31 = (60 - (av1 *3) - (av2 * 3)) / 4;

        notasTableView.getItems().add(notas);

        materiaTextField.clear();
        av1TextField.clear();
        av2TextField.clear();
    }

    @FXML public void excluirMateria() {

        ObservableList<Notas> notasSelected, todasNotas;
        todasNotas = notasTableView.getItems();
        notasSelected = notasTableView.getSelectionModel().getSelectedItems();

        notasSelected.forEach(todasNotas::remove);
        System.out.println("materia excluida");
    }
}
