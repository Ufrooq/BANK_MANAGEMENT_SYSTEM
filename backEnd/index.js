const express = require("express");
const connection = require("./dbConnection/connection.js");
const bodyParser = require("body-parser");

connection();
const app = express();
const port = process.env.PORT || 8000;

app.use(express.json());
app.use(bodyParser.json());

app.use("/api/customer", require("./Routes/customerRoutes"));
app.use("/api/admin", require("./Routes/adminRoutes"));

app.listen(port, () => {
  console.log(`http://localhost:${port}`);
});
