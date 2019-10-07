package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	ArrayList<Song> songs = new ArrayList<Song>();
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	JButton button = new JButton();
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
		//Song song = new Song("demo.mp3");
		//song.play();
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */

		songs.add(new Song("Citizen Way - WaveWalker (Official Lyric Video) ft. Bart Millard.mp3"));
		songs.add(new Song("demo.mp3"));
		songs.add(new Song("Jonas Brothers - Cool (Lyrics).mp3"));
		
		frame.add(panel);
		panel.add(button);
		button.addActionListener(this);
		button.setText("Shuffle");
		frame.setVisible(true);
		frame.pack();
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0; i<songs.size(); i++) {
			Song current=songs.get(i);
			current.stop();
		}
		Random randy = new Random();
		int songNumber = randy.nextInt(songs.size());
		Song played = songs.get(songNumber);
		played.play();
	}
}