const { AccountModel } = require("../Models/account.js");
const { customerModel } = require("../Models/customer.js");
const { adminModel } = require("../Models/admin.js");

const customerCreation = async (req, res) => {
  const {
    name,
    age,
    gender,
    accNum,
    pin,
    balance,
    dob,
    address,
    adminId,
    customer_cnic,
  } = req.body;

  try {
    const isAdminAvailable = await adminModel.findOne({ admin_id: adminId });
    if (!isAdminAvailable) {
      console.log("Enter correct Admin ID !!");
      res.status(400);
      throw new Error("Enter correct Admin ID !!");
    }
    const isUserAvailable = await customerModel.findOne({ customer_cnic });
    if (isUserAvailable) {
      console.log("Customer Already Exists !!");
      res.status(400);
      throw new Error("Customer Already Exists !!");
    }
    const insertUser_into_DB = await customerModel.create({
      admin_id: isAdminAvailable._id,
      customer_cnic,
      name,
      age,
      gender,
      dob,
      address,
    });

    // if (insertUser_into_DB) {
    //   const { _id } = insertUser_into_DB;
    //   const isAccountAvailable = await AccountModel.findOne({
    //     customer_id: _id,
    //   });
    //   console.log(isAccountAvailable);
    //   if (isAccountAvailable) {
    //     res.status(400);
    //     throw new Error("Account Already Exists !!");
    //   }
    //   const insertAccount_into_DB = await AccountModel.create({
    //     customer_id: _id,
    //     accNum,
    //     pin,
    //     balance,
    //   });
    // }
    res.status(200).json({
      message: "Customer data inserted and account created Successfully",
    });
  } catch (error) {
    console.log("error occured");
    res.status(400).json({ message: "Error Occured !!" });
  }
};

module.exports = { customerCreation };
