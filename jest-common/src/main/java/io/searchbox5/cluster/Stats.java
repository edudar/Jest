package io.searchbox5.cluster;

import io.searchbox5.action.AbstractMultiINodeActionBuilder;
import io.searchbox5.action.GenericResultAbstractAction;

public class Stats extends GenericResultAbstractAction {
    protected Stats(Builder builder) {
        super(builder);
        setURI(buildURI());
    }

    @Override
    protected String buildURI() {
        return super.buildURI() + "/_cluster/stats/nodes/" + nodes;
    }

    @Override
    public String getRestMethodName() {
        return "GET";
    }

    public static class Builder extends AbstractMultiINodeActionBuilder<Stats, Builder> {
        @Override
        public Stats build() {
            return new Stats(this);
        }
    }
}
