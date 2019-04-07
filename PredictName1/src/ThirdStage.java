import java.awt.*;
import java.awt.event.*;
public class ThirdStage extends Frame implements ActionListener
{
	TextArea ta;
	Label l;
	Button b1;
	SecondStage ss;
	char resultf[][];
	public ThirdStage(SecondStage ss1) 
	{
		setLayout(null);
		ss=ss1;
		ta=new TextArea("",5,300,3);
		l=new Label("To see your result press RESULT button");
		b1=new Button("RESULT");
		add(b1);add(l);add(ta);
		l.setBounds(200,160,550,30);
		ta.setBounds(200,200,300,300);
		b1.setBounds(500,520,100,40);
		ta.setEditable(false);
		b1.setBackground(Color.BLUE);
		String str=ss.t1.getText();
		int indexf[]=new int[ss.s.length()];
		for(int i=0;i<str.length();i++)
		{
			indexf[i]=Integer.parseInt(str.substring(i,i+1));
		}
		resultf=new char[ss.s.length()][ss.s.length()]; 
		for(int i=0;i<ss.s.length();i++)
		{
			for(int j=0;j<ss.s.length();j++)
			{
				resultf[j][i]=ss.result[indexf[i]-1][j];
			}
		}
		b1.addActionListener(this);
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
			ta.setText("");
			ta.append("\n    your \n       name \n         is\n\n               ");
			for(int i=0;i<ss.s.length();i++)
			{
				for(int j=0;j<ss.s.length();j++)
				{
					if(i==j)
					{
						ta.append(resultf[i][j]+"");
					}
				}
			}
			ta.append("\n\n        THANK YOU!!");
		}
	}

}
