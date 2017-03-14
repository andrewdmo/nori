package norialertapp.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class Utils {

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	
	/**
	 * Get Random String
	 * 
	 * @param count
	 * @return
	 */
	public static String getRandomString(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING
					.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	
	/**
	 * Get Root url
	 * 
	 * @param request
	 * @return
	 */
	public static String getRootURL(HttpServletRequest request) {
		String protocol = request.getScheme();
		int port = request.getServerPort();
		String host = request.getServerName();
		String rootURL = protocol+"://"+host+":"+port;
		return rootURL;
	}
	
	/**
	 * Convert Date to String
	 * 
	 * @param strDate
	 * @return
	 * @throws ParseException 
	 */
	public static String convertDate(String strDate)  {
		try {
			Date date = new SimpleDateFormat("MM-dd-yyyy").parse(strDate);
			return new SimpleDateFormat("yyyy-MM-dd").format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
 	}
	
	/**
	 * get current date in string 
	 * @return
	 */
	public static String currentStringDate()  {
		return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
	}
	
	/**
	 * convert string date to util date
	 * @param dateStr
	 * @return
	 */
	public static Date getDate(String dateStr) {
		final DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		try {
            return formatter.parse(dateStr);
        } catch (ParseException e) {                
            return null;
        }
    }
	
	/**
	 * get difference between two datetime
	 * @param dateTime
	 * @return
	 */
	public static long getDifferenceBtwTime(Date dateTime) {
		long timeDifferenceMilliseconds = new Date().getTime() - dateTime.getTime();
	    long diffMinutes = timeDifferenceMilliseconds / (60 * 1000);
	    return diffMinutes;
	}
	

}
