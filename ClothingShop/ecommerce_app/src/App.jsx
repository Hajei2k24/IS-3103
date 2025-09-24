import React, { useState } from 'react';
import { BrowserRouter as Router } from 'react-router-dom';
import Nav from './comp/nav.jsx';
import Rout from './comp/rout.jsx';

function App() {
  const [cart, setCart] = useState([]);

  const addToCart = (product) => {
    const exists = cart.find((item) => item.id === product.id);
    if (exists) return;

    setCart([...cart, { ...product, quantity: 1 }]);
  };

  const updateQuantity = (id, delta) => {
    setCart(cart.map(item =>
      item.id === id
        ? { ...item, quantity: Math.max(1, item.quantity + delta) }
        : item
    ));
  };

  const removeFromCart = (id) => {
    setCart(cart.filter(item => item.id !== id));
  };

  return (
    <Router>
      <Nav cartCount={cart.length} />
      <Rout
        cart={cart}
        addToCart={addToCart}
        updateQuantity={updateQuantity}
        removeFromCart={removeFromCart}
      />
    </Router>
  );
}

export default App;
