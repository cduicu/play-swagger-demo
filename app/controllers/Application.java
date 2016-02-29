package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import java.util.Date;

public class Application extends Controller {

    public static Result apiDocs() {
        return redirect("/apidocs/index.html?url=/assets/pet.yaml");
    }

    public static Result apiDocs2() {
        return redirect("/apidocs/index.html?url=/assets/pet2.yaml");
    }

    public static Result index() {
        return ok("Server is up! Request time: " + new Date().toString());
    }

}
