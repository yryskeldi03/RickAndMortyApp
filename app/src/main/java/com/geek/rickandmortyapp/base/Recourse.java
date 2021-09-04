package com.geek.rickandmortyapp.base;

public class Recourse<T> {
    public final Status status;
    public final T data;
    public final String message;

    public Recourse(Status status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Recourse<T> success(T data) {
        return new Recourse<>(Status.SUCCESS, data, null);
    }

    public static <T> Recourse<T> error(String msg, T data) {
        return new Recourse<>(Status.ERROR, data, msg);
    }

    public static <T> Recourse<T> loading(T data) {
        return new Recourse<>(Status.LOADING, data, null);
    }

    public enum Status {SUCCESS, ERROR, LOADING}
}
