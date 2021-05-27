package kmo.optionals;

import java.util.List;

public class OptionalsExample {

    public static void main(String[] args) {
        final var dtos = List.of(new Dto("A", "1"), new Dto("B", "2"), new Dto("C"), new Dto("A"));
        final var mutableValue = dtos.stream()
                .filter(dto -> dto.getMutableValue().isPresent())
                .filter(dto -> dto.getImmutableValue().equals("A"))
                .findFirst()
                .map(Dto::getMutableValue)
                .orElseThrow().map(String::toLowerCase).orElseThrow();

        final var immutableValue = dtos.stream()
                .filter(dto -> dto.getMutableValue().isPresent())
                .filter(dto -> dto.getImmutableValue().equals("A"))
                .findFirst()
                .map(Dto::getImmutableValue)
                .map(String::toLowerCase)
                .orElseThrow();

        dtos.stream()
                .filter(dto -> dto.getMutableValue().isPresent())
                .filter(dto -> dto.getImmutableValue().equals("A"))
                .findFirst()
                .ifPresent(System.out::println);

        dtos.stream()
                .filter(dto -> dto.getMutableValue().isPresent())
                .filter(dto -> dto.getImmutableValue().equals("A"))
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.err.println("oof"));

        System.out.println(mutableValue);
        System.out.println(immutableValue);
    }
}
