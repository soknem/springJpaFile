package app.springJPA.adviser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;

@RestControllerAdvice
public class RescontrollerAdviser {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String,Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception){

        return new HashMap<String,Object>(){{
            put("errors",exception.getBindingResult().getFieldErrors().stream()
                    .map(err-> {
                        return new HashMap<String, Object>() {{
                            put(err.getField(), err.getDefaultMessage());
                        }};
                    }).toList());
        }};
    }
}
