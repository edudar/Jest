package io.searchbox5.client;

/**
 * @author Dogukan Sonmez
 */

public interface JestResultHandler<T> {

    void completed(T result);

    void failed(Exception ex);


}

