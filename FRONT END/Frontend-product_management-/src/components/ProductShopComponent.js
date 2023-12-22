'use client'
import React, {useEffect} from 'react';
import {useState} from "react";
import Image from "next/image";

const fetchProduct = async (categoryId) => {
    const res = await fetch(`http://34.124.148.191:15000/api/v1/products/color-and-name?cId=${categoryId}`);
    const data = await res.json();
    return data;
}

function ProductShopComponent({id}) {
    const imageIndex = 0;
    const imageIndex1 = 1;
    const [productData, setProductData] = useState([]);
    // useEffect(() => {
    //     async function fetchData() {
    //         const data = await fetchProduct();
    //         setProductData(data);
    //     }
    //
    //     // fetchData();
    // }, []);
    //  const productss = fetchProduct(1)
    const categoryIds = [1, 2, 3, 4];

    useEffect(() => {
        const fetchDataForCategory = async (categoryId) => {
            try {
                const data = await fetchProduct(categoryId);
                setProductData((prevData) => [...prevData, ...data?.data?.list]);
            } catch (error) {
                console.error(`Error fetching data for category ${categoryId}:`, error);
            }
        };

        categoryIds.forEach((categoryId) => {
            fetchDataForCategory(categoryId);
        });
    }, []);


    console.log(productData, "product cvbr")

    return (
        <>

            <div className="shop-body mb-90">
                <div className={"container-fluid "}>
                    <nav aria-label="breadcrumb" className="mb-40">
                        <ol className="breadcrumb p-0 m-0">
                            <li className="breadcrumb-item"><a href="index3.html">Home</a></li>
                            <li className="breadcrumb-item active" aria-current="page">Product</li>
                        </ol>
                    </nav>
                    <div className={"max-w-screen-xl mx-auto px-5 lg:px-0"}>
                        <div className="col-xl-3 ">
                            {/*// <!-- widget -->*/}
                            <div className="widget">
                                <h4 className="mb-30">Product Categories</h4>
                                <div className="accordion" id="accordionExample">


                                    <div key={productData.id}>
                                        <div className="list">
                                            <a href="javascript:void(0)" onClick={""}>shirt<span>()</span></a>
                                        </div>

                                        <div className="list">
                                            <a href="javascript:void(0)">Jeans<span>(10)</span></a>
                                        </div>

                                        <div className="list">
                                            <a href="javascript:void(0)">Shoes <span>(10)</span></a>
                                        </div>

                                        <div className="list">
                                            <a href="javascript:void(0)">Other <span>(15)</span></a>

                                        </div>

                                    </div>


                                </div>
                            </div>



                            <div className="widget mt-50">
                                <h4 className="mb-30">Filter By Color</h4>
                                <ul className="space-y-4 color-list">
                                    <li className="w-8 h-8 bg-black"></li>
                                    <li className="w-8 h-8 bg-blue-600"></li>
                                    <li className="w-8 h-8 bg-yellow-400"></li>
                                    <li className="w-8 h-8 bg-gray-300"></li>
                                    <li className="w-8 h-8 bg-green-700"></li>
                                    <li className="w-8 h-8 bg-yellow-500"></li>
                                    <li className="w-8 h-8 bg-white"></li>
                                    <li className="w-8 h-8 bg-red-600"></li>
                                </ul>
                            </div>
                            <div className="widget mt-50">
                                <h4 className="mb-30">Filter By Size</h4>
                                <div className="size-link">
                                    <a href="shop2.html">3xl</a>
                                    <a href="shop2.html">l</a>
                                    <a href="shop2.html">m</a>
                                    <a href="shop2.html">s</a>
                                    <a href="shop2.html">xl</a>
                                    <a href="shop2.html">xxl</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    {/* ... */}
                    {/* Other JSX code for breadcrumbs and category filters */}
                    {/* ... */}

                    {/* Product sections based on category IDs */}

                    <h1 className="text-center">
                        {/*{index === 0 ? 'Jeans' : index === 1 ? 'Shirt' : index === 2 ? 'Shoes' : `Category ${index + 1}`}*/}
                    </h1>
                    <div className="max-w-screen-xl mx-auto px-5 lg:px-0">
                        <div className="grid gap-8 lg:gap-24 grid-cols-2 md:grid-cols-4 my-24">
                            {/* Loop through products in productData and display them */}
                            {productData?.map((product, idx) => (
                                <div key={idx}>

                                    <div className="product-box mb-40">
                                        <div  className="product-box-wrapper">
                                            <div className="product-img" >
                                                {product?.image?.length > 0 ? (
                                                    <div>
                                                        <Image
                                                            src={product.image[imageIndex]?.imageUrl || "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/No-Image-Placeholder.svg/1200px-No-Image-Placeholder.svg.png"}
                                                            className="w-100"
                                                            alt={`Image ${imageIndex}`}
                                                            width={1000}
                                                            height={1000}
                                                        />
                                                    </div>
                                                ) : (
                                                    <div className="price switcher-item">
                                                        <Image
                                                            alt="No Image"
                                                            width={1000}
                                                            height={1000}
                                                            unoptimized
                                                            className="price switcher-item"
                                                            src="https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/No-Image-Placeholder.svg/1200px-No-Image-Placeholder.svg.png"
                                                        />
                                                    </div>
                                                )}
                                                <a href={`/single-product/${product.id}`} className="d-block">
                                                    <div className="second-img">
                                                        {product?.image?.length > 0 ? (
                                                            <div>
                                                                <Image
                                                                    src={product.image[imageIndex1]?.imageUrl || "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/No-Image-Placeholder.svg/1200px-No-Image-Placeholder.svg.png"}
                                                                    className="w-100"
                                                                    alt={`Image ${imageIndex1}`}
                                                                    width={1000}
                                                                    height={1000}
                                                                />
                                                            </div>
                                                        ) : (
                                                            <div className="price switcher-item">
                                                                <Image
                                                                    alt="No Image"
                                                                    width={1000}
                                                                    height={1000}
                                                                    unoptimized
                                                                    className="price switcher-item"
                                                                    src="https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/No-Image-Placeholder.svg/1200px-No-Image-Placeholder.svg.png"
                                                                />
                                                            </div>
                                                        )}
                                                    </div>
                                                </a>
                                                <a href="javascript:void(0)"
                                                   className="product-img-link quick-view-1 text-capitalize">Quick
                                                    view</a>
                                                <span className="sale bg-red text-white">sale!</span>
                                            </div>

                                            <div className="product-desc pb-20">
                                                <div className="product-desc-top">
                                                    <div className="categories">
                                                        <a href="shop2.html"
                                                           className="product-category"><span> {product.categoryId === 1 ? 'Jeans' :
                                                            product.categoryId === 2 ? 'Shirts' :
                                                                product.categoryId === 3 ? 'Shoes' :
                                                                    product.categoryId === 4 ? 'Accessories Or order' :
                                                                        'Unknown Category'}</span></a>
                                                    </div>
                                                    <a href="wishlist.html"
                                                       className="wishlist float-right"><span><i
                                                        className="fal fa-heart"></i></span></a>
                                                </div>
                                                <a href={`/single-product/${product.id}`}
                                                   className="product-title">{product.name}</a>
                                                {product?.productVariants?.length > 0 ? (
                                                    product.productVariants.map((productVariant) => (
                                                        <div key={productVariant.id} className="product-categor ">
                                                            <div className={""}>
                                                                <span className="price switcher-item"> $ {productVariant.price}</span>
                                                            </div>

                                                        </div>
                                                    ))
                                                ) : (
                                                    <div className="price switcher-item">No product variants
                                                        available.</div>
                                                )}
                                                <div className="price-switcher">
                                                    <a href="cart.html"
                                                       className="add-cart text-capitalize switcher-item">+add
                                                        to cart</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    {/* JSX code to display individual product */}
                                </div>
                            ))}
                        </div>
                    </div>

                </div>
            </div>

        </>
    );
}

export default ProductShopComponent;