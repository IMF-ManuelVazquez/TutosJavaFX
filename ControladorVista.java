package controlador;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorVista {
	
	final String USER = "12";
	final String PASS = "123";

    @FXML
    private TextField tfUserName;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Label lblStatus;

    @FXML
    public void Login(ActionEvent event) {
    	if (tfUserName.getText().equals(USER)&&tfPassword.getText().contentEquals(PASS)) {
    		lblStatus.setText("Acceso permitido");
    		openVista2Modality();
    	}else {
    		lblStatus.setText("Acceso no permitido");
    	}
    }
    
    public void openVista2() {
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../vista/Vista2.fxml"));
			Scene scene = new Scene(root);
			Stage newStage = new Stage();
			newStage.setScene(scene);
			newStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void openVista2CloseVista() {   
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../vista/Vista2.fxml"));
			Scene scene = new Scene(root);
			Stage newStage = new Stage();
			newStage.setScene(scene);
			newStage.show();
			
			Stage old = (Stage) btnLogin.getScene().getWindow();
			old.close();   
			
			// Opcion2 mas directo: Se obtiene el "Stage" y se modifica la escena "Scene".
//			root = FXMLLoader.load(getClass().getResource("../vista/Vista2.fxml"));
//			Scene scene = new Scene(root);
//			Stage actual_stage = (Stage) btnLogin.getScene().getWindow();
//			actual_stage.setScene(scene);
//			actual_stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void openVista2CloseVistaOwner() {   // Los secundarios depende del primario.
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../vista/Vista2.fxml"));
			Scene scene = new Scene(root);
			Stage newStage = new Stage();
			
			Stage old = (Stage) btnLogin.getScene().getWindow();
			newStage.initOwner(old);
			
			newStage.setScene(scene);
			newStage.show();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    public void openVista2Modality() {  // Se bloquea el principal por lo que solo se puede utilizar la nueva ventana.
    	
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../vista/Vista2.fxml"));
			Scene scene = new Scene(root);
			Stage newStage = new Stage();
			newStage.setResizable(false);
			newStage.initModality(Modality.WINDOW_MODAL);
			
			Stage old = (Stage) btnLogin.getScene().getWindow();
			newStage.initOwner(old);
			
			newStage.setScene(scene);
			newStage.showAndWait();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
