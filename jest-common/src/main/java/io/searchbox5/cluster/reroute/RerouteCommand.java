package io.searchbox5.cluster.reroute;

import java.util.Map;

public interface RerouteCommand {
    String getType();

    Map<String, Object> getData();
}
