class SnakeGame {
    // Position of the snake head;
    int x, y;
    Queue<int[]> body;
    int[][] food;
    int curFood;
    int width, height;
    int point;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
        public SnakeGame(int width, int height, int[][] food) {
            this.width = width;
            this.height = height;
            this.x = 0;
            this.y = 0;
            this.food = food;
            this.curFood = 0;
            this.point = 0;
            this.body = new LinkedList<>();
            body.offer(new int[]{x, y});
        }

    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
        public int move(String direction) {
            switch(direction) {
                case "U": x--;
                break;
                case "L": y--;
                break;
                case "R": y++;
                break;
                case "D": x++;
                break;
                default:
            }
            // Reached the border
            if (x < 0 || y < 0 || x >= height || y >= width) return -1;
            // Obtained food.
            if (curFood < food.length && x == food[curFood][0] && y == food[curFood][1]) {
                point++;
                curFood++;
                body.offer(new int[]{x, y});
            } else {
                body.poll();
                for (int[] pos : body) {
                    //crash body
                    if (pos[0] == x && pos[1] == y) {
                        return -1;
                    }
                }
                body.offer(new int[]{x, y});
            }
            return point;
        }

    }

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
