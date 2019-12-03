package ICAT.common.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author: OY
 * @date: 19:06 2019/12/1
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ServiceException extends RuntimeException implements Serializable {

    private String msg;
    private HttpStatus status;

    public ServiceException() {
        this(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ServiceException(String msg) {
        this(msg, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ServiceException(HttpStatus status) {
        this("no message", status);
    }

    public ServiceException(String msg, HttpStatus status) {
        this.msg = msg;
        this.status = status;
    }
}
