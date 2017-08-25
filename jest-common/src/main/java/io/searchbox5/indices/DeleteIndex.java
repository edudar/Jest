package io.searchbox5.indices;

import io.searchbox5.action.GenericResultAbstractAction;

/**
 * @author Dogukan Sonmez
 * @author cihat keser
 */
public class DeleteIndex extends GenericResultAbstractAction {

    protected DeleteIndex(Builder builder) {
        super(builder);
        indexName = builder.index;
        typeName = builder.type;
        setURI(buildURI());
    }

    @Override
    public String getRestMethodName() {
        return "DELETE";
    }

    public static class Builder extends GenericResultAbstractAction.Builder<DeleteIndex, Builder> {
        private String index;
        private String type;

        public Builder(String index) {
            this.index = index;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        @Override
        public DeleteIndex build() {
            return new DeleteIndex(this);
        }
    }

}
