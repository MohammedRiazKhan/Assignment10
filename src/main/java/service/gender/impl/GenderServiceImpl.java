package service.gender.impl;

import domain.Gender;
import repository.gender.GenderRepository;
import repository.gender.impl.GenderRepositoryImpl;
import service.gender.GenderService;

import java.util.Set;

public class GenderServiceImpl implements GenderService {


    private GenderServiceImpl service = null;
    private GenderRepository repository;

    public GenderServiceImpl() {
        repository = GenderRepositoryImpl.getGenderRepository();
    }

    public GenderServiceImpl getService(){

        if(service == null){
            return new GenderServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Gender> getAll() {
        return repository.getAll();
    }

    @Override
    public Gender create(Gender gender) {
        return repository.create(gender);
    }

    @Override
    public Gender read(Integer integer) {
        return repository.read(integer);
    }

    @Override
    public Gender update(Gender gender) {
        return repository.update(gender);
    }

    @Override
    public void delete(Integer integer) {
        repository.delete(integer);
    }
}
