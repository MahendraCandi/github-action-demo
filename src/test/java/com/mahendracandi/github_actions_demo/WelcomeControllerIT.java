package com.mahendracandi.github_actions_demo;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WelcomeControllerIT {

	@LocalServerPort
	int port;

	@BeforeEach
	void setUp() {
		RestAssured.port = port;
	}

	@Test
	@DisplayName("GET /welcome should return a welcome message")
	void testWelcomeResponse() {
		RestAssured.given()
				.get("/welcome")
				.then()
				.log().all()
				.assertThat()
				.body("message", Matchers.equalTo("Welcome to Github Actions Demo!"));
	}

	@Test
	@DisplayName("GET /welcome?name=John should return a personalized welcome message")
	void testWelcomeResponseWithName() {
		RestAssured.given()
				.queryParam("name", "John")
				.get("/welcome")
				.then()
				.log().all()
				.assertThat()
				.body("message", Matchers.equalTo("Welcome to Github Actions Demo, John!"));
	}
}
