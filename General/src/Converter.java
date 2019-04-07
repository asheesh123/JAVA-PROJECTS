import java.awt.*;
import java.awt.event.*;
class Converter extends Frame implements TextListener,FocusListener,ItemListener {
	Label l;
	TextField t1,t2;
	Choice c1,c2,c;
	String prev1,prev2;
	Converter(){
		setLayout(null);
		prev1="Celcius";
		prev2="Farenheit";
		t1=new TextField("0");
		t2=new TextField("32.0");
		l=new Label("=");
		c=new Choice();
		c1=new Choice();
		c2=new Choice();
		c1.add("Celcius");
		c1.add("Farenheit");
		c1.add("Kelvin");
		c2.add("Celcius");
		c2.add("Farenheit");
		c2.add("Kelvin");
		c.add("Temperature");
		add(c);
		add(c1);
		add(t1);
		add(c2);
		add(t2);
		add(l);
		Font f=new Font("",Font.PLAIN,25);
		c.setBounds(100,100,450,20);
		t1.setBounds(100,150,200,40);
		t2.setBounds(350,150,200,40);
		c1.setBounds(100,200,200,20);
		c2.setBounds(350,200,200,20);
		l.setBounds(315, 160, 20, 20);
		l.setBackground(Color.pink);
		c.setBackground(Color.white);
		c1.setBackground(Color.white);
		c2.setBackground(Color.white);
		l.setFont(f);
		t1.setFont(f);
		t2.setFont(f);
		c1.select(0);
		c2.select(1);
		t1.addTextListener(this);
		t2.addTextListener(this);
		t1.addFocusListener(this);
		t2.addFocusListener(this);
		c1.addItemListener(this);
		c2.addItemListener(this);
		addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent e) {System.exit(0);}});
	}
	public void textValueChanged(TextEvent e) {
		if(t1==e.getSource()) {
			if(t1.isFocusOwner()==true&&!t1.getText().equals("")) {
				convertIt1(c1.getSelectedItem(),c2.getSelectedItem());
			}
			else if(t1.isFocusOwner()==true&&t1.getText().equals("")) {
				t2.setText("");
			}
		}
		if(t2==e.getSource()) {
			if(t2.isFocusOwner()==true&&!t2.getText().equals("")) {
				convertIt2(c1.getSelectedItem(),c2.getSelectedItem());
			}
			else if(t2.isFocusOwner()==true&&t2.getText().equals("")) {
				t1.setText("");
			}
		}
	}
	public void focusGained(FocusEvent e) {
		if(t1==e.getSource()) {
			t1.selectAll();
		}
		if(t2==e.getSource()) {
			t2.selectAll();
		}
	}
	public void focusLost(FocusEvent e) {
		
	}
	private void convertIt1(String s1,String s2) {
		if(s1.equals("Celcius")&&s2.equals("Farenheit")) {
			try {
				float c=Float.parseFloat(t1.getText());
				t2.setText(Float.toString(c*9/5+32));
			}
			catch(Exception ex) {
				
			}
		}
		else if(s1.equals("Celcius")&&s2.equals("Kelvin")) {
			try {
				float c=Float.parseFloat(t1.getText());
				t2.setText(Float.toString(c+273.15f));
			}
			catch(Exception ex) {
				
			}
		}
		else if(s1.equals("Farenheit")&&s2.equals("Celcius")) {
			try {
				float f=Float.parseFloat(t1.getText());
				t2.setText(Float.toString((f-32)*5/9));
			}
			catch(Exception ex) {
				
			}
		}
		else if(s1.equals("Farenheit")&&s2.equals("Kelvin")) {
			try {
				float f=Float.parseFloat(t1.getText());
				t2.setText(Float.toString((f-32)*5/9+273.15f));
			}
			catch(Exception ex) {
				
			}
		}
		else if(s1.equals("Kelvin")&&s2.equals("Celcius")) {
			try {
				float k=Float.parseFloat(t1.getText());
				t2.setText(Float.toString(k-273.15f));
			}
			catch(Exception ex) {
				
			}
		}
		else if(s1.equals("Kelvin")&&s2.equals("Farenheit")) {
			try {
				float k=Float.parseFloat(t1.getText());
				t2.setText(Float.toString((k-273.15f)*9/5+32));
			}
			catch(Exception ex) {
				
			}
		}
	}
	private void convertIt2(String s1,String s2) {
		if(s1.equals("Farenheit")&&s2.equals("Celcius")) {
			try {
				float c=Float.parseFloat(t2.getText());
				t1.setText(Float.toString(c*9/5+32));
			}
			catch(Exception ex) {
				
			}
		}
		else if(s1.equals("Kelvin")&&s2.equals("Celcius")) {
			try {
				float c=Float.parseFloat(t2.getText());
				t1.setText(Float.toString(c+273.15f));
			}
			catch(Exception ex) {
				
			}
		}
		else if(s1.equals("Celcius")&&s2.equals("Farenheit")) {
			try {
				float f=Float.parseFloat(t2.getText());
				t1.setText(Float.toString((f-32)*5/9));
			}
			catch(Exception ex) {
				
			}
		}
		else if(s1.equals("Kelvin")&&s2.equals("Farenheit")) {
			try {
				float f=Float.parseFloat(t2.getText());
				t1.setText(Float.toString((f-32)*5/9+273.15f));
			}
			catch(Exception ex) {
				
			}
		}
		else if(s1.equals("Celcius")&&s2.equals("Kelvin")) {
			try {
				float k=Float.parseFloat(t2.getText());
				t1.setText(Float.toString(k-273.15f));
			}
			catch(Exception ex) {
				
			}
		}
		else if(s1.equals("Farenheit")&&s2.equals("Kelvin")) {
			try {
				float k=Float.parseFloat(t2.getText());
				t1.setText(Float.toString((k-273.15f)*9/5+32));
			}
			catch(Exception ex) {
				
			}
		}
	}
	public void itemStateChanged(ItemEvent e) {
		if(c1==e.getSource()) {
			if(c1.getSelectedItem().equals(c2.getSelectedItem())) {
				c2.select(prev1);
			}
			prev1=c1.getSelectedItem();
			prev2=c2.getSelectedItem();
			convertIt1(c1.getSelectedItem(),c2.getSelectedItem());
		}
		if(c2==e.getSource()) {
			if(c2.getSelectedItem().equals(c1.getSelectedItem())) {
				c1.select(prev2);
			}
			prev1=c1.getSelectedItem();
			prev2=c2.getSelectedItem();
			convertIt1(c1.getSelectedItem(),c2.getSelectedItem());
		}
	}
	public static void main(String args[]) {
		Converter c=new Converter();
		c.setVisible(true);
		Toolkit t=c.getToolkit();
		Dimension d=t.getScreenSize();
		c.setSize(d.width,d.height);
		c.setBackground(Color.pink);
		c.setTitle("Converter");
	}
}