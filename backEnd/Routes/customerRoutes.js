const express = require("express");
const router = express.Router();
const { customerCreation } = require("../controllers/customer.js");

router.post("/accountCreation", customerCreation);

module.exports = router;
