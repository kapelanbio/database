
package org.eclipse.emf.examples.extlibrary.start;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ProgressMonitor;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import org.eclipse.emf.examples.extlibrary.Book;
import org.eclipse.emf.examples.extlibrary.Borrower;
import org.eclipse.emf.examples.extlibrary.Lendable;
import org.eclipse.emf.examples.extlibrary.Library;
import org.eclipse.emf.examples.extlibrary.Writer;

public class Gui {
	
	private Library		library	= null;
	private JTextArea	textAreaLibrary;
	private JButton		buttonSave;
	
	public static void main(String[] args) {
		Gui gui = new Gui();
		gui.create();
	}
	
	public JFrame create() {
		final JFrame frame = new JFrame();
		frame.setTitle("Library Sample");
		frame.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
		JButton buttonCreate = new JButton("Create Library");
		buttonCreate.setBounds(0, 0, 150, 30);
		buttonCreate.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Thread thread = new Thread(new Runnable() {
					
					public void run() {
						library = LibraryFactory.instance.create(new ProgressMonitor(frame, "Creating Library...", "", 0, 0));
						// update GUI in AWT thread
						SwingUtilities.invokeLater(new Runnable() {
							
							public void run() {
								fillLibraryTextArea();
							}
						});
						
					}
				});
				thread.start();
			}
			
		});
		frame.add(buttonCreate);
		
		buttonSave = new JButton("Save Library");
		buttonSave.setBounds(150, 0, 150, 30);
		buttonSave.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(((JButton) e.getSource()).isEnabled()) {
					Thread thread = new Thread(new Runnable() {
						
						public void run() {
							LibraryFactory.instance.save(new ProgressMonitor(frame, "Saving Library...", "", 0, 0), library);
							JOptionPane.showMessageDialog(frame, "Library saved.");
						}
					});
					thread.start();
				}
			}
			
		});
		buttonSave.setEnabled(false);
		frame.add(buttonSave);
		
		JButton buttonLoad = new JButton("Load Library");
		buttonLoad.setBounds(300, 0, 150, 30);
		buttonLoad.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Thread thread = new Thread(new Runnable() {
					
					public void run() {
						library = LibraryFactory.instance.load(new ProgressMonitor(frame, "Loading Library...", "", 0, 0));
						// update GUI in AWT thread
						SwingUtilities.invokeLater(new Runnable() {
							
							public void run() {
								fillLibraryTextArea();
							}
						});
						
					}
				});
				thread.start();
			}
			
		});
		frame.add(buttonLoad);
		
		textAreaLibrary = new JTextArea();
		textAreaLibrary.setBounds(0, 30, 450, 250);
		frame.add(textAreaLibrary);
		
		final JLabel labelMemory = new JLabel();
		labelMemory.setBounds(0, 280, 450, 30);
		labelMemory.setText(getUsedMemory());
		frame.add(labelMemory);
		
		Timer timer = new Timer(1000, new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				labelMemory.setText(getUsedMemory());
			}
		});
		timer.start();
		
		frame.setSize(450 + buttonCreate.getInsets().right, 350);
		frame.setLayout(null);
		frame.setVisible(true);
		
		fillLibraryTextArea();
		
		return frame;
	}
	
	private void fillLibraryTextArea() {
		if(library != null) {
			buttonSave.setEnabled(true);
			textAreaLibrary.setForeground(Color.BLACK);
			textAreaLibrary.setText(null);
			textAreaLibrary.append("No. of books: " + library.getBooks().size() + "\n");
			textAreaLibrary.append("No. of writers: " + library.getWriters().size() + "\n");
			textAreaLibrary.append("No. of borrowers: " + library.getBorrowers().size() + "\n");
			
			Writer writerRandom = library.getWriters().get((int) (Math.random() * (library.getWriters().size() - 1)));
			textAreaLibrary.append(writerRandom.getFirstName() + " " + writerRandom.getLastName() + " wrote " + writerRandom.getBooks().size() + " books.\n");
			
			Borrower borrowerRandom = library.getBorrowers().get((int) (Math.random() * (library.getBorrowers().size() - 1)));
			textAreaLibrary.append(borrowerRandom.getFirstName() + " " + borrowerRandom.getLastName() + ":\nBorrowed Books:\n");
			for(Lendable lendable: borrowerRandom.getBorrowed())
				if(lendable instanceof Book)
					textAreaLibrary.append("\t" + ((Book) lendable).getTitle() + "\n");
				
		} else {
			buttonSave.setEnabled(false);
			textAreaLibrary.setForeground(Color.RED);
			textAreaLibrary.setText(null);
			textAreaLibrary.setText("No library created or loaded.");
		}
	}
	
	private String getUsedMemory() {
		return "Memory Usage: " + (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024 + " MB";
	}
}
