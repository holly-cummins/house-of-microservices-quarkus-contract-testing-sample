package sample.house;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import io.quarkus.test.junit.QuarkusTest;

import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.loader.PactFolder;

@Provider("House")
@PactFolder("pacts")
@QuarkusTest // This starts the server on port 8081 for convenience in testing
public class HouseContractTest {

	@BeforeEach
	void before(PactVerificationContext context) {
		context.setTarget(new HttpTestTarget("localhost", 8081));
	}

	@TestTemplate
	@ExtendWith(PactVerificationInvocationContextProvider.class)
	void pactVerificationTestTemplate(PactVerificationContext context) {
		context.verifyInteraction();
	}

}
