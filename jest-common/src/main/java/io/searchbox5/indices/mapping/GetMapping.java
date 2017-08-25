package io.searchbox5.indices.mapping;

import io.searchbox5.action.AbstractMultiTypeActionBuilder;
import io.searchbox5.action.GenericResultAbstractAction;

/**
 * @author ferhat
 * @author cihat keser
 */
public class GetMapping extends GenericResultAbstractAction {

    protected GetMapping(Builder builder) {
        super(builder);
        setURI(buildURI());
    }

    @Override
    public String getRestMethodName() {
        return "GET";
    }

    @Override
    protected String buildURI() {
        return super.buildURI() + "/_mapping";
    }

    public static class Builder extends AbstractMultiTypeActionBuilder<GetMapping, Builder> {

        @Override
        public GetMapping build() {
            return new GetMapping(this);
        }
    }

}
