# Personal_finance_manager

Personal Finance Manager is a full-stack web application that helps users efficiently track and manage their income, expenses, and financial activities.
The system provides a secure backend using **Spring Boot** and **MySQL**, along with a responsive and modern frontend built using **React**, **JavaScript**, and **Bootstrap**.
This project demonstrates full-stack development skills including REST API creation, database integration, state management, and responsive UI design.

---
## Table of Contents
1. [Features](#features)
2. [Tech Stack](#tech-stack)
3. [Project Structure](#project-structure)
4. [Installation](#installation)
5. [Usage](#usage)
6. [Screenshots](#Screenshots)

   ## Features
   
  - **User Authentication**
  Register and log in with JWT-based authentication, providing secure access to personal     
     finance data.

 - **Transaction Management**
  Add income or expense transactions.
  Specify amount, category, date, and description.
  View all transactions.
  Delete or update transactions.

 - **Category Management**

     Users can:
  Create custom categories (e.g., Rent, Groceries, Salary, Utilities) Delete categories Assign     categories to transactions


  - **User Profile**
    
    View account details Manage personal information  Secure user-specific data access

  - **Dashboard Statistics**
     - Total Income
     - Total Expenses
     - Current Balance
     - Summary cards for quick overview

   - **Transaction Filters**
     - Filter by income or expense
     - Filter by category
     - Better tracking and financial insights

   - **Protected Endpoints**
     All backend APIs are secured using JWT authentication. Each user can only access their own       financial data.

     - **Responsive UI**
      - Built with React.js + Bootstrap
      - Fully responsive for desktop and mobile devices
      - Clean and user-friendly interface

## Tech Stack
  
🔹 **Backend**
   - [Java](https://www.oracle.com/java/)
   - [SpringBoot](https://spring.io/projects/spring-boot)
   - [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
   - [Spring Security](https://spring.io/projects/spring-security)
   - [Hibernate](https://hibernate.org/)
   - [Maven](https://maven.apache.org/)

🔹 **Frontend**
   - [React.js](https://reactjs.org/)
   - [React Rounter](https://reactrouter.com/)
   - [Boostrap](https://getbootstrap.com/)
   - [Axios](https://axios-http.com/)

🔹 **Database**
   - [MySQL](https://www.mysql.com/)
    

## Project Structure

```plaintext
Personal-Finance-Manager
│
├── backend (Spring Boot)
│   ├── controller
│   ├── service
│   ├── dao
│   ├── model
│   └── config
│
├── frontend (React)
│   ├── components
│   ├── pages
│   ├── context
│   └── services
│
└── README.md

```
## Installation

  ## 1.Clone the Repository
```bash
  git clone https://github.com/your-username/Personal-Finance-Manager.git
cd Personal-Finance-Manager
```
🔹 **Backend Setup (Spring Boot)**
     
  ## 2. **Open in Eclipse**
    - Open **Eclipse IDE**
    - Click **File → Import → Existing Maven Project**
    - Select the backend folder
    - Click **Finish**

## 3. **Configure Database**
```code
 src/main/resources/application.properties
```
```properties
spring.application.name=Personal_Finance_Manager_1

server.port=8086
spring.datasource.url=jdbc:mysql://localhost:3307/Personal_finance_Manager1 
spring.datasource.username=root
spring.datasource.password=root@123

spring.jpa.open-in-view=false
spring.jpa.hibernate.ddl-auto=update
```
## 4.Run Backend

Right click on:
 ```code
   PersonalFinanceManagerApplication.java
```
Click:
```code
Run As → Spring Boot App
```
Backend runs on:
``` code
http://localhost:8086
```

🔹 **Frontend Setup (React)**
## 5. Install Frontend Dependencies
```Bash
cd  fianancemanager
npm install
```

## 6.Start Frontend

```Bash
   npm start
```
Frontend runs on:

```Code
http://localhost:3000
```

## Usage

### 1. Start the Backend
From the `backend` directory:
```bash
mvn spring-boot:run
```
- By default, runs on http://localhost:8086`

### Using Eclipse IDE

 1.Open the project in Eclipse

 2.Right-click on
```
PersonalFinanceManagerApplication.java
```
 3. Click:
   **Run As → Spring Boot App**

 Backend will start on:
 ```Code
     http://localhost:8086
 ```

### 2. Start the Frontend

Open a new terminal in the `frontend` directory:
```bash
npm start
```
- By default, runs on `http://localhost:3000`

  ### 3. Access the Application
  Open your browser at `http://localhost:3000`. You can sign up for a new account or log in if  you already have one.
  


### Screnshort



<img width="1919" height="847" alt="Screenshot 2026-02-28 152755" src="https://github.com/user-attachments/assets/6fa56a0c-0c37-412a-a2ec-4624e43ce0a4" />

###















   
