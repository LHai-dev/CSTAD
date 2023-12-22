
import React from 'react';
import ProductDetail from "@/components/ProductDetail";

 // function Page({params}) {
async function getUserVeiwDetail1(id) {
    const response = await fetch(`http://34.124.148.191:15000/api/v1/products/${id}`);
    const data1 = await response.json();
    return data1;
}
export default async function page({params}) {
    const {id} = params;
    const product = await getUserVeiwDetail1(id);
    return (
        <ProductDetail
            product={product}
            /> );
}
