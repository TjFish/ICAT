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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceException extends RuntimeException implements Serializable {
    private String msg="nothing";
    private HttpStatus status=HttpStatus.INTERNAL_SERVER_ERROR;
    private Integer errorCode=-1;
    public ServiceException(HttpStatus status){
        this.status=status;
    }
    public ServiceException(String msg, Integer errorCode){
        this.msg=msg;
        this.errorCode=errorCode;
    }
}
