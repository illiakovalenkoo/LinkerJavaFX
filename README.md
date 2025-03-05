# JavaFX Project - MySQL Integration

## 📖 Description
This is a **JavaFX desktop application** that connects to a **MySQL database** to store and retrieve data.  
It uses **Java 23, JavaFX 23, and MySQL 8+**.

---

## 🚀 Features
✔ Modern JavaFX UI  
✔ MySQL Database integration  
✔ Configurable `config.properties` for database settings  
✔ Works as `.jar` or `.exe`  

---

## 📦 Requirements
Before running the application, make sure you have installed:  

### **1️⃣ Java Development Kit (JDK)**
- **Download JDK 23+**: [Adoptium JDK](https://adoptium.net/)  
- Verify installation:
  ```sh
  java -version
  ```
  
### **2️⃣ JavaFX SDK**
- **Download JavaFX 23 SDK**: [Gluon JavaFX](https://gluonhq.com/products/javafx/)  
- Extract and set up the JavaFX library.

### **3️⃣ MySQL Database**
- Install **MySQL Server 8+**: [Download MySQL](https://dev.mysql.com/downloads/)
- Create a database:  
  ```sql
  CREATE DATABASE spring3_db;
  ```
- Make sure MySQL is **running on `localhost:3306`**.

---

## ⚙️ **Configuration**
1. Open the `config.properties` file (`src/main/resources/config.properties`).
2. Update database credentials if needed:
   ```
   db.url=jdbc:mysql://localhost:3306/spring3_db
   db.user=root
   db.password=root
   ```
3. Save and close.

---

## 💻 **How to Run the Application**
### **Option 1: Running from IntelliJ IDEA**
1. Open the project in IntelliJ IDEA.
2. Make sure **JavaFX and MySQL Connector JARs** are loaded in dependencies.
3. Run the `HelloApplication` class.

### **Option 2: Running as a JAR**
1. **Compile the project**:
   ```sh
   mvn clean package
   ```
2. **Run the JAR file**:
   ```sh
   java --module-path "C:\path\to\javafx-sdk-23.0.2\lib" --add-modules javafx.controls,javafx.fxml -jar target/projectJavaFX.jar
   ```

### **Option 3: Running as an EXE (Windows)**
1. Use `Launch4j` to generate an `.exe` file.
2. Run the generated `projectJavaFX.exe`.

---

## 🛠 **Built With**
- **Java 23**
- **JavaFX 23**
- **MySQL 8**
- **Maven**
- **Launch4j (for `.exe`)**

---

## 📜 **License**
This project is licensed under the **MIT License** – feel free to modify and use.  

🚀 **Happy coding!**
