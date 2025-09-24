import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Product from './product.jsx';
import Cart from './cart.jsx';

const Rout = ({ cart, addToCart, updateQuantity, removeFromCart }) => {
  return (
    <Routes>
      <Route path="/" element={<h2 className="page">Welcome to ClothingShop!</h2>} />
      <Route path="/product" element={<Product addToCart={addToCart} cart={cart} />} />
      <Route path="/product/:id" element={<Product addToCart={addToCart} cart={cart} />} />
      <Route
        path="/cart"
        element={
          <Cart
            cart={cart}
            updateQuantity={updateQuantity}
            removeFromCart={removeFromCart}
          />
        }
      />
      <Route path="/about" element={<h2 className="page">About Us</h2>} />
      <Route path="*" element={<h2 className="page">404 - Page Not Found</h2>} />
    </Routes>
  );
};

export default Rout;
