
public class Time {
    public static void main(String[] args) {
    	int totalSeconds = getTotalSeconds("10:10:10");
    	System.out.println("Total Seconds = "+totalSeconds);
    }

    public static double getTotalSeconds(String time) throws NumberFormatException, StringIndexOutOfBoundsException {
        int hours = getTotalHours(time);
        //we will eventually multiply the hours by 3600 + the minutes by 60 + the seconds
        int minutes = getTotalMinutes(time);
        int seconds = getSeconds(time);
        int milliseconds = getMilliseconds(time);
        return hours * 3600 + minutes * 60 + seconds + (milliseconds / 1000.0);
    }

    public static int getMilliseconds(String time) throws NumberFormatException, StringIndexOutOfBoundsException {
        return Integer.parseInt(time.substring(9, 11));
    }

    public static int getSeconds(String time) throws NumberFormatException, StringIndexOutOfBoundsException {
        return Integer.parseInt(time.substring(6, 8));
    }

    public static int getTotalMinutes(String time) throws NumberFormatException, StringIndexOutOfBoundsException {
        return Integer.parseInt(time.substring(3, 5));
    }

    public static int getTotalHours(String time) throws NumberFormatException, StringIndexOutOfBoundsException {
        return Integer.parseInt(time.substring(0, 2));
    }
}
