package io.searchbox5.cluster;

import io.searchbox5.action.AbstractAction;
import io.searchbox5.action.GenericResultAbstractAction;

/**
 * Retrieve cluster wide settings.
 *
 * @author cihat keser
 */
public class GetSettings extends GenericResultAbstractAction {

    protected GetSettings(Builder builder) {
        super(builder);
        setURI(buildURI());
    }

    protected String buildURI() {
        return super.buildURI() + "/_cluster/settings";
    }

    @Override
    public String getRestMethodName() {
        return "GET";
    }

    public static class Builder extends AbstractAction.Builder<GetSettings, Builder> {

        @Override
        public GetSettings build() {
            return new GetSettings(this);
        }
    }

}
