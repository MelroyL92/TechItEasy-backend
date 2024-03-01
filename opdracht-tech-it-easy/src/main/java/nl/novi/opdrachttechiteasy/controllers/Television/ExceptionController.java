package nl.novi.opdrachttechiteasy.controllers.Television;

import nl.novi.opdrachttechiteasy.exceptions.RecordNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

    @ControllerAdvice
    public class ExceptionController {
        @ExceptionHandler(RecordNotFoundException.class)
        public ResponseEntity<String> handleRecordNotFoundException(RecordNotFoundException e) {
            System.err.println("RecordNotFoundException occurred: " + e.getMessage());
            return ResponseEntity.status(404).body("Record not found");
        }
    }
