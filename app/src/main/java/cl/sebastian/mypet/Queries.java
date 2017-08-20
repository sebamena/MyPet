package cl.sebastian.mypet;

import java.util.ArrayList;
import java.util.List;

import cl.sebastian.mypet.models.Pet;

/**
 * Created by Sebastián Mena on 19/08/2017.
 */

public class Queries {

    public List<Pet> pendings() {

        List<Pet> pendingList = Pet.listAll(Pet.class);

        return pendingList;
    }


    public List<Pet> listall() {
        List<Pet> pets = new ArrayList<>();
        List<Pet> petsList = Pet.listAll(Pet.class);
        if (petsList != null && petsList.size() > 0) {
            pets.addAll(petsList);
        }
        return pets;
    }


    public Pet byId (long idpending) {
        Pet pending;
        pending = Pet.findById(Pet.class, idpending);
        return pending;
    }



}
