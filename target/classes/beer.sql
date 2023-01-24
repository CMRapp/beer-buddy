/* create first */
DROP TABLE IF EXISTS brewery;
CREATE TABLE brewery(
brewery_pk INT AUTO_INCREMENT NOT NULL,
name VARCHAR(128) NOT NULL,
country VARCHAR(30) NOT NULL,
website VARCHAR(150),
PRIMARY KEY (brewery_pk)
);

/* create second */
DROP TABLE IF EXISTS beers;
CREATE TABLE beers(
beer_pk INT AUTO_INCREMENT NOT NULL,
beer_name VARCHAR(128) NOT NULL,
brewery_id INT NOT NULL,
category VARCHAR(25) NOT NULL,
flavor VARCHAR(25),
abv DOUBLE,
ibu INT,
description MEDIUMTEXT,
PRIMARY KEY (beer_pk),
FOREIGN KEY (brewery_id) REFERENCES brewery (brewery_pk) ON DELETE CASCADE
);

DROP TABLE IF EXISTS category;
CREATE TABLE category(
category_pk INT AUTO_INCREMENT NOT NULL,
name VARCHAR(25) NOT NULL,
description MEDIUMTEXT,
PRIMARY KEY (category_pk)
);

DROP TABLE IF EXISTS flavor;
CREATE TABLE flavor(
flavor_pk INT AUTO_INCREMENT NOT NULL,
name VARCHAR(25) NOT NULL,
PRIMARY KEY (flavor_pk)
);



/* JOIN TABLE */
DROP TABLE IF EXISTS flavor_profile;
CREATE TABLE flavor_profile (
beer_pk INT NOT NULL,
flavor_pk INT NOT NULL,
FOREIGN KEY (beer_pk) REFERENCES beers (beer_pk) ON DELETE CASCADE,
FOREIGN KEY (flavor_pk) REFERENCES flavor (flavor_pk) ON DELETE CASCADE
);



/* Category Names */
INSERT INTO category (name) VALUES ('Ale');
INSERT INTO category (name) VALUES ('Blonde Ale');
INSERT INTO category (name) VALUES ('Brown Ale');
INSERT INTO category (name) VALUES ('India Pale Ale');
INSERT INTO category (name) VALUES ('Lager');
INSERT INTO category (name) VALUES ('Pale Ale');
INSERT INTO category (name) VALUES ('Porter');
INSERT INTO category (name) VALUES ('Pilsner');
INSERT INTO category (name) VALUES ('Session IPA');
INSERT INTO category (name) VALUES ('Stout');
INSERT INTO category (name) VALUES ('Sour Ale');
INSERT INTO category (name) VALUES ('Wheat');

/* Category Descriptions */
UPDATE category
SET description = ''
WHERE category_name = ''

UPDATE category
SET description = 'Ale is a general category of beer: You will find sub-categories like brown ales or pale ales. This is the oldest style of beer, which dates back to antiquity. What distinguishes an ale - and also makes this category of beer accessible for home brewers - is a warm-temperature fermentation for a relatively short period of time. In the brewing process, brewers introduce top-fermenting yeasts which, as the name suggests, ferment on the top of the brew. The fermentation process turns what would otherwise be a barley and malt tea into a boozy beverage.'
WHERE category_name = 'Ale'

UPDATE category
SET description = 'Lagers are a newer style of beer with two key differences from ales. Lagers ferment for a long time at a low temperature, and they rely on bottom-fermenting yeasts, which sink to the bottom of the fermenting tank to do their magic.
Lagers are common among European countries, including Czechia, Germany, and the Netherlands, as well as in Canada, where they make up more than half of all beer sales.'
WHERE category_name = 'Lager'

UPDATE category
SET description = 'This easy drinking ale is a summer favorite, thanks to its light malt sweetness and trace of hops, which add aroma. As the name suggests, blonde ales have a pale color and a clear body. They tend to be crisp and dry, with few traces of bitterness, rather than hop-heavy or dank.'
WHERE category_name = 'Blonde Ale'

UPDATE category
SET description = 'Brown ales range in color from amber to brown, with chocolate, caramel, citrus, or nut notes. Brown ales are a bit of a mixed bag, since the different malts used and the country of origin can greatly affect the flavor and scent of this underrated beer style.'
WHERE category_name = 'Brown Ale'

UPDATE category
SET description = 'Originally, India Pale Ale or IPA was a British pale ale brewed with extra hops. High levels of this bittering agent made the beer stable enough to survive the long boat trip to India without spoiling. The extra dose of hops gives IPA beers their bitter taste. Depending on the style of hops used, IPAs may have fruit-forward citrus flavors or taste of resin and pine. American brewers have taken the IPA style and run with it, introducing unusual flavors and ingredients to satisfy U.S. beer drinkers'' love for the brew style.'
WHERE category_name = 'India Pale Ale'

