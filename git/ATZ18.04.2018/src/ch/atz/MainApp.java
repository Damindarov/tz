package ch.atz;

import java.io.IOException;

import ch.atz.model.Point_Connect;
import ch.atz.model.Point_step;
import ch.atz.model.Point_step_controller;
import ch.atz.view.Edit_Table_Spectr_Controller;
import ch.atz.view.Edit_Table_Zond_Controller;
import ch.atz.view.controller_1_spectr;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {
	private static MainApp mainApp;
	private static Stage primaryStage;
    private BorderPane rootLayout;
    @Override
    public void start(Stage primaryStage) {
        MainApp.primaryStage = primaryStage;
        MainApp.primaryStage.setTitle("ATZond");
        initRootLayout();
        showTable_spectr();
    }
    
    public static MainApp get() {
    	if (mainApp == null) {
    		mainApp = new MainApp();
    	}
    	return mainApp;
    }
    
    public static ObservableList<Point_step> pointData = FXCollections.observableArrayList();
    public static ObservableList<Point_Connect> pointConnect = FXCollections.observableArrayList();
    public static int[][] massConnect;
    private ObservableList<Point_step_controller> pointZondData = FXCollections.observableArrayList();
    
    /**
     * Инициализирует корневой макет.
     */
    public void initRootLayout() {
        try {
            // Загружаем корневой макет из fxml файла.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            // Отображаем сцену, содержащую корневой макет.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Показывает в корневом макете сведения об точках спектрометра.
     */
    public void showTable_spectr() {
        try {
            // Загружаем UI.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/1.fxml"));
            AnchorPane Table_spectr = (AnchorPane) loader.load();
            // Помещаем сведения об точках в правый край корневого макета.
            rootLayout.setCenter(Table_spectr);
            controller_1_spectr controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Возвращает данные в виде наблюдаемого списка адресатов.
     * @return
     */
    public static ObservableList<Point_step> getPointData() {
        return pointData;
    }
    /**
     * Возвращает данные о связи таблиц в виде двумерного массива.
     * Первая строка - номер зондовой точки, каждой зондовой точке 
     * соответсвует столбец с точками спектра.
     * @return
     */
    public static int[][] getmassConect() {
        return massConnect;
    }
    /**
     * Возвращает данные в виде наблюдаемого списка адресатов.
     * @return
     */
    public ObservableList<Point_step_controller> getPointZondData() {
        return pointZondData;
    }
    /**
     * Возвращает главную сцену, испрравил на статик, EditTableZond .
     * @return
     */
    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    public static void main(String[] args) {
		launch(args);
	}
    public boolean showPointEditDialog(Point_step person) {
        try {
            // Загружаем fxml-файл и создаём новую сцену
            // для всплывающего диалогового окна.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Edit_Table_Spectr.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Создаём диалоговое окно Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Передаём адресата в контроллер.
            Edit_Table_Spectr_Controller controller = loader.getController();
            //controller.
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean showPointZondEditDialog(Point_step_controller person) {
        try {
            // Загружаем fxml-файл и создаём новую сцену
            // для всплывающего диалогового окна.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Edit_Table_Zond.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Создаём диалоговое окно Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Передаём адресата в контроллер.
            Edit_Table_Zond_Controller controller = loader.getController();
           controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            // Отображаем диалоговое окно и ждём, пока пользователь его не закроет
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
