const mongoose = require("mongoose");

const managerSchema = new mongoose.Schema({
  managerId: {
    type: Number,
    required: true,
  },
  managerName: {
    type: String,
    required: true,
  },
  managerUsername: {
    type: String,
    required: true,
  },

  managerPassword: {
    type: Number,
    required: true,
  },

  managerAddress: {
    type: String,
    required: true,
  },

  branchNo: {
    type: Number,
    required: true,
  },

  gender: {
    type: String,
    required: true,
  },
});

const managerModel = mongoose.model("Manager", managerSchema);

module.exports = { managerModel };
