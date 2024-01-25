package com.epam.mjc;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionService {

    public List<Integer> filterEvenNumbers(List<Integer> list) {
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        try (Stream<Integer> stream = list.stream(); Stream<Integer> evenStream = stream.filter(n -> n % 2 == 0)) {
            List<Integer> evenList = evenStream.collect(Collectors.toList());
            return evenList;
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<String> toUpperCaseCollection(List<String> list) {
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        try (Stream<String> stream = list.stream(); Stream<String> upperStream = stream.map(s -> s.toUpperCase())) {
            List<String> upperList = upperStream.collect(Collectors.toList());
            return upperList;
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public Optional<Integer> findMax(List<Integer> list) {
        try (Stream<Integer> stream = list.stream()) {
            Optional<Integer> max = stream.max(Integer::compare);
            return max;
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
            return Optional.empty();
        }
    }

    public Optional<Integer> findMin(List<List<Integer>> list) {
        try (Stream<List<Integer>> stream = list.stream(); Stream<Integer> flatStream = stream.flatMap(l -> l.stream())) {
            Optional<Integer> min = flatStream.min(Integer::compare);
            return min;
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
            return Optional.empty();
        }
    }

    public Integer sum(List<Integer> list) {
        try (Stream<Integer> stream = list.stream()) {
            Integer result = stream.reduce(0, Integer::sum, Integer::sum);
            return result;
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
            return null;
        }
    }
}

