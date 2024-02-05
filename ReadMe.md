# MyGarage Car API

This is a RESTful API that provides information about cars. The API is built using Spring Boot framework. It exposes
endpoints to retrieve information about cars, including their make, model, year, and other details.

## Getting Started

To get started with this API, you will need to clone this repository onto your local machine. You will also need to have
Java and Maven installed. Once you have cloned the repository and installed the necessary dependencies, you can run the
application using the following command:

1. Clone this repository to your local machine
2. Setup a MySQL database on your local machine
3. For development use the `application-dev.properties`
    4. Add you database information into the `application-dev.properties`
5. Use Java corretto-17 and run the application. All the database tables should be set up

This will start the application on `http://localhost:8080`.

## API Endpoints

The following are the available endpoints for this API:

### Get all vehicles

### `GET /api/v1/cars`

This endpoint returns a paginated list of all vehicles in the database.

#### Query Parameters

| Parameter | Type    | Required | Description                                |
|-----------|---------|----------|--------------------------------------------|
| `page`    | Integer | No       | The page number to retrieve. Default is 0. |

### Get a vehicle by ID

### ``GET /api/v1/cars/{id}``

This endpoint returns a single vehicle with the given ID.

#### Path Parameters

| Parameter | Type | Required | Description                        |
|-----------|------|----------|------------------------------------|
| `id`      | Long | Yes      | The ID of the vehicle to retrieve. |

### Search for vehicles by make, model, and year

### ``GET /api/v1/cars/find?maker={maker}&name={name}&date={date}``

This endpoint returns a paginated list of vehicles that match the given search criteria.

#### Query Parameters

| Parameter | Type    | Required | Description                                |
|-----------|---------|----------|--------------------------------------------|
| `maker`   | String  | No       | The make of the vehicle.                   |
| `name`    | String  | No       | The model of the vehicle.                  |
| `date`    | String  | No       | The year of the vehicle.                   |
| `page`    | Integer | No       | The page number to retrieve. Default is 0. |

### Get a vehicle by HSN and TSN

### ``GET /api/v1/cars/hsn/{hsn}/tsn/{tsn}``

This endpoint returns a paginated list of vehicles that match the given HSN and TSN values.

#### Path Parameters

| Parameter | Type    | Required | Description                                |
|-----------|---------|----------|--------------------------------------------|
| `hsn`     | String  | Yes      | The HSN value of the vehicle.              |
| `tsn`     | String  | Yes      | The TSN value of the vehicle.              |
| `page`    | Integer | No       | The page number to retrieve. Default is 0. |

## Examples

[Examples can be found on RapidAPI](https://rapidapi.com/Salzzy/api/car-models-and-data/)

---

# BrandApiController

This controller provides REST endpoints for managing brands.

## Endpoints

### ``GET /api/v1/brands``

Returns a list of all brands, or a filtered list of brands by name.

#### Request parameters

- `name` (optional): Filters the list of brands by name. If provided, only brands whose name contains the specified
  value will be returned.

#### Response

- Status code: 200 OK
- Content: A list of `Brand` objects.

## Examples

[Examples can be found on RapidAPI](https://rapidapi.com/Salzzy/api/car-models-and-data/)

---

# Model Series API

This REST API allows you to retrieve information about car model series and their generations.

## Endpoints

### `GET /api/v1/model-series`

Retrieves a paginated list of all available car model series.

#### Query Parameters

- `page` (optional): Specifies the page number to retrieve.

### `GET /api/v1/model-series/find`

Retrieves a paginated list of car model series that match the specified search criteria.

#### Query Parameters

- `name` (optional): The name of the car model series to search for.
- `page` (optional): Specifies the page number to retrieve.

### `GET /api/v1/model-series/generations`

Retrieves a paginated list of all available car model series generations.

#### Query Parameters

- `page` (optional): Specifies the page number to retrieve.

### `GET /api/v1/model-series/generations/find`

Retrieves a paginated list of car model series generations that match the specified search criteria.

#### Query Parameters

- `name` (optional): The name of the car model series generation to search for.
- `page` (optional): Specifies the page number to retrieve.

## Examples

[Examples can be found on RapidAPI](https://rapidapi.com/Salzzy/api/car-models-and-data/)

---

# Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management

# Authors

* **Buggxs** - *Car database*
