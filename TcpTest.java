import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;


/**
 * Created by tokunn on 2017/01/22.
 */

public class TcpTest extends Thread {

    //private String m_szIp = "172.16.14.214";
    private String m_szIp = "61.25.94.55";
    //private String m_szIp = "216.58.197.3";
    private int    m_nPort = 80;

    @Override
    public void run() {
        try {
            Socket socket = new Socket(m_szIp, m_nPort);

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));

            //String http = "POST /opac/wopc/pc/pages/TopPage.jsp;jsessionid=78F9546F4B523326B9C2CB44839E6B74 HTTP/1.1\r\nHost: library.city.oyama.tochigi.jp\r\nUser-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0\r\nAccept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\nAccept-Language: ja,en-US;q=0.7,en;q=0.3\r\nReferer: http://library.city.oyama.tochigi.jp/opac/wopc/pc/pages/TopPage.jsp\r\nConnection: close\r\nContent-Type: application/x-www-form-urlencoded\r\nContent-Length: 573\r\n\r\nconfirmMessage=%E5%AE%8C%E5%85%A8%E4%B8%80%E8%87%B4%E6%A4%9C%E7%B4%A2%E3%82%92%E8%A1%8C%E3%81%84%E3%81%BE%E3%81%99%E3%80%82%E3%82%88%E3%82%8D%E3%81%97%E3%81%84%E3%81%A7%E3%81%99%E3%81%8B%EF%BC%9F&requireKeyword=%E6%A4%9C%E7%B4%A2%E3%82%AD%E3%83%BC%E3%83%AF%E3%83%BC%E3%83%89%E3%81%8C%E6%9C%AA%E5%85%A5%E5%8A%9B%E3%81%A7%E3%81%99%E3%80%82&fullSpace=%E3%80%80&topPageForm%3Akeyword=%E7%B5%B5%E6%9C%AC&topPageForm%3AbtnSearch=%E6%A4%9C%E7%B4%A2&topPageForm%3ArdoLocaleChange=ja_AD&topPageForm_SUBMIT=1&javax.faces.ViewState=7DyY5%2FgKhWBoV6YvSmodFMw7BwFqlpnN7P%2Bpya320hJPSPny";
            String http = "POST /opac/wopc/pc/pages/TopPage.jsp;jsessionid="
                //+ "78F9546F4B523326B9C2CB44839E6B74"
                + "D529A3CD1A3C28D2B3546ED6B22FB6C9"
                + " HTTP/1.1\r\n"
                + "Host: library.city.oyama.tochigi.jp\r\n" 
                + "User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0\r\n" 
                + "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n" 
                + "Accept-Language: ja,en-US;q=0.7,en;q=0.3\r\n" 
                + "Referer: http://library.city.oyama.tochigi.jp/opac/wopc/pc/pages/TopPage.jsp\r\n" 
                + "Connection: close\r\n" 
                + "Content-Type: application/x-www-form-urlencoded\r\n" 
                + "Content-Length: 573\r\n\r\n" 
                + "confirmMessage=%E5%AE%8C%E5%85%A8%E4%B8%80%E8%87%B4%E6%A4%9C%E7%B4%A2%E3%82%92%E8%A1%8C%E3%81%84%E3%81%BE%E3%81%99%E3%80%82%E3%82%88%E3%82%8D%E3%81%97%E3%81%84%E3%81%A7%E3%81%99%E3%81%8B%EF%BC%9F&requireKeyword=%E6%A4%9C%E7%B4%A2%E3%82%AD%E3%83%BC%E3%83%AF%E3%83%BC%E3%83%89%E3%81%8C%E6%9C%AA%E5%85%A5%E5%8A%9B%E3%81%A7%E3%81%99%E3%80%82&fullSpace=%E3%80%80&topPageForm%3Akeyword=%E7%B5%B5%E6%9C%AC&topPageForm%3AbtnSearch=%E6%A4%9C%E7%B4%A2&topPageForm%3ArdoLocaleChange=ja_AD&topPageForm_SUBMIT=1&javax.faces.ViewState=7DyY5%2FgKhWBoV6YvSmodFMw7BwFqlpnN7P%2Bpya320hJPSPny";

           //String str = "GET /opac/wopc/pc/pages/SearchDetail.jsp HTTP/1.0\r\nHost: library.city.oyama.tochigi.jp\r\n\r\n";
            bw.write(http);

            bw.flush();

            String szData = "a";
            //int i = 0;
            while(szData!=null) {
                szData = br.readLine();
                System.out.println(szData);
                //i+=1;
            }


            //System.out.println("Receive Strings: " + szData);

            in.close();
            out.close();
            socket.close();
        }
        catch(Exception e) {
            System.out.println("Error"+e.getMessage());
            e.printStackTrace();
        }
    }
}
