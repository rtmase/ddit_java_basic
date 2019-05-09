package bmp.view;

import bmp.service.IOwnerService;
import bmp.service.IUserService;
import bmp.service.OwnerServiceImpl;
import bmp.service.UserServiceImpl;
import bmp.vo.OwnerVO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class OwnerSignUpViewController {
	
	@FXML 
	TextField txtId;
	
	@FXML 
	PasswordField txtPwd;
	
	@FXML 
	PasswordField txtPwd2;
	
	@FXML 
	TextField txtName;
	
	@FXML 
	TextField txtTel;
	
	@FXML 
	TextField txtCorpNum;
	
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
     * 아이디 중복 확인하는 메서드
     */
    @FXML 
	public void checkingId() {
    	boolean checkedUser = false;
    	boolean checkedOwner = false;
    	
    	checkedUser = uService.checkUserId(txtId.getText());
    	checkedOwner = oService.checkOwnerId(txtId.getText());
    	Alert alert;
    	if (!(checkedUser && checkedOwner)) {
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
     * 회원가입을 클릭시 실행되는 메서드
     */
    @SuppressWarnings("null")
	@FXML
    private void handleOk() {
    	OwnerVO newOwner = null;
    	if (isInputValid()) {
    		newOwner.setId(txtId.getText());
    		newOwner.setPw(txtPwd.getText());
    		newOwner.setName(txtName.getText());
    		newOwner.setTel(txtTel.getText());
    		newOwner.setCorpNum(Integer.parseInt(txtCorpNum.getText()));
    		newOwner.setGrade(6);
    		
    		oService.insertOwner(newOwner);
            okClicked = true;
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
