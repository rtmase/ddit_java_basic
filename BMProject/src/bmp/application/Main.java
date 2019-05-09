package bmp.application;
	
import java.io.IOException;

import org.apache.log4j.Logger;

import bmp.view.HowToSignUpController;
import bmp.view.MainViewController;
import bmp.view.UserMainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Logger logger = Logger.getLogger(Main.class);
	private Stage primaryStage;
    private BorderPane rootLayout;
	private BorderPane userMainView;
	
    public Main() {	}
    
	@Override
	public void start(Stage primaryStage) {
		logger.info("Start...");
		
        this.primaryStage = primaryStage;

        initRootLayout();
        
        initMainView();
    }

	/**
	 * 진입시 초기 화면 크기 셋팅 하는 메서드
	 * 
	 * @author LDH
	 */
	private void initRootLayout() {
		logger.info("initRootLayout... ");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            Scene scene = new Scene(rootLayout);
            // css 적용
            scene.getStylesheets().add(getClass().getResource("application.css").toString());
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	/**
	 * 메인화면인 로그인화면단을 출력하는 메서드
	 * 
	 * @author LDH
	 */
	public void initMainView() {
		logger.info("initMainView... ");
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/MainView.fxml"));
            AnchorPane MainView = (AnchorPane) loader.load();
            rootLayout.setCenter(MainView);
         
            // 메인 애플리케이션이 컨트롤러를 이용할 수 있게 한다.
            MainViewController controller = loader.getController();
            controller.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	/**
     * 회원가입을 클릭시 회원가입방법 두가지를 나타내는 화면을 띄우는 메서드
     *
     * @author LDH
     */
    public boolean showHowToSignUp() {
    	logger.info("HowToSignUp... ");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/HowToSignUp.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // 다이얼로그 스테이지를 만든다.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("회원가입 선택");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("application.css").toString());
            
            HowToSignUpController controller = loader.getController();
            controller.setDialogStage(dialogStage);

            // 다이얼로그를 보여주고 사용자가 닫을 때까지 기다린다.
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * 일반 사용자로 로그인시 띄우는 화면 메서드
     * 
     * @author LDH
     */
    public void showUserView() {
    	logger.info("UserView...");
    	try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/UserMainView.fxml"));
            userMainView = (BorderPane) loader.load();
            rootLayout.setCenter(userMainView);
            
            UserMainViewController controller = loader.getController();
            controller.setUserMain(userMainView);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    }
    
    /**
     * 사업자로 로그인시 띄우는 화면 메서드
     * 
     * @author LDH
     */
    public void showOwnerView() {
    	logger.info("OwnerView...");
    	try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/OwnerMainView.fxml"));
            userMainView = (BorderPane) loader.load();
            rootLayout.setCenter(userMainView);
            
//            OwnerMainViewController controller = loader.getController();
//            controller.setUserMain(userMainView);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 관리자로 로그인시 띄우는 화면 메서드
     * 
     * @author LDH
     */
    public void showAdminView() {
    	logger.info("AdminView...");
    }
    
	public static void main(String[] args) {
		launch(args);
	}
}
