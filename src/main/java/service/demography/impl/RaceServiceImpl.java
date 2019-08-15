package service.demography.impl;

import domain.demography.Gender;
import domain.demography.Race;
import repository.demography.RaceRepository;
import repository.demography.impl.RaceRepositoryImpl;
import service.demography.RaceService;

import java.util.Set;

public class RaceServiceImpl implements RaceService {

    private static RaceServiceImpl service = null;
    private RaceRepository repository;

    public RaceServiceImpl() {
        repository = RaceRepositoryImpl.getRaceRepository();
    }

    public static RaceServiceImpl getService(){

        if(service == null){
            return new RaceServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Race> getAll() {
        return repository.getAll();
    }

    @Override
    public Race create(Race race) {
        return repository.create(race);
    }

    @Override
    public Race read(String id) {
        return repository.read(id);
    }

    @Override
    public Race update(Race race) {
        return repository.update(race);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

    //need to implement a method which will get a race by Name
    public Race readByName(String raceDesc){
        //will query the repository/db and find the race by its name
        return null;
    }
}
