package com.graphicms.service;

import com.graphicms.model.PO.Model;
import com.graphicms.model.PO.User;
import com.graphicms.service.impl.MongoServiceImpl;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.ext.mongo.MongoClient;

@VertxGen
@ProxyGen
public interface MongoService {

    static MongoService create(MongoClient mongoClient, Handler<AsyncResult<MongoService>> resultHandler) {
        return MongoServiceImpl.create(mongoClient, resultHandler);
    }

    static MongoService createProxy(Vertx vertx, String address) {
        return new MongoServiceVertxEBProxy(vertx, address);
    }

    void findUserByName(String name, Handler<AsyncResult<User>> resultHandler);

    void createUser(String name, String email, String password, Handler<AsyncResult<Void>> resultHandler);

    void findAllProjectsByUserId(String userId, Handler<AsyncResult<JsonArray>> resultHandler);

    void findAllProjectInfosByUserId(String userId, Handler<AsyncResult<JsonArray>> resultHandler);

    void findModelsByProjectId(String projectId, Handler<AsyncResult<JsonArray>> resultHandler);

    void insertModelsByProjectId(String projectId, Model model, Handler<AsyncResult<Void>> resultHandler);
}