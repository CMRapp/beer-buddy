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

DROP TABLE IF EXISTS reviews;
CREATE TABLE reviews(
review_pk INT AUTO_INCREMENT NOT NULL,
beer_pk INT NOT NULL,
reviewer_name VARCHAR(35) NOT NULL,
rating INT NOT NULL,
review MEDIUMTEXT,
PRIMARY KEY (review_pk)
);


/* JOIN TABLE */
DROP TABLE IF EXISTS beer_reviews;
CREATE TABLE beer_reviews (
review_pk INT NOT NULL,
beer_pk INT NOT NULL,
FOREIGN KEY (review_pk) REFERENCES reviews (review_pk) ON DELETE CASCADE,
FOREIGN KEY (beer_pk) REFERENCES beers (beer_pk) ON DELETE CASCADE
);


/* Category Names */
INSERT INTO category (name) VALUES ('ALE');
INSERT INTO category (name) VALUES ('BLONDE_ALE');
INSERT INTO category (name) VALUES ('BROWN_ALE');
INSERT INTO category (name) VALUES ('INDIA_PALE_ALE');
INSERT INTO category (name) VALUES ('LAGER');
INSERT INTO category (name) VALUES ('PALE_ALE');
INSERT INTO category (name) VALUES ('PORTER');
INSERT INTO category (name) VALUES ('PILSNER');
INSERT INTO category (name) VALUES ('SESSION_IPA');
INSERT INTO category (name) VALUES ('STOUT');
INSERT INTO category (name) VALUES ('SOUR_ALE');
INSERT INTO category (name) VALUES ('WHEAT');

/* Category Descriptions | 1st is template for statement
UPDATE category
SET description = ''
WHERE name = '' */

UPDATE category
SET description = 'Ale is a general category of beer: You will find sub-categories like brown ales or pale ales. This is the oldest style of beer, which dates back to antiquity. What distinguishes an ale - and also makes this category of beer accessible for home brewers - is a warm-temperature fermentation for a relatively short period of time. In the brewing process, brewers introduce top-fermenting yeasts which, as the name suggests, ferment on the top of the brew. The fermentation process turns what would otherwise be a barley and malt tea into a boozy beverage.'
WHERE name = 'ALE'

UPDATE category
SET description = 'Lagers are a newer style of beer with two key differences from ales. Lagers ferment for a long time at a low temperature, and they rely on bottom-fermenting yeasts, which sink to the bottom of the fermenting tank to do their magic. Lagers are common among European countries, including Czechia, Germany, and the Netherlands, as well as in Canada, where they make up more than half of all beer sales.'
WHERE name = 'LAGER'

UPDATE category
SET description = 'This easy drinking ale is a summer favorite, thanks to its light malt sweetness and trace of hops, which add aroma. As the name suggests, blonde ales have a pale color and a clear body. They tend to be crisp and dry, with few traces of bitterness, rather than hop-heavy or dank.'
WHERE name = 'BLONDE_ALE'

UPDATE category
SET description = 'Brown ales range in color from amber to brown, with chocolate, caramel, citrus, or nut notes. Brown ales are a bit of a mixed bag, since the different malts used and the country of origin can greatly affect the flavor and scent of this underrated beer style.'
WHERE name = 'BROWN_ALE'

UPDATE category
SET description = 'Originally, India Pale Ale or IPA was a British pale ale brewed with extra hops. High levels of this bittering agent made the beer stable enough to survive the long boat trip to India without spoiling. The extra dose of hops gives IPA beers their bitter taste. Depending on the style of hops used, IPAs may have fruit-forward citrus flavors or taste of resin and pine. American brewers have taken the IPA style and run with it, introducing unusual flavors and ingredients to satisfy U.S. beer drinkers'' love for the brew style.'
WHERE name = 'INDIA_PALE_ALE'

UPDATE category
SET description = 'An English style of ale, pale ales and known for their copper color and fruity scent. Don''t let the name fool you: these beers are strong enough to pair well with spicy foods. Related to the pale is the APA, or American Pale Ale, which is somewhat of a hybrid between the traditional English pale ale and the IPA style. American pale ales are hoppier and usually feature American two row malt.'
WHERE name = 'PALE_ALE'

UPDATE category
SET description = 'A type of ale, porter beers are known for their dark black color and roasted malt aroma and notes. Porters may be fruity or dry in flavor, which is determined by the variety of roasted malt used in the brewing process.'
WHERE name = 'PORTER'

UPDATE category
SET description = 'A subspecies of lager, pilsner beers are distinguished by their water, which varies from neutral too hard. Pilsners are among the hoppiest lagers and generally have a dry, slightly bitter flavor. Their light golden color, clear body, and crisp finish make Pilsners a popular summer beer.'
WHERE name = 'PILSNER'

UPDATE category
SET description = 'Session IPAs are India pale ales with lower alcohol content than a traditional IPA. However, when it comes to session vs. IPA beers, session IPAs have higher ABVs than regular session brews.'
WHERE name = 'SESSION_IPA'

