import React, { useState, useEffect } from "react";
import axios from "axios";
import Navbar from "./Navbar";

function Budget() {
  const [userId, setUserId] = useState(null);
  const [budgetId, setBudgetId] = useState(null); // Edit mode
  const [month, setMonth] = useState("");
  const [year, setYear] = useState("");
  const [limitAmount, setLimitAmount] = useState("");
  const [categoryId, setCategoryId] = useState("");
  const [budgetList, setBudgetList] = useState([]);
  const [categories, setCategories] = useState([]);
  const [message, setMessage] = useState(""); // Success / error messages

  const isEditMode = budgetId !== null;

  // ================= GET USER =================
  useEffect(() => {
    const storedUser = localStorage.getItem("currentUser");
    if (storedUser) {
      const user = JSON.parse(storedUser);
      setUserId(user.userId);
    }
  }, []);

  // ================= FETCH BUDGETS & CATEGORIES =================
  useEffect(() => {
    if (userId) {
      fetchBudgets();
      fetchCategories();
    }
  }, [userId]);

  const fetchBudgets = async () => {
    try {
      const res = await axios.get(`http://localhost:8086/budget/user/${userId}`);
      setBudgetList(res.data);
    } catch (err) {
      console.log("Fetch budgets error:", err);
    }
  };

  const fetchCategories = async () => {
    try {
      const res = await axios.get("http://localhost:8086/category/type/Expense");
      setCategories(res.data);
    } catch (err) {
      console.log("Fetch categories error:", err);
    }
  };

  // ================= ADD / UPDATE BUDGET =================
  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!userId || !categoryId || !month || !year || !limitAmount) {
      alert("Please fill all fields");
      return;
    }

    const data = {
      month: parseInt(month),
      year: parseInt(year),
      limitAmount: parseFloat(limitAmount),
      user: { userId },
      category: { categoryId: parseInt(categoryId) },
    };

    try {
      if (isEditMode) {
        await axios.put(`http://localhost:8086/budget/update/${budgetId}`, data);
        setMessage("Budget updated successfully");
      } else {
        await axios.post("http://localhost:8086/budget/add", data);
        setMessage("Budget added successfully");
      }
      resetForm();
      fetchBudgets();
    } catch (err) {
      const msg = err.response?.data || err.message;
      setMessage(msg);
    }
  };

  // ================= EDIT =================
  const handleEdit = (item) => {
    setBudgetId(item.budgetId);
    setMonth(item.month);
    setYear(item.year);
    setLimitAmount(item.limitAmount);
    setCategoryId(item.category?.categoryId || "");
    setMessage("");
  };

  // ================= DELETE =================
  const handleDelete = async (id) => {
    if (!window.confirm("Are you sure you want to delete this budget?")) return;

    try {
      await axios.delete(`http://localhost:8086/budget/delete/${id}`);
      setMessage("Deleted successfully");
      setBudgetList(prev => prev.filter(item => item.budgetId !== id));
    } catch (err) {
      console.error("Delete error:", err);
      setMessage("Delete failed");
    }
  };

  // ================= RESET =================
  const resetForm = () => {
    setBudgetId(null);
    setMonth("");
    setYear("");
    setLimitAmount("");
    setCategoryId("");
  };

  return (
    <>
      <Navbar />
      <div className="container mt-4">
        <h4>{isEditMode ? "Edit Budget" : "Add Budget"}</h4>

        {/* Success / Error Message */}
        {message && <div className="alert alert-info">{message}</div>}

        {/* Form */}
        <form onSubmit={handleSubmit} className="card p-3 mb-4">
          <div className="row g-2">
            <div className="col-md-2">
              <input
                type="number"
                className="form-control"
                placeholder="Month"
                value={month}
                onChange={(e) => setMonth(e.target.value)}
                required
              />
            </div>

            <div className="col-md-2">
              <input
                type="number"
                className="form-control"
                placeholder="Year"
                value={year}
                onChange={(e) => setYear(e.target.value)}
                required
              />
            </div>

            <div className="col-md-3">
              <input
                type="number"
                className="form-control"
                placeholder="Limit Amount"
                value={limitAmount}
                onChange={(e) => setLimitAmount(e.target.value)}
                required
              />
            </div>

            <div className="col-md-3">
              <select
                className="form-control"
                value={categoryId}
                onChange={(e) => setCategoryId(e.target.value)}
                required
              >
                <option value="">Select Category</option>
                {categories.map((cat) => (
                  <option key={cat.categoryId} value={cat.categoryId}>
                    {cat.name}
                  </option>
                ))}
              </select>
            </div>

            <div className="col-md-2">
              <button className="btn btn-success w-100">
                {isEditMode ? "Update" : "Add"}
              </button>
            </div>
          </div>
        </form>

        {/* Budget Table */}
        <div className="card p-3">
          <h5>My Budgets</h5>
          <table className="table table-bordered mt-3">
            <thead>
              <tr>
                <th>Month</th>
                <th>Year</th>
                <th>Category</th>
                <th>Limit</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              {budgetList.map((item) => (
                <tr key={item.budgetId}>
                  <td>{item.month}</td>
                  <td>{item.year}</td>
                  <td>{item.category?.name || "Not Assigned"}</td>
                  <td>₹{item.limitAmount}</td>
                  <td>
                    <button
                      className="btn btn-warning btn-sm me-2"
                      onClick={() => handleEdit(item)}
                    >
                      Edit
                    </button>
                    <button
                      className="btn btn-danger btn-sm"
                      onClick={() => handleDelete(item.budgetId)}
                    >
                      Delete
                    </button>
                  </td>
                </tr>
              ))}
              {budgetList.length === 0 && (
                <tr>
                  <td colSpan="5" className="text-center">
                    No budgets found
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

export default Budget;