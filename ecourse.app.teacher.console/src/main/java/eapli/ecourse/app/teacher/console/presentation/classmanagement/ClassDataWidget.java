package eapli.ecourse.app.teacher.console.presentation.classmanagement;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.SelectWidget;
import eapli.framework.time.domain.model.TimeInterval;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class ClassDataWidget {
    private String title;
    private DayOfWeek dayOfWeek;
    private TimeInterval timePeriod;
    public void show() {
        System.out.println("\n+= Input class data Menu ====+\n");
        title = Console.readNonEmptyLine("Class title:", "Class title cannot be empty");
        dayOfWeek = readDayOfWeek();
        timePeriod = readTimeInterval();
    }

    private TimeInterval readTimeInterval() {
        do {
            try {
                Date start = Console.readDate("Class start time: (HH:mm)", "HH:mm");
                Date end = Console.readDate("Class end time: (HH:mm)", "HH:mm");
                Calendar startCalendar = Calendar.getInstance(), endCalendar = Calendar.getInstance();
                startCalendar.setTime(start);
                endCalendar.setTime(end);
                return new TimeInterval(startCalendar, endCalendar);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid time interval. Please try again.");
            }

        } while (true);
    }

    private DayOfWeek readDayOfWeek() {
        SelectWidget<DayOfWeek> selector = new SelectWidget<>("Select day of week", Arrays.asList(DayOfWeek.values()));
        do {
            selector.show();
        } while (selector.selectedOption() == 0);

        return selector.selectedElement();
    }

    public String getTitle() {
        return title;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public TimeInterval getTimePeriod() {
        return timePeriod;
    }
}
