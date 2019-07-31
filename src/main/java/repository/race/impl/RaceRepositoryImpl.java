package repository.race.impl;

import domain.Race;
import repository.race.RaceRepository;

import java.util.HashSet;
import java.util.Set;

public class RaceRepositoryImpl implements RaceRepository {



    private static RaceRepositoryImpl raceRepository = null;
    private Set<Race> races;


    public RaceRepositoryImpl(){
        races = new HashSet<Race>();
    }


    public static RaceRepositoryImpl getRaceRepository() {

        if(raceRepository == null){
            return new RaceRepositoryImpl();
        }

        return raceRepository;
    }


    @Override
    public Set<Race> getAll() {
        return races;
    }

    @Override
    public Race create(Race race) {
        races.add(race);
        return race;
    }

    @Override
    public Race read(Integer integer) {
        Race race = find(integer);
        return race;
    }

    @Override
    public Race update(Race race) {

        Race raceToDelete = find(race.getId());

        if(raceToDelete != null) {
            races.remove(raceToDelete);
            return create(race);
        }
        return null;
    }

    @Override
    public void delete(Integer integer) {
        Race raceToDelete = find(integer);

        if(raceToDelete != null) {
            races.remove(raceToDelete);
        }
    }

    public Race find(int id) {
        return races.stream().filter(race -> race.getId() == id).findAny().orElse(null);
    }

}
