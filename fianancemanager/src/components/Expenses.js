/*import React, { useState, useEffect } from "react";
import axios from "axios";
import Navbar from "./Navbar";

function Expenses() {
  const [userId, setUserId] = useState(null);

  // Form states
  const [amount, setAmount] = useState("");
  const [description, setDescription] = useState("");
  const [date, setDate] = useState("");
  const [categoryId, setCategoryId] = useState("");
  const [editId, setEditId] = useState(null);

  // Data lists
  const [expensesList, setExpensesList] = useState([]);
  const [categories, setCategories] = useState([]);

  // Get logged-in user from localStorage
  useEffect(() => {
    const storedUser = localStorage.getItem("currentUser");
    if (storedUser) {
      const user = JSON.parse(storedUser);
      setUserId(user.userId || user.id);
    }
  }, []);

  // Fetch expenses
  const fetchExpenses = async (uid) => {
    try {
      const res = await axios.get(
        `http://localhost:8086/expenses/user/${uid}`
      );
      setExpensesList(res.data || []);
    } catch (err) {
      console.log("Error fetching expenses:", err);
    }
  };

  // Fetch categories
  const fetchCategories = async () => {
    try {
      const res = await axios.get(
        "http://localhost:8086/category/type/expenses"
      );
      setCategories(res.data || []);
    } catch (err) {
      console.log("Error fetching categories:", err);
    }
  };

  // Load data when userId is available
  useEffect(() => {
    if (!userId) return;
    fetchExpenses(userId);
    fetchCategories();
  }, [userId]);

  // Add / Update expense
  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!categoryId) {
      alert("Please select category");
      return;
    }

    const expenseData = {
      amount: parseFloat(amount),
      description,
      date,
      user: { userId },
      category: { categoryId: parseInt(categoryId) },
    };

    try {
      if (editId) {
        await axios.put(
          `http://localhost:8086/expenses/update/${editId}`,
          expenseData
        );
        setEditId(null);
      } else {
        await axios.post(
          "http://localhost:8086/expenses/add",
          expenseData
        );
      }

      await fetchExpenses(userId);

      // Reset form
      setAmount("");
      setDescription("");
      setDate("");
      setCategoryId("");
    } catch (err) {
      console.log("Save error:", err);
    }
  };

  // Delete expense
  const handleDelete = async (expenseId) => {
    if (!expenseId) return;

    if (!window.confirm("Are you sure you want to delete?")) return;

    try {
      await axios.delete(
        `http://localhost:8086/expenses/${expenseId}`
      );
      await fetchExpenses(userId);
      console.log("Deleted successfully");
    } catch (err) {
      console.log(
        "Delete error:",
        err.response?.data || err.message
      );
    }
  };

  // Edit expense
  const handleEdit = (item) => {
    setEditId(item.expenseId);
    setAmount(item.amount);
    setDescription(item.description);
    setDate(item.date);
    setCategoryId(item.category?.categoryId || "");
  };

  return (
    <>
      <Navbar />

      <div className="container mt-4">
        <h4 className="mb-3">
          {editId ? "Edit Expense" : "Add Expense"}
        </h4>

      
        <form
          onSubmit={handleSubmit}
          className="card p-3 mb-4 shadow-sm"
        >
          <div className="row g-2">
            <div className="col-md-2">
              <input
                type="number"
                className="form-control"
                placeholder="Amount"
                value={amount}
                onChange={(e) => setAmount(e.target.value)}
                required
              />
            </div>

            <div className="col-md-3">
              <input
                type="text"
                className="form-control"
                placeholder="Description"
                value={description}
                onChange={(e) =>
                  setDescription(e.target.value)
                }
                required
              />
            </div>

            <div className="col-md-2">
              <input
                type="date"
                className="form-control"
                value={date}
                onChange={(e) => setDate(e.target.value)}
                required
              />
            </div>

            <div className="col-md-3">
              <select
                className="form-select"
                value={categoryId}
                onChange={(e) =>
                  setCategoryId(e.target.value)
                }
                required
              >
                <option value="">Select Category</option>
                {categories.map((cat) => (
                  <option
                    key={cat.categoryId}
                    value={cat.categoryId}
                  >
                    {cat.name}
                  </option>
                ))}
              </select>
            </div>

            <div className="col-md-2">
              <button
                type="submit"
                className={`btn ${
                  editId
                    ? "btn-primary"
                    : "btn-success"
                } w-100`}
              >
                {editId ? "Update" : "Add"}
              </button>
            </div>
          </div>
        </form>

       
        <div className="card p-3 shadow-sm">
          <h5>My Expenses</h5>

          <table className="table table-bordered table-hover mt-3">
            <thead className="table-light">
              <tr>
                <th>Date</th>
                <th>Amount</th>
                <th>Description</th>
                <th>Category</th>
                <th>Action</th>
              </tr>
            </thead>

            <tbody>
              {expensesList.length > 0 ? (
                expensesList.map((item) => (
                  <tr key={item.expenseId}>
                    <td>
                      {item.date
                        ? new Date(
                            item.date
                          ).toLocaleDateString()
                        : "-"}
                    </td>
                    <td>₹{item.amount}</td>
                    <td>{item.description}</td>
                    <td>
                      {item.category?.name || "-"}
                    </td>
                    <td>
                      <button
                        className="btn btn-sm btn-primary me-2"
                        onClick={() =>
                          handleEdit(item)
                        }
                      >
                        Edit
                      </button>

                      <button
                        className="btn btn-sm btn-danger"
                        onClick={() =>
                          handleDelete(
                            item.expenseId
                          )
                        }
                      >
                        Delete
                      </button>
                    </td>
                  </tr>
                ))
              ) : (
                <tr>
                  <td
                    colSpan="5"
                    className="text-center"
                  >
                    No expenses found.
                  </td>
                </tr>
              )}
            </tbody>
          </table>
        </div>
      </div>
    </>
  );
}

export default Expenses;*/

