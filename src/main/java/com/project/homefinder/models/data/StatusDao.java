package com.project.homefinder.models.data;


import com.project.homefinder.models.Status;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import javax.transaction.Transactional;



@Repository
@Transactional
public interface StatusDao extends CrudRepository<Status, Integer> {
}