UPDATE category
SET description = 'An English style of ale, pale ales and known for their copper color and fruity scent. Don''t let the name fool you: these beers are strong enough to pair well with spicy foods. Related to the pale is the APA, or American Pale Ale, which is somewhat of a hybrid between the traditional English pale ale and the IPA style. American pale ales are hoppier and usually feature American two row malt.'
WHERE category_name = 'Pale Ale'

UPDATE category
SET description = 'A type of ale, porter beers are known for their dark black color and roasted malt aroma and notes. Porters may be fruity or dry in flavor, which is determined by the variety of roasted malt used in the brewing process.'
WHERE category_name = 'Porter'

UPDATE category
SET description = 'A subspecies of lager, pilsner beers are distinguished by their water, which varies from neutral too hard. Pilsners are among the hoppiest lagers and generally have a dry, slightly bitter flavor. Their light golden color, clear body, and crisp finish make Pilsners a popular summer beer.'
WHERE category_name = 'Pilsner'

UPDATE category
SET description = 'Session IPAs are India pale ales with lower alcohol content than a traditional IPA. However, when it comes to session vs. IPA beers, session IPAs have higher ABVs than regular session brews.'
WHERE category_name = 'Session IPA'

UPDATE category
SET description = 'Like porters, stouts are dark, roasted ales. Stouts taste less sweet than porters and often feature a bitter coffee taste, which comes from unmalted roasted barley that is added to the wort. They are characterized by a thick, creamy head. Ireland''s Guinness may be one of the world''s best-known stouts.'
WHERE category_name = 'Stout'

UPDATE category
SET description = 'An ancient style of beer that''s taken off in popularity in recent years, sour ales are crafted from wild yeasts, much like sourdough bread. These beers are known for a tart tang that pairs well with tropical fruit and spices. Within sour beers, you''ll find lambics, which are Belgian sour beers mixed with fruit, goses, a German sour beer made with coriander and sea salt, and Flanders, a Belgian sour beer fermented in wood tanks.'
WHERE category_name = 'Sour Ale'

UPDATE category
SET description = 'An easy-drinking, light style of beer, wheat beers are known for a soft, smooth flavor and a hazy body. Wheat beers tend to taste like spices or citrus, with the hefeweizen or unfiltered wheat beer being one of the more common styles.'
WHERE category_name = 'Wheat'

/* FLavor Names */
INSERT INTO flavor (name) VALUES ('Bitter');
INSERT INTO flavor (name)VALUES ('Crisp');
INSERT INTO flavor (name) VALUES ('Funky');
INSERT INTO flavor (name) VALUES ('Sour');
INSERT INTO flavor (name) VALUES ('Tart');
INSERT INTO flavor (name) VALUES ('Smokey');
INSERT INTO flavor (name) VALUES ('Hoppy');
INSERT INTO flavor (name) VALUES ('Malty');
INSERT INTO flavor (name) VALUES ('Roasty');
INSERT INTO flavor (name) VALUES ('Fruity');
INSERT INTO flavor (name) VALUES ('Tasteless');
INSERT INTO flavor (name) VALUES ('Light');
INSERT INTO flavor (name) VALUES ('Dry');
INSERT INTO flavor (name) VALUES ('Smooth');

/* Breweries */
INSERT INTO brewery (name, country, website) VALUES ('Upstream Brewing Company', 'USA', 'www.upstreambrewing.com');
INSERT INTO brewery (name, country, website) VALUES ('Fort Myers Brewing Company', 'USA', 'www.fmbrew.com');
INSERT INTO brewery (name, country, website) VALUES ('Samuel Adams', 'USA', 'www.samueladams.com');
INSERT INTO brewery (name, country, website) VALUES ('The Mcauslan Brewery', 'Montreal', 'https://mcauslan.com/en');

/* Beers */
INSERT INTO beers (beer_name, brewery_id, category, flavor, abv, ibu, description) VALUES ('St-Ambroise Irish Stout', 4, 'Stout', 'Malty', 4.2, 23, 'Black in colour, the flavor from the roasted malts is coffee-like with a slight acidity. This is complimented by the medium hop flavour and the very smooth finish.');
INSERT INTO beers (beer_name, brewery_id, category, flavor, abv, ibu, description) VALUES ('St-Ambroise Pale Ale', 4, 'Pale Ale', 'Hoppy', 5.0, 35, 'St-Ambroise Pale Ale is a golden, generously hopped brew, and a prennial favourite of the many Pale Ale drinkers who have enjoyed it''s rich, fruity flavour since 1989.');
INSERT INTO beers (beer_name, brewery_id, category, flavor, abv, ibu, description) VALUES ('St-Ambroise Baltic Porter', 4, 'Porter', 'Smooth', 8.2, 38, 'St-Ambroise Baltic Porter combines what is best of the British-style porters and the sweeter Russian Imperial Stouts brewed in countries on the Baltic Sea. This smooth, full-bodied tribute to those beers has a rich malt flavour with concentrated caramel highlights along with notes of chocolate, liquorce and dark fruit.');

