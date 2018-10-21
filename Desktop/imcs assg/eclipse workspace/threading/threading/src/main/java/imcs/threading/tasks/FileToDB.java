package imcs.threading.tasks;

import java.io.IOException;

import imcs.threading.repo.PropertyInfoLoaderService;

public class FileToDB implements Runnable {

	String fileName;

	PropertyInfoLoaderService propertyInfoLoader;
	{
		propertyInfoLoader = new PropertyInfoLoaderService();
	}

	@Override
	public void run() {

		try {
			StoreToDB.savePropertyInfo(propertyInfoLoader.processFile(fileName));
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public FileToDB(String fileName) {
		super();
		this.fileName = fileName;
	}

}
