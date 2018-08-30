# JavaAdvanced_ExamPrep

Make a Spring project that allows you to get book recommendations.

Book recommendations are random, and are based on a list of books that you own, but have not read. For the purpose of this exercise, assume all books are standalone, vs part of a series that should be read in a certain order.
Books fall into two categories: fiction and non-fiction. You can choose either, or none, in which case the whole list will be used.

Books are stored in a MySQL database. Make use of Hibernate and JPA.
Books can be added. They can also be deleted, from a dropdown list.
Whenever a book is recommended, the software will put it on hold for the next two recommendations, after which it is eligible for recommendation again, so as not to recommend the same book twice in a row.
