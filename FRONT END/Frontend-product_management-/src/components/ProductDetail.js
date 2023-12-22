'use client'
import {BsMessenger, BsTelegram} from "react-icons/bs";
import Link from "next/link";
import React from "react";


function ProductDetail({product}) {
    console.log("hello",product.data.image)
    return (
        <>
            <section className=" container single-product mb-90">
                <div className="container-fluid">
                    <nav aria-label="breadcrumb" className="mb-40">
                        <ol className="breadcrumb p-0 m-0">
                            <li className="breadcrumb-item"><Link href="/">Home</Link></li>
                            <li className="breadcrumb-item" aria-current="page"><Link href={"/product"}>Product</Link></li>
                            <li className="breadcrumb-item active" aria-current="page">single Product</li>
                        </ol>
                    </nav>
                    <div className="shop-wrapper">
                        <div className="single-product-top">
                            <div className="row">
                                <div className="col-xl-6 col-lg-6 col-md-4 col-12">
                                    <div className="shop-img">
                                        {/*{product?.data?.productVariants?.length > 0 ? (*/}
                                        {/*    product?.data?.productVariants.map((productVariant) => (*/}
                                        {/*        // console.log(productVariant.price)*/}

                                        {/*        <div key={productVariant.id} >*/}
                                        {/*            {productVariant?.description ? productVariant?.description : "UNKNOW"}*/}
                                        {/*        </div>*/}
                                        {/*    ))*/}
                                        {/*) : (*/}
                                        {/*    <div className="price switcher-item">No product variants*/}
                                        {/*        available.</div>*/}
                                        {/*)}*/}
                                        <div>
                                            <div>
                                                {product?.data?.image?.length > 0 ? (
                                                    <div className="row">
                                                        {product?.data?.image?.map((image) => (
                                                            <div className="col-md-6" key={image.id}>
                                                                <Link href={image?.imageUrl || "UNKNOWN"} className="popup-image">
                                                                    <img src={image?.imageUrl || "UNKNOWN"} className="w-100 mb-30" alt=""/>
                                                                </Link>
                                                            </div>
                                                        ))}
                                                    </div>
                                                ) : (
                                                    <div className="price switcher-item">No image available.</div>
                                                )}
                                            </div>

                                        </div>

                                    </div>
                                </div>
                                <div className="col-xl-6 col-lg-6 col-md-8 col-12">
                                    <div className="single-product-sidebar">


                                        <div className="product-content">
                                            <div className="single-product-title">
                                                {/*<h1 className=''>{id}</h1>*/}
                                                {/*<h2>{name}</h2>*/}
                                                <div>

                                                    {product?.data?.productVariants?.length > 0 ? (
                                                        <div key={product?.data?.productVariants.id}>
                                                            <div><h1>{product?.data?.name ? product?.data?.name : "UNKNOWN"}</h1></div>
                                                        </div>
                                                    ) : (
                                                        <div className="price switcher-item">No product variants available.</div>
                                                    )}</div>

                                            </div>
                                            <div className={"flex"}>

                                                {product?.data?.productVariants?.length > 0 ? (
                                                    product?.data?.productVariants.map((productVariant) => (
                                                        // console.log(productVariant.price)

                                                        <div key={productVariant.id} >
                                                            <div
                                                                className="single-product-price"><span>{productVariant?.price ? productVariant?.price : "UNKNOW"}$,</span>
                                                            </div>
                                                        </div>
                                                    ))
                                                ) : (
                                                    <div className="price switcher-item">No product variants
                                                        available.</div>
                                                )}

                                            </div>

                                            <div className="single-product-desc mb-25">
                                                {product?.data?.productVariants?.length > 0 ? (
                                                    product?.data?.productVariants.map((productVariant) => (
                                                        // console.log(productVariant.price)

                                                        <div key={productVariant.id} >
                                                            {productVariant?.description ? productVariant?.description : "UNKNOW"}
                                                        </div>
                                                    ))
                                                ) : (
                                                    <div className="price switcher-item">No product variants
                                                        available.</div>
                                                )}

                                                <div className="product-list single-product-list mt-6">
                                                    <ul >
                                                        <div className={"flex space-x-5"}><h6>Size: </h6>
                                                        {product?.data?.productVariants?.length > 0 ? (
                                                            product?.data?.productVariants.map((productVariant) => (
                                                                // console.log(productVariant.price)

                                                                <div key={productVariant.id} >
                                                                    <li><h2> {productVariant?.size ? productVariant?.size : "UNKNOW"},</h2></li>

                                                                </div>
                                                            ))
                                                        ) : (
                                                            <div className="price switcher-item">No product variants
                                                                available.</div>
                                                        )}</div>
                                                         Color :
                                                        {product?.data?.productVariants?.length > 0 ? (
                                                            product?.data?.productVariants.map((productVariant) => (
                                                                // console.log(productVariant.price)

                                                                <div key={productVariant.id} >
                                                                    <li> <h3>{productVariant?.color ? productVariant?.color : "unknow"}</h3></li>

                                                                </div>
                                                            ))
                                                        ) : (
                                                            <div className="price switcher-item">No product variants
                                                                available.</div>
                                                        )}
                                                       </ul>
                                                </div>
                                            </div>

                                            <div className="quick-quantity mt-10">
                                                <form action="#" method="POST">
                                                    <div className="total-cart">
                                                        {product?.data?.productVariants?.length > 0 ? (
                                                            product?.data?.productVariants.map((productVariant) => (
                                                                // console.log(productVariant.price)

                                                                <div key={productVariant.id} >
                                                                    {/*<li> <h1>{productVariant?.color ? productVariant?.color : "unknow"}</h1></li>*/}
                                                                    <span className="cart-count">{productVariant?.stock ? productVariant?.stock : "unknow"} in stock ({productVariant?.color ? productVariant?.color : "unknow"})</span>
                                                                </div>
                                                            ))
                                                        ) : (
                                                            <div className="price switcher-item">No product variants
                                                                available.</div>
                                                        )}
                                                    </div>
                                                    {/* Use the Link component to wrap the button */}
                                                    <Link href={"/checkout"}>
                                                        <button
                                                            type="submit" // Change the button type to "submit"

                                                            className="w-[220px] h-16 border-0 rounded-lg text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium  text-sm px-5 py-2.5 text-center inline-flex items-center mr-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
                                                        >
                                                            <div className="flex justify-center text-center text-2xl">
                                                                <svg
                                                                    className="w-6 h-6 mr-6 mt-1"
                                                                    aria-hidden="true"
                                                                    xmlns="http://www.w3.org/2000/svg"
                                                                    fill="currentColor"
                                                                    viewBox="0 0 18 21"
                                                                >
                                                                    <path d="M15 12a1 1 0 0 0 .962-.726l2-7A1 1 0 0 0 17 3H3.77L3.175.745A1 1 0 0 0 2.208 0H1a1 1 0 0 0 0 2h.438l.6 2.255v.019l2 7 .746 2.986A3 3 0 1 0 9 17a2.966 2.966 0 0 0-.184-1h2.368c-.118.32-.18.659-.184 1a3 3 0 1 0 3-3H6.78l-.5-2H15Z" />
                                                                </svg>
                                                                Buy now

                                                            </div>
                                                        </button>
                                                    </Link>
                                                </form>
                                            </div>

                                            <label className={"mt-3 text-3xl"}>Or want to contact us </label><br/>
                                            <Link href={"https://m.me/ahhai12345/"} target="_blank" rel="noopener noreferrer">
                                                <button type="button"
                                                        className="text-white bg-[#3b5998] h-16 hover:bg-[#3b5998]/90 focus:ring-4 focus:outline-none focus:ring-[#3b5998]/50 font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center dark:focus:ring-[#3b5998]/55 mr-2 mb-2">
                                                    <BsMessenger className={"mr-3"}/>
                                                    Messenger
                                                </button>
                                            </Link>
                                            <Link href={"https://t.me/lunlimhaist14"} target="_blank" rel="noopener noreferrer">
                                                <button type="button"
                                                        className="text-white bg-[#1da1f2] h-16 hover:bg-[#1da1f2]/90 focus:ring-4 focus:outline-none focus:ring-[#1da1f2]/50 font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center dark:focus:ring-[#1da1f2]/55 mr-2 mb-2">
                                                    <BsTelegram className={"mr-3"}/>
                                                    Telegram
                                                </button>
                                            </Link>


                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                </div>
            </section>
        </>


    );

}
export default ProductDetail;

