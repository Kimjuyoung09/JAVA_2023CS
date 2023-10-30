import java.io.*;
import java.util.*;

public class UserInform {
    public static void main(String[] args) throws IOException {
        int num2;
        String search;
        String num, name, tel, email;
        Scanner scan = null;
        PrintWriter in = new PrintWriter(new FileWriter("user.txt"));
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("사용자 번호를 입력하세요 ");
            num = s.next();
            System.out.println("사용자 이름을 입력하세요 ");
            name = s.next();
            System.out.println("사용자 전화번호를 입력하세요 ");
            tel = s.next();
            System.out.println("사용자 이메일을 입력하세요 ");
            email = s.next();
            System.out.println("입력이 끝났으면 1, 계속 입력하시려면 0");
            num2 = s.nextInt();
            in.print(num + "," + name + "," + tel + "," + email + "\n"); 
            in.flush();
            if (num2 == 1)
                break;
        }
        in.close(); 

        System.out.println("검색하실 사용자 번호를 입력하세요");
        num2 = s.nextInt();
        search = num2 + "";
        scan = new Scanner(new BufferedReader(new FileReader("user.txt")));
        scan.useDelimiter("\n"); 
        boolean found = false;
        PrintWriter findUserWriter = new PrintWriter(new FileWriter("find_user.txt"));
        while (scan.hasNext()) {
            String userInfo = scan.next();
            String[] userInfoParts = userInfo.split(",");
            num = userInfoParts[0];
            name = userInfoParts[1];
            tel = userInfoParts[2];
            email = userInfoParts[3];
            if (num.equals(search)) {
            	found = true;
                findUserWriter.print(num + "," + name + "," + tel + "," + email + "\n");
                break; 
            }
        }
        if (!found) {
            System.out.println("사용자 번호 " + num2 + "을 찾을 수 없습니다.");
        }
        findUserWriter.close(); 

        if (scan != null)
            scan.close();
    }
}
