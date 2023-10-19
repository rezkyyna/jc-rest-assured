package com.juaracoding;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.Argument;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.testng.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;



public class TestTMDB {
    String endpoint = "https://api.themoviedb.org/3/movie/now_playing";

    // validasi pada response body use json path
    @Test
    public void testgetMovieNowPlaying(){
        JSONObject request = new JSONObject();
        given()
                //.header("Authorization", "Bearer token")
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5MjhjYmZkZGMyZDczZDExYzJjMmMwODQwZDMxYmY1YyIsInN1YiI6IjY1MzA3OGI3ZWRlYjQzMDBmZTdjNWI4NiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.k5njpjJjFC_9mXdLdrIygq9NQb3iC-c72fHWvwNciSU")
                .then()
                .statusCode(200)
                .body("data.id[0]", equalTo(1));
    }

    @Test
    public void testgetMoviePopular(){
        given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5MjhjYmZkZGMyZDczZDExYzJjMmMwODQwZDMxYmY1YyIsInN1YiI6IjY1MzA3OGI3ZWRlYjQzMDBmZTdjNWI4NiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.k5njpjJjFC_9mXdLdrIygq9NQb3iC-c72fHWvwNciSU")
                .when()
                .get("https://api.themoviedb.org/3/movie/popular")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testAddMovieRating(){
        JSONObject request = new JSONObject();
        request.get(" \"value\": 8.5 ");
        System.out.println(request.toJSONString());
        given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5MjhjYmZkZGMyZDczZDExYzJjMmMwODQwZDMxYmY1YyIsInN1YiI6IjY1MzA3OGI3ZWRlYjQzMDBmZTdjNWI4NiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.k5njpjJjFC_9mXdLdrIygq9NQb3iC-c72fHWvwNciSU")
               .body(request.toJSONString())
                .when()
                .post("https://api.themoviedb.org/3/movie/238/rating")
                .then()
                .statusCode(201)
                .log().all();
    }

}
