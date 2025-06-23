//package C01Basic;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
//public class C01InputOutput {
//    public static void main(String[] args) throws IOException {
//        // 출력 : System.out을 통해 콘솔 출력
//        System.out.println(20); // 줄바꿈 있는 출력
//        System.out.print("hello world");    // 줄바꿈 없는 출력
//        System.out.print("hello world2\n");
//
//        // 입력 : Scanner + System.in
//        // Scanner 클래스 : 입력을 위한 클래스
//        // System.in : 키보드 입력
//        Scanner myScanner = new Scanner(System.in);
//        String input = myScanner.nextLine();   // 입력 받은 데이터를 한 줄로 읽고, String으로 리턴
//        System.out.println("입력사항 : " + input);
//
//        // 예를 들어 아래와 같은 입력값이 주어질 때 처리 방법
//        /*
//         abc
//         bcd
//         2
//        * */
//        Scanner myScanner2 = new Scanner(System.in);
//        String input1 = myScanner2.nextLine();
//        String input2 = myScanner2.nextLine();
//        int input3 = myScanner2.nextInt();
//        System.out.println("입력사항1 : " + input1);
//        System.out.println("입력사항2 : " + input2);
//        System.out.println("입력사항3 : " + input3);
//
//        // 입력 : BufferedReader + System.in
//        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
//        String input4 = br1.readLine(); // 한 줄씩 읽고 문자열로 리턴
//        System.out.println(input4);
//
//        // 입력값 : abc bcd fgd처럼 한 칸씩 띄고 입력받는 경우
//        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
//        String input5 = br2.readLine();
//        String[] arr = br2.readLine().split(" ");
//        System.out.println(arr[0]);
//        System.out.println(arr[1]);
//        System.out.println(arr[2]);
//
//        // BufferedReader + System.in + StringTokenizer
//        BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
//        String input6 = br3.readLine();
//        StringTokenizer st = new StringTokenizer(input6);
//        System.out.println(st.nextToken());
//        System.out.println(st.nextToken());
//        System.out.println(st.nextToken());
//    }
//}
