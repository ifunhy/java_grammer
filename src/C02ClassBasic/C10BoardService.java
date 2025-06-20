//package C02ClassBasic;
//
//import java.io.*;
//import java.util.*;
//
//public class C10BoardService {
////        1.회원가입 : 이름, 이메일, 비밀번호, id값(auto_increment)
////        2.회원 전체 목록 조회 : id, email
////        3.회원 상세 조회(id로 조회) : id, email, name, password, 작성글 수(for문)
////        4.게시물 작성 :id, title, contents, 작성자Email(Author객체 가능, 할 수 있다면: 작성자이름)
////        5.게시물 목록 조회 : id(post), title
////        6.게시물 상세 조회(id로 조회) : id(post), title, contents, 작성자email(할 수 있다면: 작성자이름 -> post객체 안에 Author객체가 들어가도록하면 갖고 올 수 있음)
////        7.서비스 종료
//
//    public static void main(String[] args) throws IOException {
//        List<Author> authorList = new ArrayList<>();    // authorList를 for문 돌리면 됨
//        List<Post> postList = new ArrayList<>();    // 전체 리스트
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        System.out.println("1. 회원가입 / 2. 회원 전체 목록 조회 / " +
//                "3. 회원 상세 조회 / 4. 게시물 작성 / 5. 게시물 목록 조회 / 6. 게시물 상세 조회 / 7. 서비스 종료");
//
//        while (true) {
//            String str = br.readLine();
//
//            switch (str) {
//                case "1":
//                    System.out.println("회원가입을 진행하기 위해 이름, 이메일, 비밀번호를 입력해주세요.");
//                    st = new StringTokenizer(br.readLine());
//                    String name = st.nextToken(); // 이름
//                    String email = st.nextToken(); // 이메일
//                    String password = st.nextToken(); // 비밀번호
//
//                    Author user = new Author(name, email, password);
//                    authorList.add(user);
//                    System.out.println("회원가입 완료\n회원 ID: " + user.getId());
//                    break;
//
//                case "2":
//                    System.out.println("회원 전체 목록 조회");
//                    for (Author a : authorList) {
//                        System.out.println("이름: " + a.getName() + " / 이메일: " + a.getEmail());
//                    }
//                    break;
//
//                case "3": // id, email, name, password, 작성글 수(for문)
//                    System.out.println("상세 조회할 회원의 id를 입력하세요.");
//                    long searchId = Long.parseLong(br.readLine());  // id 입력
//
//                    Author foundId = null;
//                    for (Author a : authorList) {
//                        if (a.getId() == searchId) {
//                            foundId = a;
//                            break;
//                        }
//                    }
//                    if (foundId == null) {
//                        System.out.println("해당 ID의 회원이 없습니다.");
//                        break;
//                    }
//
//                    System.out.println("회원 ID: " + foundId.getId());
//                    System.out.println("회원 email: " + foundId.getEmail());
//                    System.out.println("회원 name: " + foundId.getName());
//                    System.out.println("회원 password: " + foundId.getPassword());
//                    System.out.println("회원 작성글 수: " + foundId.getPostList().size());
//                    break;
//
//
//                case "4":   // 4.게시물 작성 :id, title, contents, 작성자Email(Author객체 가능, 할 수 있다면: 작성자이름)
//                    System.out.println("게시물 작성");
//                    System.out.println("id와 이름을 적어주세요.");
//                    st = new StringTokenizer(br.readLine());
//                    long id = Long.parseLong(st.nextToken());
//                    name = st.nextToken();
//                    Author userName = null;
//                    Author userId = null;
//
//                    for (Author a : authorList) {   // authorList에서 해당 Author 찾기
//                        if (a.getName().equals(name)) {
//                            userName = a;
//                            break;
//                        }
//                    }
//
//                    if (userName == null) {
//                        System.out.println("해당 이름의 회원이 없습니다.");
//                        break;
//                    }
//
//                    for (Author b : authorList) {   // authorList에서 해당 Author 찾기
//                        if (b.getId() == id) {
//                            userId = b;
//                            break;
//                        }
//                    }
//
//                    if (userId == null) {
//                        System.out.println("해당 id의 회원이 없습니다.");
//                        break;
//                    }
//
//                    System.out.println("제목을 입력하세요.");
//                    String title = br.readLine();
//                    System.out.println("내용을 입력하세요.");
//                    String contents = br.readLine();
//
//                    Post newPost = new Post(userName, title, contents);
//                    postList.add(newPost);
//
//                    userName.getPostList().add(newPost);
//
//                    System.out.println("게시물 작성 완료\npostID: " + newPost.getId());
//                    break;
//
//                case "5" :  // 게시물 목록 조회: id(post), title
//                    System.out.println("게시물 목록 조회");
//                    System.out.println("조회할 회원의 ID를 입력해주세요.");
//                    id = Long.parseLong(br.readLine());
//                    userId = null;
//
//                    for (Author b : authorList) {   // authorList에서 해당 Author 찾기
//                        if (b.getId() == id) {
//                            userId = b;
//                            break;
//                        }
//                    }
//
//                    if (userId == null) {
//                        System.out.println("해당 id의 회원이 없습니다.");
//                        break;
//                    } else {
//                        for (Post p : userId.getPostList()) {
//                            System.out.println("회원 ID: " + userId.getId() + " / 게시물 ID: " + p.getId() + " / 제목: " + p.getTitle());
//                        }
//                    }
//                    break;
//
//                case "6" : // 6.게시물 상세 조회(id로 조회) : id(post), title, contents, 작성자email(할 수 있다면: 작성자이름 -> post객체 안에 Author객체가 들어가도록하면 갖고 올 수 있음)
//                    System.out.println("게시물 상세 조회");
//                    System.out.println("조회할 게시물의 ID를 입력해주세요.");
//                    id = Long.parseLong(br.readLine());
//                    Post postId = null;
//
//                    for (Post p : postList) {
//                        if (p.getId() == id) {
//                            postId = p;
//                            break;
//                        }
//                    }
//
//                    if (postId == null) {
//                        System.out.println("해당 id의 게시물이 없습니다.");
//                        break;
//                    }
//
//                    System.out.println("게시물 ID: " + postId.getId());
//                    System.out.println("게시물 제목: " + postId.getTitle());
//                    System.out.println("게시물 내용: " + postId.getContents());
//                    System.out.println("작성자 email: " + postId.getAuthor().getEmail());
//                    break;
//
//                case "7" :
//                    System.out.println("서비스 종료");
//                    return;
//            }
//        }
//    }
//}
//
//class Author {
//    // 일반적으로 클래스를 정의할 때 원시자료형은 wrapper 클래스로 정의
//    List<Post> postList;    // 사용자가 쓴 글에 대한 리스트
//    private static long nextId = 1; // Long으로 정의하는 것이 일반적
//    private long id;
//    private String name;
//    private String email;
//    private String password;
//
//    public Author(String name, String email, String password) {
//        this.id = nextId++;
//        this.name = name;
//        this.email = email;
//        this.password = password;
//        this.postList = new ArrayList<>();  // Author 객체에 본인이 쓴 글 목록인 postList 객체를 만들어둠으로써 편의성 향상
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public static long getNextId() {
//        return nextId;
//    }
//
//    public List<Post> getPostList() {
//        return this.postList;
//    }
//
//}
//
//class Post {
//    private static long nextPostId = 1;
//    private long id;
//    private String title;
//    private String contents;
//    private Author author;
//    List<Author> authorList;
//
//    public Post(Author author, String title, String contents) {
//        this.id = nextPostId++;
//        this.author = author;
//        this.title = title;
//        this.contents = contents;
//        this.authorList = new ArrayList<>();
//    }
//
//    public Author getAuthor() {
//        return author;
//    }
//
//    public String getContents() {
//        return contents;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public List<Author> getAuthorList() {
//        return authorList;
//    }
//}
//
//
//// id, 이름, 이메일, pw -> list.add();
//// title, contents, email(대신에 author(를 넣게되면 메모리주소 안에 메모리를 넣게 됨))
//// 회원상세조회 중 작성글 수 : for문을 postList가서 나의 글 수를 카운트
//// 게시물 상세조회
//
//
//// 순서
//// 회원 가입 -> a1 객체 생성
//// 글쓰기 -> p1 객체 생성, postList.add(p1), a1.getPostList().add(p1)
//// a1.getPostList.size() 하면 조회 가능