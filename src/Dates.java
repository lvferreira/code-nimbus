import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Dates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Get the current date
        LocalDate currentDate = LocalDate.now();
        // Get the current day of the month
        int currentDay = currentDate.getDayOfMonth();
        // Get the current month
        int currentMonth = currentDate.getMonthValue();
        // Get the current year
        int currentYear = currentDate.getYear();
        // Print the current day and month
        System.out.println(currentDate);
        System.out.println("Current day: " + currentDay);
        System.out.println("Current month: " + currentMonth);
        System.out.println("Current year: " + currentYear);
        
        // Get the month as a String text
        String fullMonth = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        String shortMonth = currentDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        // Print the month
        System.out.println(fullMonth);
        System.out.println(shortMonth);
	}

}
