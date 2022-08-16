package co.edu.unisabana.com.subjectsmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ConflictWithExistingSubjectException extends RuntimeException {
    public ConflictWithExistingSubjectException() {
        super();
    }

    public ConflictWithExistingSubjectException(String message) {
        super(message);
    }

    public ConflictWithExistingSubjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConflictWithExistingSubjectException(Throwable cause) {
        super(cause);
    }
}
