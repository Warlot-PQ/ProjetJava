package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.*;

import Controleur.*;

public class ParamJeu extends JPanel {
	private FenetreControleur controleur;
	private JSlider sliderEquipeTaille = new JSlider();
	private JSlider sliderPlateauLongueur = new JSlider();
	private JSlider sliderPlateauLargeur = new JSlider();
	private JLabel labelEquipeTaille = new JLabel();
	private JLabel labelPlateauLongueur = new JLabel();
	private JLabel labelPlateauLargeur = new JLabel();

	public ParamJeu(FenetreControleur controleur){
		this.controleur = controleur;
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel BoxWrapper = new JPanel();
		add(BoxWrapper);
		BoxWrapper.setLayout(new BoxLayout(BoxWrapper, BoxLayout.Y_AXIS));
		
		Component verticalGlue = Box.createVerticalGlue();
		BoxWrapper.add(verticalGlue);
		
		JPanel Flow = new JPanel();
		BoxWrapper.add(Flow);
		
		JPanel BoxWrapped = new JPanel();
		Flow.add(BoxWrapped);
		BoxWrapped.setLayout(new BoxLayout(BoxWrapped, BoxLayout.Y_AXIS));
		
		JPanel panelEquipe = new JPanel();
		BoxWrapped.add(panelEquipe);
		panelEquipe.setLayout(new BoxLayout(panelEquipe, BoxLayout.Y_AXIS));
		
		JPanel equipePanelText = new JPanel();
		panelEquipe.add(equipePanelText);
		equipePanelText.setLayout(new BoxLayout(equipePanelText, BoxLayout.X_AXIS));
		
		JLabel equipeText = new JLabel("Choisir taille equipe : ");
		equipePanelText.add(equipeText);
		
		labelEquipeTaille.setText("3");
		equipePanelText.add(labelEquipeTaille);
		
		JLabel equipeTextBis = new JLabel(" joueurs");
		equipePanelText.add(equipeTextBis);
		
		JPanel equipePanelSlider = new JPanel();
		panelEquipe.add(equipePanelSlider);
		equipePanelSlider.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		sliderEquipeTaille.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//Met à jour le text au dessus du slider
				String nouvelleTaille = Integer.toString(sliderEquipeTaille.getValue());
				labelEquipeTaille.setText(nouvelleTaille);
				//Met à jour les minimums des sliders de la taille du plateau
				//TODO MAJ Slider Plateau
			}
		});
		sliderEquipeTaille.setValue(2);
		sliderEquipeTaille.setMinimum(1);
		sliderEquipeTaille.setMaximum(5);
		equipePanelSlider.add(sliderEquipeTaille);
		
		JPanel panelPlateau = new JPanel();
		BoxWrapped.add(panelPlateau);
		panelPlateau.setLayout(new BoxLayout(panelPlateau, BoxLayout.Y_AXIS));
		
		JPanel plateauPanelText = new JPanel();
		panelPlateau.add(plateauPanelText);
		plateauPanelText.setLayout(new BoxLayout(plateauPanelText, BoxLayout.X_AXIS));
		
		JLabel plateauText = new JLabel("Choisir taille plateau : ");
		plateauPanelText.add(plateauText);
		
		labelPlateauLongueur.setText("longueur");
		plateauPanelText.add(labelPlateauLongueur);
		
		JLabel plateauTextBis = new JLabel(" x ");
		plateauPanelText.add(plateauTextBis);
		
		labelPlateauLargeur.setText("largeur");
		plateauPanelText.add(labelPlateauLargeur);
		
		JPanel PlateauSlider = new JPanel();
		panelPlateau.add(PlateauSlider);
		sliderPlateauLongueur.setMaximum(10);
		sliderPlateauLongueur.setValue(5);
		sliderPlateauLongueur.setMinorTickSpacing(20);
		sliderPlateauLongueur.setMinimum(1);
		PlateauSlider.add(sliderPlateauLongueur);
		sliderPlateauLongueur.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//Met à jour le text au dessus du slider
				String nouvelleTaille = Integer.toString(sliderPlateauLongueur.getValue());
				labelPlateauLongueur.setText(nouvelleTaille);
			}
		});
		
		JLabel x = new JLabel("x");
		PlateauSlider.add(x);
		sliderPlateauLargeur.setMaximum(10);
		sliderPlateauLargeur.setValue(5);
		sliderPlateauLargeur.setMinorTickSpacing(20);
		sliderPlateauLargeur.setMinimum(1);
		PlateauSlider.add(sliderPlateauLargeur);
		sliderPlateauLargeur.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//Met à jour le text au dessus du slider
				String nouvelleTaille = Integer.toString(sliderPlateauLargeur.getValue());
				labelPlateauLargeur.setText(nouvelleTaille);
			}
		});
		
		JPanel panelBouton = new JPanel();
		BoxWrapped.add(panelBouton);
		
		JButton buttonContinue = new JButton("Suivant");
		buttonContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getControleur().continueParamJeu(
						sliderEquipeTaille.getValue(), 
						sliderPlateauLongueur.getValue(),
						sliderPlateauLargeur.getValue()
						);
			}
		});
		panelBouton.add(buttonContinue);
	}
	
	private FenetreControleur getControleur(){
		return controleur;
	}
}
