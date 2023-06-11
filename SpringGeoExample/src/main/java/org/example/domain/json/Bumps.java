package org.example.domain.json;

import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Bumps {

	@SerializedName("Id")
	@Expose
	private Integer Id;
	@SerializedName("Latitude")
	@Expose
	private Double Latitude;
	@SerializedName("Longitude")
	@Expose
	private Double Longitude;
	@SerializedName("Altitude")
	@Expose
	private Double Altitude;
	@SerializedName("Speed")
	@Expose
	private Double Speed;
	@SerializedName("Time")
	@Expose
	private String Time;
	@SerializedName("TravelId")
	@Expose
	private Integer TravelId;
	@SerializedName("Travel")
	@Expose
	private List<Object> Travel;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Double getLatitude() {
		return Latitude;
	}
	public void setLatitude(Double latitude) {
		Latitude = latitude;
	}
	public Double getLongitude() {
		return Longitude;
	}
	public void setLongitude(Double longitude) {
		Longitude = longitude;
	}
	public Double getAltitude() {
		return Altitude;
	}
	public void setAltitude(Double altitude) {
		Altitude = altitude;
	}
	public Double getSpeed() {
		return Speed;
	}
	public void setSpeed(Double speed) {
		Speed = speed;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public Integer getTravelId() {
		return TravelId;
	}
	public void setTravelId(Integer travelId) {
		TravelId = travelId;
	}
	public List<Object> getTravel() {
		return Travel;
	}
	public void setTravel(List<Object> travel) {
		Travel = travel;
	}
	@Override
	public String toString() {
		return "Bumps [Id=" + Id + ", Latitude=" + Latitude + ", Longitude=" + Longitude + ", Altitude=" + Altitude
				+ ", Speed=" + Speed + ", Time=" + Time + ", TravelId=" + TravelId + ", Travel=" + Travel + "]";
	}
}