package com.andersen.maks.service;

import com.andersen.maks.dao.DeveloperRepository;
import com.andersen.maks.model.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeveloperServiceImpl implements DeveloperService {

    private DeveloperRepository repository;

    public DeveloperServiceImpl(){

    }

    @Override
    public Developer getDeveloperById(int id) {
        Developer developer = repository.findOne(id);
        return developer;
    }

    @Autowired
    public DeveloperServiceImpl(DeveloperRepository repository){
        super();
        this.repository = repository;
    }

    @Override
    public boolean addDeveloper(Developer developer) {
        try {
            repository.save(developer);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            repository.delete(id);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public Developer editDeveloper(Developer developer) {
        return repository.save(developer);
    }

    @Transactional
    @Override
    public List<Developer> getAll() {
        return (List<Developer>) repository.findAll();
    }
}
