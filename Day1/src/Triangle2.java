
public class Triangle2 {
    private double side1;
    private double side2;
    private double side3;
    public Triangle2(double side1, double side2, double side3) throws IllegalArgumentException {
        if ((side1 + side2) > side3 && (side1 + side3) > side2 && (side2 + side3) > side1){
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        } else {
            throw new IllegalArgumentException("Độ dài 3 cạnh không thỏa mãn");
        }
    }
}
