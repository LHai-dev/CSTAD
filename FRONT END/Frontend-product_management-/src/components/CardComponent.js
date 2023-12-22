'use client'
import React, {useEffect, useState} from 'react';
import Link from "next/link";
import Image from "next/image";
import usePagination from "@/usePagination";
import {Pagination} from "flowbite-react";


async function fetchProductData() {
    const response = await fetch('http://34.124.148.191:15000/api/v1/products');
    const data = await response.json();
    return data;
}

const imageIndex = 0;
const imageIndex1 = 1;

function CardComponent({id, onPageChange}) {
    const [productData, setProductData] = useState([]);
    useEffect(() => {
        async function fetchData() {
            const data = await fetchProductData();
            setProductData(data.data.list);
        }

        // console.log("hello",productData.map(id))

        fetchData();
    }, []);
    const {
        data,
        handleResultsNumber,
        handleNextPage,
        handlePrevPage,
        totalPages,
    } = usePagination({initData: productData, itemsPerPage: 5}); // Adjust itemsPerPage as needed
    console.log(usePagination)

    return (
        <div className="max-w-screen-xl mx-auto px-5 lg:px-0">
            <div className={"grid gap-8 lg:gap-24 grid-cols-2 md:grid-cols-3 my-24"}>
                {data.length > 0 ? (
                    data.map((product) => (
                        <div key={product.id} className="carousel-single-item">
                            {/* Rest of your code for rendering a single product */}
                            <div className="col-12">
                                <div className="product-box">
                                    <div className="product-box-wrapper">
                                        <div className="product-img">
                                            <>
                                                {product?.image?.length > 0 ? (
                                                    <div>
                                                        <Image
                                                            src={product.image[imageIndex]?.imageUrl ? product.image[imageIndex]?.imageUrl : "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/No-Image-Placeholder.svg/1200px-No-Image-Placeholder.svg.png"}
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
                                            </>
                                            <Link href={`/single-product/${product.id}`} className="d-block">
                                                <div className="second-img">
                                                    {product?.image?.length > 0 ? (
                                                        <div>
                                                            <Image
                                                                src={product.image[imageIndex1]?.imageUrl ? product.image[imageIndex1]?.imageUrl :  "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/No-Image-Placeholder.svg/1200px-No-Image-Placeholder.svg.png"}
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
                                            </Link>
                                            <Link href="javascript:void(0)"
                                                  className="product-img-link quick-view-1 text-capitalize">Quick
                                                view</Link>
                                        </div>
                                        <div className="product-desc pb-20">
                                            <div className="product-desc-top">
                                                <div className="categories flex">
                                                    <div>Size:</div>
                                                    {product?.productVariants?.length > 0 ? (
                                                        product.productVariants.map((productVariant) => (
                                                            <div key={productVariant.id} className="product-categor">
                                                                <span> {productVariant?.size ? productVariant?.size : "UNKNOWN"},</span>
                                                            </div>
                                                        ))
                                                    ) : (
                                                        <div className="price switcher-item">No product variants
                                                            available.</div>
                                                    )}
                                                </div>
                                                <Link href="wishlist.html" className="wishlist float-right">
                                                    <span><i className="fal fa-heart"></i></span>
                                                </Link>
                                            </div>
                                            <Link href={`/single-product/${product.id}`} className="product-title">
                                                {product?.name ? product?.name : "UNKNOWN"}
                                            </Link>
                                            <div className="price-switcher">
                                                {product?.productVariants?.length > 0 ? (
                                                    product.productVariants.map((productVariant) => (
                                                        <div key={productVariant.id} className="price switcher-item">
                                                            <div>{productVariant?.price}$,</div>
                                                        </div>
                                                    ))
                                                ) : (
                                                    <div className="price switcher-item ml-24">No product variants
                                                        available.</div>
                                                )}
                                                <Link href={`/single-product/${product.id}`}
                                                      className="add-cart text-capitalize switcher-item">+add to
                                                    cart</Link>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    ))
                ) : (
                    <>Your fallback content</>
                )}

            </div>
            <nav aria-label="Page navigation example">
                <ul className="inline-flex -space-x-px text-base ">
                    <li>
                        <a onClick={handlePrevPage}
                           className="flex items-center justify-center px-4 h-20 ml-0 leading-tight text-gray-500 bg-white border border-gray-300 rounded-l-lg hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white">Previous</a>
                    </li>
                    <li className="flex items-center justify-center px-4 h-20 ml-0 leading-tight text-gray-500 bg-white border border-gray-300  hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white">
                        <select
                            onChange={(e) => handleResultsNumber(e.target.value)}
                            className="block w-24 py-2  pr-6 mt-2 text-gray-700 bg-white border border-gray-300 rounded-md focus:ring focus:ring-blue-200 focus:border-blue-400"
                        >
                            <option value="5">5</option>
                            <option value="10">10</option>
                            <option value="15">15</option>
                            <option value="20">20</option>
                        </select>
                    </li>


                    <li>
                        <a onClick={handleNextPage}
                           className="flex items-center justify-center px-4 h-20 leading-tight text-gray-500 bg-white border border-gray-300 rounded-r-lg hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800 dark:border-gray-700 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white">Next</a>
                    </li>
                </ul>
            </nav>
        </div>
    );
}


export default CardComponent;
