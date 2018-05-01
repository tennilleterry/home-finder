package com.project.homefinder.models.data;

import com.project.homefinder.models.Client;
import com.project.homefinder.models.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ClientDao extends CrudRepository<Client, Integer> {
}
