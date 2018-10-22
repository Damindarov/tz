package ch.atz.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Point_step {
	private final SimpleBooleanProperty On;
	private final SimpleIntegerProperty Id;
	private final SimpleStringProperty Step;
	private final SimpleStringProperty Name;
	private final SimpleStringProperty Ramp;
	private final SimpleStringProperty Temp;
	private final SimpleStringProperty Time;
	private final SimpleStringProperty Hold;
	public Point_step() {
		this(false,0,null,null,null,null,null,null);
	}
	public Point_step(Boolean On,Integer Id,String Step, String Name,String Ramp,String Temp,String Hold,String Time) {
		this.On = new SimpleBooleanProperty(On);
		this.Id = new SimpleIntegerProperty(Id);
		this.Step = new SimpleStringProperty(Step);
		this.Name = new SimpleStringProperty(Name);
		this.Ramp = new SimpleStringProperty(Ramp);
		this.Temp = new SimpleStringProperty(Temp);
		this.Time = new SimpleStringProperty(Time);	
		this.Hold = new SimpleStringProperty(Hold);
	}
	public Boolean getOn() {
		return On.get();
	}
	public void setOn(Boolean On) {
		this.On.set(On);
	}
	public BooleanProperty OnProperty() {
		return On;
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
	public String getTime() {
		return Time.get();
	}
	public void setTime(String Time) {
		this.Time.set(Time);
	}
	public StringProperty TimeProperty() {
		return Time;
	}
	public String getStep() {
		return Step.get();
	}
	public void setStep(String Step) {
		this.Step.set(Step);
	}
	public StringProperty StepProperty() {
		return Step;
	}
	public String getName() {
		return Name.get();
	}
	public void setName(String Name) {
		this.Name.set(Name);
	}
	public StringProperty NameProperty() {
		return Name;
	}
	
	public String getRamp() {
		return Ramp.get();
	}
	public void setRamp(String Type) {
		this.Ramp.set(Type);
	}
	public StringProperty RampProperty() {
		return Ramp;
	}

	public String getTemp() {
		return Temp.get();
	}
	public void setTemp(String Temp) {
		this.Temp.set(Temp);
	}
	public StringProperty TempProperty() {
		return Temp;
	}
	
	public String getHold() {
		return Hold.get();
	}
	public void setHold(String Hold) {
		this.Hold.set(Hold);
	}
	public StringProperty HoldProperty() {
		return Hold;
	}
	
}
