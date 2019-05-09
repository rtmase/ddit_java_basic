package bmp.view;

import java.io.IOException;

import org.apache.log4j.Logger;

import bmp.application.Main;
import bmp.util.Session;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;

public class UserMainViewController {
	
	private static Logger logger = Logger.getLogger(UserMainViewController.class);
	private BorderPane userMainView;
	private Session session = Session.getInstance();
	private Main main = new Main();
	@FXML 
	Label headerNotice;
	
	
	public void setUserMain(BorderPane userMainView) {
        this.userMainView = userMainView;
	}
	
	@FXML
    private void initialize() {
		
//		headerNotice.setOnInputMethodTextChanged(e -> {
//			// 공지사항및 이벤트의 목록을 가져와 10초마다 공지사항의 제목을 띄운다...
//		});
		
	}
	

	@FXML 
	public void getNotice() {
		logger.info("NoticeView... ");
		
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/NoticeView.fxml"));
            AnchorPane noticeView = (AnchorPane) loader.load();
            userMainView.setCenter(noticeView);
            
            // 메인 애플리케이션이 컨트롤러를 이용할 수 있게 한다.
//            UserMainViewController controller = loader.getController();
//            controller.setMain(userMainView);

        } catch (IOException e) {
            e.printStackTrace();
            
        }
	}

	@FXML 
	public void getCategory() {
		logger.info("CategoryView... ");
		
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/CategoryView.fxml"));
            AnchorPane categoryView = (AnchorPane) loader.load();
            userMainView.setCenter(categoryView);
            
            // 메인 애플리케이션이 컨트롤러를 이용할 수 있게 한다.
//            UserMainViewController controller = loader.getController();
//            controller.setMain(userMainView);

        } catch (IOException e) {
            e.printStackTrace();
            
        }
	}

	@FXML 
	public void getCustomService() {
		logger.info("CustomerServiceView... ");
		
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/CustomerServiceView.fxml"));
            AnchorPane customService = (AnchorPane) loader.load();
            userMainView.setCenter(customService);
            
            // 메인 애플리케이션이 컨트롤러를 이용할 수 있게 한다.
//            UserMainViewController controller = loader.getController();
//            controller.setMain(userMainView);

        } catch (IOException e) {
            e.printStackTrace();
            
        }
	}

	@FXML 
	public void getMyPage() {
		logger.info("MyPageView... ");
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/MyPageView.fxml"));
            AnchorPane myPage = (AnchorPane) loader.load();
            userMainView.setCenter(myPage);
            
            // 메인 애플리케이션이 컨트롤러를 이용할 수 있게 한다.
//            UserMainViewController controller = loader.getController();
//            controller.setMain(userMainView);

        } catch (IOException e) {
            e.printStackTrace();
            
        }
	}

	@FXML 
	public void logout() {
		logger.info("logout... ");
		session.setLoginUser(null);
		// 초기화면으로 되돌아가기...
		main.initMainView();
	}

}
