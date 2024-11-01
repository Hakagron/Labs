
public class Main {
    public static void main(String[] args) {
        Downloader simpleDownloader = new SimpleDownloader();
        Downloader cachingDownloader = new CachingDownloader(simpleDownloader);
        String url = "http://example.com/file1";
        System.out.println("FIIIIRSTTT:");
        cachingDownloader.download(url);
        String url2 = "http://example.com/file2";
        System.out.println("SECONDDD:");
        cachingDownloader.download(url2);
    }
}
