# 🥙 Restaurant Management System (Java Swing)

This repository features a robust Desktop Application developed in **Java** using the **Swing** framework. It simulates a Point of Sale (POS) system for a "Falafel & Street Food" restaurant, featuring a modern Dark Mode UI, real-time calculations, and an invoice generation system.

## 📸 Screenshots

### 1. Secure Login System
The gateway to the application features a modern dark-themed login interface.

![Login Screen](screenshots/Screenshot%202025-12-17%20114945.png)

### 2. Interactive Dashboard
The main operational hub where orders are taken, extras are added, and costs are calculated in real-time.

![Dashboard Screen](https://github.com/ahmedelsayedali1/Restaurant-Management-System-Java/blob/main/screenshots/Screenshot%202025-12-17%20115030.png)

### 3. Invoice Generation
An example of the auto-generated text receipt saved by the system.

![Invoice Example](screenshots/invoice_example.png)

---

## ✨ Key Features

### 1. Secure Login System (`LogIn.java`)
A stylized login interface that serves as the gateway to the dashboard.
* **Modern UI:** Custom-styled text fields and buttons with a dark color palette.
* **Authentication:** Validates username and password before granting access.
* **Default Credentials:** `admin` / `1234`

### 2. Interactive Dashboard (`DashBoard.java`)
The core operational window divided into logical sections:
* **Menu Selection:** Interactive items (Falafel, Foul) with quantity spinners (`JSpinner`).
* **Customization:** Checkboxes to add extras (e.g., Eggplant for food, Ice for drinks) which dynamically adjust the unit price.
* **Billing Engine:**
    * Calculates **Subtotal** automatically.
    * Applies a **5% Tax** rate.
    * Displays the final **Total Amount**.

### 3. File Handling & Invoicing
The system implements persistent data storage using `java.io`.
* **Save Invoice:** Generates a detailed `.txt` receipt containing the Order ID, Date/Time, Itemized List, and Total Cost.
* **File Organization:** Automatically creates a directory to store invoices if it doesn't exist.

## 🛠️ Technical Implementation

* **Language:** Java (JDK 8+)
* **GUI Framework:** Swing & AWT (Abstract Window Toolkit).
* **Layout Managers:** `GridBagLayout` (for centering Login) and `GridLayout` (for Dashboard structure).
* **Concepts:**
    * Object-Oriented Programming (OOP).
    * Event Handling (`ActionListener`).
    * File I/O (`PrintWriter`, `File` classes).
    * Date & Time API (`LocalDateTime`).

## ⚙️ Configuration (Important)

> **⚠️ Note:** The current version uses absolute file paths for images and invoice saving.
> Before running, please update the paths in the code to match your machine:
> 1. **Images:** Search for `"C:\\Users\\..."` in `LogIn.java` and update it to your local image path.
> 2. **Invoices:** In `DashBoard.java`, update the `folderPath` variable to your desired save location.

## 🚀 Getting Started

1. **Compile the code:**
    ```bash
    javac Practical/*.java
    ```

2. **Run the application:**
    ```bash
    java Practical.LogIn
    ```

## 📂 Invoice Example (`.txt`)

When a user saves an order, the system outputs a file formatted as follows:

```text
******** مطعم فلافل ********
رقم الفاتورة: 1
التاريخ: 2025/12/13 21:44:41
============================
2x فلافل (بالباذنجان) ... 14.0
2x عصير (مثلج) ...... 24.0
----------------------------
المجموع:  38.0
الضريبة:  1.9
الإجمالي: 39.9 جنية
============================
     شكراً لزيارتكم
