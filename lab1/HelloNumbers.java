public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
        while (x < 10) {
            int sum = 0;
            int y = 0;
            while(y <= x) {
                sum = sum + y;
                y = y + 1;
            }
            System.out.print(sum + " ");
            x = x + 1;
        }
        System.out.println("");
    }
}