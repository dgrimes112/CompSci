/* David Grimes
 * Dr. Steinberg
 * COP3503 Spring 2025
 * Eustis Setup Assignment
 */
import java.util.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;

public class EustisSetup
	{
		public static void main(String[] args)
			{
				LocalDate Date = LocalDate.now();
				Month Month = Date.getMonth();
				int Year = Date.getYear();
				String monthName = Month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);

				System.out.print("The current month is " + monthName + ".\n");
				System.out.print("The current year is " + Year + ".\n");
				System.out.println("I am a student at the University of Central Florida.");
				System.out.println("I am taking Dr. Steinberg's Computer Science 2 Course!");
				System.out.println("I am so excited to learn more algorithms and advanced data structures!");
				System.out.println("Sonic the Hedgehog 3 came to the theater last month!");
			}
	}

