package com.refugio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// Esta etiqueta convierte a la clase en el "traductor global" de la aplicación
@RestControllerAdvice
public class ManejadorDeErrores {

    // Le decimos que atrape específicamente los errores de validación (cuando @Valid falla)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> manejarErroresDeValidacion(MethodArgumentNotValidException ex) {

        // Creamos un diccionario vacío para guardar los errores limpios
        Map<String, String> erroresLimpios = new HashMap<>();

        // Recorremos todos los errores técnicos que mandó Spring Boot
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            // Sacamos el nombre del campo que falló (ej: "edad")
            String campo = ((FieldError) error).getField();
            // Sacamos el mensaje bonito que tú escribiste en el modelo (ej: "La edad no puede ser negativa")
            String mensaje = error.getDefaultMessage();

            // Los guardamos en nuestro diccionario
            erroresLimpios.put(campo, mensaje);
        });

        // Devolvemos el diccionario limpio
        return erroresLimpios;
    }
}
