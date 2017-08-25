package io.searchbox5.indices;

import io.searchbox5.action.AbstractMultiIndexActionBuilder;
import io.searchbox5.action.GenericResultAbstractAction;

import java.util.Collection;

/**
 * @author Dogukan Sonmez
 */
public class IndicesExists extends GenericResultAbstractAction {

    protected IndicesExists(Builder builder) {
        super(builder);
        setURI(buildURI());
    }

    @Override
    public String getRestMethodName() {
        return "HEAD";
    }

    public static class Builder extends AbstractMultiIndexActionBuilder<IndicesExists, Builder> {

        public Builder(String index){
            addIndex(index);
        }

        public Builder(Collection<? extends String> indices){
            addIndex(indices);
        }

        @Override
        public IndicesExists build() {
            return new IndicesExists(this);
        }
    }

}
