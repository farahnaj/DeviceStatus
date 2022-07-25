# Device Status API

The project will be built using microservices architecture. 

The Device Status Service exposes its API for realizing the following features. 

## FEATURES
* read and report the health status of devices 
* store and update information about the devices

## Functional Requirements (Create, Search and Update Device, Status)
* The user should be able to create device and status
	* Each device and status should have auto generated unique identifier
	* The user should have ability to configure device
	* The user should be able to change configuration sof device
	* The user should be able to create status
	* The user should be able to describe the status in detail

* The user should be able to search for his device and status quicky.
	* The user should have ability to search device and status created by s/he
	* The user should be able to search device and status globally with ids/name 

* Email system should send error / warning reportes to respective users.

## Non Functional Requirements (Create, Search and Update Device, Status)
* The system should be highly reliable. Created records should not get lost.
* The system should be highly available.
* The user should be able to search records quickly.

## Technology stack: 

### Backend
* Java 11 
* Spring boot for microservices
* Protocol Buffers

### UI
* React 
* Bootstrap
