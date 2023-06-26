package org.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackPointPK implements Serializable{
	@Column(name = "track")
	private String track;
	@Column(name = "point_id")
	private Integer pointId;
	
	
}