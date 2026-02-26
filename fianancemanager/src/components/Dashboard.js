import React, { useEffect, useState } from "react";
import axios from "axios";
import Navbar from "./Navbar";
import { FaMoneyBillWave, FaShoppingCart, FaWallet, FaUser } from "react-icons/fa";
import { useNavigate } from "react-router-dom";

function Dashboard() {
  const navigate = useNavigate();

  const [data, setData] = useState({
    totalIncome: 0,
    totalExpense: 0,
    balance: 0
  });

  const [username, setUsername] = useState("");

  useEffect(() => {
    const currentUser = JSON.parse(localStorage.getItem("currentUser"));

    if (!currentUser || !currentUser.userId) {
      navigate("/");
      return;
    }

    setUsername(currentUser.username || "User");
    const userId = currentUser.userId;

    axios
      .get(`http://localhost:8086/dashboard/${userId}`)
      .then((res) => setData(res.data))
      .catch((error) => console.log("Dashboard error:", error));
  }, [navigate]);

  const expensePercent = data.totalIncome
    ? Math.min((data.totalExpense / data.totalIncome) * 100, 100)
    : 0;

  const balancePercent = data.totalIncome
    ? Math.min((data.balance / data.totalIncome) * 100, 100)
    : 0;

  return (
    <>
      <Navbar />

      <div
        className="min-vh-100 py-5"
        style={{
          background: "linear-gradient(to right, #e0f7fa, #f8f9fa)"
        }}
      >
        <div className="container">

         
          <div className="text-center mb-5">
            <h3 className="fw-bold">
              <FaUser className="me-2" />
              Welcome, {username} 👋
            </h3>
            <h4 className="fw-bold display-6 mt-2">
              💰 Personal Finance Dashboard
            </h4>
          </div>

          <div className="row g-4">

          
            <div className="col-md-4">
              <div
                className="card dashboard-card text-white text-center p-4 border-0 rounded-4 shadow-lg"
                style={{
                  background: "linear-gradient(135deg, #28a745, #20c997)"
                }}
              >
                <FaMoneyBillWave size={45} className="mb-3" />
                <h5>Total Income</h5>
                <h2 className="fw-bold display-6">₹{data.totalIncome}</h2>

                <div className="progress mt-3" style={{ height: "8px" }}>
                  <div
                    className="progress-bar bg-light"
                    style={{ width: "100%" }}
                  ></div>
                </div>
                <small>100% of income</small>
              </div>
            </div>

           
            <div className="col-md-4">
              <div
                className="card dashboard-card text-white text-center p-4 border-0 rounded-4 shadow-lg"
                style={{
                  background: "linear-gradient(135deg, #dc3545, #ff6b6b)"
                }}
              >
                <FaShoppingCart size={45} className="mb-3" />
                <h5>Total Expense</h5>
                <h2 className="fw-bold display-6">₹{data.totalExpense}</h2>

                <div className="progress mt-3" style={{ height: "8px" }}>
                  <div
                    className="progress-bar bg-dark"
                    style={{ width: `${expensePercent}%` }}
                  ></div>
                </div>
                <small>{expensePercent.toFixed(1)}% of income spent</small>
              </div>
            </div>

           
            <div className="col-md-4">
              <div
                className="card dashboard-card text-white text-center p-4 border-0 rounded-4 shadow-lg"
                style={{
                  background: "linear-gradient(135deg, #007bff, #6610f2)"
                }}
              >
                <FaWallet size={45} className="mb-3" />
                <h5>Remaining Balance</h5>
                <h2 className="fw-bold display-6">₹{data.balance}</h2>

                <div className="progress mt-3" style={{ height: "8px" }}>
                  <div
                    className="progress-bar bg-light"
                    style={{ width: `${balancePercent}%` }}
                  ></div>
                </div>
                <small>{balancePercent.toFixed(1)}% of income remaining</small>
              </div>
            </div>

          </div>

          
          <div className="row mt-5">
            <div className="col-md-12">
              <div className="card shadow-sm p-4 rounded-4 border-0 text-center">
                <h5 className="fw-bold mb-3">📊 Financial Summary</h5>
                <p className="mb-1">
                  You have spent <strong>{expensePercent.toFixed(1)}%</strong> of your income.
                </p>
                <p>
                  You have saved <strong>{balancePercent.toFixed(1)}%</strong> of your income.
                </p>
              </div>
            </div>
          </div>

        </div>
      </div>

    
      <style>
        {`
          .dashboard-card {
            transition: transform 0.3s ease, box-shadow 0.3s ease;
          }

          .dashboard-card:hover {
            transform: translateY(-8px);
            box-shadow: 0 20px 30px rgba(0,0,0,0.2);
          }
        `}
      </style>
    </>
  );
}

export default Dashboard;
