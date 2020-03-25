package homework.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import jdbc.util.DBUtil;

public class JdbcBoard {

   
   private Connection conn;
   private Statement stmt;
   private PreparedStatement pstmt;
   private ResultSet rs;
   
   private Scanner scan = new Scanner(System.in); 
   
   
   /**
    * 메뉴를 출력하는 메서드
    */
   public void displayMenu(){
      System.out.println();
      System.out.println("----------------------");
      System.out.println("  === 작 업 선 택 ===");
      System.out.println("  1. 전체 목록 출력");
      System.out.println("  2. 새글작성");
      System.out.println("  3. 수정");
      System.out.println("  4. 삭제");
      System.out.println("  5. 검색");
      System.out.println("----------------------");
      System.out.print("원하는 작업 선택 >> ");
   }
   
   
   /**
    * 프로그램 시작메서드
    */
   public void start(){
      int choice;
      do{
         displayMenu(); //메뉴 출력
         choice = scan.nextInt(); // 메뉴번호 입력받기
         switch(choice){
            case 1 :    
               viewall(); //전체목록출력
               break;
            case 2 :  
               writeBoard(); //새글작성
               break;
            case 3 :  
               updateBoard(); //수정
               break;
            case 4 :  
               deleteBoard(); //삭제
               break;
            case 5 :  // 검색
               searchBoard(); //검색               
               break;
            case 6 :  // 종료            
               break;
            default :
               System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
         }
      }while(choice!=6);
   }
   
   
   private void searchBoard() {
      
      boolean chk = false; //  중복여부 체크
      int board_no;
      
      do {
         viewall(); //전체목록출력
         System.out.println("검색할 게시판 번호를 입력하세요.");
         System.out.print("게시판 번호 >> ");
         board_no = Integer.parseInt(scan.next());
         chk = getBoard(board_no);
         if(!chk) {
            System.out.println("게시판 번호가 " + board_no 
                                   + "인 회원은 존재하지 않습니다.");
            System.out.println("다시 입력하세요.");
         }
      }while(!chk);

      try {
         conn = DBUtil.getConnection();
         String sql = "select * from jdbc_board where board_no="+board_no;
         stmt = conn.prepareStatement(sql);
         rs = stmt.executeQuery(sql);
         
         System.out.println("------------------전체리스트보기---------------------");
         while(rs.next()) {
            int board_no1 = rs.getInt("board_no");
            String board_title = rs.getString("board_title");
            String board_writer = rs.getString("board_writer");
            String date = rs.getString("board_date");
            String board_content = rs.getString("board_content");

            System.out.println(board_no1 + "\t" + board_title +"\t" + board_writer +"\t" + date +"\t" + board_content);
         }
         
         
      }catch(SQLException e) {
         e.printStackTrace();
      }finally {
         disConnect();
      }
      
      
   }


   private void deleteBoard() {
      boolean chk = false; //  중복여부 체크
      int board_no;
      
      do {
         System.out.println();
         System.out.println("삭제할 게시판 번호를 입력하세요.");
         System.out.print("게시판 번호 >> ");
         board_no = Integer.parseInt(scan.next());
         chk = getBoard(board_no);
         if(!chk) {
            System.out.println("게시판 번호가 " + board_no 
                                   + "인 회원은 존재하지 않습니다.");
            System.out.println("다시 입력하세요.");
         }
      }while(!chk);

      try {
         conn = DBUtil.getConnection();
         String sql = "delete from jdbc_board where board_no =?";
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setInt(1, board_no);
         
         int cnt = pstmt.executeUpdate();
         
         if(cnt >0) {
            System.out.println("삭제완료");
         }else {
            System.out.println("삭제되지 않았습니다.");
         }
         
      }catch(SQLException e) {
         e.printStackTrace();
      }finally {
         disConnect();
      }
      
      
   }


