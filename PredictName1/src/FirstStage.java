import java.awt.*;
import java.awt.event.*;
public class FirstStage extends Frame implements ActionListener
{
	TextArea ta;
	Label l,l1,lm;
	TextField t1;
	Button b1;
	char[][] content={{'A','B','C','D','E'},{'F','G','H','I','J'},{'K','L','M','N','O'},{'P','Q','R','S','T'},{'U','V','W','X','Y'},{'Z','-','-','-','-'}};
	public FirstStage()
	{
		setLayout(null);
		ta=new TextArea("",5,300,3);
		l=new Label("Rows are 1,2,3,4,5,6. (Multiple word name also can be found)");
		b1=new Button("NEXT");
		l1=new Label("Fill row number corresponding to latter of your name");
		t1=new TextField();
		lm=new Label("Example For name ASHEESH fill 1421142 ");
		add(t1);add(b1);add(l);add(ta);add(l1);add(lm);
		l.setBounds(200,160,600,30);
		ta.setBounds(200,200,300,300);
		l1.setBounds(200,510,550,30);
		b1.setBounds(500,600,100,40);
		lm.setBounds(200,550,550,30);
		t1.setBounds(200,590,200,40);
		ta.append("\n  A       B       C       D       E \n\n");
		ta.append("  F       G       H       I        J \n\n");
		ta.append("  K       L       M       N      O \n\n");
		ta.append("  P       Q       R       S        T \n\n");
		ta.append("  U       V       W       X       Y \n\n");
		ta.append("  Z        -        -        -        - ");
		ta.setEditable(false);
		b1.setBackground(Color.BLUE);
		b1.addActionListener(this);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) 
	{
		FirstStage f=new FirstStage();
		f.setSize(900,700);
		f.setVisible(true);
		f.setTitle("First Stage");
		f.setBackground(Color.cyan);
		Font font=new Font(Font.SERIF,Font.PLAIN,20);
		f.setFont(font);
	}
	public void actionPerformed(ActionEvent ae) 
	{
		if(b1==ae.getSource())
		{
			SecondStage s=new SecondStage(this);
			s.setSize(900,700);
			s.setVisible(true);
			s.setTitle("First Stage");
			s.setBackground(Color.magenta);
			Font font=new Font(Font.SERIF,Font.PLAIN,20);
			s.setFont(font);
		}
	}

}
