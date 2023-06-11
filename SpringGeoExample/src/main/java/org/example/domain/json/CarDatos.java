package org.example.domain.json;

import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class CarDatos {

    @SerializedName("Id")
    @Expose
    private Integer Id;
    @SerializedName("Brand")
    @Expose
    private String Brand;
    @SerializedName("Model")
    @Expose
    private String Model;
    @SerializedName("Year")
    @Expose
    private Integer Year;
    @SerializedName("Travels")
    @Expose
    private List<Object> Travels;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public Integer getYear() {
		return Year;
	}
	public void setYear(Integer year) {
		Year = year;
	}
	public List<Object> getTravels() {
		return Travels;
	}
	public void setTravels(List<Object> travels) {
		Travels = travels;
	}
	@Override
	public String toString() {
		return "CarDatos [Id=" + Id + ", Brand=" + Brand + ", Model=" + Model + ", Year=" + Year + ", Travels="
				+ Travels + "]";
	}
    
}
