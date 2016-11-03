/**
 * 
 */
package aIAD_REPAST;

import java.util.ArrayList;
import java.util.List;

import repast.simphony.context.Context;
import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.query.space.grid.GridCell;
import repast.simphony.query.space.grid.GridCellNgh;
import repast.simphony.random.RandomHelper;
import repast.simphony.space.SpatialMath;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.continuous.NdPoint;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;
import repast.simphony.util.ContextUtils;
import repast.simphony.util.SimUtilities;

/**
 * @author Joao Pascoal Faria
 *
 */
public class Producer {

	private ContinuousSpace<Object> space;
	private Grid<Object> grid;
	
	public Producer(ContinuousSpace<Object> space,Grid<Object> grid){
		this.space = space;
		this.grid = grid;
	}
	
	@ScheduledMethod ( start = 1 , interval = 1)
	public void step() {

		GridPoint pt = grid.getLocation(this);
		GridCellNgh<MiningNode> nghCreator = new GridCellNgh<MiningNode>(grid, pt, MiningNode.class, 1, 1);
		List<GridCell<MiningNode>> gridCells = nghCreator.getNeighborhood(true);
		SimUtilities.shuffle(gridCells, RandomHelper.getUniform());

		GridPoint pointWithMostMiningNodes = gridCells.get(RandomHelper.nextIntFromTo(0, gridCells.size()-1)).getPoint();
		int maxCount = -1;
		for (GridCell<MiningNode> cell : gridCells) {
			if (cell.size() > maxCount) {
				pointWithMostMiningNodes = cell.getPoint();
				maxCount = cell.size();
			}
		}
		moveTowards(pointWithMostMiningNodes);
	}
	
	public void moveTowards(GridPoint pt) {
		// only move if we are not already in this grid location
		if (!pt.equals(grid.getLocation(this))) {
			NdPoint myPoint = space.getLocation(this);
			NdPoint otherPoint = new NdPoint(pt.getX(), pt.getY());
			double angle = SpatialMath.calcAngleFor2DMovement(space, myPoint, otherPoint);
			space.moveByVector(this, 1, angle, 0);
			myPoint = space.getLocation(this);
			grid.moveTo(this, (int) myPoint.getX(), (int) myPoint.getY());
		}
	}
	
	/**
	 * @description mines random miningNode in the place the producer is
	 */
	public void mine() {
		GridPoint pt = grid.getLocation(this);
		List<Object> miningnodes = new ArrayList<Object>();
		for (Object obj : grid.getObjectsAt(pt.getX(), pt.getY())) {
			if (obj instanceof MiningNode) {
				miningnodes.add(obj);
			}
		}
		if (miningnodes.size() > 0) {
			int index = RandomHelper.nextIntFromTo(0, miningnodes.size()-1);
			Object obj = miningnodes.get(index);
			NdPoint spacePt = space.getLocation(obj);
			@SuppressWarnings("unchecked") Context<Object> context = ContextUtils.getContext(obj);
			context.remove(obj);
			ResourcePack pack = new ResourcePack(space, grid, ((MiningNode)obj).getResource(), ((MiningNode)obj).getAmount());
			context.add(pack);
			space.moveTo(pack, spacePt.getX(), spacePt.getY());
			grid.moveTo(pack, pt.getX(), pt.getY());
		}
	}
}
