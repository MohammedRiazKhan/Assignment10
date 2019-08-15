package repository.demography.impl;

import domain.demography.Gender;
import repository.demography.GenderRepository;

import java.util.HashSet;
import java.util.Set;

public class GenderRepositoryImpl implements GenderRepository {

    private static GenderRepositoryImpl genderRepository = null;
    private Set<Gender> genders;

    public GenderRepositoryImpl(){

        genders = new HashSet<Gender>();

    }

    public static GenderRepositoryImpl getGenderRepository() {

        if(genderRepository == null){
            return new GenderRepositoryImpl();
        }

        return genderRepository;
    }


    @Override
    public Set<Gender> getAll(){

        return genders;

    }

    @Override
    public Gender create(Gender gender) {

        genders.add(gender);
        return gender;
    }

    @Override
    public Gender read(String id) {

        return genders.stream().filter(gender -> gender.getId() == id).findAny().orElse(null);

    }

    @Override
    public Gender update(Gender gender) {

        Gender genderToDelete = read(gender.getId());

        if(genderToDelete != null) {
            genders.remove(genderToDelete);
            return create(gender);
        }
        return null;

    }

    @Override
    public void delete(String id) {

        Gender genderToDelete = read(id);

        if(genderToDelete != null) {
            genders.remove(genderToDelete);
        }

    }

    //method which will search the set/db for the corresponding gender
    public Gender readByName(String genderDesc){
        //do the logic to get the gender
        return genders.stream().filter(gender -> gender.getDesc().equals(genderDesc)).findAny().orElse(null);
    }


}