package org.example.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.example.domain.Measure;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.locationtech.jts.geom.Geometry;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.Data;
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Entity
@Table(name="track_points")
@Data
public class TrackPoint {

	@EmbeddedId
	private TrackPointPK trackPointPK;
	@Column(name = "point_geo")
	private Geometry point;
	@Column(name = "speed")
	private Double speed;
	@Column(name = "elevation")
	private Double elevation;
	@Column(name = "start_time")
	private Timestamp  startTime;
	@Column(name = "end_time")
	private Timestamp  endTime;
	@Type(type = "jsonb")
	@Column(name = "measures")
	private List<Measure> measures;
	
	public TrackPoint() {
		super();
	}
	
	public TrackPoint(TrackPointPK trackPointPK, Geometry point, Double speed, Double elevation, Timestamp startTime,
			Timestamp endTime, List<Measure> measures) {
		super();
		this.trackPointPK = trackPointPK;
		this.point = point;
		this.speed = speed;
		this.elevation = elevation;
		this.startTime = startTime;
		this.endTime = endTime;
		this.measures = measures;
	}
	
}
