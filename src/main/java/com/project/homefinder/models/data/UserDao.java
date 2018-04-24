package com.project.homefinder.models.data;

import com.project.homefinder.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional

public interface UserDao extends CrudRepository<User, Integer> {
    User findByName(String name);
    boolean existsByName(String name);

    //User findOne(int userId);
}