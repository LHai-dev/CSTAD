"use client";

import Image from "next/image";
import Link from "next/link";

export default function NavbarComponent({}) {

    return (<>
            {/*<div id="loader-wrapper">*/}
            {/*    <div id="loader"></div>*/}
            {/*</div>*/}
            <nav className="bg-white border-gray-200 dark:bg-gray-900">
                <div className="flex flex-wrap justify-between items-center mx-auto max-w-screen-xl p-4">
                    <Link href="/" className="flex items-center">
                        <img  src="/images/logo12.svg" className="h-8 mr-3" alt="logo12"/>
                        <span
                            className="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">Heng shop</span>
                    </Link>
                    <div className="flex items-center ">
                        <a href="tel:012349929"
                           className="mr-3 ml-5 text-sm   text-gray-500 dark:text-white hover:underline">(855)
                            12349929</a>
                        <Link href={"/sign-in"}>
                            <button
                                className="relative inline-flex items-center justify-center p-0.5 mb-2 mr-2 overflow-hidden text-sm font-medium text-gray-900 rounded-lg group bg-gradient-to-br from-purple-600 to-blue-500 group-hover:from-purple-600 group-hover:to-blue-500 hover:text-white dark:text-white focus:ring-4 focus:outline-none focus:ring-blue-300 dark:focus:ring-blue-800">
                        <div className={"flex"} >
                        <span
                          className="relative px-5 py-2.5 transition-all ease-in duration-75 bg-white dark:bg-gray-900 rounded-md group-hover:bg-opacity-0">
                        <svg width={"30"} xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512"><path
                        d="M352 96l64 0c17.7 0 32 14.3 32 32l0 256c0 17.7-14.3 32-32 32l-64 0c-17.7 0-32 14.3-32 32s14.3 32 32 32l64 0c53 0 96-43 96-96l0-256c0-53-43-96-96-96l-64 0c-17.7 0-32 14.3-32 32s14.3 32 32 32zm-9.4 182.6c12.5-12.5 12.5-32.8 0-45.3l-128-128c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3L242.7 224 32 224c-17.7 0-32 14.3-32 32s14.3 32 32 32l210.7 0-73.4 73.4c-12.5 12.5-12.5 32.8 0 45.3s32.8 12.5 45.3 0l128-128z"/></svg>
                        Sign In
                        </span>
                        </div>
                            </button>
                        </Link>
                        <div className={""}>
                            <Link href={"/sign-up"}>
                                <button type="button"
                                        className="text-white bg-gradient-to-br from-purple-600 to-blue-500 hover:bg-gradient-to-bl focus:ring-4 focus:outline-none focus:ring-blue-300 dark:focus:ring-blue-800 font-medium rounded-lg text-sm px-5 py-2.5 text-center mr-2 mb-2">
                                    <svg className="w-[12px] ml-3 h-[12px] text-gray-800 dark:text-white" aria-hidden="true"
                                         xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
                                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                                              stroke-width="2"
                                              d="M10 19a9 9 0 1 0 0-18 9 9 0 0 0 0 18Zm0 0a8.949 8.949 0 0 0 4.951-1.488A3.987 3.987 0 0 0 11 14H9a3.987 3.987 0 0 0-3.951 3.512A8.948 8.948 0 0 0 10 19Zm3-11a3 3 0 1 1-6 0 3 3 0 0 1 6 0Z"/>
                                    </svg>
                                    Sign Up
                                </button>


                            </Link>
                        </div>


                    </div>
                </div>
            </nav>
            <nav className="bg-gray-50 dark:bg-gray-700">
                <div className="max-w-screen-xl px-4 py-3 mx-auto">
                    <div className="flex items-center">
                        <ul className="flex flex-row  font-medium mt-0 mr-6 space-x-8 text-sm">
                            <li>
                                <a href={"/"}
                                   className="text-gray-900 mr-5 dark:text-white hover:underline"
                                   aria-current="page">Home</a>
                            </li>
                            <li>
                                <a href="/product"
                                   className="text-gray-900  mr-5 dark:text-white hover:underline">Product</a>
                            </li>
                            <li>
                                <a href={"/contact"}
                                   className="text-gray-900  mr-5 dark:text-white hover:underline">About/Contact</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>


            {/*// <!-- slider section start -->*/}

            {/*// <!-- slider section end -->*/}


        </>


    );
}
