
package org.example.domain.json;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Car {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("year")
    @Expose
    private Integer year;
    @SerializedName("travels")
    @Expose
    private List<Object> travels;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<Object> getTravels() {
        return travels;
    }

    public void setTravels(List<Object> travels) {
        this.travels = travels;
    }

	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", model=" + model + ", year=" + year + ", travels=" + travels
				+ "]";
	}


    
}
