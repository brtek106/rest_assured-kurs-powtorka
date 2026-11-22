package pl.javastart.restassured.test.headers;

import io.restassured.http.Cookie;

import static io.restassured.RestAssured.given;

public class HeadersExample {
    public static void main(String[] args) {
        given().contentType("application/json");
        given().accept("application/json");

        given().header("Klucz", "wartość");
        given().headers("Klucz1", "wartość1", "Klucz2", "wartość2");
        given().header("Klucz1", "wartość1").header("Klucz2", "wartość2");
        given().header("klucz1", "wartość1", "wartość2");

        given().cookie("klucz", "wartość");
        given().cookie("klucz", "wartość1", "wartość2");

        Cookie someCookie = new Cookie.Builder("klucz", "wartość").setSecured(true).build();
        given().cookie(someCookie);
    }
}
