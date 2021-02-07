package com.apploidxxx.investapp.module.tinkoff.http.api;

public interface RestClient {
    <T> T requestGet(Class<T> clazz, String path);
}
