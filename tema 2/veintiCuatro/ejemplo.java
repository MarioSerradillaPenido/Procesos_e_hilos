package ejemplo;
 
import java.io.IOException;
 
public class ejemplo extends Thread {
	
	public ejemplo() {
		
	}
	
	public void run() {
		try {
			sleep(1000);
			synchronized (this) {
				wait(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
 