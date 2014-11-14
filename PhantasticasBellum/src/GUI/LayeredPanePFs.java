package GUI;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import Controleur.ParamJoueurControleur;
import Model.PFs;

public class LayeredPanePFs extends JLayeredPane{
	private ParamJoueurControleur controleur = null;
	private PFs monPfs = null;
	
	private int PFsImageWidth = 120;
	private int PFsImageHeight = 150;
	private int PFsNameHeight = 20;
	private int LayeredPanePFsWidth = 120;
	private int LayeredPanePFsHeight = PFsNameHeight + PFsImageHeight;

	public LayeredPanePFs(ParamJoueurControleur controleur, PFs monPFs){
		super();
		this.controleur = controleur;
		
		setLayout(null);
		setPreferredSize(new Dimension(LayeredPanePFsWidth, LayeredPanePFsHeight));
		setPFs(monPFs);
		
		JLabel labelNom = new JLabel();
		labelNom.setBounds(0, 0, LayeredPanePFsWidth, PFsNameHeight);
		labelNom.setText(monPFs.getClasse());

		JLabel labelImage = new JLabel(monPFs.getImage());
		labelImage.setBounds(0, PFsNameHeight, PFsImageWidth, PFsImageHeight);
		
		add(labelNom, new Integer(0), 0);
		add(labelImage, new Integer(0), 0);
	}
	
	public void ajouterBoutonAjout(){
		LabelBoutonAjouter monLabelBouton = new LabelBoutonAjouter(controleur);
		ajouterBouton(monLabelBouton);
	}

	public void ajouterBoutonSup(){
		LabelBoutonSupprimer monLabelBouton = new LabelBoutonSupprimer(controleur);
		ajouterBouton(monLabelBouton);
	}
	
	public void ajouterBouton(final LabelBouton monLabelBouton){
		add(monLabelBouton, new Integer(1), 0);
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
				monLabelBouton.mouseExited(e);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
				monLabelBouton.mouseEntered(e);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				monLabelBouton.mouseClicked(e);
			}
		});
	}
	
	public PFs getPFs(){
		return monPfs;
	}
	public void setPFs(PFs monPFs){
		this.monPfs = monPFs;
	}
}