package kr.highthon.common.api;

import lombok.Getter;

import java.util.List;

@Getter
public class ApiResponse<T> {
    private T result;
    private List<Error> errors;
    private String message;

    private ApiResponse(T result, String message) {
        this.result = result;
        this.message = message;
    }

    private ApiResponse(List<Error> errors, String message) {
        this.errors = errors;
        this.message = message;
    }


    public static <T> ApiResponse<T> success(T result) {
        return success(result, null);
    }

    public static <T> ApiResponse<T> success(T result, String message) {
        return new ApiResponse<T>(result, message);
    }

    public static <T> ApiResponse<T> failure(String message) {
        return failure(message, null);
    }

    public static <T> ApiResponse<T> failure(String message, List<Error> errors) {
        return new ApiResponse<T>(errors, message);
    }
}
