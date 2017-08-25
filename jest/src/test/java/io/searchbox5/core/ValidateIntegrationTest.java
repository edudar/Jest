package io.searchbox5.core;

import io.searchbox5.action.Action;
import io.searchbox5.client.JestResult;
import io.searchbox5.common.AbstractIntegrationTest;
import io.searchbox5.params.Parameters;
import org.elasticsearch.test.ESIntegTestCase;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Dogukan Sonmez
 */
@ESIntegTestCase.ClusterScope(scope = ESIntegTestCase.Scope.SUITE, numDataNodes = 1)
public class ValidateIntegrationTest extends AbstractIntegrationTest {

    @Before
    public void setup() {
        createIndex("twitter");
    }

    @Test
    public void validateQueryWithIndex() throws IOException {
        Validate validate = new Validate.Builder("{\n" +
                "  \"query\" : {\n" +
                "    \"bool\" : {\n" +
                "      \"must\" : {\n" +
                "        \"query_string\" : {\n" +
                "          \"query\" : \"*:*\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"filter\" : {\n" +
                "        \"term\" : { \"user\" : \"kimchy\" }\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}")
                .index("twitter")
                .setParameter(Parameters.EXPLAIN, true)
                .build();
        executeTestCase(validate);
    }

    @Test
    public void validateQueryWithIndexAndType() throws IOException {
        executeTestCase(new Validate.Builder("{\n" +
                "  \"query\" : {\n" +
                "    \"bool\" : {\n" +
                "      \"must\" : {\n" +
                "        \"query_string\" : {\n" +
                "          \"query\" : \"*:*\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"filter\" : {\n" +
                "        \"term\" : { \"user\" : \"kimchy\" }\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}").index("twitter").type("tweet").build());
    }

    private void executeTestCase(Action action) throws RuntimeException, IOException {
        JestResult result = client.execute(action);
        assertTrue(result.getErrorMessage(), result.isSucceeded());
        assertTrue((Boolean) result.getValue("valid"));
    }
}
