package eapli.ecourse.app.teacher.console.presentation.classmanagement;

import eapli.framework.visitor.Visitor;
import eapli.ecourse.classmanagment.domain.Class;

import java.util.Calendar;

public class ClassPrinter implements Visitor<Class> {
    @Override
    public void visit(Class visitee) {
        Calendar start = visitee.timePeriod().start();
        Calendar end = visitee.timePeriod().end();
        String timeStart = String.format("%02d:%02d", start.get(Calendar.HOUR_OF_DAY), start.get(Calendar.MINUTE));
        String timeEnd = String.format("%02d:%02d", end.get(Calendar.HOUR_OF_DAY), end.get(Calendar.MINUTE));
        String day = String.format("%02d/%02d/%04d", start.get(Calendar.DAY_OF_MONTH), start.get(Calendar.MONTH)+1, start.get(Calendar.YEAR));
        String string = String.format("%s (%s, %s -> %s)", visitee, day, timeStart, timeEnd);
        System.out.println(string);
    }
}
