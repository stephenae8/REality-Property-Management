# API Documentation

## Endpoints and HTTP Methods

### User-related endpoints
- `/user`
- `/user/id`

### Account-related endpoints
- `/account/user`
- `/account/name`
- `/account/balance`

### Transfer-related endpoints
- `/transfer/user`
- `/transfer/send`
- `/transfer/history`
- `/transfer/request`
- `/transfer/pending`
- `/transfer/pending/approved`
- `/transfer/pending/reject`

## API Operations

The API uses HTTP methods and paths to define the operations:

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/user` | Retrieve a list of all users. |
| POST   | `/user/id` | Retrieve the username by account ID (non-standard use of POST). |
| GET    | `/account/user` | Retrieve the account ID for the authenticated user. |
| POST   | `/account/name` | Retrieve the username by account ID. |
| GET    | `/account/balance` | Retrieve the account balance for the authenticated user. |
| GET    | `/transfer/user` | Retrieve the list of transfers for the authenticated user. |
| POST   | `/transfer/send` | Send TE Bucks to another user. |
| GET    | `/transfer/history` | Retrieve the transfer history. |
| PUT    | `/transfer/request` | Request a transfer from another user. |
| GET    | `/transfer/pending` | Retrieve pending transfer requests. |
| PUT    | `/transfer/pending/approved` | Approve a pending transfer. |
| PUT    | `/transfer/pending/reject` | Reject a pending transfer. |