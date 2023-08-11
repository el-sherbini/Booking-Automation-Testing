# Booking-Test-Automation
> This is a test automation task on [__Booking.com__](https://www.booking.com/) website (Reservation).

## Installation

Clone the repo:

```sh
git clone https://github.com/el-sherbini/Booking-Automation-Testing.git
```

Install dependencies:

You need to install these dependencies from [_mvnrepository_](https://mvnrepository.com/):

```sh
Selenium
Testng
Webdrivermanager
POI
```

## Test Scenarios

Scenario:
1. Open www.booking.com
2. In search type the Location "Alexandria", select Check-in date "1 October 2023" and Checkout date "14 October 2023" (Excel Sheet (data provider)), and click Search
3. From search results, pick "Tolip Hotel Alexandria" (it can be on the first or second page)
4. Click on the See Availability button to go to the booking’s details page
5. On the details page: Select the bed and amount and click I’ll reserve button to navigate to the confirmation page

## Skills

- Java
- Selenium
- TestNG
- POM (Page Object Model)
- Apache POI (Data Driven Framework)
