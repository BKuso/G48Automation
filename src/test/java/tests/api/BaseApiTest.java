package tests.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Before;

public abstract class BaseApiTest {

    protected RequestSpecification rspec;
    protected ResponseSpecification respSpec;

    @Before
    public void setUp(){
        this.rspec = new RequestSpecBuilder()
                .build();
        this.respSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

}
