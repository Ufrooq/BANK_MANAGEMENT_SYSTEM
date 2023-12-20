const mongoose = require("mongoose");

const connection = async () => {
  try {
    const connect = await mongoose.connect("mongodb://localhost:27017/Bank");
    console.log("Database is connected Sucessfully !!");
  } catch (error) {
    console.log(error);
  }
};

module.exports = connection;
