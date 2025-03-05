# projectJavaFX - URL Shortener

## 📖 Project Overview
**projectJavaFX** is a JavaFX-based **URL Shortener** application that allows users to store and manage shortened links.  
Users can enter a **long URL** and assign a **short name** to it. The program **stores the mapping in a database**  
and allows users to access and manage their shortened links.

---

## 🚀 Features
✔ **Shorten long URLs** with custom names  
✔ **Store links in a MySQL database**  
✔ **Click on short links to open the original URL**  
✔ **List all stored links in the database**  
✔ **Modern JavaFX-based UI**  
✔ **Images folder with test screenshots**  

---

## 🛠 How It Works
1. **Enter a long URL** (e.g., `https://example.com/very-long-url`).
2. **Enter a short name** (e.g., `my-short-link`).
3. **The link is stored in the database** and appears in the list.
4. **Click on a short link** to open the original URL in a browser.

**Example:**
- Input:  
  - **Long URL:** `https://example.com/some-really-long-address`
  - **Short Name:** `example-short`
- Output:  
  - The user can now access the long URL via:  
    `http://localhost:8080/example-short`

---

## 📦 System Requirements

### **1️⃣ Java Development Kit (JDK)**
- Download **JDK 23+**: [Adoptium JDK](https://adoptium.net/)  
- Verify installation:
  ```sh
  java -version
  ```

### **2️⃣ JavaFX SDK**
- Download **JavaFX 23 SDK**: [Gluon JavaFX](https://gluonhq.com/products/javafx/)  
- Extract and set up JavaFX libraries.

### **3️⃣ MySQL Database**
- Install **MySQL Server 8+**: [Download MySQL](https://dev.mysql.com/downloads/)
- Create the database using:
  ```sql
  CREATE DATABASE shortener_db;
  ```

---

## 📂 Images Folder

The project includes an **images/** folder containing UI test screenshots:
- `img.png` – Main link shortening interface  
- `img2.png` – Detailed information screen  

These images help verify the UI and ensure smooth functionality.

---

## ⚙️ Configuration

1. Open `config.properties` (located in `src/main/resources/config.properties`).
2. Modify database connection settings if needed:
   ```properties
   db.url=jdbc:mysql://localhost:3306/shortener_db
   db.user=root
   db.password=root
   ```
3. Save the file.

---

## 💻 How to Run the Application

### **Option 1: Running from IntelliJ IDEA**
1. Open the project in **IntelliJ IDEA**.
2. Ensure **JavaFX SDK and MySQL Connector JARs** are loaded in dependencies.
3. Run the `HelloApplication` class.

### **Option 2: Running as a JAR**
1. **Build the project** using Maven:
   ```sh
   mvn clean package
   ```
2. **Run the JAR file**:
   ```sh
   java --module-path "C:\path	o\javafx-sdk-23.0.2\lib" --add-modules javafx.controls,javafx.fxml -jar target/projectJavaFX.jar
   ```

### **Option 3: Running as an EXE (Windows)**
1. Use **Launch4j** to generate an `.exe` file.
2. Run `projectJavaFX.exe` located in the project directory.

---

## 🛠 Built With
- **Java 23**
- **JavaFX 23**
- **MySQL 8**
- **Maven**
- **Launch4j (for `.exe` creation)**

---

## 📜 License
This project is licensed under the **MIT License** – feel free to use and modify it.  

🚀 **Happy coding!**
