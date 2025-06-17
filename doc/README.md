# Linker - JavaFX URL Shortener

**Linker** is a JavaFX-based application that allows users to store and manage shortened links. The application supports **database storage via MySQL** and provides a **modern UI with FXML and CSS**.

## 1. How to Download and Run the Project

### **Prerequisites**

To run this project, you need to have:

- **Java Development Kit (JDK) 23+** installed. Download from [Adoptium JDK](https://adoptium.net/) or use OpenJDK.
- **JavaFX SDK 23** installed. Download from [Gluon JavaFX](https://gluonhq.com/products/javafx/) or [OpenJFX](https://openjfx.io/).
- **MySQL Database** installed. You can use [MAMP](https://www.mamp.info/en/) for an easy setup on macOS or Windows.

### **Setting Up the MySQL Database with MAMP**

1. **Install MAMP**:

   - Download and install MAMP from the [official website](https://www.mamp.info/en/).

2. **Start MAMP**:

   - Open the MAMP application and click on "Start Servers".

3. **Access phpMyAdmin**:

   - Click on "Open WebStart page" in MAMP.
   - Navigate to the "Tools" section and select "phpMyAdmin".

4. **Create a New Database**:

   - In phpMyAdmin, go to the "Databases" tab.
   - Enter a name for your database (e.g., `linker_db`) and click "Create".

5. **Create the Necessary Tables**:

   - Select the newly created database.
   - Go to the "SQL" tab and execute the following SQL statements to create the required tables:

     ```sql
     CREATE TABLE links (
         id INT AUTO_INCREMENT PRIMARY KEY,
         short_name VARCHAR(50) NOT NULL UNIQUE,
         long_url TEXT NOT NULL
     );
     ```

### **Clone the Repository**

1. **Download the repository**:

   ```sh
   git clone https://github.com/illiakovalenkoo/LinkerJavaFX.git
   cd LinkerJavaFX
   ```

### **Configure the Application**

1. **Set Database Connection Properties**:

   - Locate the configuration file (e.g., `config.properties`) in the `src/linker` directory.
   - Update the database connection properties to match your MySQL setup:

     ```properties
     db.url=jdbc:mysql://localhost:3306/linker_db
     db.username=root
     db.password=root
     ```

### **Run the Application**

- **Option 1: Using the `.jar` file**:

  ```sh
  java -jar linker.jar
  ```

  If JavaFX is missing, use:

  ```sh
  java --module-path "path_to_javafx_sdk/lib" --add-modules javafx.controls,javafx.fxml -jar "path_to_project/linker.jar"
  ```

- **Option 2: Using an IDE**:

  - Open the project in your preferred IDE (e.g., IntelliJ IDEA).
  - Ensure that the JavaFX SDK is properly configured in your project settings.
  - Run the `Main` class located in the `src/linker` directory.

## 2. First-Time Execution Issues

- **Java not installed** → Install **JDK 23+**.
- **JavaFX not found** → Install JavaFX SDK and configure it in your environment.
- **MySQL database not configured** → Ensure MySQL is running, and the database along with the necessary tables are created as described above.

## 3. Project Structure

```
LinkerJavaFX/                      # Root project directory
│── src/                           # Source code of the application
│── images/                        # Screenshots and images for documentation
│── doc/                           # README.md file
```

## 4. Technologies Used

- **Java 23+**
- **JavaFX 23**
- **MySQL** (via MAMP)
- **FXML (UI Layouts)**
- **CSS (UI Styling)**
- **Maven** (for project management)
- **JUnit** (for testing)

## 5. Application Testing

The application has been tested for:

- **Shortening and storing URLs**
- **Database integration with MySQL**
- **Managing and opening short links**
- **Graphical interface responsiveness**

### `images/` Folder

img.png -
img2.png - 
imp3.png

Screenshots and other images related to the application's UI and functionality are stored in the `images/` folder.

## 6. License

This project is licensed under the **MIT License**. You are free to use, modify, and distribute this software with no restrictions. The software is provided "as is", without warranty of any kind.


