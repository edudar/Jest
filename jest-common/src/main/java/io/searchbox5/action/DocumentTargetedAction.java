package io.searchbox5.action;

import io.searchbox5.client.JestResult;

/**
 * Represents an Action that <b>can <i>(but NOT necessarily does)</i></b> operate on a targeted single document on Elasticsearch.
 *
 * @author cihat keser
 */
public interface DocumentTargetedAction<T extends JestResult> extends Action<T> {

    String getIndex();

    String getType();

    String getId();
}
