import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Base Book class
class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean availability;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.availability = true; // By default, a new book is available
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}

// FictionBook class inheriting from Book
class FictionBook extends Book {
    public FictionBook(String title, String author, String isbn) {
        super(title, author, isbn);
    }
}

// NonFictionBook class inheriting from Book
class NonFictionBook extends Book {
    public NonFictionBook(String title, String author, String isbn) {
        super(title, author, isbn);
    }
}

// HistoricalBook class inheriting from Book
class HistoricalBook extends Book {
    public HistoricalBook(String title, String author, String isbn) {
        super(title, author, isbn);
    }
}

// MathematicalBook class inheriting from Book
class MathematicalBook extends Book {
    public MathematicalBook(String title, String author, String isbn) {
        super(title, author, isbn);
    }
}

// ProgrammingBook class inheriting from Book
class ProgrammingBook extends Book {
    public ProgrammingBook(String title, String author, String isbn) {
        super(title, author, isbn);
    }
}

// Library class managing a collection of books
class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
        // Add some default books
        addDefaultBooks();
    }

    // Method to add default books to the library
    private void addDefaultBooks() {
        FictionBook fictionBook = new FictionBook("The Great Gatsby", "F. Scott Fitzgerald", "1");
        NonFictionBook nonFictionBook = new NonFictionBook("Sapiens: A Brief History of Humankind", "Yuval Noah Harari",
                "2");
        HistoricalBook historicalBook = new HistoricalBook("The Book Thief", "Markus Zusak", "3");
        MathematicalBook mathematicalBook = new MathematicalBook("The Joy of x", "Steven Strogatz", "4");
        ProgrammingBook programmingBook = new ProgrammingBook("Clean Code: A Handbook of Agile Software Craftsmanship",
                "Robert C. Martin", "5");

        books.add(fictionBook);
        books.add(nonFictionBook);
        books.add(historicalBook);
        books.add(mathematicalBook);
        books.add(programmingBook);
    }

    // Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("\t\tBook added to the library: " + book.getTitle() + "-----" + book.getAuthor() + "-----"
                + book.getIsbn());
    }

    // Display the list of available books with details and types
    public void displayAvailableBooks() {
        System.out.println("\n\t\tAvailable Books: \n");
        for (Book book : books) {
            if (book.isAvailable()) {

                System.out.println(getBookType(book) + " ----- " + book.getTitle() + " ----- " + book.getAuthor()
                        + " -----(ISBN: " + book.getIsbn() + ")");
            }
        }
    }

    // Get the book type
    private String getBookType(Book book) {
        if (book instanceof FictionBook) {
            return "Fiction";
        } else if (book instanceof NonFictionBook) {
            return "Non-Fiction";
        } else if (book instanceof HistoricalBook) {
            return "Historical";
        } else if (book instanceof MathematicalBook) {
            return "Mathematical";
        } else if (book instanceof ProgrammingBook) {
            return "Programming";
        } else {
            return "Unknown";
        }
    }

    // Borrow a book (update availability status)
    public void borrowBook(User user, String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && book.isAvailable()) {
                user.borrowBook(book);
                book.setAvailability(false);
                System.out.println("\t\tBook borrowed successfully: " + book.getTitle() + "-----" + book.getIsbn());
                return;
            }
        }
        System.out.println("Book with ISBN " + isbn);

    }

    // Return a book (update availability status)
    public void returnBook(User user, String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && !book.isAvailable()) {
                user.returnBook(book);
                book.setAvailability(true);
                System.out.println("\t\tBook returned successfully: " + book.getTitle() + "-----" + book.getAuthor()
                        + "-----" + book.getIsbn());
                return;
            }
        }
        System.out.println("Book with ISBN " + isbn + " cannot be returned or is not borrowed by the user.");

    }
}

// User class representing a library user
class User {
    private static int userCount = 1;
    private int userId;
    private String userName;
    private List<Book> borrowedBooks;

    public User(String userName) {

        this.userNmae = userName;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    // Set user ID
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Borrow a book
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    // Return a book
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    // Display borrowed books
    public void displayBorrowedBooks() {
        System.out.println("\t\tBorrowed Books by User " + userId + ":");
        for (Book book : borrowedBooks) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " (ISBN: " + book.getIsbn() + ")");
        }
    }
}

