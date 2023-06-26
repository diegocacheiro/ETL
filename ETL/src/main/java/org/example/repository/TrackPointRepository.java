package org.example.repository;

import java.util.List;

import org.example.entity.TrackPoint;
import org.example.entity.TrackPointPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackPointRepository extends CrudRepository<TrackPoint, TrackPointPK>{
	@Query("SELECT distinct(tp.trackPointPK.track) FROM TrackPoint tp") 
	public List<String> tracks();
}
