
interface Storage {
    void connect();
    void uploadFile(String fileName);
    void downloadFile(String fileName);
}

class LocalDiskStorage implements Storage {
    @Override
    public void connect() {
        System.out.println("Connected to Local Disk Storage.");
    }

    @Override
    public void uploadFile(String fileName) {
        System.out.println("Uploading " + fileName + " to Local Disk.");
    }

    @Override
    public void downloadFile(String fileName) {
        System.out.println("Downloading " + fileName + " from Local Disk.");
    }
}

class AmazonS3Storage implements Storage {
    @Override
    public void connect() {
        System.out.println("Connected to Amazon S3 Storage.");
    }

    @Override
    public void uploadFile(String fileName) {
        System.out.println("Uploading " + fileName + " to Amazon S3.");
    }

    @Override
    public void downloadFile(String fileName) {
        System.out.println("Downloading " + fileName + " from Amazon S3.");
    }
}

class StorageManager {
    private static StorageManager instance;
    private Storage storage;

    private StorageManager() {
    }

    public static StorageManager getInstance() {
        if (instance == null) {
            instance = new StorageManager();
        }
        return instance;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
        this.storage.connect();
    }

    public void uploadFile(String fileName) {
        if (storage != null) {
            storage.uploadFile(fileName);
        } else {
            System.out.println("Storage not set.");
        }
    }

    public void downloadFile(String fileName) {
        if (storage != null) {
            storage.downloadFile(fileName);
        } else {
            System.out.println("Storage not set.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        StorageManager manager = StorageManager.getInstance();

        manager.setStorage(new LocalDiskStorage());
        manager.uploadFile("localfile.txt");
        manager.downloadFile("localfile.txt");

        manager.setStorage(new AmazonS3Storage());
        manager.uploadFile("s3file.txt");
        manager.downloadFile("s3file.txt");
    }
}
