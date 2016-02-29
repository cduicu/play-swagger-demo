package store;

import models.Pet;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by cristiand on 2/26/2016.
 */
public class Store {

    private static final Store instance = new Store();
    private static final Map<String, Pet> store = new HashMap<>();

    static {
        store.put("bill", new Pet("bill", "4", "male"));
        store.put("stacy", new Pet("stacy", "6", "female"));
        store.put("buck", new Pet("buck", "2", "male"));
        store.put("jane", new Pet("jane", "4", "female"));
    }

    public static final Store getInstance() {
        return instance;
    }

    private Store() {
    }

    public List<Pet> getPetList() {
        // return sorted list
        return store.values().stream().sorted((a, b) -> a.name.compareTo(b.name)).collect(Collectors.toList());
    }

    public Pet getByName(String name) {
        return store.get(name);
    }

    public void update(Pet pet) {
        if (getByName(pet.name) == null) {
            throw new NoSuchElementException("Pet [" + pet.name + "] not found!");
        }
        store.put(pet.name, pet);
    }

    public void put(Pet pet) {
        if (getByName(pet.name) == null) {
            throw new NoSuchElementException("Pet [" + pet.name + "] already in store!");
        }
        store.put(pet.name, pet);
    }

    public void deletePet(String name) {
        if (getByName(name) == null) {
            throw new NoSuchElementException("Pet [" + name + "] not in store!");
        }
        store.remove(name);
    }
}
