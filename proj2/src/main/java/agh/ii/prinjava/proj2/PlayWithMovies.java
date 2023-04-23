package agh.ii.prinjava.proj2;

import agh.ii.prinjava.proj2.dal.ImdbTop250;
import agh.ii.prinjava.proj2.model.Movie;

import java.util.*;
import java.util.stream.Collectors;

interface PlayWithMovies {

    /**
     * Returns the movies (only titles) directed (or co-directed) by a given director
     */
    static Set<String> ex01(String director) {
        Optional<List<Movie>> movies = ImdbTop250.movies();
        if (movies.isEmpty()) {
            return Collections.emptySet();
        }

        return movies.get().stream()
                .filter(m -> m.directors().contains(director))
                .map(Movie::title)
                .collect(Collectors.toSet());
    }

    /**
     * Returns the movies (only titles) in which an actor played
     */
    static Set<String> ex02(String actor) {
        Optional<List<Movie>> movies = ImdbTop250.movies();
        if (movies.isEmpty()) {
            return Collections.emptySet();
        }

        return movies.get().stream()
                .filter(m -> m.actors().contains(actor))
                .map(Movie::title)
                .collect(Collectors.toSet());
    }

    /**
     * Returns the number of movies per director (as a map)
     */
    static Map<String, Long> ex03() {
        Optional<List<Movie>> movies = ImdbTop250.movies();
        if (movies.isEmpty()) {
            return Collections.emptyMap();
        }

        return movies.get().stream()
                .flatMap(m -> m.directors().stream())
                .collect(Collectors.groupingBy(d -> d, Collectors.counting()));
    }

    /**
     * Returns the 10 directors with the most films on the list
     */
    static Map<String, Long> ex04() {
        Optional<List<Movie>> movies = ImdbTop250.movies();
        if (movies.isEmpty()) {
            return Collections.emptyMap();
        }

        return movies.get().stream()
                .flatMap(m -> m.directors().stream())
                .collect(Collectors.groupingBy(d -> d, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
    }

    /**
     * Returns the movies (only titles) made by each of the 10 directors found in {@link PlayWithMovies#ex04 ex04}
     */
    static Map<String, Set<String>> ex05() {
        Optional<List<Movie>> movies = ImdbTop250.movies();
        if (movies.isEmpty()) {
            return Collections.emptyMap();
        }

        Set<String> topDirectors = ex04().keySet();

        return movies.get().stream()
                .filter(m -> m.directors().stream().anyMatch(topDirectors::contains))
                .collect(Collectors.groupingBy(m -> m.directors().stream().filter(topDirectors::contains).findFirst().orElse("")))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().stream().map(Movie::title).collect(Collectors.toSet())));
    }

    /**
     * Returns the number of movies per actor (as a map)
     */
    static Map<String, Long> ex06() {
        List<Movie> movies = ImdbTop250.movies().orElse(Collections.emptyList());
        return movies.stream()
                .flatMap(movie -> movie.actors().stream())
                .collect(Collectors.groupingBy(actor -> actor, Collectors.counting()));
    }

    /**
     * Returns the 9 actors with the most films on the list
     */
    static Map<String, Long> ex07() {
        throw new RuntimeException("ex07 is not implemented!");
    }

    /**
     * Returns the movies (only titles) of each of the 9 actors from {@link PlayWithMovies#ex07 ex07}
     */
    static Map<String, Set<String>> ex08() {
        throw new RuntimeException("ex08 is not implemented!");
    }

    /**
     * Returns the 5 most frequent actor partnerships (i.e., appearing together most often)
     */
    static Map<String, Long> ex09() {
        throw new RuntimeException("ex08 is not implemented!");
    }

    /**
     * Returns the movies (only titles) of each of the 5 most frequent actor partnerships
     */
    static Map<String, Set<String>> ex10() {
        return ImdbTop250.movies()
                .orElseThrow()
                .stream()
                .flatMap(movie -> {
                    List<String> actors = movie.actors();
                    return actors.stream().flatMap(a1 ->
                            actors.stream().filter(a2 -> !a1.equals(a2))
                                    .map(a2 -> new AbstractMap.SimpleEntry<>(Arrays.asList(a1, a2), movie.title())));
                })
                .collect(Collectors.groupingBy(
                        entry -> entry.getKey().stream().sorted().collect(Collectors.toList()),
                        Collectors.groupingBy(Map.Entry::getValue, Collectors.toSet())
                ))
                .entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue().size(), e1.getValue().size()))
                .limit(5)
                .collect(Collectors.toMap(
                        entry -> String.join(", ", entry.getKey()),
                        entry -> entry.getValue().keySet()
                ));
    }
}

