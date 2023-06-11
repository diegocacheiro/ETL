package org.example.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Measure implements Serializable{

	private Timestamp time;
	private Double va;
	private Integer bm;
}
