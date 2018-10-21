package imcs.threading.repo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import imcs.threading.bean.PropertyInfo;

public class PropertyInfoValidator {

		public static List<PropertyInfo> validator(List<PropertyInfo> propertyinfo) throws ParseException {
		
			List<PropertyInfo> valid = new ArrayList<PropertyInfo>();
	
			List<PropertyInfo> invalid = new ArrayList<PropertyInfo>();
		
			for(PropertyInfo property:propertyinfo) {
			
					if(property.getTax()<=500 || (checkDate(property.getFillingDate()))>=3){
								invalid.add(property);
					}
					else{
								valid.add(property);
						}
				}
				return valid;

		}
		
		
		
	private static int checkDate(Date date) throws ParseException {
		
		LocalDate todaydt= LocalDate.now();
		LocalDate localDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(date) );
		long months =  ChronoUnit.MONTHS.between(todaydt,localDate);
		return (int)months;
	}
}
