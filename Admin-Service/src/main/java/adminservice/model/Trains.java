package adminservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="traindb")
public class Trains {

	@Id
	private String trainid;
	private String trainName;
	private String startStation;
	private String endStation;
	private int fare;

public Trains() {
	
}


public Trains(String trainid, String trainName, String startStation, String endStation,int fare) {
	super();
	this.trainid = trainid;
	this.trainName = trainName;
	this.startStation = startStation;
	this.endStation = endStation;
	this.fare=fare;
}

public String getTrainid() {
	return trainid;
}

public void setTrainid(String trainid) {
	this.trainid = trainid;
}

public String getTrainName() {
	return trainName;
}

public void setTrainName(String trainName) {
	this.trainName = trainName;
}

public String getStartStation() {
	return startStation;
}

public void setStartStation(String startStation) {
	this.startStation = startStation;
}

public String getEndStation() {
	return endStation;
}

public void setEndStation(String endStation) {
	this.endStation = endStation;
}

public int getFare() {
	return fare;
}

public void setFare(int fare) {
	this.fare = fare;
}

}
