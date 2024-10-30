
abstract class Page {
    protected Renderer renderer;

    public Page(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract void render();
}

class SimplePage extends Page {
    private String title;
    private String content;

    public SimplePage(Renderer renderer, String title, String content) {
        super(renderer);
        this.title = title;
        this.content = content;
    }

    @Override
    public void render() {
        renderer.renderContent("Title: " + title + ", Content: " + content);
    }
}

class ProductPage extends Page {
    private Product product;

    public ProductPage(Renderer renderer, Product product) {
        super(renderer);
        this.product = product;
    }

    @Override
    public void render() {
        renderer.renderContent("Product: " + product.getName() + ", Description: " + product.getDescription() +
                ", Image: " + product.getImage() + ", ID: " + product.getId());
    }
}

interface Renderer {
    void renderContent(String content);
}

class HTMLRenderer implements Renderer {
    @Override
    public void renderContent(String content) {
        System.out.println("<html>" + content + "</html>");
    }
}

class JSONRenderer implements Renderer {
    @Override
    public void renderContent(String content) {
        System.out.println("{ 'content': '" + content + "' }");
    }
}

class XMLRenderer implements Renderer {
    @Override
    public void renderContent(String content) {
        System.out.println("<xml>" + content + "</xml>");
    }
}

// Класс Product
class Product {
    private String name;
    private String description;
    private String image;
    private int id;

    public Product(String name, String description, String image, int id) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.id = id;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getImage() { return image; }
    public int getId() { return id; }
}

// Пример клиентского кода
public class Main {
    public static void main(String[] args) {
        Renderer htmlRenderer = new HTMLRenderer();
        Renderer jsonRenderer = new JSONRenderer();
        Renderer xmlRenderer = new XMLRenderer();

        Page simplePageHtml = new SimplePage(htmlRenderer, "html", "html page");
        Page simplePageXml = new SimplePage(xmlRenderer, "xml", "xml page");
        Page productPageJson = new ProductPage(jsonRenderer, new Product("Hak", "1231234124", "image.jpg", 1));

        simplePageHtml.render();
        simplePageXml.render();
        productPageJson.render();
    }
}
