package com.project.homefinder.models.data;

import com.project.homefinder.models.Location;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import javax.transaction.Transactional;



@Repository
@Transactional
public interface LocationDao extends CrudRepository<Location, Integer> {
}
