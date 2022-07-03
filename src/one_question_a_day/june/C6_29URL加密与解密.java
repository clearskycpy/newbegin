package one_question_a_day.june;

import java.util.HashMap;
import java.util.Map;

public class C6_29URL加密与解密 {
    Map<Integer,String> map = new HashMap<>();
    int count = 0;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {  // 得到加密的URL
        count++;
        map.put(count,longUrl);
        return "http://tinyurl.com/"+count;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {  // 返回初始的url

        int p = shortUrl.lastIndexOf('/') + 1;
        int key = Integer.parseInt(shortUrl.substring(p));
        return map.get(key);
    }
}
