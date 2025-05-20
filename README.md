# 🏨 Hotel Management System

This project presents the **design and implementation** of a full-featured **Hotel Management System** aimed at automating and optimizing guest room operations. Built with a **scalable three-tier architecture**, the system supports essential hotel functions like **room booking, employee and parking management, billing, and analytics**, all integrated into a seamless web interface.

The system empowers hotel staff to manage daily operations with ease, enhancing productivity and delivering a modern experience aligned with contemporary guest expectations.

---

## 🚀 Features

- 🔐 **User Authentication**  
  Secure login and registration functionality for staff and admin users.

- 🛏️ **Room Reservation**  
  Customers can book rooms online based on real-time availability and category.

- 🧾 **Check-In / Check-Out**  
  Manages the arrival and departure of guests with tracking.

- 👩‍💼 **Employee Management**  
  Admins can add, update, and manage employee records and role assignments.

- 🚗 **Parking Management**  
  Organizes and tracks available parking spaces for hotel guests.

- 💰 **Dynamic Pricing**  
  Automatically adjusts room prices based on demand and occupancy trends.

- 💳 **Billing and Invoicing**  
  Generates digital invoices for stays and services rendered.

- 🎟️ **Voucher System**  
  Create and manage discount vouchers. Customers can apply vouchers at checkout.

- 📊 **Analytics Dashboard**  
  Displays real-time statistics on room occupancy, bookings, and user activity.

- 📝 **Feedback Collection**  
  Guests can submit feedback and reviews about their stay.

---

## ⚙️ Technologies Used

### 🖥️ Frontend

- **HTML5** — Page structure  
- **CSS3** — Styling  
- **JavaScript** — Interactive behaviors  
- **Bootstrap** — Responsive UI design

### 🧠 Backend

- **Java Servlets** — Handle business logic and HTTP requests/responses  
- **Java Classes** — Define models and business processes  
- **JSP (JavaServer Pages)** — For server-side rendering

### 🗄️ Database

- **MySQL** — Relational database for persistent data  
- **JDBC (Java Database Connectivity)** — Bridge between Java and MySQL

---

## 🛠️ Development Environment Setup

### Prerequisites

- [Eclipse IDE for Java EE Developers](https://www.eclipse.org/downloads/packages/)
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Apache Tomcat Server](https://tomcat.apache.org/) — to deploy and run the application
- [MySQL Workbench](https://dev.mysql.com/downloads/workbench/) — for database management

---

## 📦 How to Run the Project

1. **Clone the Repository**

   ```bash
   git clone https://github.com/RevishaVas/Hotel-Management-System.git
   
2. **Import the Project in Eclipse**

   Open Eclipse IDE

   File → Import → Dynamic Web Project → Select folder

3.  **Configure Tomcat Server**

     Add Tomcat in Eclipse

     Right-click project → Run on Server

4. **Setup Database**

    Open MySQL Workbench

    Import the SQL dump (if provided)

    Update ```DBConfig.java``` or relevant class with your credentials

5. **Launch the App**

    Go to ```http://localhost:8080/Hotel-Management-System```

    Use login credentials to test different roles (Admin, Staff)

