const mongoose = require("mongoose");

const adminSchema = new mongoose.Schema({
  manager_id: {
    type: mongoose.Schema.Types.ObjectId,
    required: true,
    ref: "Manager",
  },
  adminId: {
    type: Number,
    required: true,
  },
  name: {
    type: String,
    required: true,
  },
  Uname: {
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
