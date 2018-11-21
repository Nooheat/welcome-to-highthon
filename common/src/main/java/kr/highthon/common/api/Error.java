package kr.highthon.common.api;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class Error {
    private String fieldName;
    private String message;

    public Error(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }
}
