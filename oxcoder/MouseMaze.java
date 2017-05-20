import java.sql.SQLSyntaxErrorException;

public class MouseMaze {
    private int startI, startJ; // 入口
    private int endI, endJ; // 出口
    private boolean success = false;

    public void display(int[][] maze){
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 2) {
                    System.out.print("██");
                } else if (maze[i][j] == 1) {
                    System.out.print(" @");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) { // 迷宫2表示墙 ，@表示出口和入口，0表示可走
        int[][] maze = { { 2, 2, 2, 2, 2, 2, 2 }, { 1, 0, 0, 0, 0, 0, 2 },
                { 2, 0, 2, 0, 2, 0, 2 }, { 2, 0, 0, 0, 0, 2, 2 },
                { 2, 2, 0, 2, 0, 2, 2 }, { 2, 0, 0, 0, 0, 0, 1 },
                { 2, 2, 2, 2, 2, 2, 2 } };

        System.out.println("显示迷宫：");
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 2) {
                    System.out.print("██");
                } else if (maze[i][j] == 1) {
                    System.out.print(" @");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        MouseMaze mouse = new MouseMaze();
        mouse.setStart(1, 1);
        mouse.setEnd(5, 5);
        //No.2
        //开始写代码，在这里判断小老鼠是否走出了迷宫,并且打印出图形。
        if ( mouse.go(maze) ) {
            System.out.println("可以走出，路径如下:");
            mouse.display(maze);

        } else {

            System.out.println("走不出，所有尝试路径如下:");

            mouse.display(maze);
        }
        //end_code
    }

    public void setStart(int i, int j) {
        this.startI = i;
        this.startJ = j;
    }

    public void setEnd(int i, int j) {
        this.endI = i;
        this.endJ = j;
    }

    public boolean go(int[][] maze) {
        return visit(maze, startI, startJ);
    }

    private boolean visit(int[][] maze, int i, int j) {
//        System.out.println(i+","+j);
        if(i<0||j<0) return false;
        if(success) return true;
        //No.1
        //开始写代码，递归实现老鼠找迷宫路线的功能
        if (i == endI && j == endJ) {
            success =true;
            return true;
        }
        int l0 = maze.length, l1 = maze[0].length;
        int in = (i+1)%l0, ip = (i-1)%l0;
        int jn = (j+1)%l1, jp = (j-1)%l1;
        if (maze[i][j] == 2 ) {
            return ((maze[ip][j]!=2&& visit(maze, ip, j) )
                    || (maze [i] [jp]!=2&&visit(maze, i, jp)));
        }  else if (maze[i][j] == 0|| maze[i][j]==1) {
            maze[i][j] = 1;
//            display(maze);
            return ((maze[in][j]!=2&&visit(maze, in, j))
                    || (maze[i][jn]!=2&&visit(maze, i, jn)));
        }

        return success;
    }

}
//用java代码实现：迷宫中有一只老鼠，要求以最短路径找出迷宫的出口，用2 ██表示迷宫墙壁，1 @表示迷宫的入口和出口，0  表示可以走出迷宫的路径。