
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OpenSaveMenuExample extends Frame implements ActionListener
{
	MenuBar mbr;
	Menu file,sub,close;
	MenuItem i1,i2,i3,i4,i5,cl;
	CheckboxMenuItem c1;
	TextArea ta;
	String dir,fil,path;
	public OpenSaveMenuExample()
	{
		dir=new String();
		fil=new String();
		path=new String();
		setLayout(null);
		mbr=new MenuBar();
		ta=new TextArea("",10,200,1);
		file=new Menu("File");
		close=new Menu("Close");
		sub=new Menu("Sub",true);
		i1=new MenuItem("new",new MenuShortcut(KeyEvent.VK_N));
		i2=new MenuItem("open",new MenuShortcut(KeyEvent.VK_O));
		i3=new MenuItem("save",new MenuShortcut(KeyEvent.VK_S));
		i4=new MenuItem("Fisrst");
		i5=new MenuItem("Second");
		cl=new MenuItem("Close");
		close.add(cl);
		c1=new CheckboxMenuItem("Debug");
		file.add(i1);
		file.add(i2);
		file.add(i3);
		sub.add(i4);
		sub.add(i5);
		file.add(sub);
		file.add(c1);
		mbr.add(file);
		mbr.add(close);
		setMenuBar(mbr);
		i1.addActionListener(this);
		i2.addActionListener(this);
		i3.addActionListener(this);
		i4.addActionListener(this);
		i5.addActionListener(this);
		cl.addActionListener(this);
		add(ta);
		ta.setBackground(Color.white);
		ta.setBounds(10,70,1340,670);
		ta.setVisible(false);
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
		OpenSaveMenuExample m=new OpenSaveMenuExample();
		m.setTitle("My Menu");
		m.setVisible(true);
		Toolkit t=m.getToolkit();
		Dimension d=t.getScreenSize();
		m.setSize(d.width,d.height);
		m.setBackground(Color.pink);
		m.setFont(new Font(Font.DIALOG,Font.BOLD,15));
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(i1==ae.getSource())
		{
			ta.setText("");
			ta.setVisible(true);
		}
		if(i2==ae.getSource())
		{
			ta.setVisible(false);
			FileDialog fd=new FileDialog(this,"open dialog",FileDialog.LOAD);
			fd.setVisible(true);
			ta.setText("");
			if(fd.getDirectory()!=null)
			{
				ta.setVisible(true);
				try 
				{
					BufferedReader br=new BufferedReader(new FileReader(fd.getDirectory()+fd.getFile()));
					String s;
					while((s=br.readLine())!=null)
					{
						ta.append(s+"\n");
					}
					br.close();
					
				}
				catch(Exception e) {}
			}
			
		}
		if(i3==ae.getSource())
		{
			FileDialog fd=new FileDialog(this,"save dialog",FileDialog.SAVE);
			fd.setVisible(true);
			try 
			{
				path=fd.getDirectory()+fd.getFile();
				FileWriter fw=new FileWriter(path);
				String s=ta.getText();
				System.out.println(s);
				fw.write(s);
				fw.close();
			} 
			catch (Exception e) {}
		}
		if(cl==ae.getSource())
		{
			ta.setText("");
			ta.setVisible(false);
		}
	}
}