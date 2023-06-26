package org.example.service;

import java.util.List;

import org.example.entity.TrackPoint;
import org.example.repository.TrackPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackPointService {
	
	@Autowired
	private TrackPointRepository trackPointRepository;

	public TrackPoint save(TrackPoint trackPoint) {
		return trackPointRepository.save(trackPoint);
	}
	
	public List<String> tracks(){
		return trackPointRepository.tracks();
	}
}
