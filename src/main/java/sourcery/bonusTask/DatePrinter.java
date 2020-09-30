package sourcery.bonusTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatePrinter
{
    static int[] daysInMonth = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static void printBonusDatesBetween(int fromYear, int toYear)
    {
        Calendar cal = Calendar.getInstance();
        for (int i = Math.max(fromYear, 1000); i < Math.min(toYear, 10000); i++)
        {
            int month = i % 10 * 10 + (i / 10) % 10;
            int day = ((int)(i / Math.pow(10, 2)) % 10 * 10 + (int)(i / Math.pow(10, 3)) % 10);

            if (month >= 1 && month <= 12 && day >= 1 && day <= daysInMonth[month - 1])
            {
                if (month == 2 && day > 28 && java.time.Year.of(i).isLeap())
                    continue;

                cal.set(i, month - 1, day, 0, 0);
                Date date = cal.getTime();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                System.out.println(dateFormat.format(date));
            }
        }
    }

    public static void main(String[] args)
    {
        printBonusDatesBetween(0, 9999);
    }
}
