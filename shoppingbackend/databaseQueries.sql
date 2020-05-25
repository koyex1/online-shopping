 DROP ALL OBJECTS 
 
CREATE TABLE category(
 id IDENTITY,
 name VARCHAR(50),
 description VARCHAR(255),
 image_url VARCHAR(50),
 is_active BOOLEAN,
 
 CONSTRAINT pk_category_id PRIMARY KEY (id)
 );
 
INSERT INTO category (name, description, image_url, is_active) VALUES('Laptop','This is description for Laptop category!', 'CAT_1.png',true)
INSERT INTO category (name, description, image_url, is_active) VALUES('Television','This is description for Television category!', 'CAT_2.png',true)
INSERT INTO category (name, description, image_url, is_active) VALUES('Mobile','This is description for Mobile category!', 'CAT_3.png',true)

 
CREATE TABLE user_detail(
 id IDENTITY,
 first_name VARCHAR(50),
 last_name VARCHAR(50),
 role VARCHAR(50),
 enabled BOOLEAN,
 password VARCHAR(50),
 email VARCHAR(100),
 contact_number VARCHAR(15),

 CONSTRAINT pk_category_id PRIMARY KEY (id)
 );

 
 INSERT INTO user_detail (first_name)
 