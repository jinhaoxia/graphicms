package com.graphicms.graphQL.dataFetcher;

import com.graphicms.util.AsyncHandler;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

import java.util.concurrent.CompletableFuture;

public interface AsyncDataFetcher<T> extends DataFetcher<CompletableFuture<T>> {

    default CompletableFuture<T> get(DataFetchingEnvironment environment) {
        AsyncHandler<T> asyncHandler = new AsyncHandler<>();
        async(environment, asyncHandler);
        return asyncHandler;
    }

    void async(DataFetchingEnvironment environment, Handler<AsyncResult<T>> handler);

}