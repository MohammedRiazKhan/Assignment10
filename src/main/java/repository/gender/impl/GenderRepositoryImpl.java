package repository.gender.impl;

import domain.Gender;
import repository.gender.GenderRepository;

import java.util.HashSet;
import java.util.Set;

public class GenderRepositoryImpl implements GenderRepository {




    private static GenderRepositoryImpl genderRepository = null;
    private Set<Gender> genders;


    private GenderRepositoryImpl(){
        genders = new HashSet<Gender>();
    }


    public static GenderRepositoryImpl getGenderRepository() {

        if(genderRepository == null){
            return new GenderRepositoryImpl();
        }

        return genderRepository;
    }


    @Override
    public Set<Gender> getAll() {
        return genders;
    }

    @Override
    public Gender create(Gender gender) {

        genders.add(gender);
        return gender;
    }

    @Override
    public Gender read(Integer integer) {

        Gender gender = find(integer);
        return gender;

    }

    @Override
    public Gender update(Gender gender) {

        Gender genderToDelete = find(gender.getId());

        if(genderToDelete != null) {
            genders.remove(genderToDelete);
            return create(gender);
        }
        return null;

    }

    @Override
    public void delete(Integer integer) {

        Gender genderToDelete = find(integer);

        if(genderToDelete != null) {
            genders.remove(genderToDelete);
        }

    }

    public Gender find(int id) {
        return genders.stream().filter(gender -> gender.getId() == id).findAny().orElse(null);
    }

}
