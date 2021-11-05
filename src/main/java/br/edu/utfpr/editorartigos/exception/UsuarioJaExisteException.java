package br.edu.utfpr.editorartigos.exception;

public class UsuarioJaExisteException extends Exception {

    private final String message;

    public UsuarioJaExisteException(String message) {
        this.message = message;
    }
}
