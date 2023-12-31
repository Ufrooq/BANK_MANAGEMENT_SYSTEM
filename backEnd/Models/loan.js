const mongoose = require("mongoose");

const loanSchema = new mongoose.Schema({
  account_id: {
    type: mongoose.Schema.Types.ObjectId,
    required: true,
    ref: "Account",
  },
  loanAmount: {
    type: Number,
    required: true,
  },
  loanDate: {
    type: String,
    required: true,
  },

  returnDate: {
    type: String,
    required: true,
  },
  permonthReturn: {
    type: String,
    required: true,
  },
});

const loanModel = mongoose.model("Loan", loanSchema);

module.exports = { loanModel };
