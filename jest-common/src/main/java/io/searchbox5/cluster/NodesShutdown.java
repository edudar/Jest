package io.searchbox5.cluster;

import io.searchbox5.action.AbstractMultiINodeActionBuilder;
import io.searchbox5.action.GenericResultAbstractAction;

/**
 * @author Dogukan Sonmez
 * @author cihat keser
 */
public class NodesShutdown extends GenericResultAbstractAction {

    protected NodesShutdown(Builder builder) {
        super(builder);
        setURI(buildURI());
    }

    @Override
    protected String buildURI() {
        return super.buildURI() + "/_nodes/" +
                nodes +
                "/_shutdown";
    }

    @Override
    public String getRestMethodName() {
        return "POST";
    }

    @Override
    public String getPathToResult() {
        return "nodes";
    }

    public static class Builder extends AbstractMultiINodeActionBuilder<NodesShutdown, Builder> {

        /**
         * By default, the shutdown will be executed after a 1 second delay (1s).
         * The delay can be customized by setting the delay parameter in a time value format.
         *
         * @param value e.g.: "1s" -> 1 second, "10m" -> 10 minutes
         */
        public Builder delay(String value) {
            return setParameter("delay", value);
        }

        @Override
        public NodesShutdown build() {
            return new NodesShutdown(this);
        }
    }
}