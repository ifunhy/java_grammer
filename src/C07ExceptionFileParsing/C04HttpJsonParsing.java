package C07ExceptionFileParsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class C04HttpJsonParsing {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 외부데이터(api) 요청 : 서버 간의 통신
        // RestTemplate, RestClient : 스프링에서 가장 많이 사용하는 라이브러리
        // HttpClient는 자바의 내장클래스로서 별도의 역직렬화, 직렬화 작업이 필요
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()  // 어떤 서버에, 어떤 요청을
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))  // URL 명시
                .GET()  // get 요청
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); // 요청을 보내고, String으로 받음
        String postString = response.body();    // 들어온 Json을 문자열 객체로 형변환

//        System.out.println(postString);

        // 실습 : Json -> 객체
        ObjectMapper o1 = new ObjectMapper();
        JsonNode jsonNode = o1.readTree(postString);
        List<Board> boardList = new ArrayList<>();
        for (JsonNode j : jsonNode) {
            Board b1 = o1.readValue(j.toString(), Board.class);
            boardList.add(b1);
        }
        System.out.println("실습 : " + boardList);

        // 객체 -> Json
        String returnStr = o1.writeValueAsString(boardList);
        System.out.println(returnStr);
    }
}

// 파싱을 해줄 때 필요한 것 : 기본생성자 + getter
class Board {
    private Long userId;
    private String id;
    private String title;
    private String body;

    public Board() {

    }

    public Long getUserId() {
        return userId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Board{" + "userId=" + userId + ", id='" + id + '\'' +
                ", title='" + title + '\'' + ", body='" + body + '\'' + '}';
    }
}