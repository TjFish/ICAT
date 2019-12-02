package ICAT.common.handler;

import ICAT.common.exception.ServiceException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author: OY
 * @date: 19:27 2019/12/1
 */
@ControllerAdvice(basePackages = {"ICAT"})
public class GlobalDefultExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseEntity<String> serviceExcepitonHandler(ServiceException e) {
        String body=String.format("Error: %d\nMsg: %s",e.getErrorCode(),e.getMsg());
        return new ResponseEntity<>(body,e.getStatus());
    }
}