UPDATE category
SET description = 'Like porters, stouts are dark, roasted ales. Stouts taste less sweet than porters and often feature a bitter coffee taste, which comes from unmalted roasted barley that is added to the wort. They are characterized by a thick, creamy head. Ireland''s Guinness may be one of the world''s best-known stouts.'
WHERE name = 'STOUT'

UPDATE category
SET description = 'An ancient style of beer that''s taken off in popularity in recent years, sour ales are crafted from wild yeasts, much like sourdough bread. These beers are known for a tart tang that pairs well with tropical fruit and spices. Within sour beers, you''ll find lambics, which are Belgian sour beers mixed with fruit, goses, a German sour beer made with coriander and sea salt, and Flanders, a Belgian sour beer fermented in wood tanks.'
WHERE name = 'SOUR_ALE'

UPDATE category
SET description = 'An easy-drinking, light style of beer, wheat beers are known for a soft, smooth flavor and a hazy body. Wheat beers tend to taste like spices or citrus, with the hefeweizen or unfiltered wheat beer being one of the more common styles.'
WHERE name = 'WHEAT'


/* Breweries */
INSERT INTO brewery (name, country, website) VALUES ('Upstream Brewing Company', 'USA', 'https://www.upstreambrewing.com');
INSERT INTO brewery (name, country, website) VALUES ('Fort Myers Brewing Company', 'USA', 'https://www.fmbrew.com');
INSERT INTO brewery (name, country, website) VALUES ('Samuel Adams', 'USA', 'https://www.samueladams.com');
INSERT INTO brewery (name, country, website) VALUES ('The Mcauslan Brewery', 'Montreal', 'https://mcauslan.com/en');

/* Beers */
INSERT INTO beers (beer_name, brewery_id, category, abv, ibu, description) VALUES ('St-Ambroise Irish Stout', 4, 'STOUT', 4.2, 23, 'Black in colour, the flavor from the roasted malts is coffee-like with a slight acidity. This is complimented by the medium hop flavour and the very smooth finish.');
INSERT INTO beers (beer_name, brewery_id, category, abv, ibu, description) VALUES ('St-Ambroise Pale Ale', 4, 'PALE_ALE', 5.0, 35, 'St-Ambroise Pale Ale is a golden, generously hopped brew, and a prennial favourite of the many Pale Ale drinkers who have enjoyed it''s rich, fruity flavour since 1989.');
INSERT INTO beers (beer_name, brewery_id, category, abv, ibu, description) VALUES ('St-Ambroise Baltic Porter', 4, 'PORTER', 8.2, 38, 'St-Ambroise Baltic Porter combines what is best of the British-style porters and the sweeter Russian Imperial Stouts brewed in countries on the Baltic Sea. This smooth, full-bodied tribute to those beers has a rich malt flavour with concentrated caramel highlights along with notes of chocolate, liquorce and dark fruit.');

INSERT INTO beers (beer_name, brewery_id, category, abv, ibu, description) VALUES ('Samuel Adams Boston Lager', 3, 'LAGER', 5.0, 30, 'A distinctive balance of Spicy Hops, Slightly Roasted Malts and a smooth finish.');
INSERT INTO beers (beer_name, brewery_id, category, abv, ibu, description) VALUES ('Samuel Adams Wicked Hazy IPA', 3, 'INDIA_PALE_ALE', 6.8, 35, 'Super-juiced with haze for days. How about a rush of pineapple over here? How about a one-two punch of mango and peach over there? Wicked Hazy is a little bit extra - a blast of tropical fruit, with a smooth, silky finish.');
INSERT INTO beers (beer_name, brewery_id, category, abv, ibu, description) VALUES ('Samuel Adams Cold Snap White Ale', 3, 'ALE', 5.3, 12, 'Bright citrus and floral notes with a touch of vanilla, and smooth, subtle sweetness that says spring is on the way.');
INSERT INTO beers (beer_name, brewery_id, category, abv, ibu, description) VALUES ('Samuel Adams Festbier', 3, 'LAGER',  5.8, 22, 'Just like they drink at Munich''s Oktoberfest. Malty with a soft sweetness, like a biscuit spread with honey. This light lager has a higher ABV to get the cheers a little bigger.');

INSERT INTO beers (beer_name, brewery_id, category, abv, ibu, description) VALUES ('Gateway Gold Blonde Ale', 2, 'BLONDE_ALE', 4.1, 0, 'Smooth and light bodied with a sweetness from the brewing with honey malt. This honey blonde ale is a perfect gateway into craft beer drinking.');
INSERT INTO beers (beer_name, brewery_id, category, abv, ibu, description) VALUES ('High 5 IPA', 2, 'INDIA_PALE_ALE', 5.9, 59, 'Brewed and dry hopped beer with Citra and Centennial hops to create piney, citrusy aromas and flavors bursting out of every pint.' );
INSERT INTO beers (beer_name, brewery_id, category, abv, ibu, description) VALUES ('Fort Myers American Wheat', 2, 'WHEAT', 5.0, 0, 'Fort Myers American Wheat brings the Florida sunshine to the glass. This award winning beer boasts a light and crisp body with refreshing hints of Florida citrus flavors on the finish.');
INSERT INTO beers (beer_name, brewery_id, category, abv, ibu, description) VALUES ('Get Lei''d', 2, 'ALE', 4.1, 0, 'Our summertime pineapple infused ale is the perfect refresher for the dog days of summer that happen to be most days in Southwest Florida.');

