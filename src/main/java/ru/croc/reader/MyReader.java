package ru.croc.reader;

import ru.croc.task13.cinema.Movie;
import ru.croc.task13.cinema.Poster;
import ru.croc.task13.cinema.Visitor;
import ru.croc.task15.voting.Respondent;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyReader {
    private MyReader() {
    }

    public static String[] readTask9(String[] args) {
        if (args.length > 0) {
            return args;
        } else {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine().split(" ");
        }
    }

    public static List<Movie> readTask13(String path) {
        List<Movie> movies = new ArrayList<>();

        try (Reader reader = new FileReader(path)) {
            Scanner scanner = new Scanner(reader);

            while (scanner.hasNext()) {
                String[] numberAndName = scanner.nextLine().split(",");

                movies.add(new Movie(numberAndName));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return movies;
    }

    public static List<Visitor> readTask13(String path, Poster poster) {
        List<Visitor> visitors = new ArrayList<>();

        try (Reader reader = new FileReader(path)) {
            Scanner scanner = new Scanner(reader);

            while (scanner.hasNext()) {
                Visitor visitor = new Visitor(scanner.nextLine());
                visitor.compileStatistics(poster);
                visitors.add(visitor);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return visitors;
    }


    public static List<Respondent> readTask15(String path) {

        List<Respondent> respondents = new ArrayList<>();

        try (Reader reader = new FileReader(path)) {
            Scanner scanner = new Scanner(reader);

            String current;

            while (!(current = scanner.nextLine()).equalsIgnoreCase("END")) {
                String[] fullNameAndAge = current.split(",");

                respondents.add(new Respondent(fullNameAndAge[0], Integer.parseInt(fullNameAndAge[1])));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return respondents;
    }


    public static List<String[]> readTask17(String arg) {

        List<String[]> result = new ArrayList<>();

        try (Reader reader = new FileReader(arg)) {
            Scanner scanner = new Scanner(reader);

            String current;

            while (scanner.hasNextLine()) {

                current = scanner.nextLine();

                String[] stringOrderAndProduct = current.split(",");

                result.add(stringOrderAndProduct);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;

    }

}
