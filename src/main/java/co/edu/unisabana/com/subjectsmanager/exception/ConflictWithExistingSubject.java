package co.edu.unisabana.com.subjectsmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ConflictWithExistingSubject extends RuntimeException {
    public ConflictWithExistingSubject() {
        super();
    }

    public ConflictWithExistingSubject(String message) {
        super(message);
    }

    public ConflictWithExistingSubject(String message, Throwable cause) {
        super(message, cause);
    }

    public ConflictWithExistingSubject(Throwable cause) {
        super(cause);
    }
}
