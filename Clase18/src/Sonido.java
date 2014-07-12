import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.ProgressBarUI;


public class Sonido implements ActionListener{

	JFrame ventana;
	JPanel panel;
	JButton play;
	Clip sonido;
	
	
	public void crearBotones(){
		panel = new JPanel();
		panel.setSize(120,120);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		play = new JButton();
		play.setSize(100,100);
		play.setText("Play");
		panel.add(play);
		
		
	}
	
	public void ejecutarAudio() throws IOException, UnsupportedAudioFileException,InterruptedException {
		
		try {
			sonido = AudioSystem.getClip();
			//File archivo = new File("allwrong.wav");
			File archivo = new File("/Users/jose/Desktop/allwrong.wav");
			
			sonido.open(AudioSystem.getAudioInputStream(archivo));
			sonido.start();
			
			Thread.sleep(1000);
			sonido.close();
		
		
			
			
			
		} catch (LineUnavailableException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		
	}
	
	
	public void crearVentana(){
		ventana = new JFrame();
		ventana.setLayout(new BoxLayout(ventana.getContentPane(), BoxLayout.Y_AXIS));
		ventana.setTitle("Clase 18");
		ventana.setSize(600,600);
		play.addActionListener(this);
		ventana.add(panel);
		ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		
		
	}
	
	
	public Sonido(){
		crearBotones();
		crearVentana();
	}
	
	public static void main(String[] arg){
		Sonido ventana = new Sonido();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==play){
			try {
				ejecutarAudio();
			} catch (IOException| UnsupportedAudioFileException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
