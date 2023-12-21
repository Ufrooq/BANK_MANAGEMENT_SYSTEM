const mongoose = require("mongoose");

const accountSchema = new mongoose.Schema({
  customer_id: {
    type: mongoose.Schema.Types.ObjectId,
    required: true,
    ref: "Customer",
  },
  accNum: {
    type: Number,
    required: true,
    unique: true,
  },
  accType: {
    type: String,
    required: true,
  },
  pin: {
    type: Number,
    required: true,
  },
  balance: {
    type: Number,
    required: true,
  },
});

const AccountModel = mongoose.model("Account", accountSchema);
module.exports = { AccountModel };
