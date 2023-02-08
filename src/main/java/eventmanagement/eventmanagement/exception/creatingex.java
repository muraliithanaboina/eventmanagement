package eventmanagement.eventmanagement.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class creatingex {


        @Autowired
        private  Applicationerror applicationerror;
        @ExceptionHandler(value = applicationex.class)
        public ResponseEntity<Applicationerror> save(applicationex applicationex){
            applicationerror.setMess(applicationex.getEnumerror());
            applicationerror.setDescription(applicationex.getMessage());
            applicationerror.setThrowable(applicationex);
            if(applicationex.getEnumerror()==Enumerror.attendee_Not_found) {
                return new ResponseEntity<Applicationerror>(applicationerror, HttpStatus.NOT_FOUND);
            }
            else return  new ResponseEntity<Applicationerror>(applicationerror, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }


