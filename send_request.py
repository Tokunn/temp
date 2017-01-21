
import socket
import urllib.parse

http = """POST /opac/wopc/pc/pages/TopPage.jsp;jsessionid=A665303477761BD3BC06FC534B9334BB HTTP/1.1
Host: library.city.oyama.tochigi.jp
User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
Accept-Language: ja,en-US;q=0.7,en;q=0.3
Referer: http://library.city.oyama.tochigi.jp/opac/wopc/pc/pages/TopPage.jsp
Connection: close
Content-Type: application/x-www-form-urlencoded
Content-Length: 591

confirmMessage=%E5%AE%8C%E5%85%A8%E4%B8%80%E8%87%B4%E6%A4%9C%E7%B4%A2%E3%82%92%E8%A1%8C%E3%81%84%E3%81%BE%E3%81%99%E3%80%82%E3%82%88%E3%82%8D%E3%81%97%E3%81%84%E3%81%A7%E3%81%99%E3%81%8B%EF%BC%9F&requireKeyword=%E6%A4%9C%E7%B4%A2%E3%82%AD%E3%83%BC%E3%83%AF%E3%83%BC%E3%83%89%E3%81%8C%E6%9C%AA%E5%85%A5%E5%8A%9B%E3%81%A7%E3%81%99%E3%80%82&fullSpace=%E3%80%80&topPageForm%3Akeyword=%E3%82%BF%E3%82%A4%E3%83%88%E3%83%AB&topPageForm%3AbtnSearch=%E6%A4%9C%E7%B4%A2&topPageForm%3ArdoLocaleChange=ja_AD&topPageForm_SUBMIT=1&javax.faces.ViewState=7DyY5%2FgKhWBoV6YvSmodFMw7BwFqlpnN7P%2Bpya320hJPSPny"""


sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
#sock.connect(('61.25.94.55', 80))
sock.connect(('library.city.oyama.tochigi.jp', 80))
sock.send(http.encode())

strings = ''
recv = 'default'
while (recv != ''):
    recv = sock.recv(4096).decode('utf-8', 'ignore')
    strings += recv

fd = open("recv_html.html", "w")
fd.write(strings)
fd.close()
