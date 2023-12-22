package finalproject;

import java.util.ArrayList;

import finalproject.system.Tile;

public class FastestPath extends PathFindingService {
    //TODO level 6: find time prioritized path
    public FastestPath(Tile start) {
        super(start);
        generateGraph();
    }

    @Override
    public void generateGraph() {
        // TODO Auto-generated method stub
        // Create a Graph with all the Graph's methods you have already implemented before
        g = new Graph(new ArrayList<>());

        // This new Graph should contain all reachable Tiles from the source Tile
        ArrayList<Tile> reachableTiles = GraphTraversal.DFS(source);

        for (Tile tile : reachableTiles) {
            g.tiles.add(tile);
        }

        // There is an edge between two Tiles of this new Graph if the Tiles are adjacent and both Tiles are walkable.
        for (Tile tile : reachableTiles) {
            for (Tile neighbor : tile.neighbors) {
                if (neighbor.isWalkable()) {
                    double weight = g.calculateEdgeWeightTimeCost(tile, neighbor);
                    // The weight of the edge is the time cost of the destination tile
                    g.addEdge(tile, neighbor, weight);
                }
            }
        }

    }

}
