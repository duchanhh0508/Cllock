import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

public class Clock extends JPanel implements Runnable{

	private JLabel label_time;
	private String muigio;

	public Clock(String muigio) {
		setLayout(null);
		this.muigio = muigio;
		
		label_time = new JLabel("");
		label_time.setFont(new Font("Tahoma", Font.BOLD, 80));
		label_time.setBounds(10, 5, 515, 157);
		label_time.setHorizontalAlignment(SwingConstants.CENTER);
		label_time.setBackground(Color.cyan);
		label_time.setOpaque(true);
		add(label_time);

	}

	@Override
	public void run() {
		while(true) {
			label_time.setText(update());
		}	
	}
	
	public String update() {
		ZoneOffset offset = ZoneOffset.of(muigio);
        ZonedDateTime currentTime = ZonedDateTime.now(offset);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentTime.format(formatter);
        return formattedTime;
	}

}
