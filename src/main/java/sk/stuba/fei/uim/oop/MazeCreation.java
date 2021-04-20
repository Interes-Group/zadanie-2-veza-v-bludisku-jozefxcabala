package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.Random;
import java.util.Stack;

public class MazeCreation {
    @Setter @Getter private MazeCell[][] maze;
    @Setter @Getter private int row;
    @Setter @Getter private int col;

    MazeCreation(int row, int col){
        this.row = row;
        this.col = col;
        this.maze = new MazeCell[getRow()+2][getCol()+2];
        createMazeCells();
        createMaze();
    }

    private void createMazeCells(){
        for (int i = 0; i < getRow() + 2; ++i)
            for (int j = 0; j < getCol() + 2; ++j)
                this.maze[i][j] = new MazeCell();
    }

    private void createMaze(){
        rdfsCreateMaze();
    }

    private boolean isOutOfBorder(int x, int y, int colNumber, int rowNumber) {
        if ((x == 0 && y == 1) || (x == colNumber + 1 && y == rowNumber))
            return false;
        else
            return x > colNumber || y > rowNumber || x < 1 || y < 1;
    }

    private Point ArroundPoint(MazeCell[][] maze, Point p, Random rand, int colNumber,
                                 int rowNumber) {
        final int[] arroundPoint = { -2, 0, 2, 0, -2 };
        int r = rand.nextInt(4);
        for (int i = 0; i < 4; ++i) {
            int j = r % 4;
            int x = p.x + arroundPoint[j];
            int y = p.y + arroundPoint[j + 1];
            ++r;
            if (!isOutOfBorder(x, y, colNumber, rowNumber) && !maze[y][x].isPassable()) {
                maze[y][x].setPassable(true);
                maze[p.y + arroundPoint[j + 1] / 2][p.x + arroundPoint[j] / 2].setPassable(true);
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
        currentPoint = ArroundPoint(getMaze(), currentPoint, rand, getCol(), getRow());
        while (true) {
            Point p = ArroundPoint(getMaze(), currentPoint, rand, getCol(), getRow());
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
