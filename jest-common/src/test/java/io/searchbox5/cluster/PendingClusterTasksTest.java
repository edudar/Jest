package io.searchbox5.cluster;

import io.searchbox5.action.Action;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PendingClusterTasksTest {
    @Test
    public void testUriGeneration() {
        Action action = new PendingClusterTasks.Builder().build();
        assertEquals("/_cluster/pending_tasks", action.getURI());
    }
}
