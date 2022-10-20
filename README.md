
### 🔨 Run the App

<b>1 )</b> Install <b>Docker Desktop</b>. Here is the installation <b>link</b> : https://docs.docker.com/docker-for-windows/install/

<b>2 )</b> Open <b>Terminal</b> under <b>resources</b> folder to run <b>Docker</b> Container
```
    docker-compose up -d
```
<b>3 )</b> Open <b>[Swagger Ui](http://localhost:8081/swagger-ui/index.html#/)</b> in the Browser and Try it 

<b>4 )</b> Open <b>[Kafka Ui](http://localhost:9090/)</b> in the Browser 


### Used Dependencies
* Spring Boot Web
* Kafka
* Cassandra
* Lombok
* Swagger

## Features
1 - Find All Users

Example:
<br>
**Request:**
```json
GET /user
```

**Success:**
```json
HTTP/1.1 200 OK
Content-Type: application/json

[
    {
    "id": "9ef47520-ea5f-42d2-bec2-7820360e6db3",
    "name": "Vilyım",
    "surname": "Volıs",
    "followedList": ["c24131f8-61c6-401f-9b5f-58ad69587266"],
    "followerList": ["c24131f8-61c6-401f-9b5f-58ad69587266"]
    },
    {
    "id": "c24131f8-61c6-401f-9b5f-58ad69587266",
    "name": "Keyser",
    "surname": "Söze",
    "followedList": ["9ef47520-ea5f-42d2-bec2-7820360e6db3"],
    "followerList": ["9ef47520-ea5f-42d2-bec2-7820360e6db3"]   
    },
]
```

2 - Creating New User (Sending to Kafka Queue)

Example:
<br>
**Request:**
```json
POST /user
Content-Type: application/json
Body: {
    "name": "Test",
    "surname": "Testoğlu",
    "followedList": [
      "c24131f8-61c6-401f-9b5f-58ad69587266",
      "c24131f8-61c6-401f-9b5f-58ad69587266"
                    ]
      }
```

**Success:**
```json
HTTP/1.1 200 OK
Content-Type: application/json

{
    "name": "Test",
    "surname": "Testoğlu",
    "followedList": [
        "c24131f8-61c6-401f-9b5f-58ad69587266"
                    ]
}
```

3 - Find User by Id

Example:
<br>
**Request:**
```json
GET /user/{userId} HTTP/1.1
Path Parameter: User id to find
```

**Success:**
```json
HTTP/1.1 200 OK
Content-Type: application/json

{
        "name": "Keyser",
        "surname": "Söze",
        "followerList": [
            "9ef47520-ea5f-42d2-bec2-7820360e6db3",
            "8018df86-3c9a-4788-afbf-46022a90380a"
                        ],
        "followedList": [
            "9ef47520-ea5f-42d2-bec2-7820360e6db3"
                        ]
}
```
4 - Update User by Id  (Sending to Kafka Queue)

Example:
<br>
**Request:**
```json
PUT /user/{userId}
Content-Type: application/json
Body:  {
    "id": "9ef47520-ea5f-42d2-bec2-7820360e6db3",
    "name": "William",
    "surname": "Wallace",
    "followedList": [
      "c24131f8-61c6-401f-9b5f-58ad69587266",
      "cf4479d2-9b37-4a3a-b08c-176b7f90f5c3",
      "5239ac94-9abd-4b8e-be65-73d65d88272b",
      "8018df86-3c9a-4788-afbf-46022a90380a",
      "8018df86-3c9a-4788-afbf-46022a90380a"
]
}
```

**Success:**
```json
HTTP/1.1 200 OK
Content-Type: application/json

{
    "id": "9ef47520-ea5f-42d2-bec2-7820360e6db3",
    "name": "William",
    "surname": "Wallace",
    "followedList": [
    "c24131f8-61c6-401f-9b5f-58ad69587266",
    "cf4479d2-9b37-4a3a-b08c-176b7f90f5c3",
    "5239ac94-9abd-4b8e-be65-73d65d88272b",
    "8018df86-3c9a-4788-afbf-46022a90380a"
        ]
}
```
## Contact
- [LinkedIn](https://www.linkedin.com/in/altugkarakayali/)
- E-Mail: **altugkarakayali@gmail.com**
