package ch.atz.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Point_Connect {
public static ObservableList<Point_step> pointData = FXCollections.observableArrayList();//STASTIC change
private SimpleStringProperty name;
public Point_Connect() {
	this(null,pointData);
}
public Point_Connect(String name,ObservableList<Point_step> pointData) {
	this.name = new SimpleStringProperty(name);
	Point_Connect.pointData = pointData;
}
public String getName(){
	return name.get();
}
public void setName(String name) {
	this.name.set(name);
}
public StringProperty NameProperty(){
	return name;
}
/**
 * Возвращает данные в виде наблюдаемого списка адресатов.
 * @return
 */
public ObservableList<Point_step> getPointData() {
    return pointData;
}
public void setPointData(ObservableList<Point_step> pointData) {
     Point_Connect.pointData.setAll(pointData);
}

}
