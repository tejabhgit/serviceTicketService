db = db.getSiblingDB("rps_ticket");
db.createUser({
 user: "rps-ticket-db-user",
 pwd: "changeme",
 roles: [
 {
 role: "readWrite",
 db: "rps_ticket",
 },
 ],
});
