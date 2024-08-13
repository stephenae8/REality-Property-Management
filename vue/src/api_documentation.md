# API Documentation

## Endpoints and HTTP Methods

### Property-related endpoints
- `/property`
- `/property/owner/{ownerId}`
- `/property/{propId}`
- `/property/create`
- `/property/update/`

### Images-related endpoints
- `/images`
- `/images/image/{imageId}`
- `/images/property/{propId}`
- `/images/create`
- `/images/update`

### Lease-related endpoints
- `/lease`
- `/lease/{leaseId}`
- `/lease/user/{userId}`
- `/lease/create`
- `/lease/update`

### Messages-related endpoints
- `/messages/user/{userId}`
- `/messages/message/{msgId}`
- `/messages/create`

### Payments-related endpoints
- `/payments`
- `/payments/user/{userId}`
- `/payments/property/{propId}`
- `/payments/lease/{leaseId}`
- `/payments/payment/{payId}`
- `/payments/create`

### Applications-related endpoints
- `/applications`
- `/applications/user/{userId}`
- `/applications/create`
- `/applications/update`

### Amenities-related endpoints
- `/amenities`
- `/amenities/property/{propId}`
- `/amenities/amenity/{amenitiesId}`
- `/amenities/create`
- `/amenities/update`

## API Operations

The API uses HTTP methods and paths to define the operations:

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/property` | Retrieve a list of all properties. |
| GET    | `/property/owner/{ownerId}` | Retrieve a list of properties for a specific owner. |
| GET    | `/property/{propId}` | Retrieve a specific property by its ID. |
| POST   | `/property/create` | Create a new property. |
| PUT    | `/property/update/` | Update an existing property. |
| GET    | `/images` | Retrieve a list of all images. |
| GET    | `/images/image/{imageId}` | Retrieve a specific image by its ID. |
| GET    | `/images/property/{propId}` | Retrieve images for a specific property. |
| POST   | `/images/create` | Create a new image entry. |
| PUT    | `/images/update` | Update an existing image entry. |
| GET    | `/lease` | Retrieve a list of all leases. |
| GET    | `/lease/{leaseId}` | Retrieve a specific lease by its ID. |
| GET    | `/lease/user/{userId}` | Retrieve a lease for a specific user. |
| POST   | `/lease/create` | Create a new lease. |
| PUT    | `/lease/update` | Update the status of an existing lease. |
| GET    | `/messages/user/{userId}` | Retrieve messages for a specific user. |
| GET    | `/messages/message/{msgId}` | Retrieve a specific message by its ID. |
| POST   | `/messages/create` | Create a new message. |
| GET    | `/payments` | Retrieve a list of all payments. |
| GET    | `/payments/user/{userId}` | Retrieve payments for a specific user. |
| GET    | `/payments/property/{propId}` | Retrieve payments for a specific property. |
| GET    | `/payments/lease/{leaseId}` | Retrieve payments for a specific lease. |
| GET    | `/payments/payment/{payId}` | Retrieve a specific payment by its ID. |
| POST   | `/payments/create` | Create a new payment. |
| GET    | `/applications` | Retrieve a list of all applications. |
| GET    | `/applications/user/{userId}` | Retrieve an application for a specific user. |
| POST   | `/applications/create` | Create a new application. |
| PUT    | `/applications/update` | Update an existing application. |
| GET    | `/amenities` | Retrieve a list of all amenities. |
| GET    | `/amenities/property/{propId}` | Retrieve amenities for a specific property. |
| GET    | `/amenities/amenity/{amenitiesId}` | Retrieve specific amenities by their ID. |
| POST   | `/amenities/create` | Create new amenities. |
| PUT    | `/amenities/update` | Update existing amenities. |   