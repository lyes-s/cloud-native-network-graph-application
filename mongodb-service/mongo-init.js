// db.getSiblingDB() : used to return another database without modifying the db variable in the shell environment.
// You can use db.getSiblingDB() as an alternative to the use <database> helper.
// This is particularly useful when writing scripts using mongosh where the use helper is not available.
// Ref.: https://www.mongodb.com/docs/manual/reference/method/db.getSiblingDB/
db = db.getSiblingDB("graph")

// Insert a log trace
db.log.insertOne({"message": "Switched to graph Database."});

// Collection created
db.createCollection("network-graph")

// Insert a log trace
db.log.insertOne({"message": "Collection network-graph created."});

// Create a user for the database above.
// TODO : find a way to pass the credentials from Docker ENV to this script (if possible).
db.createUser(
        {
            user: "admin",
            pwd: "admin",
            roles: [
                {
                    role: "readWrite",
                    db: "graph"
                }
            ]
        }
);