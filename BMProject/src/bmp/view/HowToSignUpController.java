package bmp.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class HowToSignUpController {

	private Stage dialogStage;
	private boolean okClicked = false;
	@FXML 
	Button btnUser;
	
	@FXML 
	Button btnOwner;
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
    @FXML
    private void initialize() {    }
	
	public boolean isOkClicked() {
		
		return okClicked;
	}
	
	public void userSign() {
		showUserSignUpView();
	}
	
	/**
	 * 사용자 회원가입 클릭시 보여주는 화면메서드
	 * 
	 * @author LDH
	 */
	private void showUserSignUpView() {
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("UserSignUpView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage SigndialogStage = new Stage();
            SigndialogStage.setTitle("유저 회원가입");
            SigndialogStage.initModality(Modality.WINDOW_MODAL);
            SigndialogStage.initOwner(dialogStage);
            Scene scene = new Scene(page);
            SigndialogStage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("../application/application.css").toString());
            
            UserSignUpViewController controller = loader.getController();
            controller.setSignDialogStage(SigndialogStage);

            SigndialogStage.showAndWait();
            dialogStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void ownerSign() {
		showOwnerSignUpView();
	}
	
	/**
	 * 사업자 회원가입 클릭시 보여주는 화면 메서드
	 * 
	 * @author LDH
	 */
	private void showOwnerSignUpView() {
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("OwnerSignUpView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage SigndialogStage = new Stage();
            SigndialogStage.setTitle("사업자 회원가입");
            SigndialogStage.initModality(Modality.WINDOW_MODAL);
            SigndialogStage.initOwner(dialogStage);
            Scene scene = new Scene(page);
            SigndialogStage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("../application/application.css").toString());
            
            OwnerSignUpViewController controller = loader.getController();
            controller.setSignDialogStage(SigndialogStage);

            SigndialogStage.showAndWait();
            dialogStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
}
