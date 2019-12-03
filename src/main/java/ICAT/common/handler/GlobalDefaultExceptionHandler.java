package ICAT.common.handler;

import ICAT.common.exception.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author: OY
 * @date: 19:27 2019/12/1
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseEntity<String> serviceExceptionHandler(ServiceException e) {
        String body = String.format("Msg: %s", e.getMsg());
        return new ResponseEntity<>(body, e.getStatus());
    }
}
