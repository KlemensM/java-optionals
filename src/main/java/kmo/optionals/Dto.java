package kmo.optionals;

import java.util.Optional;

public class Dto {

    private final String immutableValue;
    private String mutableValue;

    public Dto(final String immutableValue) {
        this(immutableValue, null);
    }

    public Dto(final String immutableValue, final String mutableValue) {
        this.immutableValue = Optional.ofNullable(immutableValue).orElseThrow(IllegalArgumentException::new);
        this.mutableValue = mutableValue;
    }

    public String getImmutableValue() {
        return immutableValue;
    }

    public void setMutableValue(final String mutableValue) {
        this.mutableValue = mutableValue;
    }

    public Optional<String> getMutableValue() {
        return Optional.ofNullable(mutableValue);
    }
}
