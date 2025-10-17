package br.com.islno.anime444.anime444.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {


    public ResourceNotFoundException(String message) {
        // A palavra-chave 'super' chama o construtor da classe pai (RuntimeException)
        // e passa a mensagem de erro para ela.
        super(message);
    }
}