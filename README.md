# Datortehnika Web System

## Setup Instructions

### Backend Setup

#### **Prerequisites**
- **Java 17+** installed
- **IntelliJ IDEA (or any Java supporting IDE)**
- **SQLite Database Driver** (automatically included in dependencies)

1. **Clone the Backend Repository**
    ```
    git clone https://github.com/reinisa/Datortehnika.git
   
    cd datortehnika-web-system # Navigate to the root directory
    ```
2. **Build the project using Maven**
    ```
    mvn clean install
    ```
3. **Run the Main Application file**
    ```
    Open DatortehnikaWebSystemApplication.java and run it.
   
    - The backend will start on `http://localhost:8686`
    ```
4. **Swagger API Documentation** (Available when the server is running)
    ```
    http://localhost:8686/swagger-ui/index.html
    ```

### **Database Information**
- **SQLite Database (`datortehnikaDb.db`)**
- The database is automatically created in the project root directory.