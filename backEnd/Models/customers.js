const { Schema, model } = require("mongoose");

const customerSchema = Schema({
  username: {
    required: true,
    type: String,
  },
  email: {
    type: String,
    required: true,
    unique: true,
  },
});

const CustomerData = model("CustomerData", customerSchema);
module.exports = CustomerData;
