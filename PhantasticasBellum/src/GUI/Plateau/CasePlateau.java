package GUI.Plateau;

import javax.swing.JButton;

import Model.PFs;

public class CasePlateau extends JButton {
	private int xPlateau = 0;
	private int yPlateau = 0;
	private PFs monPFs = null;
	
	public CasePlateau(final int x, final int y){
		super(x + " " + y);
		this.xPlateau = x;
		this.yPlateau = y;
	}
	
	public int getXPlateau() {
		return xPlateau;
	}
	public void setXPlateau(int x) {
		this.xPlateau = x;
	}
	public int getYPlateau() {
		return yPlateau;
	}
	public void setYPlateau(int y) {
		this.yPlateau = y;
	}
	public PFs getMonPFs() {
		return monPFs;
	}
	public void setMonPFs(PFs monPFs) {
		this.monPFs = monPFs;
	}
}
