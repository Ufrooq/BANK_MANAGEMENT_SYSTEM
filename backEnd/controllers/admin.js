const { adminModel } = require("../Models/admin.js");

const adminCreation = async (req, res) => {
  const { admin_id, name, age, gender, uName, pin, dob } = req.body;
  try {
    const isAdminAvailable = await adminModel.findOne({ admin_id });
    console.log(isAdminAvailable);
    if (isAdminAvailable) {
      console.log("Admin Already Exists !!");
      res.status(400);
      throw new Error("Admin Already Exists !!");
    }
    console.log(req.body);
    const insertAdmin_into_DB = await adminModel.create({
      admin_id,
      uName,
      name,
      age,
      gender,
      pin,
      dob,
    });
    console.log(insertAdmin_into_DB);
    res.status(200).json({ message: "Admin Created Successfully" });
  } catch (error) {
    console.log("Error Occured !!!!");
    res.status(400).json({ message: "Error Occured !!" });
  }
};
module.exports = { adminCreation };
