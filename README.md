# Library Management System

This repository contains a console-based Library Management System implemented in Java for the University of Moratuwa. It models a small library where staff or students can add different types of books, borrow and return them, and inspect current inventory—all via a text-based menu.

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

## Output

![1](https://github.com/user-attachments/assets/542a6354-1a7f-4420-bdd2-af92cb5366aa)

![2](https://github.com/user-attachments/assets/9539f17e-2309-4a2a-a8c8-c64fdea6cd7e)

![3](https://github.com/user-attachments/assets/02f4aa0f-91f5-4a98-b0a6-ced01c4e5d63)

![4](https://github.com/user-attachments/assets/85335a2b-2384-4207-898e-60ef2f43620d)

![5](https://github.com/user-attachments/assets/7a5b4260-465c-4c4c-881e-009928ac1a09)

![6](https://github.com/user-attachments/assets/209ed86d-db99-40cc-bde9-c162a1f50b7e)

![7](https://github.com/user-attachments/assets/e96916e4-20f0-45b5-8f87-9d71a1f6ecbe)

![8](https://github.com/user-attachments/assets/438bf994-bdc0-4921-b613-f39158bbe231)

![9](https://github.com/user-attachments/assets/83c4fc23-1ad2-401e-82d2-a7c1ad1463ef)

![10](https://github.com/user-attachments/assets/2bef2922-f427-40aa-9c02-326d50a33832)

![11](https://github.com/user-attachments/assets/670fb9ec-4b65-41bb-ad60-83a04fe8559c)

![12](https://github.com/user-attachments/assets/aca9e20d-c965-4207-ae0a-6c71fa10fcaa)

![13](https://github.com/user-attachments/assets/52e1d421-4e1c-4257-b073-cb78bb870fc5)

![14](https://github.com/user-attachments/assets/77de3a5d-33a3-4851-b3bf-85ba07b9a622)


## Customisation Ideas
- Persist the catalogue and user data to disk (JSON, CSV, database) instead of keeping everything in memory.
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



