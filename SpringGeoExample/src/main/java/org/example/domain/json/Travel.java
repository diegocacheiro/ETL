
package org.example.domain.json;

import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Travel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("roadQuality")
    @Expose
    private String roadQuality;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("roadType")
    @Expose
    private Boolean roadType;
    @SerializedName("bumpType")
    @Expose
    private Boolean bumpType;
    @SerializedName("carId")
    @Expose
    private Integer carId;
    @SerializedName("car")
    @Expose
    private Car car;
    @SerializedName("acceletarions")
    @Expose
    private List<Acceletarions> acceletarions;
    @SerializedName("locations")
    @Expose
    private List<Locations> locations;
    @SerializedName("bumps")
    @Expose
    private List<Bumps> bumps;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoadQuality() {
        return roadQuality;
    }

    public void setRoadQuality(String roadQuality) {
        this.roadQuality = roadQuality;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getRoadType() {
        return roadType;
    }

    public void setRoadType(Boolean roadType) {
        this.roadType = roadType;
    }

    public Boolean getBumpType() {
        return bumpType;
    }

    public void setBumpType(Boolean bumpType) {
        this.bumpType = bumpType;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Acceletarions> getAcceletarions() {
        return acceletarions;
    }

    public void setAcceletarions(List<Acceletarions> acceletarions) {
        this.acceletarions = acceletarions;
    }

    public List<Locations> getLocations() {
        return locations;
    }

    public void setLocations(List<Locations> locations) {
        this.locations = locations;
    }

    public List<Bumps> getBumps() {
        return bumps;
    }

    public void setBumps(List<Bumps> bumps) {
        this.bumps = bumps;
    }

	@Override
	public String toString() {
		return "Travel [id=" + id + ", roadQuality=" + roadQuality + ", date=" + date + ", roadType=" + roadType
				+ ", bumpType=" + bumpType + ", carId=" + carId + ", car=" + car + ", acceletarions=" + acceletarions
				+ ", locations=" + locations + ", bumps=" + bumps + "]";
	}

}
