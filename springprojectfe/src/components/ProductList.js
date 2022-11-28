import React from 'react'
import { Button } from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import '../components/CSS/listProduct.css'

function ProductLists(props) {
  const { products } = props

  function handleDetail(id) {
    const url = 'http://localhost:3000/product/' + id;
    window.location.href = url;
  }

  function handleDelete(id) {
    const url = 'http://localhost:1234/home/delete/' + id;
    async function deleteProduct() {
      await fetch(url, {
        method: 'POST',
      }).then((error) => {
        if (error) {
          console.log(error);
        }
      });
    }
    deleteProduct();
    window.location.reload();
  }
  return (
    <div className='product-list'>
      <ul className='temp'>{products.map(product => (
        <div key={product.id}>
          <div className='product'>
            <div className='thumbnail'>
              <img src={product.picture_p}></img>
            </div>
            <div className='content'>
              <h2>Name: {product.productName_p}</h2>
              <p>Description: {product.description_d}</p>
              <p>Price: {product.price_p} $</p>
              <p>Status: {product.status_s}</p>
            </div>
            <div className='custom-button'>
              <Button onClick={() => handleDetail(product.id)}>Detail</Button>
              <Button onClick={() => handleDelete(product.id)} variant='danger'>Delete</Button>
            </div>
          </div>
        </div>
      ))}</ul>
    </div>
  )
}

export default ProductLists;
