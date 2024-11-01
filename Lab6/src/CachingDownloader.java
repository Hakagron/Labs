import java.util.HashMap;
import java.util.Map;

public class CachingDownloader implements Downloader {
    private final Downloader downloader;
    private final Map<String, byte[]> cache = new HashMap<>();

    public CachingDownloader(Downloader downloader) {
        this.downloader = downloader;
    }

    @Override
    public byte[] download(String url) {
        if (cache.containsKey(url)) {
            System.out.println("Fetching cache " + url);
            return cache.get(url);
        }
        byte[] data = downloader.download(url);
        cache.put(url, data);
        return data;
    }
}
