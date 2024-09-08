# OTP Service

This is a Spring Boot application that provides OTP (One-Time Password) generation and validation services with support for multiple channels (Email and SMS).

## Table of Contents
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Configuration](#configuration)
- [Building the Application](#building-the-application)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [Security](#security)
- [Contributing](#contributing)
- [License](#license)

## Features

- Generate OTP for a given recipient via Email or SMS
- Validate OTP
- Automatic OTP expiration
- Integration with Twilio for SMS sending

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- Twilio account (for SMS functionality)

## Configuration

1. Clone the repository:
   ```
   git clone https://github.com/your-username/otp-service.git
   cd otp-service
   ```

2. Update `src/main/resources/application.properties` with your Twilio credentials:
   ```
   twilio.account.sid=your_account_sid_here
   twilio.auth.token=your_auth_token_here
   twilio.phone.number=your_twilio_phone_number_here
   ```

## Building the Application

To build the application, run:
mvn clean install

## Running the Application

To run the application, use:
mvn spring-boot:run

The application will start on `http://localhost:8080`.

## API Endpoints

1. Generate OTP:
   ```
   POST /api/otp/generate
   Parameters:
   - recipient: Email address or phone number
   - channel: EMAIL or SMS
   ```

2. Validate OTP:
   ```
   POST /api/otp/validate
   Parameters:
   - recipient: Email address or phone number
   - otp: The OTP to validate
   ```

## Testing

To run the tests, use:
mvn test

## Security

The application uses basic authentication. The default credentials are:
- Username: user
- Password: test

You can change these in the `application.properties` file.

## Contributing

Please read CONTRIBUTING.md for details on our code of conduct, and the process for submitting pull requests.

## License

This project is licensed under the MIT License - see the LICENSE.md file for details.
