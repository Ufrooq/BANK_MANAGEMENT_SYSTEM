const CustomerData = require("../Models/customers.js");

const customerCreation = async (req, res) => {
  const { username, email } = req.body;
  try {
    const isUserAvailable = await CustomerData.findOne({ email });
    if (isUserAvailable) {
      res.status(400);
      throw new Error("User email Already Exists !!");
    }
    const insertUser_into_DB = await CustomerData.create({
      username,
      email,
    });
    res.status(200).json({ message: "customer Created Successfully" });
  } catch (error) {
    res.status(400).json({ message: "Error Occured !!" });
  }
};
module.exports = { customerCreation };
