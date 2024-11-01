public class SimpleDownloader implements Downloader {
    @Override
    public byte[] download(String url) {
        System.out.println("Downloading " + url);
        return url.getBytes();
    }
}
