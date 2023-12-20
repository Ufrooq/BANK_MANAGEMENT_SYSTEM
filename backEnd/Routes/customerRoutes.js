const express = require("express");
const router = express.Router();
const { customerCreation } = require("../controllers/customer");

router.post("/", customerCreation);

module.exports = router;
