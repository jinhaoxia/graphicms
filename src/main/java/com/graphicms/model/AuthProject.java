package com.graphicms.model;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class AuthProject {
    private String _id;
    private String auth;

    public AuthProject(JsonObject jsonObject) {
        this._id = jsonObject.getString("_id");
        this.auth = jsonObject.getString("auth");
    }

    public JsonObject toJson() {
        return new JsonObject().put("_id", _id).put("auth", auth);
    }

    public AuthProject() {
    }

    public AuthProject(String _id, String auth) {
        this._id = _id;
        this.auth = auth;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "AuthProject{" +
                "_id='" + _id + '\'' +
                ", auth='" + auth + '\'' +
                '}';
    }
}