package GUI;

import java.util.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Controleur.FenetreControleur;
import Controleur.ParamJoueurControleur;
import Model.PFs;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


//TODO mettre en place le controleur sur ParamJoueur, enlever l'acces direct sur FenetreControleur
public class ParamJoueur extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ParamJoueurControleur controleur;
	
	private JLabel labelNomJoueur = new JLabel();
	private JLabel labelPFsRestant = new JLabel("X places");
	private JLabel labelPFsTotal = new JLabel("X disponibles");
	
	private JPanel panelPFsTous = new JPanel();
	private JPanel panelPFsChoisi = new JPanel();
	private JButton boutonSuivant;
	
	public ParamJoueur(FenetreControleur controleurParent, final String nomJ){
		this.controleur = new ParamJoueurControleur(this, controleurParent);
		this.labelNomJoueur.setText(nomJ);
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Component horizontalStrut = Box.createHorizontalStrut(40);
		add(horizontalStrut);
		
		JPanel body = new JPanel();
		add(body);
		body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
		
		Component verticalStrut = Box.createVerticalStrut(40);
		body.add(verticalStrut);
		
		body.add(labelNomJoueur);
		labelNomJoueur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JPanel panel = new JPanel();
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		body.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel1 = new JPanel();
		panel.add(panel1);
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel1.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("Composer votre \u00E9quipe : ");
		panel_1.add(lblNewLabel);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		//majLabelPlaceRestante();
		panel_1.add(labelPFsRestant);
		
		panelPFsChoisi.setBorder(new LineBorder(new Color(0, 0, 0)));
		JScrollPane panelScrollPFsChoisi = new JScrollPane(panelPFsChoisi);
		panel1.add(panelScrollPFsChoisi);
		
		JPanel panel2 = new JPanel();
		panel.add(panel2);
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		
		JPanel panel_2Info = new JPanel();
		panel2.add(panel_2Info);
		panel_2Info.setLayout(new BoxLayout(panel_2Info, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_1 = new JLabel("Tous les PFs : ");
		panel_2Info.add(lblNewLabel_1);
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		panel_2Info.add(labelPFsTotal);

		panelPFsTous.setBorder(new LineBorder(new Color(0, 0, 0)));
		JScrollPane panelScrollPFsTous = new JScrollPane(panelPFsTous);
		panel2.add(panelScrollPFsTous);
		
		listerPFsDisponible();
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		panel2.add(rigidArea);
		
		boutonSuivant = new JButton("Suivant");
		boutonSuivant.addActionListener(new ActionListener() {
			//TODO placer dans le controleur
			public void actionPerformed(ActionEvent e) {
				getControleur().suivant();
			}
		});
		boutonSuivant.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel2.add(boutonSuivant);
		
		Component verticalStrut_1 = Box.createVerticalStrut(40);
		body.add(verticalStrut_1);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(40);
		add(horizontalStrut_1);
		
	}
		
	private void listerPFsDisponible(){
		List<PFs> collectionPFs = getControleur().getCollectionPFs();
		
		labelPFsTotal.setText(Integer.toString(collectionPFs.size()) + " disponibles");
		
		for(PFs o : collectionPFs){
			LayeredPanePFs monLayeredPanePFs = new LayeredPanePFs(controleur, o);
			monLayeredPanePFs.ajouterBoutonAjout();
			
			panelPFsTous.add(monLayeredPanePFs);
		}
	}
	
	public void ajouterPanelPFsChoisi(LayeredPanePFs o){
		panelPFsChoisi.add(o);	
	}
	
	public void suprimerPanelPFsChoisi(LayeredPanePFs o){
		(o.getParent()).remove(o);
	}
	
	public void majLabelPlaceRestante(int tailleEquipeTotal, int tailleEquipe){
		labelPFsRestant.setText(Integer.toString(tailleEquipeTotal - tailleEquipe) + " places");
	}
	
	private ParamJoueurControleur getControleur(){
		return controleur;
	}

	/**
	 * @return the panelPFsTous
	 */
	public JPanel getPanelPFsTous() {
		return panelPFsTous;
	}

	/**
	 * @return the panelPFsChoisi
	 */
	public JPanel getPanelPFsChoisi() {
		return panelPFsChoisi;
	}
}
abstract class LabelBouton extends JLabel{
	protected ParamJoueurControleur controleur = null;
	
	private int boutonImageWidth = 30;
	private int boutonImageHeight = 30;
	
	public LabelBouton(ParamJoueurControleur controleur){
		super();
		this.controleur = controleur;
		
		setBounds(0, 20, boutonImageWidth, boutonImageHeight);
		setVisible(false);
	}
	
	public void mouseExited(MouseEvent e){
		setVisible(false);
	}
	
	public  void mouseEntered(MouseEvent e){
		setVisible(true);
	}
	
	public abstract void mouseClicked(MouseEvent e);
}

class LabelBoutonAjouter extends LabelBouton{
	public LabelBoutonAjouter(ParamJoueurControleur controleur){
		super(controleur);
		
		setIcon(new ImageIcon(this.getClass().getResource("/images/Add.png")));
	}
	
	public void mouseClicked(MouseEvent e){
		LayeredPanePFs parent = (LayeredPanePFs) e.getComponent();

		if (parent instanceof LayeredPanePFs){
			controleur.ajouterPFs(
					parent.getPFs()
					);
		}
	}
}

class LabelBoutonSupprimer extends LabelBouton{
	public LabelBoutonSupprimer(ParamJoueurControleur controleur){
		super(controleur);
		
		setIcon(new ImageIcon(this.getClass().getResource("/images/Sup.png")));
	}
	
	public void mouseClicked(MouseEvent e){
		Component parent = e.getComponent();

		if (parent instanceof LayeredPanePFs){
			controleur.supprimerPFs(
					(LayeredPanePFs) parent
					);
		}
	}
}

