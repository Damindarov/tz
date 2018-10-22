package ch.atz.view;

import ch.atz.model.Point_step;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Edit_Table_Spectr_Controller {
	@FXML
    private TextField StepField;
	@FXML
    private TextField NameField;
    @FXML
    private TextField TempField;
    @FXML
    private TextField HoldField;
    @FXML
    private TextField TimeField;
    @FXML
    private TextField RampField;
    
    private Stage dialogStage;
    private Point_step point_step;
    private boolean okClicked = false;
    
    /**
     * �������������� �����-����������. ���� ����� ���������� �������������
     * ����� ����, ��� fxml-���� ����� ��������.
     */
    @FXML
    private void initialize() {
    	
    }
    /**
     * ������������� ����� ��� ����� ����.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    /**
     * ����� ��������, ���������� � ������� ����� ������.
     * 
     * @param person
     */
    public void setPerson(Point_step point_step) {
        this.point_step = point_step;
        
        StepField.setText(point_step.getStep());
        NameField.setText(point_step.getName());
        TempField.setText(point_step.getTemp());
        HoldField.setText(point_step.getHold());
        TimeField.setText(point_step.getTime());
        RampField.setText(point_step.getRamp());
        
    }
    /**
     * Returns true, ���� ������������ ������� OK, � ������ ������ false.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }
    /**
     * ����������, ����� ������������ ������� �� ������ OK.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
        	point_step.setStep(StepField.getText());	
        	point_step.setName(NameField.getText());
        	point_step.setTemp(TempField.getText());
        	point_step.setHold(HoldField.getText());
        	point_step.setTime(TimeField.getText());	
        	point_step.setRamp(RampField.getText());
        	okClicked = true;
            dialogStage.close();
        }
    }
    /**
     * ����������, ����� ������������ ������� �� ������ Cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    /**
     * ��������� ���������������� ���� � ��������� �����.
     * 
     * @return true, ���� ���������������� ���� ���������
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (NameField.getText() == null || NameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n"; 
        }
        if (TempField.getText() == null || TempField.getText().length() == 0) {
            errorMessage += "No valid postal code!\n"; 
        } else {
            // �������� ������������� �������� ��� � int.
            try {
                Integer.parseInt(TempField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid postal code (must be an integer)!\n"; 
            }
        }
        if (HoldField.getText() == null || HoldField.getText().length() == 0) {
            errorMessage += "No valid postal code!\n"; 
        } else {
            // �������� ������������� �������� ��� � int.
            try {
                Integer.parseInt(HoldField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid postal code (must be an integer)!\n"; 
            }
        }


        if (errorMessage.length() == 0) {
            return true;
        } else {
            // ���������� ��������� �� ������.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}	

