package order.server.model;

import org.springframework.data.annotation.Id;

public class BookingOrder {

	@Id
	private String id;
	private String train;
	private String startStation;
	private String endStation;
	private String name;
	private String age;
	private String gender;
	private String creditNo;
	private String address;
	private String bankname;
	private String date;
	
	public BookingOrder(String id, String train, String startStation, String endStation, String name, String age,
			String gender, String creditNo, String address, String bankname, String date) {
		super();
		this.id = id;
		this.train = train;
		this.startStation = startStation;
		this.endStation = endStation;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.creditNo = creditNo;
		this.address = address;
		this.bankname = bankname;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTrain() {
		return train;
	}

	public void setTrain(String train) {
		this.train = train;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCreditNo() {
		return creditNo;
	}

	public void setCreditNo(String creditNo) {
		this.creditNo = creditNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
