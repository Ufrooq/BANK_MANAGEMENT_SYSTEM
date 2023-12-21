const { adminModel } = require("../Models/admin.js");

const adminCreation = async (req, res) => {
  const { name, age, gender, balance, dob, adminId } = req.body;
  console.log(name, age, gender, balance, dob, adminId);
  // try {
  //   const isUserAvailable = await adminModel.findOne({ accNum });
  //   if (isUserAvailable) {
  //     res.status(400);
  //     throw new Error("Admin Already Exists !!");
  //   }
  //   const insertUser_into_DB = await adminModel.create({
  //     name,
  //     age,
  //     gender,
  //     balance,
  //     dob,
  //   });
  //   res.status(200).json({ message: "Admin Created Successfully" });
  // } catch (error) {
  //   res.status(400).json({ message: "Error Occured !!" });
  // }
};
module.exports = { adminCreation };
