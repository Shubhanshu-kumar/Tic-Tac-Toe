import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class TicTacToe 
{
	
	JFrame fr=new JFrame("Tic Tac Toe");
	JLabel img=new JLabel(new ImageIcon(getClass().getResource("images/t2.jpg")));
    JPanel[] pa=new JPanel[3];
	JLabel msg=new JLabel("First Player Turn....");
	
	JButton [] bt=new JButton[9];
	JButton reset=new JButton("RESET");             
	ImageIcon icon1=new ImageIcon(getClass().getResource("images/user1.png"));
	
	ImageIcon icon2=new ImageIcon(getClass().getResource("images/user2.png"));

	int player=1,count=0;
	boolean WinnerFound=false;
	public TicTacToe()
	{
		fr.setSize(500,650);
		fr.setResizable(false);
		fr.setDefaultCloseOperation(3);
		fr.setLocationRelativeTo(null);
		fr.add(img);
		addPannels();
		fr.setVisible(true);
	}
	private void addPannels() 
	{
		
		img.setLayout(null);
		for(int i=0;i<3;i++)
		{
			pa[i]=new JPanel();
			img.add(pa[i]);
			
		}
		pa[0].setBounds(50,30,400,40);
		pa[1].setBounds(50,100,400,400);
		pa[2].setBounds(50,530,400,40);
		addinfo();
	}
	private void addinfo()
	{
		pa[0].add(msg);
		
		msg.setFont(new Font("elephant",Font.PLAIN,25));
		msg.setForeground(Color.blue);
		pa[2].add(reset);
		pa[2].setOpaque(false);
		reset.setFont(new Font("arial",Font.HANGING_BASELINE,20));
		reset.setBackground(Color.white);
		reset.addActionListener(new ResetListener());
		addButtons();
			
	}
	private void addButtons() 
	{
		pa[1].setLayout(new GridLayout(3, 3));
		Border border=BorderFactory.createLineBorder(Color.red,2);
		TicListener listener=new TicListener();
		for(int i=0;i<9;i++)
		{
			bt[i]=new JButton();
			bt[i].addActionListener(listener);
			bt[i].setBackground(Color.yellow);
			bt[i].setBorder(border);
			pa[1].add(bt[i]);
		}
		
	}
	class TicListener implements ActionListener
	{

		public void actionPerformed(ActionEvent evt) 
		{
			JButton bb=(JButton)evt.getSource();
			if(player==1)
			{
				bb.setIcon(icon1);
				bb.setEnabled(false);//this code will disable the buttons
				msg.setText("Second Player Turn....");
				player=2;
			}
			else if(player==2)
			{
				bb.setIcon(icon2);
				bb.setEnabled(false);
				msg.setText("First Player Turn....");
				player=1;
			}
					FindWinner();
					count++;
					if(count==9 && !WinnerFound)
					{
						msg.setText("NO ONE IS WINNER...");
						msg.setForeground(Color.red);
					}
		}
        private void FindWinner()
        {
        	//row
        	
        	
			if(bt[0].getIcon()==icon1&&bt[1].getIcon()==icon1&&bt[2].getIcon()==icon1)
        		announcewinner(0,1,2,"First Player Have Won..");
					
			else if(bt[0].getIcon()==icon2&&bt[1].getIcon()==icon2&&bt[2].getIcon()==icon2)
        		announcewinner(0,1,2,"Second Player Have Won..");
			
			else if(bt[3].getIcon()==icon1&&bt[4].getIcon()==icon1&&bt[5].getIcon()==icon1)
        		announcewinner(3,4,5,"First Player Have Won..");
			
			else if(bt[3].getIcon()==icon2&&bt[4].getIcon()==icon2&&bt[5].getIcon()==icon2)
        		announcewinner(3,4,5,"Second Player Have Won..");
			
			else if(bt[6].getIcon()==icon1&&bt[7].getIcon()==icon1&&bt[8].getIcon()==icon1)
        		announcewinner(6,7,8,"First Player Have Won..");
			
			else if(bt[6].getIcon()==icon2&&bt[7].getIcon()==icon2&&bt[8].getIcon()==icon2)
        		announcewinner(6,7,8,"Second Player Have Won..");
			
			
			//column
			
			else if(bt[0].getIcon()==icon1&&bt[3].getIcon()==icon1&&bt[6].getIcon()==icon1)
        		announcewinner(0,3,6,"First Player Have Won..");
			
			else if(bt[0].getIcon()==icon2&&bt[3].getIcon()==icon2&&bt[6].getIcon()==icon2)
        		announcewinner(0,3,6,"Second Player Have Won..");
			
			else if(bt[1].getIcon()==icon1&&bt[4].getIcon()==icon1&&bt[7].getIcon()==icon1)
        		announcewinner(1,4,7,"First Player Have Won..");
			
			else if(bt[1].getIcon()==icon2&&bt[4].getIcon()==icon2&&bt[7].getIcon()==icon2)
        		announcewinner(1,4,7,"Second Player Have Won..");
        
			else if(bt[2].getIcon()==icon1&&bt[5].getIcon()==icon1&&bt[8].getIcon()==icon1)
        		announcewinner(2,5,8,"First Player Have Won..");
        
			else if(bt[2].getIcon()==icon2&&bt[5].getIcon()==icon2&&bt[8].getIcon()==icon2)
        		announcewinner(2,5,8,"Second Player Have Won..");
			
			//Diagonal
			
			else if(bt[0].getIcon()==icon1&&bt[4].getIcon()==icon1&&bt[8].getIcon()==icon1)
        		announcewinner(0,4,8,"First Player Have Won..");
			
			else if(bt[0].getIcon()==icon2&&bt[4].getIcon()==icon2&&bt[8].getIcon()==icon2)
        		announcewinner(0,4,8,"Second Player Have Won..");
			
			else if(bt[2].getIcon()==icon1&&bt[4].getIcon()==icon1&&bt[6].getIcon()==icon1)
        		announcewinner(2,4,6,"First Player Have Won..");
			
			else if(bt[2].getIcon()==icon2&&bt[4].getIcon()==icon2&&bt[6].getIcon()==icon2)
        		announcewinner(2,4,6,"Second Player Have Won..");
			
	    }
		private void announcewinner(int i, int j, int k, String str) 
		{
			msg.setText(str);
			bt[i].setBackground(Color.red);
			bt[j].setBackground(Color.red);
			bt[k].setBackground(Color.red);
			msg.setForeground(Color.green);
			disablebuttons();
			WinnerFound=true;
		}
		private void disablebuttons()
		{
		     for(JButton b:bt)
		    	 b.setEnabled(false);
			
		}        	
     }		
	class ResetListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt) 
		{
			for(JButton bb:bt)
			{
				bb.setBackground(Color.yellow);
				bb.setIcon(null);
				bb.setEnabled(true);
			}
			count=0;
			player=1;
			msg.setText("First Player Turn...");
			msg.setForeground(Color.blue);
			WinnerFound=false;
		}
	}
	public static void main(String[] args) 
	{
		new TicTacToe();
	
	}

}
