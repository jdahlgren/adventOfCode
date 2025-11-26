package se.johannesdahlgren.adventofcode2019.util;

@FunctionalInterface
public interface CheckedFunction<T, R> {

  R apply(T t);
}
