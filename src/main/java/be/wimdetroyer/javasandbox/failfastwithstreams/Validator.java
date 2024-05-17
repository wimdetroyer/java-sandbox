package be.wimdetroyer.javasandbox.failfastwithstreams;

import java.util.Optional;

public interface Validator {

  Optional<Error> validate();
}
