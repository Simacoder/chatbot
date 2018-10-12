import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.Color;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.lang.Math;

public class ChatBot extends JFrame implements KeyListener {
	
	JPanel p=new JPanel();
	JTextArea dialog=new JTextArea(20,50);
	JTextArea input=new JTextArea(1,50);
	JScrollPane scroll=new JScrollPane(dialog,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

String[][] chatBot= {
		//Standard Greetings
		{"Hi","Hello","Holla","Ola","Howdy"},
		{"Hi","Hello", "Hey"},
		//Question Greetings
		{"How Are You?","How R YOU?","How R U?","How Are U?"},
		{"Good","Doing well"},
		//Yes
		{"Yes"},
		{"No","no","NO!!!!!!"},
		//Defaults 
		{"Shut up","You're a bad","Noob","Tseki...","Stop talking"
			,("Simanga is unavalaible,due to LOL")}
};

public static void main(String[] args) {
	new ChatBot();
}

public ChatBot() {
	super("Chat Bot");
	setSize(600,400);
	setResizable(false);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	dialog.setEditable(false);
	input.addKeyListener(this);
	
	p.add(scroll);
	p.add(input);
	p.setBackground(new Color(255,200,0));
	add(p);
	
	setVisible(true);
}


public void KeyPressed(KeyEvent e) {
	if(e.getKeyCode()==KeyEvent.VK_ENTER) {
		input.setEditable(false);
		//----Grab the quotes from the textArea
		String qoute=input.getText();
		input.setText("");
		addText("---> You:\t" + qoute);
		qoute=qoute.trim();
		while(qoute.charAt(qoute.length()-1)== '!' ||
				qoute.charAt(qoute.length()-1)== '.' ||
				qoute.charAt(qoute.length()-1)== '?' 
				) {
			qoute=qoute.substring(0,qoute.length()-1);
		}
		qoute=qoute.trim();
		byte response=0;
		/*
		 0:we are searching through chatBot[][] for matches.
		 1: we didnt find anything chatBot [][]
		 2:we did find somethng in chtBot[]	[]
		 	 	 */
		//---Check for matches---
		int j=0; // which group we're searching
		while(response==0) {
			if(inArray(qoute.toLowerCase(),chatBot[j*2])) {
				response=2;
				int r=(int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
				addText("\n-->Simanga\t"+chatBot[(j*2)+1][r]);
				}
			j++;
			if(j*2==chatBot.length-1 && response==0) {
				response=1;
			}
		}
		//---default
		if(response==1) {
			int r=(int)Math.floor(Math.random()*chatBot[chatBot.length-1].length);
			addText("\n-->Simanga\t"+chatBot[chatBot.length-1][r]);
		}
		
		addText("\n");
	}
}
public void KeyReleased(KeyEvent e) {
	if(e.getKeyCode()==KeyEvent.VK_ENTER) {
		input.setEditable(true);
	}
}
public void KeyTyped(KeyEvent e) {
	if(e.getKeyCode()==KeyEvent.VK_ENTER) {
		input.setEditable(true);
	}
	
}

public void addText(String str) {
	dialog.setText(dialog.getText()+ str);
}

public boolean inArray(String in, String[] str) {
	 boolean match=false;
	 for(int i =0; i <str.length;i++) {
		 if(str[i].equals(in)) {
			 match=true;
		 }
	 }
	 return match;
}

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub

	if(e.getKeyCode()==KeyEvent.VK_ENTER) {
		input.setEditable(false);
		//----Grab the quotes from the textArea
		String qoute=input.getText();
		input.setText("");
		addText("---> You:\t" + qoute);
		qoute=qoute.trim();
		while(qoute.charAt(qoute.length()-1)== '!' ||
				qoute.charAt(qoute.length()-1)== '.' ||
				qoute.charAt(qoute.length()-1)== '?' 
				) {
			qoute=qoute.substring(0,qoute.length()-1);
		}
		qoute=qoute.trim();
		byte response=0;
		/*
		 0:we are searching through chatBot[][] for matches.
		 1: we didnt find anything chatBot [][]
		 2:we did find somethng in chtBot[]	[]
		 	 	 */
		//---Check for matches---
		int j=0; // which group we're searching
		while(response==0) {
			if(inArray(qoute.toLowerCase(),chatBot[j*2])) {
				response=2;
				int r=(int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
				addText("\n-->Simanga\t"+chatBot[(j*2)+1][r]);
				}
			j++;
			if(j*2==chatBot.length-1 && response==0) {
				response=1;
			}
		}
		//---default
		if(response==1) {
			int r=(int)Math.floor(Math.random()*chatBot[chatBot.length-1].length);
			addText("\n-->Simanga\t"+chatBot[chatBot.length-1][r]);
		}
		
		addText("\n");
	}
	
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	if(e.getKeyCode()==KeyEvent.VK_ENTER) {
		input.setEditable(true);
	}
	
}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	if(e.getKeyCode()==KeyEvent.VK_ENTER) {
		input.setEditable(true);
	}
}

}
