package corebanking.common.exception;

import corebanking.common.dto.ApiDTO;
import corebanking.deposit.exception.DepositException;
import corebanking.customer.exception.CustomerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
@RestController
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {
    Logger logger = Logger.getLogger(this.getClass().getName());

    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<ApiDTO> handleApiException(CustomerException ex, HttpServletRequest request) {
        return exceptionToHttpResponse(ex, HttpStatus.BAD_REQUEST,request);
    }


    @ExceptionHandler(DepositException.class)
    public ResponseEntity<ApiDTO> handleApiException(DepositException ex, HttpServletRequest request) {
        return exceptionToHttpResponse(ex, HttpStatus.BAD_REQUEST,request);
    }

    private ResponseEntity<ApiDTO> exceptionToHttpResponse(Exception ex, HttpStatus status, HttpServletRequest request){
        logger.log(Level.SEVERE,ex.getClass().getSimpleName() + " thrown with message = " + ex.getMessage() + " for service " + request.getServletPath());
        return exceptionToHttpResponse(ex, ex.getMessage(), status);
    }

    private ResponseEntity<ApiDTO> exceptionToHttpResponse(Exception ex, String message, HttpStatus status) {
        ApiDTO response = new ApiDTO(Boolean.TRUE, message, null);
        return new ResponseEntity<>(response, status);
    }
}