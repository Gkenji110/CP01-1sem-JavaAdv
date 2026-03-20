package br.com.fiap.exception;

public class CommitException extends RuntimeException {

    public CommitException() {
        super("Erro ao realizar o commit");
    }

    public CommitException(String message) {
        super(message);
    }
}
