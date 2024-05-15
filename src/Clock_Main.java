
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneOffset;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Clock_Main extends JFrame {

	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clock_Main frame = new Clock_Main("+07:00");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Clock_Main(String muigio) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 432);	
		setLayout(null);
		
		Clock clock = new Clock(muigio);
		clock.setBounds(57, 50, 500, 170);
		add(clock);
		Thread t = new Thread(clock);
		t.start();
		
		JLabel lblNewLabel = new JLabel("MÚI GIỜ:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(57, 276, 120, 52);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 25));
		textField.setBounds(207, 276, 197, 52);
		add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("OPEN");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open(textField.getText());
			}
		});
		button.setBounds(432, 276, 144, 52);
		add(button);
		setVisible(true);
	}
	
	
	//cai cho nay tui khong ro , nma cach chon mui gio khong dung
	//no khong han la so, cx khong han la String 
	//phai nhap dung dinh dang +(-)HH:00
	public void open(String muigio) {
		try {
			ZoneOffset offset = ZoneOffset.of(muigio);
			new Clock_Main(muigio);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			textField.setText("");
		}
		
	}
}

