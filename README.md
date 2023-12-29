# Pizza Maker 🍕

Pizza Maker is a purpose-built mobile application designed for the dedicated staff at your pizzeria. Developed using Android Studio, this comprehensive system streamlines the process of taking and managing customer orders. With intuitive functionalities, Pizza Maker empowers pizzeria employees to seamlessly handle order creation, review the current order status, place orders efficiently, and keep track of all active orders within the store.
## Detailed System Description

### Core Functionalities

#### Add Pizzas to Order

Users can add pizzas to their order with ease. The options include:

- **Specialty Pizzas:** Choose from a diverse list of 13 specialty pizzas, each defined by a dedicated class and characterized by unique ingredients and preparations.
  
- **Build Your Own Pizza:** Customize pizzas with a selection of toppings, sauces, and sizes. The application supports modifications like extra cheese or sauce, facilitated by the enum classes.

#### View Current Order

* Store staff can add one or more pizzas to an order or remove selected pizzas.
* Before placing an order, staff can review the current order details, including selected toppings, sauce/extra sauce, extra cheese, individual pizza prices, total amount, sales tax amount, and order total.

#### View All Orders

* The system keeps track of all store orders, allowing staff to browse and cancel orders.
* Store orders are displayed by order numbers, including the order total (with 2 decimal places) and the list of pizzas in each order.


### User Interface & Interaction

- **Dynamic Pricing/Image Display:** As the store staff selects the pizza size, toppings, and additional options like extra cheese or sauce, the system dynamically updates and displays the running pizza price with precision up to two decimal places. For specialty pizzas, the `imageView` changes as well.

- **Order Management:** The staff can add multiple pizzas to an order or remove any previously selected pizza. Before finalizing, they can review the detailed current order, which includes individual pizza prices, the total amount, and the calculated sales tax.

- **Sales Tax Calculation:** The system calculates the sales tax based on the New Jersey rate of 6.625%, adding it to the total amount to compute the order total.

- **Order Tracking and Browsing:** All orders are tracked uniquely via order numbers. The staff can browse through all store orders, cancel any order, and view detailed totals and pizza lists for each.

## Technical Specifications

### Action Event Handling

The application employs lambda expressions for handling action events, streamlining the code for event listeners and providing a more concise way to implement functionality that responds to user interactions.

### Singleton State Management

The `PizzaManager` class uses the Singleton pattern to maintain a consistent state across the application, ensuring that the front end remains synchronized with the backend data. It handles the addition and removal of pizzas from the current order and maintains visibility over all store orders.

### Enum Classes

Enumerations for Topping, Sauce, and Size offer a standardized way of selecting options for pizzas. Each enum class defines the permissible values for its respective category, ensuring valid selections and simplifying the process of creating or customizing pizzas.

### Specialty Pizza Classes

The application boasts a collection of 13 specialty pizza classes, each representing a unique recipe. These classes inherit from the `Pizza` class, allowing for polymorphic behavior while providing specialized configurations for each type of pizza.

### Abstract Factory Pattern

To instantiate new pizzas, an Abstract Factory design pattern is employed. This pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes, enhancing the modularity and scalability of the application.

## Technologies Used

- **Android Studio:** The project is developed using Android Studio, a popular integrated development environment for Android app development.

- **RecyclerView:**
  - The core of Pizza Maker's dynamic list presentation is the `RecyclerView`. In Android development, the `RecyclerView` efficiently handles large datasets in a scrollable and reusable manner.
  - **Adapter:** The `RecyclerView.Adapter` connects data to the UI, creating and binding views for each item. Pizza Maker employs a custom adapter to manage the display of pizzas in the order and store orders.
  - **LayoutManager:** Determines how items are arranged in the `RecyclerView`. Pizza Maker selects a suitable layout to provide an intuitive representation of pizza orders and store orders.
  - **ViewHolder:** Represents each item in the `RecyclerView` and optimizes scrolling performance by recycling views. Custom ViewHolder classes in Pizza Maker efficiently handle the display of pizza details.

- **Spinner:** Employed to create a dropdown menu for selecting sizes for Build Your Own pizza.

- **ListView:** Used to present the list of toppings, allowing users to customize their own pizzas in Build Your Own Pizza. Used to view the orders in Store Order and Current Order.

## System Use Flow

1. The store staff starts a new order and selects either a specialty pizza or the option to build a custom pizza.
2. For a custom pizza, they choose toppings (up to 7, but min of 3), sauce type, and size. For specialty pizzas, they select from predefined options and add extra sauce or cheese if desired.
3. As selections are made, the system provides a live update on the cost.
4. Once the pizza(s) selection is complete, the staff reviews the order details, including the tax calculation.
5. The order can be placed, modified, or canceled based on the customer's final decision.
6. Completed orders are tracked and can be reviewed or canceled from the order list.

## How to Use

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/pizza-maker.git
   ```

2. **Open in Android Studio:**
   Open the project in Android Studio to review, modify, or build upon the existing codebase.

3. **Run the Application:**
   Run the application in an Android emulator or on a physical Android device to experience the Pizza Maker in action.
