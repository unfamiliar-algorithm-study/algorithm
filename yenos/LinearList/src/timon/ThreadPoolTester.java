/**
 * 
 */
package timon;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yenos
 * @date 2016. 11. 4.
 */
public class ThreadPoolTester {
	private static final ExecutorService threadPool = Executors.newFixedThreadPool(3);
	
	public static void initTest() {
	
	}
	
	public static void destroyTester() {
			threadPool.shutdown();
	}
	
	
	private static int gidx = 0;
	private String[] arrText = {"a","3","b","3"};
	
	public  void process(String request) {
		threadPool.execute(new  Runnable() {
			public void run() {
				Random r = new Random();
			
				System.out.println(++gidx + ":myId:" + Thread.currentThread().getId() );
				//System.out.println("arrText:" +  ( Math.abs(r.nextInt()) % arrText.length )  );
//				System.out.println("arrText:" + arrText[gidx]);
				
			}
		});
	}
}
