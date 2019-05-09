package bmp.view;

import java.lang.reflect.InvocationTargetException;

import bmp.service.IOwnerService;
import bmp.service.IUserService;
import bmp.service.OwnerServiceImpl;
import bmp.service.UserServiceImpl;
import bmp.vo.UserVO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserSignUpViewController {
	

	@FXML 
	private TextField txtId;
	@FXML 
	private PasswordField txtPwd;
	@FXML 
	private PasswordField txtPwd2;
	@FXML 
	private TextField txtName;
	@FXML 
	private TextField txtTel;
	@FXML 
	private TextField txtAddr1;
	@FXML 
	private TextField txtAddr2;
	
	private Stage signdialogStage;
	
	private boolean okClicked = false;
	
	private IUserService uService = UserServiceImpl.getInstance();
	
	private IOwnerService oService = OwnerServiceImpl.getInstance();
	
	/**
	 * 상위 컨트롤러에서 signdialogStage 를 받아오는 메서드
	 * @param signdialogStage
	 */
	public void setSignDialogStage(Stage signdialogStage) {
    	this.signdialogStage = signdialogStage;
    }
	
	@FXML
    private void initialize() {    }
	
	/**
     * 회원가입을 클릭시 실행되는 메서드
     */
    @SuppressWarnings("null")
	@FXML
    private void handleOk() {
    	UserVO newUser = null;
    	if (isInputValid()) {
    		newUser.setId(txtId.getText());
    		newUser.setPw(txtPwd.getText());
    		newUser.setName(txtName.getText());
    		newUser.setTel(txtTel.getText());
    		newUser.setAddr1(txtAddr1.getText());
    		newUser.setAddr2(txtAddr2.getText());
    		newUser.setGrade(1);
    		newUser.setPoint(0);
    		
    		uService.insertUser(newUser);
            okClicked = true;
            
            txtId.clear();
            txtPwd.clear();
            txtName.clear();
            txtTel.clear();
            txtAddr1.clear();
            txtAddr2.clear();
            
            signdialogStage.close();
        }
    }

    /**
     * 취소를 클릭시 회원가입 창이 닫히는 메서드
     */
    @FXML
    private void handleCancel() {
    	signdialogStage.close();
    }
    
    /**
     * 아이디 중복 확인하는 메서드
     */
    @FXML 
	public void checkingId() {
    	boolean checkedUser = false;
    	boolean checkedOwner = false;
    	String id = null;
    	
    	if (txtId.getText() == null || txtId.getText().length() == 0) {
    		Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(signdialogStage);
            alert.setTitle("아이디 확인");
            alert.setHeaderText("아이디를 입력하지않았거나 공백입니다.");

            alert.showAndWait();
    		return;
        }
    	
    	id = txtId.getText();
    	checkedUser = uService.checkUserId(id);
		checkedOwner = oService.checkOwnerId(id);
		Alert alert;
    	if ((checkedUser || checkedOwner) == false) {
    		alert = new Alert(AlertType.ERROR);
            alert.initOwner(signdialogStage);
            alert.setTitle("존재하는 아이디");
            alert.setHeaderText("이미 존재하는 아이디입니다.");
            alert.setContentText("사용중인 아이디입니다.\n다른 아이디를 입력해주세요.");

            alert.showAndWait();
		}else {
			alert = new Alert(AlertType.INFORMATION);
            alert.initOwner(signdialogStage);
            alert.setTitle("사용가능한 아이디");
            alert.setHeaderText("사용가능한 아이디입니다.");

            alert.showAndWait();
		}
    }

	/**
     * 텍스트 필드로 사용자 입력을 검사한다.
     *
     * @return 유효성을 만족시 true 반환
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (txtId.getText() == null || txtId.getText().length() == 0) {
            errorMessage += "아이디를 입력해주세요\n";
        }
        if (txtPwd.getText() == null || txtPwd.getText().length() == 0) {
            errorMessage += "비밀번호을 입력해주세요\n";
        }
        if (txtPwd2.getText() == null || txtPwd2.getText().length() == 0) {
            errorMessage += "비밀번호 확인을 입력해주세요\n";
        }
        if (!txtPwd.getText().equals(txtPwd2.getText())) {
			errorMessage += "비밀번호가 같지 않습니다\n";
		}
        if (txtName.getText() == null || txtName.getText().length() == 0) {
            errorMessage += "이름을 입력해주세요\n";
        }
        if (txtTel.getText() == null || txtTel.getText().length() == 0) {
            errorMessage += "전화번호를 입력해주세요\n";
        } else {
            try {
                Integer.parseInt(txtTel.getText());
            } catch (NumberFormatException e) {
                errorMessage += "숫자만 입력해주세요\n";
            }
        }
        if (txtAddr1.getText() == null || txtAddr1.getText().length() == 0) {
            errorMessage += "주소를 입력해주세요\n";
        }
        if (txtAddr2.getText() == null || txtAddr2.getText().length() == 0) {
            errorMessage += "상세 주소를 입력해주세요\n";
        } 

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // 오류 메시지를 보여준다.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(signdialogStage);
            alert.setTitle("잘못된 필드");
            alert.setHeaderText("잘못된 필드를 수정하십시오.");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

}