import React, { useState, useEffect } from "react";
import axios from "axios";
import Navbar from "./Navbar";

function Expenses() {
  const [userId, setUserId] = useState(null);

  // Form states
  const [amount, setAmount] = useState("");
  const [description, setDescription] = useState("");
  const [date, setDate] = useState("");
  const [categoryId, setCategoryId] = useState("");
  const [editId, setEditId] = useState(null);

  // Data lists
  const [expensesList, setExpensesList] = useState([]);
  const [categories, setCategories] = useState([]);

  // Get logged-in user from localStorage
  useEffect(() => {
    const storedUser = localStorage.getItem("currentUser");
    if (storedUser) {
      const user = JSON.parse(storedUser);
      setUserId(user.userId || user.id);
    }
  }, []);

  // Fetch expenses
  const fetchExpenses = async (uid) => {
    try {
      const res = await axios.get(
        `http://localhost:8086/expenses/user/${uid}`
      );
      setExpensesList(res.data || []);
    } catch (err) {
      console.log("Error fetching expenses:", err);
    }
  };

  // Fetch categories
  const fetchCategories = async () => {
    try {
      const res = await axios.get(
        "http://localhost:8086/category/type/expenses"
      );
      setCategories(res.data || []);
    } catch (err) {
      console.log("Error fetching categories:", err);
    }
  };

  // Load data when userId is available
  useEffect(() => {
    if (!userId) return;
    fetchExpenses(userId);
    fetchCategories();
  }, [userId]);

  // Add / Update expense
  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!categoryId) {
      alert("Please select category");
      return;
    }

    const expenseData = {
      amount: parseFloat(amount),
      description,
      date,
      user: { userId },
      category: { categoryId: parseInt(categoryId) },
    };

    try {
      if (editId) {
        await axios.put(
          `http://localhost:8086/expenses/update/${editId}`,
          expenseData
        );
        setEditId(null);
      } else {
        await axios.post(
          "http://localhost:8086/expenses/add",
          expenseData
        );
      }

      await fetchExpenses(userId);

      // Reset form
      setAmount("");
      setDescription("");
      setDate("");
      setCategoryId("");
    } catch (err) {
      console.log("Save error:", err);
    }
  };

  // Delete expense
  const handleDelete = async (expenseId) => {
    if (!expenseId) return;

    if (!window.confirm("Are you sure you want to delete?")) return;

    try {
      await axios.delete(
        `http://localhost:8086/expenses/${expenseId}`
      );
      await fetchExpenses(userId);
      console.log("Deleted successfully");
    } catch (err) {
      console.log(
        "Delete error:",
        err.response?.data || err.message
      );
    }
  };

  // Edit expense
  const handleEdit = (item) => {
    setEditId(item.expenseId);
    setAmount(item.amount);
    setDescription(item.description);
    setDate(item.date);
    setCategoryId(item.category?.categoryId || "");
  };

  return (
    <>
      <Navbar />

      <div className="container mt-4">
        <h4 className="mb-3">
          {editId ? "Edit Expense" : "Add Expense"}
        </h4>

        {/* FORM */}
        <form
          onSubmit={handleSubmit}
          className="card p-3 mb-4 shadow-sm"
        >
          <div className="row g-2">
            <div className="col-md-2">
              <input
                type="number"
                className="form-control"
                placeholder="Amount"
                value={amount}
                onChange={(e) => setAmount(e.target.value)}
                required
              />
            </div>

            <div className="col-md-3">
              <input
                type="text"
                className="form-control"
                placeholder="Description"
                value={description}
                onChange={(e) =>
                  setDescription(e.target.value)
                }
                required
              />
            </div>

            <div className="col-md-2">
              <input
                type="date"
                className="form-control"
                value={date}
                onChange={(e) => setDate(e.target.value)}
                required
              />
            </div>

            <div className="col-md-3">
              <select
                className="form-select"
                value={categoryId}
                onChange={(e) =>
                  setCategoryId(e.target.value)
                }
                required
              >
                <option value="">Select Category</option>
                {categories.map((cat) => (
                  <option
                    key={cat.categoryId}
                    value={cat.categoryId}
                  >
                    {cat.name}
                  </option>
                ))}
              </select>
            </div>

            <div className="col-md-2">
              <button
                type="submit"
                className={`btn ${
                  editId
                    ? "btn-primary"
                    : "btn-success"
                } w-100`}
              >
                {editId ? "Update" : "Add"}
              </button>
            </div>
          </div>
        </form>

        {/* TABLE */}
        <div className="card p-3 shadow-sm">
          <h5>My Expenses</h5>

          <table className="table table-bordered table-hover mt-3">
            <thead className="table-light">
              <tr>
                <th>Date</th>
                <th>Amount</th>
                <th>Description</th>
                <th>Category</th>
                <th>Action</th>
              </tr>
            </thead>

            <tbody>
              {expensesList.length > 0 ? (
                expensesList.map((item) => (
                  <tr key={item.expenseId}>
                    <td>
                      {item.date
                        ? new Date(
                            item.date
                          ).toLocaleDateString()
                        : "-"}
                    </td>
                    <td>₹{item.amount}</td>
                    <td>{item.description}</td>
                    <td>
                      {item.category?.name || "-"}
                    </td>
                    <td>
                      <button
                        className="btn btn-sm btn-primary me-2"
                        onClick={() =>
                          handleEdit(item)
                        }
                      >
                        Edit
                      </button>

                      <button
                        className="btn btn-sm btn-danger"
                        onClick={() =>
                          handleDelete(
                            item.expenseId
                          )
                        }
                      >
                        Delete
                      </button>
                    </td>
                  </tr>
                ))
              ) : (
                <tr>
                  <td
                    colSpan="5"
                    className="text-center"
                  >
                    No expenses found.
                  </td>
                </tr>
              )}
            </tbody>
          </table>
        </div>
      </div>
    </>
  );
}

export default Expenses;