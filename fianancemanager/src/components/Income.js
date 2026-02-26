import React, { useState, useEffect } from "react";
import axios from "axios";
import Navbar from "./Navbar";

function Income() {
  const [incomeList, setIncomeList] = useState([]);
  const [amount, setAmount] = useState("");
  const [source, setSource] = useState("");
  const [date, setDate] = useState("");
  const [userId, setUserId] = useState(null);
  const [error, setError] = useState("");

  const [editId, setEditId] = useState(null); 

  
  useEffect(() => {
    const storedUser = localStorage.getItem("currentUser");

    if (!storedUser) {
      console.log("No user found in localStorage");
      return;
    }

    const user = JSON.parse(storedUser);
    const id = user.userId || user.id;

    if (id) {
      setUserId(id);
    }
  }, []);

 
  useEffect(() => {
    if (userId !== null) {
      fetchIncome();
    }
  }, [userId]);

  const fetchIncome = async () => {
    try {
      const res = await axios.get(
        `http://localhost:8086/income/user/${userId}`
      );
      setIncomeList(res.data);
    } catch (err) {
      console.error("Fetch error:", err);
      setError("Failed to load income records");
    }
  };

  
  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!userId) {
      alert("User not logged in");
      return;
    }

    const incomeData = {
      amount: parseFloat(amount),
      source,
      date,
      user: { userId }
    };

    try {
      if (editId) {
        
        await axios.put(
          `http://localhost:8086/income/update/${editId}`,
          incomeData
        );
        setEditId(null);
      } else {
        
        await axios.post(
          "http://localhost:8086/income/add",
          incomeData
        );
      }

      setAmount("");
      setSource("");
      setDate("");
      fetchIncome();
    } catch (err) {
      console.error("Submit error:", err);
      setError("Failed to save income");
    }
  };

 
  const handleDelete = async (incomeId) => {
    if (!window.confirm("Are you sure you want to delete?")) return;

    try {
      await axios.delete(
        `http://localhost:8086/income/delete/${incomeId}`
      );
      fetchIncome();
    } catch (err) {
      console.error("Delete error:", err);
      setError("Failed to delete income");
    }
  };


  const handleEdit = (item) => {
    setEditId(item.incomeId);
    setAmount(item.amount);
    setSource(item.source);
    setDate(item.date);
  };

  return (
    <>
      <Navbar />
      <div className="container mt-4">
        <h4>{editId ? "Edit Income" : "Add Income"}</h4>

        {error && <div className="alert alert-danger">{error}</div>}

        <form onSubmit={handleSubmit} className="card p-3 mb-4">
          <div className="row">
            <div className="col-md-4">
              <input
                type="number"
                className="form-control"
                placeholder="Amount"
                value={amount}
                onChange={(e) => setAmount(e.target.value)}
                required
              />
            </div>

            <div className="col-md-4">
              <input
                type="text"
                className="form-control"
                placeholder="Source"
                value={source}
                onChange={(e) => setSource(e.target.value)}
                required
              />
            </div>

            <div className="col-md-3">
              <input
                type="date"
                className="form-control"
                value={date}
                onChange={(e) => setDate(e.target.value)}
                required
              />
            </div>

            <div className="col-md-1">
              <button type="submit" className="btn btn-success w-100">
                {editId ? "Update" : "Add"}
              </button>
            </div>
          </div>
        </form>

        <div className="card p-3">
          <h5>Income List</h5>

          <table className="table table-bordered mt-3">
            <thead>
              <tr>
                <th>Date</th>
                <th>Amount</th>
                <th>Source</th>
                <th>Action</th>
              </tr>
            </thead>

            <tbody>
              {incomeList.length > 0 ? (
                incomeList.map((item) => (
                  <tr key={item.incomeId}>
                    <td>
                      {new Date(item.date).toLocaleDateString()}
                    </td>
                    <td>₹{item.amount}</td>
                    <td>{item.source}</td>
                    <td>
                      <button
                        className="btn btn-primary btn-sm me-2"
                        onClick={() => handleEdit(item)}
                      >
                        Edit
                      </button>

                      <button
                        className="btn btn-danger btn-sm"
                        onClick={() =>
                          handleDelete(item.incomeId)
                        }
                      >
                        Delete
                      </button>
                    </td>
                  </tr>
                ))
              ) : (
                <tr>
                  <td colSpan="4" className="text-center">
                    No income records found
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

export default Income;
