package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class _02_LogSearch implements ActionListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	HashMap<Integer, String> hash = new HashMap<Integer, String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton();
	JButton search = new JButton();
	JButton list = new JButton();
	JButton remove = new JButton();
	public static void main(String[] args) {
		_02_LogSearch yeeted = new _02_LogSearch();
		yeeted.doStuff();
	}
	void doStuff() {
		frame.add(panel);
		panel.add(add);
		panel.add(search);
		panel.add(list);
		add.addActionListener(this);
		search.addActionListener(this);
		list.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(add)) {
			String id = JOptionPane.showInputDialog("What ID should this be (a number)");
			int ID = Integer.parseInt(id);
			String name = JOptionPane.showInputDialog("What name would you like this to be?");
			hash.put(ID, name);
		}else if(e.getSource().equals(search)) {
			String wantedID = JOptionPane.showInputDialog("What ID do you want to look up?");
			int IDWanted = Integer.parseInt(wantedID);
			boolean found=false;
			for(int i=0; i<hash.size(); i++) {
				if(hash.containsKey(i)) {
					found=true;
					JOptionPane.showMessageDialog(null, "The person at that key is "+hash.get(i));
				}
			}
			if(!found) {
				JOptionPane.showMessageDialog(null, "Oh no! That key doesn't exist!", "OOF", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource().equals(list)) {
			//NEED TO FINISH THE LIST THEN THE REMOVE!!!
		}
	}
}
