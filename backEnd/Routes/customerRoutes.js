const express = require("express");
const router = express.Router();
const { customerCreation, availLoan } = require("../controllers/customer.js");

router.post("/accountCreation", customerCreation);
router.post("/loan", availLoan);

module.exports = router;
