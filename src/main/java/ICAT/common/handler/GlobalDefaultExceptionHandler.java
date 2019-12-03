package ICAT.common.handler;

import ICAT.common.exception.ServiceException;
import ICAT.common.exception.UnauthorizedException;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
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

    // 捕捉shiro的异常
    @ExceptionHandler(ShiroException.class)
    public ResponseEntity<String> handle401(ShiroException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    // 捕捉UnauthorizedException
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> handle401(UnauthorizedException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

}
