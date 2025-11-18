# Library Management System

This repository contains a console-based Library Management System implemented in Java for the University of Moratuwa. It models a small library where staff or students can add different types of books, borrow and return them, and inspect current inventory—all via a text-based menu.

> The workspace also includes other projects (e.g., an Android sign-language translator). Unless you intend to work on them, focus on the root-level Java files for this Library Management System.

## Features
- **Object-oriented book catalog:** `Book` is the base class with shared fields (title, author, ISBN, availability). Specialized subclasses (`FictionBook`, `NonFictionBook`, `HistoricalBook`, `MathematicalBook`, `ProgrammingBook`) demonstrate inheritance.
- **Library operations:** The `Library` class seeds default books, lets you add more titles by genre, lists available books with type information, and updates availability as books are borrowed or returned.
- **User management:** `User` objects maintain a unique ID, a user name, and the list of borrowed books. Utility methods track what a patron currently has checked out.
- **Interactive CLI:** `LibraryManagementSystem__UOM` contains the `main` method with a loop-based menu (options 1–10) covering add/list/borrow/return workflows plus exit handling.
- **Educational messaging:** Console output introduces library rules, staff members, and general etiquette before the menu loop begins, mirroring a campus experience.

## Repository Layout
```
Library-Management-System/
├─ LibraryManagementSystem__UOM.java   # Main entry point + all supporting classes
├─ *.class                             # Precompiled class files (can be regenerated)
├─ README.md                           # Project documentation
├─ app/, openCVLibrary3413/            # Unrelated Android project (ignore for CLI)
└─ ...
```

## Prerequisites
- JDK 8 or later on your machine (`java -version` should succeed).
- A terminal/command prompt capable of running `javac` and `java`.

## Quick Start
1. **Clone the repo**
   ```bash
   git clone <repo-url>
   cd Library-Management-System
   ```
2. **Compile the console app**
   ```bash
   javac LibraryManagementSystem__UOM.java
   ```
   All helper classes live in the same source file, so a single command produces the necessary `.class` files.
3. **Run the program**
   ```bash
   java LibraryManagementSystem__UOM
   ```
   - Enter a user ID and name when prompted.
   - Use menu options 1–5 to add books of various genres.
   - Option 6 lists available books.
   - Options 7 and 8 borrow/return books by ISBN.
   - Option 9 shows the books currently borrowed by the user.
   - Option 10 exits the application.

## Customization Ideas
- Persist the catalog and user data to disk (JSON, CSV, database) instead of keeping everything in memory.
- Add validation for duplicate ISBNs or enforce maximum borrow limits per user.
- Track due dates and fines; extend the menu to process late returns automatically.
- Wrap the core logic in unit tests (e.g., JUnit) to verify borrowing/returning behavior.
- Replace the CLI with a GUI (Swing/JavaFX) or a REST API while reusing the same domain classes.

## Known Issues
- There are a few typos in the source (`userNmae`, `uaer`) that may prevent compilation—rename those identifiers consistently.
- `User` lacks a no-argument constructor, yet the main program currently calls `new User()`. Either supply one or instantiate with the required name parameter.
- Input handling assumes valid integers; entering text when a number is expected will throw an exception. Consider wrapping menu reads in try/catch blocks.

## Contributing
1. Fork and branch from `main`.
2. Make sure the program still compiles/runs via `javac`/`java`.
3. Document your changes (README updates, comments, or in-code docs as needed).
4. Open a pull request describing the motivation and testing steps.

## License
No explicit license is provided; treat this code as “all rights reserved” unless the repository owner states otherwise.

---
_Maintained as part of the University of Moratuwa Library Management System coursework._ #
