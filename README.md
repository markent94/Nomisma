Readme - Nomisma by Mark Bercasio, Barryn Chun, Egan Nakano, Shaziney Natividad
ICS 491

For this iteration of the project, Shaziney worked on creating the login functionality. The methods check for user input from which it can be compared to a username/password database table.

Egan worked on the user menu - from which the user is able to log transactions and check for balance.

Barryn and Mark worked on the database aspect of the project. Mark set up the Java - JDBM - MySQL drivers and connections whereas Barryn handled the SQL queries to be used.

Ver 2.0

Barryn worked on setting up and running the login GUI along with validating username / password input with the database.

Shaziney worked on input validation and tested out input/output of the program to verify correctness.

Egan refined the menu option, which now includes the different methods associated with each choice.

Mark worked on unifying the two tables within the database schema and set up the prepared statements to be used for future queries on the database.

Ver 3.0 - Final

Barryn worked on the menu GUI that displays the user's transactions. The user is able to input how much they've spent and their new total balance is displayed on the screen as well as the different categories for spending.

Mark worked on connecting the menu GUI to the backend functions that use the database queries. The functions were edited as to better output changes in data onto the GUI screen.

Shaziney and Egan worked on final tests on the program in search of possible issues that were left unhandled. In addition, they worked on editing the MySQL connection code so that it could access Barryn's database.

The program turned out to be successful for the most part. However, there is a security issue that arises with the nature of how we designed the program and the scope with which the project is in prevents us from making significant changes. We talk more about it in our report. We decided to change the functionality of how users would create new accounts. Similar to the UH Manoa method of creating an account, new users would email their username and password to the company mailing list (teamomega491@gmail.com) along with a set balance they'd like to use. We'd verify if the data is sufficient and return an email if it was accepted or rejected. With that said, mroe time on the project would allow the team to expand on the scalability and ease with which users could access their personal data. Perhaps we could find methods by which we could connect bank accounts with our system.
