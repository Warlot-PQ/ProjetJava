package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;

import Controleur.JeuPlacementControleur;
import Model.Joueur;
import Model.PFs;

class RadioButton extends JRadioButton{
	private PFs monPfs = null;
	
	public RadioButton(String text){
		super(text);
	}
	
	public PFs getPFs(){
		return monPfs;
	}
	public void setPFs(PFs monPFs){
		this.monPfs = monPFs;
	}
}

public class JoueurPlacement extends JeuJoueur {
	private ButtonGroup radioGroup;
	
	public JoueurPlacement(JeuPlacementControleur controleur, Joueur monJoueur){
		super(controleur, monJoueur);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		radioGroup = new ButtonGroup();
		for (PFs o : monJoueur.listerEquipe()){
			JPanel panelPFs = new JPanel();
			panelPFs.setLayout(new FlowLayout());
			
			RadioButton radio = new RadioButton(o.getClasse());
			radio.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					RadioButton monRadioButton = (RadioButton) e.getSource();
					
					getControleur().selectionnerPFs(monRadioButton.getPFs());
				}
			});
			radio.setPFs(o);
			radioGroup.add(radio);
			
			panelPFs.add(radio);
			panelPFs.add(new JLabel(""));
			
			add(panelPFs);
		}
	}
	
	public void indiquerPFsPlace(PFs o){
		 for (Enumeration<AbstractButton> buttons = radioGroup.getElements(); buttons.hasMoreElements();) {
			 AbstractButton button = buttons.nextElement();
			 
			 if (button.isSelected()){
				 button.setForeground(Color.GREEN);
				 return;
			 }
		 }
	}
	
	public JeuPlacementControleur getControleur() {
		return (JeuPlacementControleur) controleur;
	}
}
