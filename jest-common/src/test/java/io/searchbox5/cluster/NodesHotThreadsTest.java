package io.searchbox5.cluster;

import io.searchbox5.action.Action;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author cihat keser
 */
public class NodesHotThreadsTest {

    @Test
    public void testUriGenerationWithAllNodes() {
        Action action = new NodesHotThreads.Builder().build();
        assertEquals("/_nodes/_all/hot_threads", action.getURI());
    }

    @Test
    public void testUriGenerationWithSingleNode() {
        Action action = new NodesHotThreads.Builder().addNode("Pony").build();
        assertEquals("/_nodes/Pony/hot_threads", action.getURI());
    }

    @Test
    public void testUriGenerationWithSingleNodeAndParameter() {
        Action action = new NodesHotThreads.Builder().addNode("Pony").interval("100ms").build();
        assertEquals("/_nodes/Pony/hot_threads?interval=100ms", action.getURI());
    }

}
