const { AccountModel } = require("../Models/account.js");

const accountCreation = async (req, res) => {
  const { name, age, gender, accNum, pin, balance, dob, address } = req.body;

  try {
    const isUserAvailable = await AccountModel.findOne({ accNum });
    if (isUserAvailable) {
      res.status(400);
      throw new Error("Customer Already Exists !!");
    }
    const insertUser_into_DB = await AccountModel.create({
      name,
      age,
      gender,
      accNum,
      pin,
      balance,
      dob,
      address,
    });
    res.status(200).json({ message: "account Created Successfully" });
  } catch (error) {
    res.status(400).json({ message: "Error Occured !!" });
  }
};
module.exports = { accountCreation };