public class LibraryManagementSystem__UOM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\nWelcome to the Library Management System, University of Moratuwa!");

        System.out.print("\n\nRules to follow...");
        System.out.print("\n\t1.To be a member of Library of UOM, need unique ID for the user");
        System.out.print("\n\t2.Use ID for borrow and return books from the Library,UOM");
        System.out.print(
                "\n\t3.User must return books in 7 days. if not user should pay money Rs.1000 per day and can't borrow book next time");
        System.out.print("\n|n\t4.you can enjoy the full facilities of the Library,UOM with responsibilities");
        System.out.print(
                "\n\n----------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.print("\n\nStaff Details...");
        System.out.print("\n\tLibrary Clark : Mrs.Rameesh");
        System.out.print("\n\tLibrary Assistant : Miss.Niranchana");
        System.out.print("\n\tLibrary Technician : Mr.Sunthar");
        System.out.print(
                "\n\n----------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.print("\n\n\n .....Let's Begining.....");
        System.out.print("\n\nEnter user ID: ");
        System.out.print("\nEnter user Name: ");
        User user = new User();
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        // Set the user ID
        user.setUserId(userId);
        uaer.setUserName(userName);

        Library library = new Library();

        while (true) {
            System.out.println(
                    "\n\n-------------------------------------------------------------------------------------------");
            System.out.println("\t\t\t1. Add a Fiction Book");
            System.out.println("\t\t\t2. Add a Non-Fiction Book");
            System.out.println("\t\t\t3. Add a Historical Book");
            System.out.println("\t\t\t4. Add a Mathematical Book");
            System.out.println("\t\t\t5. Add a Programming Book");
            System.out.println("\t\t\t6. Display available books");
            System.out.println("\t\t\t7. Borrow a book");
            System.out.println("\t\t\t8. Return a book");
            System.out.println("\t\t\t9. Display borrowed books");
            System.out.println("\t\t\t10. Exit");

            System.out.print("Enter the action: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("\nEnter details for a Fiction Book!");
                    System.out.print("\tTitle: ");
                    String fictionTitle = scanner.nextLine();
                    System.out.print("\tAuthor: ");
                    String fictionAuthor = scanner.nextLine();
                    System.out.print("\tISBN: ");
                    String fictionIsbn = scanner.nextLine();

                    FictionBook fictionBook = new FictionBook(fictionTitle, fictionAuthor, fictionIsbn);
                    library.addBook(fictionBook);
                    break;
                case 2:
                    System.out.println("\nEnter details for a Non-Fiction Book!");
                    System.out.print("\tTitle: ");
                    String nonFictionTitle = scanner.nextLine();
                    System.out.print("\tAuthor: ");
                    String nonFictionAuthor = scanner.nextLine();
                    System.out.print("\tISBN: ");
                    String nonFictionIsbn = scanner.nextLine();

                    NonFictionBook nonFictionBook = new NonFictionBook(nonFictionTitle, nonFictionAuthor,
                            nonFictionIsbn);
                    library.addBook(nonFictionBook);
                    break;
                case 3:
                    System.out.println("\nEnter details for a Historical Book!");
                    System.out.print("\tTitle: ");
                    String historicalTitle = scanner.nextLine();
                    System.out.print("\tAuthor: ");
                    String historicalAuthor = scanner.nextLine();
                    System.out.print("\tISBN: ");
                    String historicalIsbn = scanner.nextLine();

                    HistoricalBook historicalBook = new HistoricalBook(historicalTitle, historicalAuthor,
                            historicalIsbn);
                    library.addBook(historicalBook);
                    break;
                case 4:
                    System.out.println("\nEnter details for a Mathematical Book!");
                    System.out.print("\tTitle: ");
                    String mathematicalTitle = scanner.nextLine();
                    System.out.print("\tAuthor: ");
                    String mathematicalAuthor = scanner.nextLine();
                    System.out.print("\tISBN: ");
                    String mathematicalIsbn = scanner.nextLine();

                    MathematicalBook mathematicalBook = new MathematicalBook(mathematicalTitle, mathematicalAuthor,
                            mathematicalIsbn);
                    library.addBook(mathematicalBook);
                    break;
                case 5:
                    System.out.println("\nEnter details for ProgrammingBook!");
                    System.out.print("\tTitle: ");
                    String programmingTitle = scanner.nextLine();
                    System.out.print("\tAuthor: ");
                    String programmingAuthor = scanner.nextLine();
                    System.out.print("\tISBN: ");
                    String programmingIsbn = scanner.nextLine();

                    ProgrammingBook programmingBook = new ProgrammingBook(programmingTitle, programmingAuthor,
                            programmingIsbn);
                    library.addBook(programmingBook);
                    break;
                case 6:
                    library.displayAvailableBooks();
                    break;
                case 7:
                    System.out.print("\nEnter the ISBN to borrow a book: ");
                    String borrowIsbn = scanner.nextLine();
                    library.borrowBook(user, borrowIsbn);
                    break;
                case 8:
                    System.out.print("\nEnter the ISBN to return a book: ");
                    String returnIsbn = scanner.nextLine();
                    library.returnBook(user, returnIsbn);
                    break;
                case 9:
                    user.displayBorrowedBooks();
                    break;
                case 10:
                    System.out.println("\nExiting the system. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("\nInvalid choice. Please enter a number between 1 and 10.");
            }
        }
    }
}