package leetcode.editor.en;

import java.util.HashMap;
import java.util.UUID;

class P535EncodeAndDecodeTinyurl {
    public static void main(String[] args) {
        // Solution solution = new P535 Solution();
        Codec sol = new P535EncodeAndDecodeTinyurl().new Codec();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Codec {

        HashMap<String, String> toTiny = new HashMap<>();
        HashMap<String, String> toOrigin = new HashMap<>();

        String baseUrl = "http://tinyurl.com/";

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {

            if (!toTiny.containsKey(longUrl)) {

                String uuid = UUID.randomUUID().toString();
                toTiny.put(longUrl, uuid);
                toOrigin.put(uuid, longUrl);

            }
            return baseUrl + toTiny.get(longUrl);
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            String[] uri = shortUrl.split("/");
            return toOrigin.get(uri[uri.length - 1]);
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
//leetcode submit region end(Prohibit modification and deletion)

}