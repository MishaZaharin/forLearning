package vector;

public class Vector {
    // variable fields)
    private double x;
    private double y;
    private double z;

    // initialization block
    {
        //now empty
        //x = 0;
        //y = 0;
        //z = 0;
    }

    // constructor)
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static void main(String[] args) {
        Vector[] vectors = Vector.generative(10);
        System.out.println(vectors[0]);
        System.out.println(vectors[1]);
        System.out.println(vectors[0].length());
        System.out.println(vectors[0].scalarProduct(vectors[1]));
        System.out.println(vectors[0].crossProduct(vectors[1]));
        System.out.println(vectors[0].cos(vectors[1]));
        System.out.println(vectors[0].add(vectors[1]));
        System.out.println(vectors[0].subtract(vectors[1]));
    }

    // method length of vector) (extract the root(xx+yy+zz))
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    //method scalar product) (x,y,z) = |x|*x + |y|*y + |z|*z
    public double scalarProduct(Vector vector) {
        return x * vector.x + y * vector.y + z * vector.z;
    }

    // method vector product)
    public Vector crossProduct(Vector vector) {
        return new Vector(
                y * vector.z - z * vector.y,
                z * vector.x - x * vector.z,
                x * vector.y - y * vector.x);
    }

    //method cosine between two vectors
    public double cos(Vector vector) {
        return scalarProduct(vector) / (length() * vector.length());
    }

    //method
    public Vector add(Vector vector) {
        return new Vector(
                x + vector.x,
                y + vector.y,
                z + vector.z);
    }

    //method
    public Vector subtract(Vector vector) {
        return new Vector(
                x - vector.x,
                y - vector.y,
                z - vector.z);
    }

    //method
    public static Vector[] generative(int a) {
        Vector[] vectors = new Vector[a];
        for (int i = 0; i < a; i++) {
            vectors[i] = new Vector(Math.random(), Math.random(), Math.random());
        }
        return vectors;
    }

    @Override
    public String toString() {
        return "VectorArray.VectorArray{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}