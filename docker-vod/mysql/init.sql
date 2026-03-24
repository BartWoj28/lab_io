CREATE TABLE `store`
(
    `id`   int          NOT NULL AUTO_INCREMENT,
    `logo` varchar(255) NOT NULL,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `producer`
(
    `id`        int          NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `country`  varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `product`
(
    `id`          int          NOT NULL AUTO_INCREMENT,
    `photo`      varchar(255) NOT NULL,
    `price`      float DEFAULT NULL,
    `name`       varchar(255) NOT NULL,
    `producer_id` int   DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `product_store`
(
    `product_id`  int DEFAULT NULL,
    `store_id` int DEFAULT NULL
);

INSERT INTO `store` (`id`, `name`, `logo`)
VALUES (1, 'X-Kom', 'https://upload.wikimedia.org/wikipedia/commons/7/7f/X-kom_logo_ver2018.png');
INSERT INTO `store` (`id`, `name`, `logo`)
VALUES (2, 'RTV EURO AGD', 'https://upload.wikimedia.org/wikipedia/commons/c/c6/RTV_EURO_AGD_logo.png');
INSERT INTO `store` (`id`, `name`, `logo`)
VALUES (3, 'Neonet', 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/Neonet-logo.png/1280px-Neonet-logo.png');
INSERT INTO `store` (`id`, `name`, `logo`)
VALUES (4, 'Media Expert', 'https://tychy.geminipark.pl/wp-content/uploads/2022/06/logotypy_mediaexpert.png');

INSERT INTO `producer` (`id`, `name`, `country`)
VALUES (1, 'Steelseries', 'Denmark');
INSERT INTO `producer` (`id`, `name`, `country`)
VALUES (2, 'Acer', 'Taiwan');
INSERT INTO `producer` (`id`, `name`, `country`)
VALUES (3, 'Razer', 'USA');
INSERT INTO `producer` (`id`, `name`, `country`)
VALUES (4, 'Lenovo', 'China');

INSERT INTO `product` (`id`, `name`, `photo`, `producer_id`, `price`)
VALUES (1, 'Arctis Nova Elite', 'https://images.ctfassets.net/hmm5mo4qf4mf/7tSln6l9gp3Xhcbx0jWsYN/0e947bfefcb76dfd702a02f290a9ebeb/arctis_nova_elite_sage_gold_img_buy_primary.png?fm=webp&q=90&fit=scale&w=768', 1, 599.99);
INSERT INTO `product` (`id`, `name`, `photo`, `producer_id`, `price`)
VALUES (2, 'Apex Pro Gen 3', 'https://images.ctfassets.net/hmm5mo4qf4mf/EmzhCU4XjBiVebd68loN6/7d2683bc1b3d19e3cef0a39efa0faa1f/e5ca6f19587a4e508c2b2339898595d7-3786.png?fm=webp&q=90&fit=scale&w=768', 1, 219.99);
INSERT INTO `product` (`id`, `name`, `photo`, `producer_id`, `price`)
VALUES (3, 'Swift Go 14', 'https://static2-ecemea.acer.com/media/catalog/product/a/c/acer-swift-go-14-sfg14-63-with-fingerprint-with-backlit-on-wp-oled-start-screen-steel-gray-01_7.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=320&width=320&canvas=320:320', 2, 1243.27);
INSERT INTO `product` (`id`, `name`, `photo`, `producer_id`, `price`)
VALUES (4, 'Aspire C24 Ultra', 'https://cdn.x-kom.pl/i/setup/images/prod/big/product-big,,2025/5/pr_2025_5_30_9_16_17_919_00.jpg', 2, 952.94);
INSERT INTO `product` (`id`, `name`, `photo`, `producer_id`, `price`)
VALUES (5, 'Kraken Tournament', 'https://cdn.x-kom.pl/i/setup/images/prod/big/product-new-big,,2018/11/pr_2018_11_19_16_2_54_770_00.jpg', 3, 59.68);
INSERT INTO `product` (`id`, `name`, `photo`, `producer_id`, `price`)
VALUES (6, 'Viper V3 Hyperspeed', 'https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcTV1qWtxA5bBKycDEwX4bVlV7zeXeTjx-SIE30UyJR4W4zNS79nb9cNpnOJ8rUuvG2yAGan8IZDa2Ka82InoHg6GRlWL86UlxvQg0BR-oHf', 3, 60.55);
INSERT INTO `product` (`id`, `name`, `photo`, `producer_id`, `price`)
VALUES (7, 'Loq 15ARP9 ', 'https://prod-api.mediaexpert.pl/api/images/gallery/thumbnails/images/91/9136106/Laptop-LENOVO-LOQ-15ARP9-1.jpg', 4, 1078.1);
INSERT INTO `product` (`id`, `name`, `photo`, `producer_id`, `price`)
VALUES (8, 'Legion Go S', 'https://f00.esfr.pl/foto/8/156772454513/9bedb485bc023df34522dbd89a68ac3f/lenovo-legion-go-s-steam-os,156772454513_5.webp', 4, 701.70);

INSERT INTO `product_store`(`product_id`, `store_id`)
VALUES ('1', '1');
INSERT INTO `product_store`(`product_id`, `store_id`)
VALUES ('1', '3');
INSERT INTO `product_store`(`product_id`, `store_id`)
VALUES ('2', '3');
INSERT INTO `product_store`(`product_id`, `store_id`)
VALUES ('3', '1');
INSERT INTO `product_store`(`product_id`, `store_id`)
VALUES ('3', '2');
INSERT INTO `product_store`(`product_id`, `store_id`)
VALUES ('4', '1');
INSERT INTO `product_store`(`product_id`, `store_id`)
VALUES ('4', '3');
INSERT INTO `product_store`(`product_id`, `store_id`)
VALUES ('5', '2');
INSERT INTO `product_store`(`product_id`, `store_id`)
VALUES ('5', '3');
INSERT INTO `product_store`(`product_id`, `store_id`)
VALUES ('6', '1');
INSERT INTO `product_store`(`product_id`, `store_id`)
VALUES ('7', '2');
INSERT INTO `product_store`(`product_id`, `store_id`)
VALUES ('8', '1');


CREATE TABLE user
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE role
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    role     VARCHAR(255)
);

INSERT INTO user(username, password)
VALUES ('dbuser1', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS'),
       ('dbuser2', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS'),
       ('dbuser3', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS');


INSERT INTO role(username, role)
VALUES ('dbuser1', 'USER_ADMIN'),
       ('dbuser2', 'AUTHOR_ADMIN'),
       ('dbuser3', 'BOOK_ADMIN');




