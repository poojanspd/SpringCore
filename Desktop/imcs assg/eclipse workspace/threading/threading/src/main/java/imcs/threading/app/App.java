package imcs.threading.app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import imcs.threading.tasks.FileToDB;

public class App {

	public static void main(String[] args) {
		
		String[] str= { "C:\\Users\\pooja\\Desktop\\imcs assg\\eclipse workspace\\threading\\threading\\src\\main\\resource\\PropertyInfo1.csv",
				"C:\\Users\\pooja\\Desktop\\imcs assg\\eclipse workspace\\threading\\threading\\src\\main\\resource\\PropertyInfo2.csv",
				"C:\\Users\\pooja\\Desktop\\imcs assg\\eclipse workspace\\threading\\threading\\src\\main\\resource\\PropertyInfo3.csv",
				"C:\\Users\\pooja\\Desktop\\imcs assg\\eclipse workspace\\threading\\threading\\src\\main\\resource\\PropertyInfo4.csv",
				"C:\\Users\\pooja\\Desktop\\imcs assg\\eclipse workspace\\threading\\threading\\src\\main\\resource\\PropertyInfo5.csv",
				"C:\\Users\\pooja\\Desktop\\imcs assg\\eclipse workspace\\threading\\threading\\src\\main\\resource\\PropertyInfo6.csv",
				"C:\\Users\\pooja\\Desktop\\imcs assg\\eclipse workspace\\threading\\threading\\src\\main\\resource\\PropertyInfo7.csv"};		
		ExecutorService thread = Executors.newFixedThreadPool(5);
		
		for(String str1:str){
			
		thread.execute(new FileToDB(str1));

		}
		
		thread.shutdown();
	}

}
