import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Check for Arithmetic Progression
        int diff = arr[1] - arr[0];
        boolean isAP = true;

        for (int i = 2; i < n; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                isAP = false;
                break;
            }
        }

        if (isAP) {
            System.out.println(arr[n - 1] + diff);
        } else {
            int ratio = arr[1] / arr[0];
            System.out.println(arr[n - 1] * ratio);
        }

        sc.close();
    }
}
