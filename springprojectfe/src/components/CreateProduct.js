import React from 'react'
import { Button, Container, Form } from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import { useEffect, useState } from "react";
import axios from 'axios';

export default function CreateProduct(props) {
    const [productName_p, setProduct] = useState('');
    const [description_d, setDescription] = useState('');
    const [price_p, setPrice] = useState('');
    const [status_s, setStatus] = useState('');
    const [picture_p, setPicture] = useState('');

    function handleCreateProduct() {
        async function addNewProduct() {
            const url = 'http://localhost:1234/home/save'
            const response = await axios.post(url, {
                productName_p : productName_p,
                description_d : description_d,
                picture_p : picture_p,
                price_p : price_p,
                status_s : status_s,
            }).catch(error => {
                console.log(error);
            })
            console.log(response);
        }
        addNewProduct();
        window.location.reload();
    }

    return (
        <div>
            <h1>ADD NEW PRODUCT</h1>
            <Container>
                <Form>
                    <Form.Group>
                        <Form.Label>Product Name</Form.Label>
                        <Form.Control type='text' name='productName_p' onChange={(e) => setProduct(e.target.value)} placeholder='Product Name'></Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Description</Form.Label>
                        <Form.Control type='text' name='description_d' onChange={(e) => setDescription(e.target.value)} placeholder='Description'></Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Picture</Form.Label>
                        <Form.Control type='text' name='picture_p' onChange={(e) => setPicture(e.target.value)} placeholder='Picture'></Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Price</Form.Label>
                        <Form.Control type='number' name='price_p' onChange={(e) => setPrice(e.target.value)} placeholder='Price'></Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Status</Form.Label>
                        <Form.Control type='text' name='status_s' onChange={(e) => setStatus(e.target.value)} placeholder='Status'></Form.Control>
                    </Form.Group>
                    <br></br>
                    <Button onClick={() => { handleCreateProduct() }} variant='primary'>Create</Button>
                </Form>
                <br></br>
                <Button onClick={() => {window.location.href = 'http://localhost:3000/'}}></Button>
            </Container>
        </div>
    )
}
