const mongoose = require("mongoose");

const adminSchema = new mongoose.Schema({
  admin_id: {
    type: Number,
    required: true,
    unique: true,
  },

  uName: {
    type: String,
    required: true,
    unique: true,
  },
  name: {
    type: String,
    required: true,
  },
  age: {
    type: Number,
    required: true,
  },
  gender: {
    type: String,
    required: true,
  },

  pin: {
    type: Number,
    required: true,
  },

  dob: {
    type: String,
    required: true,
  },
});

const adminModel = mongoose.model("Admin", adminSchema);

module.exports = { adminModel };
