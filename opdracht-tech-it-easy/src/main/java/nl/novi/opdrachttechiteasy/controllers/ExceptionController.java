package nl.novi.opdrachttechiteasy.controllers;


import nl.novi.opdrachttechiteasy.exceptions.RecordNotFoundException;
import nl.novi.opdrachttechiteasy.exceptions.UsernameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
    public class ExceptionController {

        @ExceptionHandler(value = RecordNotFoundException.class)
        public ResponseEntity<Object> exception(RecordNotFoundException exception) {

            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);

        }

        @ExceptionHandler(value = UsernameNotFoundException.class)
        public ResponseEntity<Object>exception(UsernameNotFoundException exception) {
            return new ResponseEntity<>("Username" + exception.getMessage(), HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(value = IndexOutOfBoundsException.class)
        public ResponseEntity<Object>exception(IndexOutOfBoundsException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }



    }

