package vn.kunjava.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseData<T> {
    private final int status;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    // PUT. PATH. DELETE
    public ResponseData(int status, String message) {
        this.status = status;
        this.message = message;
    }

    // POST. GET
    public ResponseData(int status, String message, T data) {
        this.message = message;
        this.data = data;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
