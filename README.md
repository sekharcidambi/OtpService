<h1 align="center"> OTP Service </h1> <br>

<p align="center">
  Java spring boot microservice to send an OTP to an email address and verify the OTP
</p>


## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Requirements](#requirements)
- [Quick Start](#quick-start)
- [Testing](#testing)
- [API](#requirements)




## Introduction

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/e91606af4a364076a7058c5ea1c006a8)](https://www.codacy.com/app/joneubank/microservice-template-java?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=overture-stack/microservice-template-java&amp;utm_campaign=Badge_Grade)
[![CircleCI](https://circleci.com/gh/overture-stack/microservice-template-java/tree/master.svg?style=shield)](https://circleci.com/gh/overture-stack/microservice-template-java/tree/master)

Java spring boot microservice to send an OTP to an email address and verify the OTP. Users mailersend to send the email OTP.

## Features
Generate and send an OTP to a email address
Verify the OTP associated with an email address


## Requirements
Mailersend api key to send emails


## Quick Start


### Run Local
```bash
$ mvn spring-boot:run
```

Application will run by default on port `8080`

Configure the port by changing `server.port` in __application.yml__


### Run Docker

First build the image:
```bash
$ docker-compose build
```

When ready, run it:
```bash
$ docker-compose up
```

Application will run by default on port `1234`

Configure the port by changing `services.api.ports` in __docker-compose.yml__. Port 1234 was used by default so the value is easy to identify and change in the configuration file.


## Testing
TODO: Additional instructions for testing the application.


## API
TODO: API Reference with examples, or a link to a wiki or other documentation source.

## Acknowledgements
TODO: Show folks some love.
