package imcs.threading.repo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import imcs.threading.bean.PropertyInfo;

public class PropertyInfoLoaderService {


	public  List<PropertyInfo> processFile(String file) throws IOException {
		
		List<PropertyInfo> propertyinfo = new ArrayList<PropertyInfo>();
		
		File file1 =new File(file);
		
		if(file1.exists()) {
		
			try(FileReader inputReader = new FileReader(file1);
		
					BufferedReader bufreader = new BufferedReader(inputReader);)
			{
			
		String details = null;

		while(bufreader.ready()) {

			details = bufreader.readLine();
			PropertyInfo property=parse(details);
			propertyinfo.add(property);
			
		}
		}
		finally {
			try {
				
				return PropertyInfoValidator.validator(propertyinfo);
			} catch (ParseException e) {
		
				e.printStackTrace();
			}
	}
	}
		else {
			throw new FileNotFoundException("File is not present at the provided location");
		}
		return null;
		}
	
	private  PropertyInfo parse(String details) {
	
		String[] line =details.split(",");
		Date date = null;
		try {
			date = new SimpleDateFormat("dd/MM/yyyy").parse(line[3]);
		} catch (ParseException e) {
		e.printStackTrace();
		}		
	return	new PropertyInfo(null,line[0],line[1],Integer.parseInt(line[2]), date);
	}
}
