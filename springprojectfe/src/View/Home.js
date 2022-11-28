import React from 'react'
import { useEffect, useState } from "react";
import ProductLists from "../components/ProductList";
import { Button } from 'react-bootstrap';

export default function Home() {
    const [productList, setProductList] = useState([]);
    const catPic = 'https://i.guim.co.uk/img/media/26392d05302e02f7bf4eb143bb84c8097d09144b/446_167_3683_2210/master/3683.jpg?width=1200&quality=85&auto=format&fit=max&s=a52bbe202f57ac0f5ff7f47166906403';

    useEffect(() => {
        async function fetchProductList() {
            try {
                const url = 'http://localhost:1234/home';
                const response = await fetch(url, {
                    method: 'GET',
                })
                const responseJSON = await response.json();
                setProductList(responseJSON);
            } catch (error) {
                console.log('ERROR: ', error);
            }
        }
        fetchProductList();
    }, []);

    return (
        <div>
            <img src={catPic}></img>
            <ProductLists products={productList} />
            {/* <Button onClick={() => {window.location.href = 'http://localhost:3000/save'}}>Create New Product</Button> */}
        </div>
    )
}
