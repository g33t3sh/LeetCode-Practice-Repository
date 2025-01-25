import java.util.Random;
public class Solution {
    private double radius;
    private double x_center;
    private double y_center;
    private Random random;
    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        this.random = new Random();
    }
    public double[] randPoint() {
        double angle = 2 * Math.PI * random.nextDouble();
        double r = radius * Math.sqrt(random.nextDouble()); 
        double x = x_center + r * Math.cos(angle);
        double y = y_center + r * Math.sin(angle);
        return new double[]{x, y}; 
    }
    public static void main(String[] args) {
        Solution solution = new Solution(1.0, 0.0, 0.0); 
        for (int i = 0; i < 10; i++) {
            double[] point = solution.randPoint();
            System.out.printf("Random Point %d: (%.5f, %.5f)%n", i + 1, point[0], point[1]);
        }
    }
}