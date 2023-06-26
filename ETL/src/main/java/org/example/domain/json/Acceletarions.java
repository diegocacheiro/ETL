package org.example.domain.json;

import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Acceletarions {
	@SerializedName("Id")
    @Expose
    private Integer Id;
    @SerializedName("X")
    @Expose
    private Double X;
    @SerializedName("Y")
    @Expose
    private Double Y;
    @SerializedName("Z")
    @Expose
    private Double Z;
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
	public Double getX() {
		return X;
	}
	public void setX(Double x) {
		X = x;
	}
	public Double getY() {
		return Y;
	}
	public void setY(Double y) {
		Y = y;
	}
	public Double getZ() {
		return Z;
	}
	public void setZ(Double z) {
		Z = z;
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
		return "Acceletarions [Id=" + Id + ", X=" + X + ", Y=" + Y + ", Z=" + Z + ", Time=" + Time + ", TravelId="
				+ TravelId + ", Travel=" + Travel + "]";
	}
	
	
}
