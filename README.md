<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OTP Service README</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 20px;
            max-width: 800px;
            margin: 0 auto;
        }
        h1, h2 {
            color: #333;
        }
        code {
            background-color: #f4f4f4;
            padding: 2px 5px;
            border-radius: 3px;
        }
        pre {
            background-color: #f4f4f4;
            padding: 10px;
            border-radius: 5px;
            overflow-x: auto;
        }
        #toc {
            background-color: #f8f8f8;
            padding: 20px;
            border-radius: 5px;
            margin-bottom: 20px;
        }
        #toc ul {
            list-style-type: none;
            padding-left: 20px;
        }
    </style>
</head>
<body>
    <h1>OTP Service</h1>
    
    <div id="toc">
        <h2>Table of Contents</h2>
        <ul>
            <li><a href="#features">Features</a></li>
            <li><a href="#prerequisites">Prerequisites</a></li>
            <li><a href="#configuration">Configuration</a></li>
            <li><a href="#building">Building the Application</a></li>
            <li><a href="#running">Running the Application</a></li>
            <li><a href="#api">API Endpoints</a></li>
            <li><a href="#testing">Testing</a></li>
            <li><a href="#security">Security</a></li>
            <li><a href="#contributing">Contributing</a></li>
            <li><a href="#license">License</a></li>
        </ul>
    </div>

    <p>This is a Spring Boot application that provides OTP (One-Time Password) generation and validation services with support for multiple channels (Email and SMS).</p>

    <h2 id="features">Features</h2>
    <ul>
        <li>Generate OTP for a given recipient via Email or SMS</li>
        <li>Validate OTP</li>
        <li>Automatic OTP expiration</li>
        <li>Integration with Twilio for SMS sending</li>
    </ul>

    <h2 id="prerequisites">Prerequisites</h2>
    <ul>
        <li>Java 11 or higher</li>
        <li>Maven 3.6 or higher</li>
        <li>Twilio account (for SMS functionality)</li>
    </ul>

    <h2 id="configuration">Configuration</h2>
    <ol>
        <li>Clone the repository:
            <pre><code>git clone https://github.com/your-username/otp-service.git
cd otp-service</code></pre>
        </li>
        <li>Update <code>src/main/resources/application.properties</code> with your Twilio credentials:
            <pre><code>twilio.account.sid=your_account_sid_here
twilio.auth.token=your_auth_token_here
twilio.phone.number=your_twilio_phone_number_here</code></pre>
        </li>
    </ol>

    <h2 id="building">Building the Application</h2>
    <p>To build the application, run:</p>
    <pre><code>mvn clean install</code></pre>

    <h2 id="running">Running the Application</h2>
    <p>To run the application, use:</p>
    <pre><code>mvn spring-boot:run</code></pre>
    <p>The application will start on <code>http://localhost:8080</code>.</p>

    <h2 id="api">API Endpoints</h2>
    <ol>
        <li>Generate OTP:
            <pre><code>POST /api/otp/generate
Parameters:
- recipient: Email address or phone number
- channel: EMAIL or SMS</code></pre>
        </li>
        <li>Validate OTP:
            <pre><code>POST /api/otp/validate
Parameters:
- recipient: Email address or phone number
- otp: The OTP to validate</code></pre>
        </li>
    </ol>

    <h2 id="testing">Testing</h2>
    <p>To run the tests, use:</p>
    <pre><code>mvn test</code></pre>

    <h2 id="security">Security</h2>
    <p>The application uses basic authentication. The default credentials are:</p>
    <ul>
        <li>Username: user</li>
        <li>Password: test</li>
    </ul>
    <p>You can change these in the <code>application.properties</code> file.</p>

    <h2 id="contributing">Contributing</h2>
    <p>Please read CONTRIBUTING.md for details on our code of conduct, and the process for submitting pull requests.</p>

    <h2 id="license">License</h2>
    <p>This project is licensed under the MIT License - see the LICENSE.md file for details.</p>
</body>
</html>
