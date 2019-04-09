package com.andersen.maks.dao;

import com.andersen.maks.model.Developer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends CrudRepository<Developer, Integer> {

}