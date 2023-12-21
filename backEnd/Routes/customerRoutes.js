const express = require("express");
const router = express.Router();
const { accountCreation } = require("../controllers/customer.js");

router.post("/accountCreation", accountCreation);

module.exports = router;
