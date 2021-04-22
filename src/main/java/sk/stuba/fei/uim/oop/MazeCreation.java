package sk.stuba.fei.uim.oop;

import lombok.Getter;
import java.awt.*;
import java.util.Random;
import java.util.Stack;

public class MazeCreation{
    @Getter private final MazeCell[][] maze;
    @Getter private final int row;
    @Getter private final int col;

    MazeCreation(int row, int col, Maze maze){
        this.row = row;
        this.col = col;
        this.maze = new MazeCell[getRow()+2][getCol()+2];

        createMaze(maze);
    }

    private void createMazeCells(Maze maze){
        for (int i = 0; i < getRow() + 2; ++i)
            for (int j = 0; j < getCol() + 2; ++j) {
                this.maze[i][j] = new MazeCell(maze);
                this.maze[i][j].getCoordination().setLocation(i, j);
            }
    }

    private void findPossibleRoutes(){
        for(int i = 1; i < this.row + 1; i++){
            for(int j = 1; j < this.col + 1; j++){
                findPossibleRoute(1,0,i,j);
                findPossibleRoute(-1,0,i,j);
                findPossibleRoute(0,1,i,j);
                findPossibleRoute(0,-1,i,j);
            }
        }
    }

    private void findPossibleRoute(int x, int y , int i, int j){
        int xL = 0;
        int yL = 0;
        while(this.maze[i + (xL*x)][j + (yL*y)].isPassable()){
            xL = xL + 1;
            yL = yL + 1;
            if(this.maze[i + (xL*x)][j + (yL*y)].isPassable()) {
                this.maze[i][j].getPossibleRoutes().add(this.maze[i + (xL*x)][j + (yL*y)]);
            }
        }
    }

    private void createMaze(Maze maze){
        createMazeCells(maze);
        rdfsCreateMaze();
        findPossibleRoutes();
    }

    private boolean isOutOfBorder(int x, int y, int colNumber, int rowNumber) {
        if ((x == 0 && y == 1) || (x == colNumber + 1 && y == rowNumber))
            return false;
        else
            return x > (colNumber) || y > (rowNumber) || x < 1 || y < 1;
    }

    private Point AroundPoint(MazeCell[][] maze, Point p, Random rand, int colNumber,
                                 int rowNumber) {
        final int[] aroundPoint = { -2, 0, 2, 0, -2 };
        int r = rand.nextInt(4);
        for (int i = 0; i < 4; ++i) {
            int j = r % 4;
            int x = p.x + aroundPoint[j];
            int y = p.y + aroundPoint[j + 1];
            ++r;
            if (!isOutOfBorder(x, y, colNumber, rowNumber) && !maze[y][x].isPassable()) {
                maze[y][x].setPassable(true);
                maze[p.y + aroundPoint[j + 1] / 2][p.x + aroundPoint[j] / 2].setPassable(true);
                return new Point(x, y);
            }
        }
        return null;
    }

    private void rdfsCreateMaze() {
        Random rand = new Random();
        Point currentPoint = new Point(2 * rand.nextInt(getCol() / 2) + 1, 2 * rand.nextInt(getRow() / 2) + 1);
        getMaze()[currentPoint.y][currentPoint.x].setPassable(true);
        Stack<Point> pathStack = new Stack<>();
        pathStack.push(currentPoint);
        currentPoint = AroundPoint(getMaze(), currentPoint, rand, getCol(), getRow());
        while (true) {
            Point p = AroundPoint(getMaze(), currentPoint, rand, getCol(), getRow());
            if (p != null) {
                pathStack.push(currentPoint);
                currentPoint = p;
            } else if (!pathStack.isEmpty())
                currentPoint = pathStack.pop();
            else
                break;
        }
    }
}
