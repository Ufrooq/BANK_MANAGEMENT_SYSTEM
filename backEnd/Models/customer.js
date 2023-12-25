const mongoose = require("mongoose");

const customerSchema = new mongoose.Schema({
  admin_id: {
    type: mongoose.Schema.Types.ObjectId,
    required: true,
    ref: "Admin",
  },
  customer_cnic: {
    type: String,
    required: true,
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

  dob: {
    type: String,
    required: true,
  },
  address: {
    type: String,
    required: true,
  },
});

const customerModel = mongoose.model("Customer", customerSchema);
module.exports = { customerModel };
