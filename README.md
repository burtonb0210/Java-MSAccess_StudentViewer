# Java-MSAccess_StudentViewer
Java console application for viewing student and major records from a Microsoft Access database using JDBC.

# Java Student & Major Viewer

A Java console application that connects to a Microsoft Access `.accdb` database and allows users to view student and major records through a menu-based interface.

---

## 📚 Description

This project demonstrates:
- JDBC database connectivity with MS Access
- Console-based menu system
- Exception handling and input validation
- Modular structure using multiple helper classes

---

## 🗂️ Project Structure

| File Name              | Purpose                                                                 |
|------------------------|-------------------------------------------------------------------------|
| `MainViewer.java`      | Displays the menu and handles user interaction                         |
| `ViewStudentsMajors.java` | Manages database connection and combined data viewing logic           |
| `DisplayMajorInfo.java` | Retrieves and displays major records from the database                  |
| `DisplayStudentInfo.java` | Retrieves and displays student records from the database (not shown here but expected in full project) |

---

## 🧪 Features

- Opens a `.accdb` Access database using UCanAccess JDBC
- Displays formatted student and major records
- Handles invalid input gracefully
- Simple, user-friendly command-line interface
