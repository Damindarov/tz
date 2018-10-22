package ch.atz.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Point_step_controller {
	private SimpleIntegerProperty Id;
	private SimpleStringProperty Step;
	private SimpleStringProperty Type;
	private SimpleStringProperty Time;
	public Point_step_controller() {
		this(0,null,null,null);
	}
	public Point_step_controller(Integer Id,String Step,String Type, String Time) {
		this.Id = new SimpleIntegerProperty(Id);
		this.Step = new SimpleStringProperty(Step);
		this.Type = new SimpleStringProperty(Type);
		this.Time = new SimpleStringProperty(Time);
	}
	
	
	public Integer getId() {
		return Id.get();
	}
	public void setId(Integer Id) {
		this.Id.set(Id);
	}
	public IntegerProperty IdProperty() {
		return Id;
	}	
	public String getStep() {
		return Step.get();
	}
	public void setStep(String Name) {
		this.Step.set(Name);
	}
	public StringProperty StepProperty() {
		return Step;
	}	
	public String getType() {
		return Type.get();
	}
	public void setType(String Type) {
		this.Type.set(Type);
	}
	public StringProperty TypeProperty() {
		return Type;
	}	

	public String getTime() {
		return Time.get();
	}
	public void setTime(String Time) {
		this.Time.set(Time);
	}
	public StringProperty TimeProperty() {
		return Time;
	}
}
