package ch.atz.view;

import ch.atz.model.Point_step;
import ch.atz.model.Point_step_controller;



import ch.atz.MainApp;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class controller_1_spectr {
	// ������ �� ������� ����������.
    private static MainApp mainApp;
    public ObservableList<Point_step> pointData;
    @FXML
    public Button New_Spectr;
    
    @FXML
    private TableView<Point_step> Table_Spectr;//����� ��� 'S_' ������ ������� ����������� � ������� ������
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
    @FXML
    public TableView<Point_step_controller> Table_Controller;//����� ��� 'C_' ������ ������� ����������� � ������� ������
    	@FXML
    	private TableColumn<Point_step_controller, String> C_Step_Column;
    	@FXML
    	private TableColumn<Point_step_controller, String> C_Type_Column;
    	@FXML
    	private TableColumn<Point_step_controller, String> C_Time_Column;
     public int getTableControllerSize() {
    	 int size = Table_Controller.getItems().size();
    	 return size;
     }
     
     /**
     * �����������.
     * ����������� ���������� ������ ������ initialize().
     */
     public controller_1_spectr() {
     }
     /**
      * ������������� ������-�����������. ���� ����� ���������� �������������
      * ����� ����, ��� fxml-���� ����� ��������.
      */
     @FXML
     private void initialize() {
    	 
    	 S_Step_Column.setCellValueFactory(cellData -> cellData.getValue().StepProperty());
    	 S_Name_Column.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
    	 S_Temp_Column.setCellValueFactory(cellData -> cellData.getValue().TempProperty());
    	 S_Hold_Column.setCellValueFactory(cellData -> cellData.getValue().HoldProperty());
    	 S_Time_Column.setCellValueFactory(cellData -> cellData.getValue().TimeProperty());
    	 S_Ramp_Column.setCellValueFactory(cellData -> cellData.getValue().RampProperty());
    	 
    	 C_Step_Column.setCellValueFactory(cellData -> cellData.getValue().StepProperty());
    	 C_Type_Column.setCellValueFactory(cellData -> cellData.getValue().TypeProperty());
    	 C_Time_Column.setCellValueFactory(cellData -> cellData.getValue().TimeProperty());
    	 
    	 // ������� ��������� ������, � ��� ��������� ����������
         // �������������� ���������� �� ��������.
    	 Table_Spectr.getSelectionModel().selectedItemProperty().addListener(
                 (observable, oldValue, newValue) -> showPersonDetails(newValue));
    	// ������� ��������� ������, � ��� ��������� ����������
         // �������������� ���������� �� ��������.
    	 Table_Controller.getSelectionModel().selectedItemProperty().addListener(
                 (observable, oldValue, newValue) -> showPersonZondDetails(newValue));
     
     }
     public int getSizeControl() {
    	 int size = Table_Controller.getItems().size();
    	 return size;
    	 //for(int i = 0; i < Table_Controller.getItems().size(); i++)
    	//	 System.out.println(Table_Controller.getItems().get(i).getId());
     }
     @FXML
     private  void handleTestButton() {
    	 for(int i = 0; i < Table_Controller.getItems().size(); i++)
    		 System.out.println(Table_Controller.getItems().get(i).getId());
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
     /**
      * ��������� ��� ��������� ����, ��������� ����������� � �����.
      * ���� ��������� ����� = null, �� ��� ��������� ���� ���������.
      * 
      * @param point_step � ����� ���� point_step ��� null
      */
     private void showPersonZondDetails(Point_step_controller point_step) {
         if (point_step != null) {
         	}
     }
     /**
      * ���������� ������� �����������, ������� ��� �� ���� ������.
      * 
      * @param mainApp
      */
     public void setMainApp(MainApp mainApp) {
         this.mainApp = mainApp;
         // ���������� � ������� ������ �� ������������ ������
         Table_Spectr.setItems(mainApp.getPointData());
         Table_Controller.setItems(mainApp.getPointZondData());
         
     }
     /**
      * ����������, ����� ������������ ������� �� ������ ��������.
      */
     @FXML
     private void handleDeletePointController() {
         int selectedIndex = Table_Spectr.getSelectionModel().getSelectedIndex();
         if (selectedIndex >= 0) {
        	 Table_Spectr.getItems().remove(selectedIndex);
        	 
        	 pointData = Table_Spectr.getItems();
        	 for(int i = 0; i < pointData.size(); i++) {
        	 	 pointData.get(i).setId(i);
         	 }
        	 Table_Spectr.setItems(pointData);
         } else {
             // ������ �� �������.
             Alert alert = new Alert(AlertType.WARNING);
             alert.setTitle("No Selection");
             //alert.setHeaderText("No Person Selected");
             //alert.setContentText("Please select a person in the table.");

             alert.showAndWait();
         }
     }
     /**
      * ����������, ����� ������������ ������� �� ������ ��������.
      */
     @FXML
     private void handleDeletePointZond() {
         int selectedIndex = Table_Controller.getSelectionModel().getSelectedIndex();
         if (selectedIndex >= 0) { 
        	 Table_Controller.getItems().remove(selectedIndex);
        	 ObservableList<Point_step_controller> pointData_local;
        	 pointData_local = Table_Controller.getItems();
        	 if(pointData_local.size() == 0) {
        		 New_Spectr.setDisable(false);
        	 }
         } else {
             // ������ �� �������.
             Alert alert = new Alert(AlertType.WARNING);
             alert.setTitle("No Selection");
             //alert.setHeaderText("No Person Selected");
             //alert.setContentText("Please select a person in the table.");

             alert.showAndWait();
         }
     }
     /**
      * ����������, ����� ������������ ������� �� ������ New...
      * ��������� ���������� ���� � �������������� ����������� �����  �����.
      */
     @FXML
     private void handleNewPointController() {
         Point_step tempPerson = new Point_step();
         boolean okClicked = mainApp.showPointEditDialog(tempPerson);
         if (okClicked) {
             mainApp.getPointData().add(tempPerson);
         }
         pointData = Table_Spectr.getItems();
    	 for(int i = 0; i < pointData.size(); i++) {
    	 	 pointData.get(i).setId(i);
     	 }
    	 Table_Spectr.setItems(pointData);
     }
     /**
      * ����������, ����� ������������ ������� �� ������ New...
      * ��������� ���������� ���� � �������������� ����������� �����  �����.
      */
     @FXML
     private void handleNewPointZond() {
         Point_step_controller tempPerson = new Point_step_controller();
         boolean okClicked = mainApp.showPointZondEditDialog(tempPerson);
         if (okClicked) {
        	 New_Spectr.setDisable(true);
             mainApp.getPointZondData().add(tempPerson);
         }
     }
     /**
      * ����������, ����� ������������ ������� �� ������ Edit...
      * ��������� ���������� ���� ��� ��������� ��������� �����
      */
     @FXML
     private void handleEditPerson() {
    	 Point_step selectedPerson = Table_Spectr.getSelectionModel().getSelectedItem();
         if (selectedPerson != null) {
             boolean okClicked = mainApp.showPointEditDialog(selectedPerson);
             if (okClicked) {
                 showPersonDetails(selectedPerson);
             }
             
         } else {
             // ������ �� �������.
             Alert alert = new Alert(AlertType.WARNING);
             alert.initOwner(mainApp.getPrimaryStage());
             alert.setTitle("Error");
             alert.setHeaderText("");
             alert.setContentText("");
             alert.showAndWait();
         }
     }
     
     /**
      * ����������, ����� ������������ ������� �� ������ Edit...
      * ��������� ���������� ���� ��� ��������� ��������� �����
      */
     @FXML
     private void handleEditPersonZond() {
    	 Point_step_controller selectedPerson = Table_Controller.getSelectionModel().getSelectedItem();
         if (selectedPerson != null) {
             boolean okClicked = mainApp.showPointZondEditDialog(selectedPerson);
             if (okClicked) {
                 showPersonZondDetails(selectedPerson);
             }

         } else {
             // ������ �� �������.
             Alert alert = new Alert(AlertType.WARNING);
             alert.initOwner(mainApp.getPrimaryStage());
             alert.setTitle("Error");
             alert.setHeaderText("");
             alert.setContentText("");
             alert.showAndWait();
         }
     }
}
