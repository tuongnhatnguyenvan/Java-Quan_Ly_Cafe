package thu;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class ThoiGian extends Thread{
      private JLabel thoiGian;

	public ThoiGian(JLabel thoiGian) {
		this.thoiGian = thoiGian;
	}
	
	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy '  ---  ' hh:mm:ss aa");
		
		while (true) {
			Date now = new Date();
			
			String time = sdf.format(now);
			
			thoiGian.setText(time);
			
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException ex) {
	
			}
		}
		
		
	}
      
      
}
