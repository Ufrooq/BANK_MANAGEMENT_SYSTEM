const express = require("express");
const router = express.Router();
const { adminCreation } = require("../controllers/admin.js");

router.post("/adminCreation", adminCreation);
module.exports = router;
