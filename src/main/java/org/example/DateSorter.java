package org.example;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 *
 package sample;

 import java.time.LocalDate;
 import java.util.Collection;
 import java.util.List;

 /**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 * Implement in single class. Don't chane constructor and signature method.
 */
public class DateSorter {
    public static void main(String[] args) {

        List<LocalDate> datesForSoring = List.of(
                LocalDate.of(2004, 7, 1),
                LocalDate.of(2005, 1, 2),
                LocalDate.of(2007, 1, 1),
                LocalDate.of(2032, 5, 3)
        );
        Collection<LocalDate> sortedDates = sortDates(datesForSoring);
        sortedDates.forEach(System.out::println);
    }
    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
     * would sort to
     * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    public static Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        List<LocalDate> listWithR = unsortedDates.stream()
                .filter(date -> date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH).toLowerCase().contains("r"))
                .sorted()
                .toList();

        List<LocalDate> listWithoutR = unsortedDates.stream()
                .filter(date -> !date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH).toLowerCase().contains("r"))
                .sorted(Comparator.reverseOrder())
                .toList();

        List<LocalDate> sortedDates = new ArrayList<>();
        sortedDates.addAll(listWithR);
        sortedDates.addAll(listWithoutR);

        return sortedDates;
    }
}