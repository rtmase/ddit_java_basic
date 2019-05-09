package bmp.view;

import java.util.HashMap;

import org.apache.log4j.Logger;

import bmp.application.Main;
import bmp.service.IOwnerService;
import bmp.service.IUserService;
import bmp.service.OwnerServiceImpl;
import bmp.service.UserServiceImpl;
import bmp.util.Session;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MainViewController{
	
	@FXML
	private TextField idField;
	
	@FXML
	private TextField pwField;
	
	@FXML 
	private Button btnsign;
	
	@FXML 
	private Button btnLogin;
	
	private Main main;
	private IUserService uService = UserServiceImpl.getInstance();
	private IOwnerService oService = OwnerServiceImpl.getInstance();
	private Session session = Session.getInstance();
	private static Logger logger = Logger.getLogger(MainViewController.class);

	
    @FXML
    public void handleSignUp() {
    	main.showHowToSignUp();
    }
    
    @FXML
	public void initialize() {	}
	
	public void setMain(Main main) {
        this.main = main;
	}
	
	/**
	 * 사용자가 아이디와 비밀번호를 입력하고 클릭시 접속하는 메서드
	 * 
	 * @author LDH
	 */
	@FXML 
	public void Join() {
		logger.info("Join... ");
		HashMap<String, String> idPwd = new HashMap<String, String>();
		idPwd.put("user_id", idField.getText());
		idPwd.put("user_pwd", pwField.getText());
		
//		String errorMessage = "";
//
//        if (idField.getText() == null || idField.getText().length() == 0) {
//            errorMessage += "아이디를 입력해주세요\n";
//        }
//        if (pwField.getText() == null || pwField.getText().length() == 0) {
//            errorMessage += "비밀번호을 입력해주세요\n";
//        }
//        if (errorMessage.length() != 0) {
//        	Alert alert = new Alert(AlertType.ERROR);
////            alert.initOwner(signdialogStage);
//            alert.setTitle("아이디 / 비밀번호 확인");
//            alert.setHeaderText("아이디와 비밀번호를 입력해주세요.");
//            alert.setContentText(errorMessage);
//            alert.showAndWait();
//        } 
		
		idField.clear();
		pwField.clear();
		
		if (uService.joinUser(idPwd) != null) {
			session.setLoginUser(uService.joinUser(idPwd));
			switch (session.getLoginUser().getGrade()) {
			case "일반회원": case "VIP": case "VVIP":
				// 사용자로 로그인할때 보여줄 view
				main.showUserView();
				break;
			case "관리자":
				// 관리자로 로그인할때 보여줄 view
//				main.showAdminView();
				break;
			default:
				break;
			}
		}
		if (oService.joinOwner(idPwd) != null) {
			session.setLoginOwner(oService.joinOwner(idPwd));
			// 사업자로 로그인할때 보여줄 view
			main.showOwnerView();
		} else {

		}
	}
	
	/**
	 * 엔터키를 누르면 로그인하게 하는 메서드
	 * 
	 * @param event
	 * @author LDH
	 */
	@FXML 
	public void setEnter(KeyEvent event) {
		
		pwField.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {	
				if(event.getCode().equals(KeyCode.ENTER)) {
					Join();
				}
			};
		});
	}

}
