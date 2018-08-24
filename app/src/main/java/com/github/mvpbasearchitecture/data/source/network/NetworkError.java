package com.github.mvpbasearchitecture.data.source.network;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.HttpException;

import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_CONFLICT;
import static java.net.HttpURLConnection.HTTP_GONE;
import static java.net.HttpURLConnection.HTTP_NOT_ACCEPTABLE;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;

/**
 * Helps converting network exception to appropriate error type
 *
 * Created by gk
 */

public class NetworkError extends Throwable {
    public static final String DEFAULT_ERROR_MESSAGE = "Something went wrong! Please try again.";
    public static final String NETWORK_ERROR_MESSAGE = "No Internet Connection!";
    private static final String ERROR_MESSAGE_HEADER = "NetworkError-Message";
    private static final String BAD_REQUEST_MESSAGE = "This operation is not allowed!";
    private final Throwable error;

    public NetworkError(Throwable e) {
        super(e);
        this.error = e;
    }

    public NetworkError() {
        error = null;
    }

    public String getMessage() {
        return error.getMessage();
    }

    public boolean isRefreshTokenFailure() {
        return error instanceof HttpException &&
                ((HttpException) error).code() == HTTP_GONE;
    }

    public boolean isAcceptanceFailure() {
        return error instanceof HttpException &&
                ((HttpException) error).code() == HTTP_NOT_ACCEPTABLE;
    }

    public boolean isAuthFailure() {
        return error instanceof HttpException &&
                ((HttpException) error).code() == HTTP_UNAUTHORIZED;
    }

    public boolean isNotFound() {
        return error instanceof HttpException &&
                ((HttpException) error).code() == HTTP_NOT_FOUND;
    }

    public boolean isBadRequest() {
        return error instanceof HttpException &&
                ((HttpException) error).code() == HTTP_BAD_REQUEST;
    }

    public boolean isConflictRequest() {
        return error instanceof HttpException &&
                ((HttpException) error).code() == HTTP_CONFLICT;
    }

    public boolean isResponseNull() {
        return error instanceof HttpException && ((HttpException) error).response() == null;
    }

    public String getAppErrorMessage() {
        if (this.error instanceof IOException) return NETWORK_ERROR_MESSAGE;
        if (this.error instanceof HttpException) {
            ResponseBody body = ((HttpException) error).response().errorBody();
            if (body != null) {
                try {
                    JSONObject jObjError = new JSONObject(body.string());
                    return jObjError.getString("message");
                } catch (Exception e) {
                    e.printStackTrace();
                    return DEFAULT_ERROR_MESSAGE;
                }
            } else return DEFAULT_ERROR_MESSAGE;

        } else {
            return DEFAULT_ERROR_MESSAGE;
        }
    }

    public Throwable getError() {
        return error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NetworkError that = (NetworkError) o;

        return error != null ? error.equals(that.error) : that.error == null;

    }

    @Override
    public int hashCode() {
        return error != null ? error.hashCode() : 0;
    }
}
