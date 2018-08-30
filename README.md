# JavaAdvanced_ExamPrep

Make a Spring project that allows you to get book recommendations.

A book consists of a Title, Author, and a Category, either Fiction or NonFiction.
Book recommendations are random, and are based on a list of books that you own, but have not read. For the purpose of this exercise, assume all books are standalone, vs part of a series that should be read in a certain order.
Books fall into two categories: fiction and non-fiction. You can choose either, or none, in which case the whole list will be used.

Books are stored in a MySQL database. Make use of Hibernate and JPA.
Books can be added. They can also be deleted, by title. This should be done using Swing.
Whenever a book is recommended, a messagebox will show which one, and the software will put it on hold for the next two recommendations, after which it is eligible for recommendation again, so as not to recommend the same book twice in a row. If you do not have enough books to pass this test, it will take a random book from the whole list (or by category). A messagebox is shown when this happens. The same applies for there not being any books.

# When running this project on your own pc

Change the application.properties file to your specifications. e.g. MySql port, pwd, ...
Create an empty Database called books in your MySql Workbench, or change the name of the DB in the application.properties file and create one with that name.
The books table is created on startup, and is initialized empty.
