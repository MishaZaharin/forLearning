public class SimpleOfClass {
    class Point {
        private int x; // closed by private
        private int y; // closed by private

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() { // public the getter, can return
            return x;
        }

        public void setX(int x) { // public the setter, can't return, can set. ('!pay attention about VOID!')
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
