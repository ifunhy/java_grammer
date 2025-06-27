package C09NetWorking;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class C01WebServerGet {
    public static void main(String[] args) throws IOException {
//        소켓이란 서버와 사용자가 통신을 하기 위한 네트워크 통신의 끝점을 나타내는 개념
        ServerSocket serverSocket = new ServerSocket(8080); // 서버와 통신 위해 포트번호 제공
        System.out.println("서버 시작");
        while (true) {
//            accept : 사용자의 연결 요청을 수락
//            socket객체 안에는 사용자의 정보(ip 등)
            Socket socket = serverSocket.accept();
//            사용자에게 응답을 줄 메시지를 http프로토콜에 맞게 세팅
            String reponse = "HTTP/1.1 200 OKay\r\n\r\n" + "hello world java"; // 문서 규격에 맞도록 header\r\n\r\n + body
//            사용자에게 메시지 응답
            socket.getOutputStream().write(reponse.getBytes(StandardCharsets.UTF_8));   // 문자열응답 위해 write()
//            flush : 일반적으로 변경사항을 확정하는 것을 의미
            socket.getOutputStream().flush();
            socket.close(); // 메모리 회수
        }
    }
}