   private void updateBoard() {
      boolean chk = false; //  중복여부 체크
      int board_no;
      
      do {
         System.out.println();
         System.out.println("수정할 게시판 번호를 입력하세요.");
         System.out.print("게시판 번호 >> ");
         board_no = Integer.parseInt(scan.next());
         chk = getBoard(board_no);
         if(!chk) {
            System.out.println("게시판 번호가 " + board_no 
                                   + "인 회원은 존재하지 않습니다.");
            System.out.println("다시 입력하세요.");
         }
      }while(!chk);
      System.out.println("수정할 내용을 입력하세요.");
      System.out.println("새로운 제목 >> ");
      String title = scan.next();
      
      System.out.println("새로운 작성자 >> ");
      String writer = scan.next();

      System.out.println("새로운 내용 >> ");
      String content = scan.next();
      
      
      try {
         conn = DBUtil.getConnection();
         String sql = "update jdbc_board set board_title = ?"+" ,board_writer =?"+" ,board_content =?"+" where board_no =?";
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(1, title);
         pstmt.setString(2, writer);
         pstmt.setString(3, content);
         pstmt.setInt(4, board_no);
         
         int cnt = pstmt.executeUpdate();
         
         if(cnt >0) {
            System.out.println("입력완료");
         }else {
            System.out.println("입력이되지 않았습니다.");
         }
         
      }catch(SQLException e) {
         e.printStackTrace();
      }finally {
         disConnect();
      }
      
   }


   private boolean getBoard(int board_no) {
      boolean chk = false;
      
      try {
         conn = DBUtil.getConnection();
         String sql = "select count(*) as cnt from jdbc_board "
                  +" where board_no =?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, board_no);
         
         rs = pstmt.executeQuery();
         
         int cnt = 0;
         if(rs.next()) {
            cnt = rs.getInt("cnt");
         }
         if(cnt>0) {
            chk = true;
         }
      }catch(SQLException e) {
         e.printStackTrace();
      }finally {
         disConnect();
      }
            return chk;
      
   }


   private void writeBoard() {

      System.out.println("새글 작성합니다.");
      System.out.println("제목 :");
      String title = scan.next();
      System.out.println("작성자 : ");
      String writer = scan.next();
      System.out.println("내용 : ");
      String content = scan.next();

      
      try {
         conn = DBUtil.getConnection();
         String sql = "insert into jdbc_board values (board_seq.nextval,?,?,sysdate,?)";
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(1, title);
         pstmt.setString(2, writer);
         pstmt.setString(3, content);
         
         int cnt = pstmt.executeUpdate();
         
         if(cnt >0) {
            System.out.println("입력완료");
         }else {
            System.out.println("입력이되지 않았습니다.");
         }
         
      }catch(SQLException e) {
         e.printStackTrace();
      }finally {
         disConnect();
      }
      
      
   }


   private void viewall() {
      try {
         conn = DBUtil.getConnection();
         String sql = "select * from jdbc_board";
         stmt = conn.prepareStatement(sql);
         rs = stmt.executeQuery(sql);
         
         System.out.println("------------------전체리스트보기---------------------");
         while(rs.next()) {
            int board_no = rs.getInt("board_no");
            String board_title = rs.getString("board_title");
            String board_writer = rs.getString("board_writer");
            String date = rs.getString("board_date");
            String board_content = rs.getString("board_content");

            System.out.println(board_no + "\t" + board_title +"\t" + board_writer +"\t" + date +"\t" + board_content);
         }
      }catch(SQLException e){
         e.printStackTrace();
         
      }finally {
         disConnect();
      }
      
   
      
      
      
      
   }
   
   /**
    * 자원 반납용 메서드
    */
   private void disConnect() {
      //  사용했던 자원 반납
      if(rs!=null)try{ rs.close(); }catch(SQLException ee){}
      if(stmt!=null)try{ stmt.close(); }catch(SQLException ee){}
      if(pstmt!=null)try{ pstmt.close(); }catch(SQLException ee){}
      if(conn!=null)try{ conn.close(); }catch(SQLException ee){}
      
   }


   public static void main(String[] args) {
      JdbcBoard memObj = new JdbcBoard();
      memObj.start();
   }
}