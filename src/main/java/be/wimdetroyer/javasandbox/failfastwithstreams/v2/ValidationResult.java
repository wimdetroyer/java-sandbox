package be.wimdetroyer.javasandbox.failfastwithstreams.v2;


// TODO: what if payload has the same type as the error?
public record ValidationResult<T>(T payload, Error error) {

    public static <T> ValidationResult<T> of(Error error) {
        return new ValidationResult<>(null, error);
    }

    public static <T> ValidationResult<T> of(T payload) {
        return new ValidationResult<>(payload, null);
    }

    public boolean isOk() {
        return error == null;
    }
}
