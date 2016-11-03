/**
 * 
 */
package aIAD_REPAST;

import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.grid.Grid;

/**
 * @author Joao Pascoal Faria
 *
 */
public class MiningNode {
	
	private ContinuousSpace<Object> space;
	private Grid<Object> grid;
	private Resource resource;
	private int amount;
	private boolean dangerous;
	private boolean scanned;
	
	public MiningNode(ContinuousSpace<Object> space, Grid<Object> grid, Resource resource, int amount, boolean dangerous){
		this.space = space;
		this.grid = grid;
		this.resource = resource;
		this.amount = amount;
		this.dangerous = dangerous;
		this.scanned = false;
	}
	
	public void scan() {
		this.scanned = true;
	}

	public Resource getResource() {
		return resource;
	}

	public int getAmount() {
		return amount;
	}

	public boolean isDangerous() {
		return dangerous;
	}
	
	public boolean alreadyScanned() {
		return scanned;
	}
}
