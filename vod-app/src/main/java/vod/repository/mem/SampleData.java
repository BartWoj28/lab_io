package vod.repository.mem;

import vod.model.Store;
import vod.model.Producer;
import vod.model.Product;

import java.util.ArrayList;
import java.util.List;

class SampleData {

    static List<Store> stores = new ArrayList<>();

    static List<Producer> producers = new ArrayList<>();

    static List<Product> products = new ArrayList<>();

    static {

        Producer steelseries = new Producer(1, "Steelseries", "Denmark");
        Producer acer = new Producer(2, "Acer", "Taiwan");
        Producer razer = new Producer(3, "Andrzej", "USA");
        Producer lenovo = new Producer(4, "Lenovo", "China");

        Product arctisNova = new Product(1, "Arctis Nova Elite", "https://images.ctfassets.net/hmm5mo4qf4mf/7tSln6l9gp3Xhcbx0jWsYN/0e947bfefcb76dfd702a02f290a9ebeb/arctis_nova_elite_sage_gold_img_buy_primary.png?fm=webp&q=90&fit=scale&w=768", steelseries, (float) 599.99);
        Product apexPro = new Product(2, "Apex Pro Gen 3", "https://images.ctfassets.net/hmm5mo4qf4mf/EmzhCU4XjBiVebd68loN6/7d2683bc1b3d19e3cef0a39efa0faa1f/e5ca6f19587a4e508c2b2339898595d7-3786.png?fm=webp&q=90&fit=scale&w=768", steelseries, (float) 219.99);

        Product swiftGo = new Product(3, "Swift Go 14", "https://static2-ecemea.acer.com/media/catalog/product/a/c/acer-swift-go-14-sfg14-63-with-fingerprint-with-backlit-on-wp-oled-start-screen-steel-gray-01_7.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=320&width=320&canvas=320:320", acer, (float) 1243.27);
        Product aspire = new Product(4, "Aspire C24 Ultra", "https://cdn.x-kom.pl/i/setup/images/prod/big/product-big,,2025/5/pr_2025_5_30_9_16_17_919_00.jpg", acer, (float) 952.94);

        Product kraken = new Product(5, "Kraken Tournament", "https://cdn.x-kom.pl/i/setup/images/prod/big/product-new-big,,2018/11/pr_2018_11_19_16_2_54_770_00.jpg", razer, (float) 59.68);
        Product viper = new Product(6, "Viper V3 Hyperspeed", "https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcTV1qWtxA5bBKycDEwX4bVlV7zeXeTjx-SIE30UyJR4W4zNS79nb9cNpnOJ8rUuvG2yAGan8IZDa2Ka82InoHg6GRlWL86UlxvQg0BR-oHf", razer, (float) 60.55);

        Product loq = new Product(7, "Loq 15ARP9 ", "https://prod-api.mediaexpert.pl/api/images/gallery/thumbnails/images/91/9136106/Laptop-LENOVO-LOQ-15ARP9-1.jpg", lenovo, (float) 1078.1);
        Product legionGo = new Product(8, "Legion Go S", "https://f00.esfr.pl/foto/8/156772454513/9bedb485bc023df34522dbd89a68ac3f/lenovo-legion-go-s-steam-os,156772454513_5.webp", lenovo, (float) 701.70);

        bind(arctisNova, steelseries);
        bind(apexPro, steelseries);

        bind(swiftGo, acer);
        bind(aspire, acer);

        bind(kraken, razer);
        bind(viper, razer);

        bind(loq, lenovo);
        bind(legionGo, lenovo);

        Store xKom = new Store(1, "X-Kom", "https://upload.wikimedia.org/wikipedia/commons/7/7f/X-kom_logo_ver2018.png");
        Store rtvEuro = new Store(2, "RTV EURO AGD", "https://upload.wikimedia.org/wikipedia/commons/c/c6/RTV_EURO_AGD_logo.png");
        Store neonet = new Store(3, "Neonet", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/Neonet-logo.png/1280px-Neonet-logo.png");
        Store mediaExpert = new Store(4, "Media Expert", "https://tychy.geminipark.pl/wp-content/uploads/2022/06/logotypy_mediaexpert.png");

        bind(xKom, apexPro);
        bind(neonet, apexPro);
        bind(neonet, arctisNova);
        bind(neonet, swiftGo);

        bind(xKom, viper);
        bind(mediaExpert, viper);
        bind(mediaExpert, loq);
        bind(rtvEuro, loq);
        bind(rtvEuro, swiftGo);

        products.add(arctisNova);
        products.add(apexPro);
        products.add(swiftGo);
        products.add(aspire);
        products.add(kraken);
        products.add(viper);
        products.add(loq);
        products.add(legionGo);

        producers.add(steelseries);
        producers.add(acer);
        producers.add(razer);
        producers.add(lenovo);

        stores.add(xKom);
        stores.add(rtvEuro);
        stores.add(neonet);
        stores.add(mediaExpert);

    }

    private static void bind(Store s, Product p) {
        s.addProduct(p);
        p.addStore(s);
    }

    private static void bind(Product p, Producer pp) {
        pp.addMovie(p);
        p.setProducer(pp);
    }

}
