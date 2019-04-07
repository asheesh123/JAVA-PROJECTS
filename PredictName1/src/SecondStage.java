import java.awt.*;
import java.awt.event.*;
public class SecondStage extends Frame implements ActionListener
{
	TextArea ta;
	Label l,l1,lm;
	TextField t1;
	Button b1;
	FirstStage fp;
	String s="";
	char result[][];
	public SecondStage(FirstStage fp1)
	{
		setLayout(null);
		fp=fp1;
		ta=new TextArea("",5,300,3);
		l=new Label("Rows are 1,2,3,4,5. (Multiple word name also can be found)");
		b1=new Button("NEXT");
		l1=new Label("Fill row number corresponding to latter of your name");
		t1=new TextField();
		lm=new Label("Example For name ASHEESH fill 1435543 ");
		add(t1);add(b1);add(l);add(ta);add(l1);add(lm);
		l.setBounds(200,160,600,30);
		ta.setBounds(200,200,400,300);
		l1.setBounds(200,510,550,30);
		b1.setBounds(500,600,100,40);
		lm.setBounds(200,550,550,30);
		t1.setBounds(200,590,200,40);
		ta.setEditable(false);
		b1.setBackground(Color.BLUE);
		b1.addActionListener(this);
		s=fp.t1.getText();
		int index[]=new int[s.length()];
		for(int i=0;i<s.length();i++)
		{
			index[i]=Integer.parseInt(s.substring(i,i+1));
		}
		result=new char[5][s.length()];
		for(int i=0;i<s.length();i++)
		{
			for(int j=0;j<5;j++)
			{
				result[j][i]=fp1.content[index[i]-1][j];
			}
		}
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<s.length();j++)
			{
				ta.append(result[i][j]+"    ");
			}
			ta.append("\n\n");
		}
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				setVisible(false);
			}
		});
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(b1==ae.getSource())
		{
			ThirdStage th=new ThirdStage(this);
			th.setSize(900,700);
			th.setTitle("Third Stage");
			th.setVisible(true);
			th.setBackground(Color.green);
			Font font=new Font(Font.SERIF,Font.PLAIN,20);
			th.setFont(font);
		}
	}
}