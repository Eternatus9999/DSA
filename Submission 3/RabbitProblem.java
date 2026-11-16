// Rabbit problem (Fibonacci breeding model):
// A pair of rabbits matures after 1 month and produces a new pair every month
// thereafter. Starting with 1 newborn pair, how many pairs after n months?
//   Month n: f(n) = f(n-1) + f(n-2),  f(1) = f(2) = 1.
public class RabbitProblem {

    // Iterative - O(n), safe for large n
    public static long rabbitPairs(int n) {
        if (n <= 0) return 0;
        long a = 1, b = 1; // f(1), f(2)
        for (int i = 3; i <= n; i++) {
            long next = a + b;
            a = b;
            b = next;
        }
        return (n == 1) ? a : b;
    }

    // Naive recursive version for illustration - O(2^n)
    public static long rabbitPairsRecursive(int n) {
        if (n <= 0) return 0;
        if (n <= 2) return 1;
        return rabbitPairsRecursive(n - 1) + rabbitPairsRecursive(n - 2);
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println("Rabbit pairs after " + n + " months:");
        for (int i = 1; i <= n; i++) {
            System.out.printf("Month %2d: %d pairs%n", i, rabbitPairs(i));
        }
    }
}
