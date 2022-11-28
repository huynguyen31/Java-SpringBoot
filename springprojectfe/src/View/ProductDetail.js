import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import SingleProduct from '../components/SingleProduct';

export default function ProductDetail() {
    const [tempProduct, setProduct] = useState('');
    const {id} = useParams();

    useEffect(() => {
        async function fetchProduct(){
            const url = 'http://localhost:1234/home/' + id;
            const response = await fetch(url,{
                method: 'GET',
            }).catch((error) => {console.log("ERROR: " , error)});
            const responseJSON = await response.json();
            setProduct(responseJSON);
        }
        fetchProduct();
    }, [])
  return (
    <div>
        <SingleProduct product={tempProduct}></SingleProduct>
    </div>
  )
}
