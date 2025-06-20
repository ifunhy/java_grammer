package C02ClassBasic;

public class C12RecursivePractice {
    public static void main(String[] args) {
        // for문으로 1~10까지 누적합계
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println(sum);

        // 재귀함수로 1~10까지 누적합계
        System.out.println(sumAcc(1,10));

        // 재귀함수로 factorial값 구하기 : 1 ~ n까지를 모두 곱한 값
        System.out.println(factorial(5));   // 1*2*3*4*5 = 120

        // 피보나치 수열 : f(n-1) + f(n-2) = f(n)
        // 1 1 2 3 5 8 13 21 34 ...
        // 피보나치 수열의 10번째 값은?
        // 풀이1 : 재귀
        System.out.println(fibonacci(10));

        // 풀이2: dp알고리즘(기억하기(메모이제이션) 알고리즘)을 활용한 풀이법
        // 앞의 연산을 기억해놨다가 참고하는 것
        System.out.println(fibonacciDP(10));
    }

    public static int sumAcc(int n, int target) {
        if(n > target)
            return 0;

        return (n + sumAcc(n+1, target));
    }

    public static int factorial(int n) {
        if(n == 1)
            return 1;

        return (n * factorial(n-1));
    }

    public static int fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        return fibonacci(n-1) + fibonacci(n-2);

    }

    public static int fibonacciDP(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < n; i++)
            arr[i] = arr[i-1] + arr[i-2];
        return (arr[n-1]);
    }
}
