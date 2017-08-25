package io.searchbox5.indices.script;

import io.searchbox5.client.JestResult;
import io.searchbox5.common.AbstractIntegrationTest;
import org.elasticsearch.action.admin.cluster.storedscripts.GetStoredScriptResponse;
import org.elasticsearch.test.ESIntegTestCase;
import org.junit.Test;

import java.io.IOException;

import static io.searchbox5.indices.script.ScriptLanguage.PAINLESS;

@ESIntegTestCase.ClusterScope(scope = ESIntegTestCase.Scope.TEST, numDataNodes = 1)
public class CreateIndexedScriptIntegrationTest extends AbstractIntegrationTest {

    @Test
    public void createAnIndexedScript() throws IOException {
        String name = "script-test";
        String script = "int aVariable = 1; return aVariable";

        CreateStoredScript createIndexedScript = new CreateStoredScript.Builder(name)
                .setLanguage(PAINLESS)
                .setSource(script)
                .build();
        JestResult result = client.execute(createIndexedScript);
        assertTrue(result.getErrorMessage(), result.isSucceeded());

        GetStoredScriptResponse getIndexedScriptResponse =
                client().admin().cluster().prepareGetStoredScript()
                        .setLang("painless")
                        .setId(name).get();
        assertNotNull(getIndexedScriptResponse.getSource());
        assertEquals(script, getIndexedScriptResponse.getSource().getCode());
    }
}

