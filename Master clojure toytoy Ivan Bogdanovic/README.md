# ToyToy
Inspirated by toys.Maked for warehouse inspection ,you can see availability of toys and prices.From navigation bar you can choose
to see list of toys update them, also you can add new toy and delete other toys. When you click on the tab "Picture Of Toys" you can 
see the picture of some toys.
Choose from navigation bar :
				"List Of Toys"-you can see list of toys from database and you can update them.
				"Add New Toy"-you can add name of toy ,type,price,number of sold toys and availability.After that you are on home screen,
				and you can see the new list of toys when you click "List Of Toys".
				"Delete Toys"-you can see list of toys and delete them from database. If you click on delete button you are on the same 
				screen and you have new list of items without deleted item.
			
## Technical specification
*Hiccup
Hiccup is a library for representing HTML in Clojure. It uses vectors to represent elements, and maps to represent an element's attributes.
To use hiccup i just need to put dependency to my project.clj.
*Clostache
Mustache for Clojure.Template, in this project used for "pictureOfToys.mustache" page.
We need dependency [de.ubercode.clostache/clostache "1.4.0"] inside of project.clj.
*CSS
Used bootstrap and custom css.
*Jquery.slides
Used for slider on page "Picture Of Toys".
*JDBC
Driver i use to connect to mysql database.Also need dependency inside of project.clj.
*Ring
Used ring-core - essential functions for handling parameters, cookies and more.
## Requirements

You must have MySql database server active (through WAMP, XAMPP etc.)
It is necessary to import toytoy.sql database.

You will need Leiningen installed:
https://leiningen.org/

## Usage

For staring a web server run:
    lein ring server


