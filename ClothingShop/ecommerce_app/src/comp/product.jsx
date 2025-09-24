import React, { useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import productsData from './productDetails';
import './style.css';

const Product = ({ addToCart, cart }) => {
  const { id } = useParams();
  const [searchTerm, setSearchTerm] = useState('');

  const handleSearch = (e) => {
    setSearchTerm(e.target.value);
  };

  const filteredProducts = productsData.filter((prod) =>
    prod.name.toLowerCase().includes(searchTerm.toLowerCase())
  );

  if (id) {
    const product = productsData.find((p) => p.id === parseInt(id));
    if (!product) return <h2>Product Not Found</h2>;

    const inCart = cart.find((item) => item.id === product.id);

    return (
      <div className="product-detail">
        <h2>{product.name}</h2>
        <img src={product.image} alt={product.name} className="product-image" />
        <p>{product.description}</p>
        <p>₱{product.price}</p>
        {inCart ? (
          <p style={{ color: 'red', fontWeight: 'bold' }}>Already in Cart</p>
        ) : (
          <button onClick={() => addToCart(product)}>Add to Cart</button>
        )}
        <br />
        <Link to="/">Back to Products</Link>
      </div>
    );
  }

  return (
    <div>
      <h2>Products</h2>
      <input
        type="text"
        placeholder="Search shirts..."
        value={searchTerm}
        onChange={handleSearch}
        className="search-bar"
      />
      <div className="product-list">
        {filteredProducts.length > 0 ? (
          filteredProducts.map((prod) => {
            const inCart = cart.find((item) => item.id === prod.id);
            return (
              <div key={prod.id} className="product-card">
                <img src={prod.image} alt={prod.name} className="product-image" />
                <h3>{prod.name}</h3>
                <p>₱{prod.price}</p>
                <Link to={`/product/${prod.id}`}>View Details</Link>
                {inCart && <p style={{ color: 'red' }}>Already in Cart</p>}
                {!inCart && (
                  <button onClick={() => addToCart(prod)}>Add to Cart</button>
                )}
              </div>
            );
          })
        ) : (
          <p>No products found.</p>
        )}
      </div>
    </div>
  );
};

export default Product;
