import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Lab2_1 {

	public static void main(String[] args) {
		//Создание окна
		JFrame frame = new JFrame();
		//Завершение приложения при закрытии окна
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Задать размер окна
		frame.setSize(850,100);
		//Задать позицию окна
		frame.setLocation(100,100);
		//Задать заголовок окна
		frame.setTitle("Lab2_1");
		
		
		frame.setLayout(new FlowLayout());
		JLabel LNum = new JLabel("Число чашек = ");	
		frame.add(LNum);
		JTextArea TA = new JTextArea(1, 4);
		frame.add(TA);
		JComboBox<String>CoffeeType = new JComboBox<String>(
				new String[] {"Эспрессо","Капучино","Латте"});
		frame.add(CoffeeType);
		

		ButtonGroup group = new ButtonGroup();
		JRadioButton B1 = new JRadioButton("Без сахара", false);
		group.add(B1);
		JRadioButton B2 = new JRadioButton("1 ложка", true);
		group.add(B2);
		JRadioButton B3 = new JRadioButton("2 ложки", true);
		group.add(B3);
		frame.add(B1);
		frame.add(B2);
		frame.add(B3);
		
		JCheckBox Sirop = new JCheckBox("Сироп");
		frame.add(Sirop);
				
		JLabel Inf = new JLabel("Стоимость кофе ");
		frame.add(Inf);
		
		JButton calculateButton = new JButton("=");
		frame.add(calculateButton);
		
		JTextField resultField = new JTextField("	");
		frame.add(resultField);
		
		//реализация функциональности
		calculateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				float result = 0;
				float CupCost = 0;
				float Dop1 = 0;
				float Dop2 = 0;
			
				int N = Integer.parseInt(TA.getText());
				
				if (CoffeeType.getSelectedItem().equals("Эспрессо")) {
					CupCost = 100;
				}else if (CoffeeType.getSelectedItem().equals("Капучино")) {
					CupCost = 150;
				}else if (CoffeeType.getSelectedItem().equals("Латте")) {
					CupCost = 200;
				}
				
				if (Sirop.isSelected()) {
					Dop1 = 15;
				} else {
				    Dop1 = 0;
				}
				
				boolean isB1Selected = B1.isSelected();
				boolean isB2Selected = B2.isSelected();
				boolean isB3Selected = B3.isSelected();
				
				if (isB1Selected) {
					Dop2 = 0;				 
				} else if (isB2Selected){
					Dop2 = 10;
				} else if (isB3Selected){
					Dop2 = 20;
				}
				
				result = N*(CupCost + Dop1 +Dop2);
				
				resultField.setText(String.valueOf(result));
			}	
		});
		//Сделать окно видимым
		frame.setVisible(true);
	}
}
