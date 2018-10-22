package ch.atz.view;



import ch.atz.MainApp;
import ch.atz.model.Point_Connect;
import ch.atz.model.Point_step;
import ch.atz.model.Point_step_controller;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Edit_Table_Zond_Controller {
	// ������ �� ������� ����������.
    private static MainApp mainApp;
    public int size = 0;
    private controller_1_spectr c2;
	@FXML
    public Label StepField;
	@FXML
	private ComboBox<String> Typebox = new ComboBox<String>();
    @FXML
    private TextField TimeField;
    public ObservableList<Point_step> pointData;
    public ObservableList<Point_Connect> pointConnect;
    public ObservableList<Point_step> pointStepConnect;
    
    private Stage dialogStage;
    private Point_step_controller point_step;
    private boolean okClicked = false;
    @FXML
    private TableView<Point_step> Table_Spectr;//����� ��� 'S_' ������ ������� ����������� � ������� ������
    	@FXML
    	private TableColumn<Point_step, Boolean> S_ON_Column;
    	@FXML
    	private TableColumn<Point_step, String> S_Step_Column;
    	@FXML
    	private TableColumn<Point_step, String> S_Name_Column;
    	@FXML
    	private TableColumn<Point_step, String> S_Temp_Column;
    	@FXML
    	private TableColumn<Point_step, String> S_Hold_Column;
    	@FXML
    	private TableColumn<Point_step, String> S_Time_Column;
    	@FXML
    	private TableColumn<Point_step, String> S_Ramp_Column;
    
    	public Edit_Table_Zond_Controller() {
      	}
    /**
     * �������������� �����-����������. ���� ����� ���������� �������������
     * ����� ����, ��� fxml-���� ����� ��������.
     */
    @FXML
    private void initialize() {
    	pointData = mainApp.getPointData();
    	Typebox.getItems().addAll(
    		    "Drop",
    		    "Catch",
    		    "Initial"
    		);
    	S_ON_Column.setCellValueFactory(cellData -> cellData.getValue().OnProperty());
    	S_Step_Column.setCellValueFactory(cellData -> cellData.getValue().StepProperty());
   	 	S_Name_Column.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
   	 	S_Temp_Column.setCellValueFactory(cellData -> cellData.getValue().TempProperty());
   	 	S_Hold_Column.setCellValueFactory(cellData -> cellData.getValue().HoldProperty());
   	 	S_Time_Column.setCellValueFactory(cellData -> cellData.getValue().TimeProperty());
   	 	S_Ramp_Column.setCellValueFactory(cellData -> cellData.getValue().RampProperty());
   	 	Table_Spectr.setItems(pointData);
   	 	
   	 	//������� ��������� ������, � ��� ��������� ����������
        // �������������� ���������� �� ��������.
   	 	Table_Spectr.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    
    }
    /**
     * ��������� ��� ��������� ����, ��������� ����������� � �����.
     * ���� ��������� ����� = null, �� ��� ��������� ���� ���������.
     * 
     * @param point_step � ����� ���� point_step ��� null
     */
    private void showPersonDetails(Point_step point_step) {
        if (point_step != null) {
        	}
    }
    public void setSizeController( int size) {
    	this.size = size;
    }
    /**
     * ������������� ����� ��� ����� ����.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    public void setPerson(Point_step_controller point_step) {
        this.point_step = point_step;
        //point_step.setId(size + 1);
        StepField.setText(point_step.getStep());
        Typebox.setPromptText(point_step.getType());
        TimeField.setText(point_step.getTime());   
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
    private void handlePlus() {
    	Point_step selectedPerson = Table_Spectr.getSelectionModel().getSelectedItem();
    	pointData = Table_Spectr.getItems();
    	if (selectedPerson != null) {
    		
        	
        } else {
            // ������ �� �������.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(MainApp.getPrimaryStage());
            alert.setTitle("Error");
            alert.setHeaderText("");
            alert.setContentText("");
            alert.showAndWait();
        }
    }
    /**
     * ����������, ����� ������������ ������� �� ������ OK.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
        	point_step.setId(size+1);
        	point_step.setStep(StepField.getText());	
        	point_step.setType(Typebox.getValue());
        	point_step.setTime(TimeField.getText());
        	okClicked = true;
            dialogStage.close();
        }
    }
    public void setSize(int size) {
    	this.size = size;
    	}
    /**
     * ����������, ����� ������������ ������� �� ������ Cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
   /* ��������� ���������������� ���� � ��������� �����.
    * 
    * @return true, ���� ���������������� ���� ���������
    */
   private boolean isInputValid() {
       String errorMessage = "";



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
