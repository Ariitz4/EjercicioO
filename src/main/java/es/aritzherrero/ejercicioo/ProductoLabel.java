package es.aritzherrero.ejercicioo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.IOException;

/**
 * Clase para mostrar información de un producto en un diseño tipo GridPane.
 *
 * Permite mostrar el nombre, una imagen y el stock del producto.
 * El estilo del stock cambia según la cantidad:
 * - Verde: más de 100.
 * - Azul: entre 21 y 100.
 * - Rojo: 20 o menos.
 */
public class ProductoLabel extends GridPane {

    @FXML
    protected Label nombreProductoLabel;

    @FXML
    protected Label stockProductoLabel;

    @FXML
    private ImageView imagenProductoImageView;

    /**
     * Carga la interfaz desde un archivo FXML y configura el controlador.
     *
     * Si ocurre un error al cargar el archivo FXML, lanza una excepción.
     */
    public ProductoLabel() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/es/aritzherrero/ejercicioo/ProductoLabel.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * Cambia el stock del producto y ajusta el estilo según la cantidad.
     *
     * @param cantidad nueva cantidad de stock.
     */
    public void setStock(double cantidad) {
        String style;
        if (cantidad > 100) {
            style = "verde"; // Stock alto
        } else if (cantidad > 20) {
            style = "azul"; // Stock medio
        } else {
            style = "rojo"; // Stock bajo
        }
        stockProductoLabel.setText(cantidad + "");
        this.getStyleClass().clear();
        this.getStyleClass().add(style);
    }

    /**
     * Cambia la imagen del producto.
     *
     * @param imagen nueva imagen del producto.
     */
    public void setImage(Image imagen) {
        imagenProductoImageView.setImage(imagen);
    }

    /**
     * Cambia el nombre del producto.
     *
     * @param nombre nuevo nombre del producto.
     */
    public void setName(String nombre) {
        nombreProductoLabel.setText(nombre);
    }
}
