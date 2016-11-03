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
public class ResourcePack {

	private ContinuousSpace<Object> space;
	private Grid<Object> grid;
	private Resource resource;
	private int amount;
	
	public ResourcePack(ContinuousSpace<Object> space, Grid<Object> grid, Resource resource, int amount){
		this.space = space;
		this.grid = grid;
		this.resource = resource;
		this.amount = amount;
	}
}
