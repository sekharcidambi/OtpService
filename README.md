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

# Future roadmap
Based on the current implementation of this OTP service, here are some additional features to add:

1. Rate Limiting: Implement a mechanism to limit the number of OTP requests per recipient within a given time frame to prevent abuse.
2. OTP Resend Functionality: Add an endpoint to resend the OTP if the user doesn't receive it, with a cooldown period between resends.
3. OTP Expiration Cleanup: Create a scheduled task to automatically remove expired OTPs from the database.
4. Configurable OTP Settings: Allow customization of OTP length, expiration time, and other parameters through configuration files or database settings.
5. OTP Attempt Tracking: Implement a system to track failed OTP validation attempts and lock out users after a certain number of failures.
7. Audit Logging: Add comprehensive logging for OTP generation, validation, and other important events for security and debugging purposes.
8. Multi-tenancy Support: If applicable, add support for multiple organizations or applications using the same OTP service.
9. API Key Authentication: Implement an API key system for authenticating client applications that use the OTP service.
10. Metrics and Monitoring: Add endpoints or integrate with monitoring tools to track usage statistics and service health.
11. Internationalization: Support multiple languages for OTP messages and error responses.
12. OTP Delivery Status Tracking: Implement a way to track whether the OTP was successfully delivered (especially useful for SMS).
13. Backup OTP Channel: Allow users to specify a backup channel (e.g., email if SMS fails) for OTP delivery.
14. OTP Templates: Create customizable templates for OTP messages to allow for branding and different use cases.
15. Integration with User Management: If applicable, integrate the OTP service with a user management system for additional security checks.
16. OTP Blacklisting: Implement a system to blacklist certain OTPs that should never be generated (e.g., sequential numbers, repeated digits).

## Contributing

Please read CONTRIBUTING.md for details on our code of conduct, and the process for submitting pull requests.

## License

This project is licensed under the MIT License - see the LICENSE.md file for details.