INSERT INTO beers (beer_name, brewery_id, category, flavor, abv, ibu, description) VALUES ('Samuel Adams Boston Lager', 3, 'Lager', 'Hoppy', 5.0, 30, 'A distinctive balance of Spicy Hops, Slightly Roasted Malts and a smooth finish.');
INSERT INTO beers (beer_name, brewery_id, category, flavor, abv, ibu, description) VALUES ('Samuel Adams Wicked Hazy IPA', 3, 'India Pale Ale', 'Bitter', 6.8, 35, 'Super-juiced with haze for days. How about a rush of pineapple over here? How about a one-two punch of mango and peach over there? Wicked Hazy is a little bit extra - a blast of tropical fruit, with a smooth, silky finish.');
INSERT INTO beers (beer_name, brewery_id, category, flavor, abv, ibu, description) VALUES ('Samuel Adams Cold Snap White Ale', 3, 'Ale', 'Fruity', 5.3, 12, 'Bright citrus and floral notes with a touch of vanilla, and smooth, subtle sweetness that says spring is on the way.');
INSERT INTO beers (beer_name, brewery_id, category, flavor, abv, ibu, description) VALUES ('Samuel Adams Festbier', 3, 'Lager', 'Malty', 5.8, 22, 'Just like they drink at Munich''s Oktoberfest. Malty with a soft sweetness, like a biscuit spread with honey. This light lager has a higher ABV to get the cheers a little bigger.');

INSERT INTO beers (beer_name, brewery_id, category, flavor, abv, ibu, description) VALUES ('Gateway Gold Blonde Ale', 2, 'Blonde Ale', 'Crisp', 4.1, 0, 'Smooth and light bodied with a sweetness from the brewing with honey malt. This honey blonde ale is a perfect gateway into craft beer drinking.');
INSERT INTO beers (beer_name, brewery_id, category, flavor, abv, ibu, description) VALUES ('High 5 IPA', 2, 'India Pale Ale', 'Hoppy', 5.9, 59, 'Brewed and dry hopped beer with Citra and Centennial hops to create piney, citrusy aromas and flavors bursting out of every pint.' );
INSERT INTO beers (beer_name, brewery_id, category, flavor, abv, ibu, description) VALUES ('Fort Myers Wheat', 2, 'Wheat', 'Dry', 5.0, 0, 'Fort Myers American Wheat brings the Florida sunshine to the glass. This award winning beer boasts a light and crisp body with refreshing hints of Florida citrus flavors on the finish.');
INSERT INTO beers (beer_name, brewery_id, category, flavor, abv, ibu, description) VALUES ('Get Lei''d', 2, 'Ale', 'Fruity', 4.1, 0, 'Our summertime pineapple infused ale is the perfect refresher for the dog days of summer that happen to be most days in Southwest Florida.');

INSERT INTO beers (beer_name, brewery_id, category, flavor, abv, ibu, description) VALUES ('O! Gold Light Lager', 1, 'Lager', 'Dry', 3.8, 4, 'A light, dry, clean and balanced AMerican Light Lager');
INSERT INTO beers (beer_name, brewery_id, category, flavor, abv, ibu, description) VALUES ('Firehouse Red Lager', 1, 'Lager', 'Roasty', 4.5, 10, 'Medium-Light Body, Malty yet Crisp with Notes of Caramel and Toffee');
INSERT INTO beers (beer_name, brewery_id, category, flavor, abv, ibu, description) VALUES ('Capitol Pale Ale', 1, 'Pale Ale', 'Tasteless', 5.0, 25, 'Light Body, Bright Hops, Citrus, Pine, Earthy, Reserved Malt, Balanced Finish. Brewed with Nebraska Grown Cascade, Chinook, Centennial, and Comet Hops');

/* Flavor Profiles */
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (1,8);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (1,9);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (2,7);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (2,10);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (3,8);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (3,9);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (4,7);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (4,1);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (5,7);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (5,1);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (5,10);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (6,2);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (6,10);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (7,2);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (7,10);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (8,2);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (9,7);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (9,1);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (10,2);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (10,26);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (11,2);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (11,27);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (13,9);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (13,27);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (14,7);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (14,11);
INSERT INTO flavor_profile (beer_pk, flavor_pk) VALUES (14,1);