INSERT INTO beers (beer_name, brewery_id, category, abv, ibu, description) VALUES ('O! Gold Light Lager', 1, 'LAGER', 3.8, 4, 'A light, dry, clean and balanced AMerican Light Lager');
INSERT INTO beers (beer_name, brewery_id, category, abv, ibu, description) VALUES ('Firehouse Red Lager', 1, 'LAGER', 4.5, 10, 'Medium-Light Body, Malty yet Crisp with Notes of Caramel and Toffee');
INSERT INTO beers (beer_name, brewery_id, category, abv, ibu, description) VALUES ('Upstream Capitol Pale Ale', 1, 'PALE_ALE', 5.0, 25, 'Light Body, Bright Hops, Citrus, Pine, Earthy, Reserved Malt, Balanced Finish. Brewed with Nebraska Grown Cascade, Chinook, Centennial, and Comet Hops');

/* Reviews */
/* Capitol Pale Ale */
INSERT INTO reviews (beer_id, name, rating, review) VALUES (14, 'ads135', 4, 'An earthy, grassy pale ale. Light and crisp. Medium bodied with little citrus aftertaste.');
INSERT INTO reviews (beer_id, name, rating, review) VALUES (14, 'AirForceHops', 4, 'Draft @ Old Market location. Slightly hazy glad. Aroma is citrus / mostly grapefruit with some mild lemon. Body is lighter side of medium. Pale grain body with a slightly / mild bitter finish. Respectable.');
INSERT INTO reviews (beer_id, name, rating, review) VALUES (14, 'Niko100', 5, 'Tap; Nice amber/gold color; Medium slight creamy body; Aroma of floral hops, hay/grain, & some citrus; Flavor of malt/biscuit, pine hops, some floral, and citrus; Finish is dry & fairly bitter; Not too bad.');

/*Ft Myers High 5 IPA */
INSERT INTO reviews (beer_id, name, rating, review) VALUES (9, 'johnnnniee', 3, 'On tap at the Yucatan Waterfront Matlacha, FL Mostly clear deep gold in color with a bubbly white head that persists. Sweet bready maltiness offset with grassy earthy citrus hops. Decent. ');
INSERT INTO reviews (beer_id, name, rating, review) VALUES (9, 'jw0406', 5, '12 oz can pours a golden color with a small white head. Aromas of citrus, pine, floral. Medium bodied, a very nice beaxh beer.');
INSERT INTO reviews (beer_id, name, rating, review) VALUES (9, 'Kleg', 3, '12 oz. can. Thanks Bob! Pours a cloudy gold color with a white head and very good retention. Great lacing. As expected, aroma of citrus and hops. Strong hoppy flavor with a biting dry finish and barely enough citrus to cut the bitterness. Medium body and good carbonation. Okay.');

/*Baltic Porter*/
INSERT INTO reviews (beer_id, name, rating, review) VALUES (3, 'Strangebrewer', 3, 'Poured deep brown with a creamy tan head. Roasty malt aroma with a licorice note. Full bodied, tight carbonation with a slick mouthfeel. Flavours of heavily roasted malt, slightly burnt but sweet, notes of molasses, raisin, coffee, cocoa, a bit tart.');
INSERT INTO reviews (beer_id, name, rating, review) VALUES (3, 'Tessic', 5, 'This porter poured a deep black colour with a creamy, tan coloured head. Nice lacing. Scents include wine, alcohol and light malt. First swig was really good and boozey. Thicker mouthfeel with a flavour burst at first. Flavours of ripe fruit, molasses, alcohol and sweet malt. Finish is medium thick sweet with just malty goodness lingering.');
INSERT INTO reviews (beer_id, name, rating, review) VALUES (3, 'Raistlin', 4, 'Pours black with tan head that stays and leaves bit of lacing behind. Aroma of fermented fruit. Taste of dark fruit with dark chocolate finish. Hides alcohol well. Soft carbonation with medium to heavy body.');

/*beer_reviews (JOIN TABLE) */
INSERT INTO beer_reviews (review_pk, beer_pk) VALUES (1,14);
INSERT INTO beer_reviews (review_pk, beer_pk) VALUES (2,14);
INSERT INTO beer_reviews (review_pk, beer_pk) VALUES (3, 14);
INSERT INTO beer_reviews (review_pk, beer_pk) VALUES (4,9);
INSERT INTO beer_reviews (review_pk, beer_pk) VALUES (5,9);
INSERT INTO beer_reviews (review_pk, beer_pk) VALUES (6,9);
INSERT INTO beer_reviews (review_pk, beer_pk) VALUES (7,3);
INSERT INTO beer_reviews (review_pk, beer_pk) VALUES (8,3);
INSERT INTO beer_reviews (review_pk, beer_pk) VALUES (9,3);
