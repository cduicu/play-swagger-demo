package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Pet;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import store.Store;
import utils.PetUtils;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by cristiand on 2/27/2016.
 */
public class StoreController extends Controller {

    public static Result pet(String name) {
        if (name == null || name.isEmpty()) {
            return badRequest("Please provide a name");
        }
        Pet pet = Store.getInstance().getByName(name);
        if (pet == null) {
            return notFound("Pet [" + name + "] not found");
        }
        return ok(Json.toJson(pet)).as(PetUtils.APPLICATION_JSON);
    }

    public static Result petList() {
        List<Pet> list = Store.getInstance().getPetList();
        return ok(Json.toJson(list)).as(PetUtils.APPLICATION_JSON);
    }

    public static Result updatePet() {
        try {
            JsonNode petJson = request().body().asJson();
            Pet pet = Json.fromJson(petJson, Pet.class);
            Store.getInstance().update(pet);
        } catch (NoSuchElementException e) {
            return notFound(e.getMessage());
        } catch (Exception e) {
            return badRequest("Cannot deserialize the body!");
        }
        return ok(PetUtils.resultOk()).as(PetUtils.APPLICATION_JSON);
    }

    public static Result putPet() {
        try {
            JsonNode petJson = request().body().asJson();
            Pet pet = Json.fromJson(petJson, Pet.class);
            Store.getInstance().put(pet);
        } catch (NoSuchElementException e) {
            return internalServerError(e.getMessage());
        } catch (Exception e) {
            return badRequest("Cannot deserialize the body!");
        }
        return ok(PetUtils.resultOk()).as(PetUtils.APPLICATION_JSON);
    }

    public static Result deletePet(String name) {
        try {
            Store.getInstance().deletePet(name);
        } catch (NoSuchElementException e) {
            return notFound(e.getMessage());
        }
        return ok(PetUtils.resultOk()).as(PetUtils.APPLICATION_JSON);
    }
}
