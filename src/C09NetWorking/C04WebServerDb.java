package C09NetWorking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class C04WebServerDb {
    public static void main(String[] args) throws IOException, SQLException {

        // 1. JDBC 연결 설정 및 DB 연결
        String url = "jdbc:mysql://localhost:3306/board1?useSSL=false";
        String userName = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, userName, password);

        // 2. 쿼리를 실행할 Statement 생성
        Statement st = connection.createStatement();

        // 3. 서버소켓 생성 및 대기
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("서버 시작");

        while (true) {
            // 4. 클라이언트 접속 수락
            Socket socket = serverSocket.accept();

            // 5. HTTP 요청 받기
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null && !line.isEmpty()) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }

            // 6. 요청 문자열 파싱 (GET /?id=1 HTTP/1.1 → id=1 추출)
            String requestString = sb.toString();
            String firstLine = requestString.split("\n")[0];      // GET /?id=1 HTTP/1.1
            String infos = firstLine.split(" ")[1];               // /?id=1
            String id = "";
            if (infos.contains("?")) {
                id = infos.split("=")[1];                         // id = 1
            }

            // 7. DB에서 해당 id의 게시글 조회
            ResultSet rs = st.executeQuery("select * from post where id='" + id + "'");

            // 8. 응답 메시지 준비 (HTTP 헤더 + 본문)
            String response = "HTTP/1.1 200 OK\r\n\r\n";
            while (rs.next()) {
                response += "id : ";
                response += rs.getInt("id");
                response += " title : ";
                response += rs.getString("title");
                response += " contents : ";
                response += rs.getString("contents");
            }

            // 9. 응답 결과 서버 콘솔에 출력 (디버깅용)
            System.out.println(response);

            // 10. 클라이언트에게 응답 전송
            socket.getOutputStream().write(response.getBytes(StandardCharsets.UTF_8));
            socket.getOutputStream().flush();

            // 11. 소켓 닫기
            socket.close();
        }
    }
}
