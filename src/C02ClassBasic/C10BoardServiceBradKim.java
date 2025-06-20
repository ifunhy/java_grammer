package C02ClassBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C10BoardServiceBradKim {
    //        1.회원가입 : 이름, 이메일, 비밀번호, id값(auto_increment)
//        2.회원 전체 목록 조회 : id, email
//        3.회원 상세 조회(id로 조회) : id, email, name, password, 작성글수(List<Author>)
//        4.게시글 작성(회원-email입력) : id, title, contents, 작성자Email(Author객체가능)
//        5.게시물 목록 조회 : id(post), title
//        6.게시물 상세 조회(id로 조회) : id, title, contents, 작성자email(작성자이름)
//        7.서비스 종료
    public static void main(String[] args) {
        List<Author> authorList = new ArrayList<>();
        List<Post> postList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("하고자 하는 서비스를 입력해주세요. ");
            int serviceNumber = Integer.parseInt(sc.nextLine());
            if(serviceNumber==1){
                System.out.println("회원가입서비스입니다.");
                System.out.println("이름 입력 하세요");
                String name = sc.nextLine();
                System.out.println("이메일 입력 하세요");
                String email = sc.nextLine();
                System.out.println("패스워드 입력 하세요");
                String password = sc.nextLine();
                Author author = new Author(name, email, password);
                authorList.add(author);
            }else if(serviceNumber==2){
                System.out.println("회원 목록 조회 입니다.");
                for(Author a : authorList){
                    System.out.println(a);
                }
            }else if(serviceNumber==3){
                System.out.println("회원 상세 조회 입니다.");
                System.out.println("email을 입력해주세요");
                String email = sc.nextLine();
                Author author = null;
                for(Author a : authorList){
                    if(a.getEmail().equals(email)){
                        author = a;
                        break;
                    }
                }
                System.out.println(author.getName() + author.getEmail() + author.getPostList().size());
            }else if(serviceNumber==4){
                System.out.println("게시글 작성 서비스입니다.");
                System.out.println("제목을 입력 하세요");
                String title = sc.nextLine();
                System.out.println("내용을 입력 하세요");
                String contents = sc.nextLine();
                System.out.println("작성자의 이메일을 입력 하세요");
                String authorEmail = sc.nextLine();
                Author author = null;
                for(Author a : authorList){
                    if(a.getEmail().equals(authorEmail)){
                        author = a;
                    }
                }
                Post post = new Post(title, contents, author);
                postList.add(post);
//                글을 쓰는 시점에 postList에 add 및 author의 postList에도 add
//                author.getPostList().add(post);
            }else if(serviceNumber==5){
                System.out.println("게시글 전체 조회 입니다.");
                for(Post p : postList){
                    System.out.println(p);
                }
            }else if(serviceNumber==6){
                System.out.println("게시글 상세 조회 입니다.");
                System.out.println("게시글의 ID를 입력해주세요");
                long postId = Long.parseLong(sc.nextLine());
                Post post = null;
                for(Post p : postList){
                    if(p.getId() == postId){
                        post=p;
                    }
                }
                System.out.println("제목 : " + post.getTitle() + "내용 : " + post.getContents() + "작성자 이름 : "+ post.getAuthor().getName());
            }else {
                break;
            }
        }
    }
}

class Author{
    //    일반적으로 클래스를 정의할때 원시자료형은 wrapper클래스로 정의
    private Long id;
    private static Long static_id = 0L;
    private String name;
    private String email;
    private String password;
    //    Author객체에 본인이 쓸글 목록인 postList객체를 만들어둠으로서 편의성 향상
    List<Post> postList;
    public Author(String name, String email, String password){
        this.id  = static_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.postList  = new ArrayList<>();
        static_id++;
    }

    public Long getId() {
        return id;
    }

    public static Long getStatic_id() {
        return static_id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Post> getPostList() {
        return postList;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", post_count='" + postList.size() + '\'' +
                '}';
    }
}
class Post{
    private Long id;
    private static Long staticId=0L;
    private String title;
    private String contents;
    //    객체 안의 객체를 선언함으로서 post객체에서 쉽게 author객체에 접근 가능
    private Author author;
    public Post(String title, String contents, Author author){
        this.id = staticId;
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.author.getPostList().add(this);
    }

    public Long getId() {
        return id;
    }

    public static Long getStaticId() {
        return staticId;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
