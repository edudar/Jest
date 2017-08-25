package io.searchbox5.cluster;

import io.searchbox5.action.Action;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author cihat keser
 */
public class NodesStatsTest {

    @Test
    public void testUriGeneration() throws Exception {
        Action action = new NodesStats.Builder()
                .build();
        assertEquals("/_nodes/_all/stats", action.getURI());
    }

    @Test
    public void testUriGenerationWithSingleNode() throws Exception {
        Action action = new NodesStats.Builder()
                .addNode("james")
                .withOs()
                .withJvm()
                .build();
        assertEquals("/_nodes/james/stats/os,jvm", action.getURI());
    }

}
