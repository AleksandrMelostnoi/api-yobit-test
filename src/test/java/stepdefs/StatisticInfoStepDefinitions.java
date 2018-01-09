package stepdefs;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertFalse;

import cucumber.api.Scenario;
import cucumber.api.java.ru.*;
import io.restassured.response.Response;
import cucumber.api.java.Before;

public class StatisticInfoStepDefinitions {
	private Response response;

	private Scenario scenario;

	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}

	@Когда("^клиент выполнит запрос GET (.*)$")
	public void getResponse(String path) throws Exception {
		response = given().when().get(path);
	}

	@То("^будет возвращён ответ со статусом (\\d+)$")
	public void verify_status_code(int statusCode){
		response.then().statusCode(statusCode);
	}

	@Также("^тип содержимого будет (.*)$")
	public void verify_type_body(String bodyType){
		response.then().contentType(bodyType);
	}

	@И("^ответ не будет содержать (.*)$")
	public void response_contains(String error){
		assertFalse(response.getBody().asString().contains(error));
	}

	@И("^ответ будет выведен в лог$")
	public void response_log(){
		scenario.write("response: " + response.prettyPrint() + "\n");
	}
}


