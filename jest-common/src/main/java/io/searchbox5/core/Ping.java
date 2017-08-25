package io.searchbox5.core;

import io.searchbox5.action.GenericResultAbstractAction;

public class Ping extends GenericResultAbstractAction {
    protected Ping(Builder builder) {
        super(builder);
        setURI(buildURI());
    }

    @Override
    protected String buildURI() {
        return super.buildURI();
    }

    @Override
    public String getRestMethodName() {
        return "GET";
    }

    public static class Builder extends GenericResultAbstractAction.Builder<Ping, Builder> {
        public Ping build() {
            return new Ping(this);
        }
    }
}
