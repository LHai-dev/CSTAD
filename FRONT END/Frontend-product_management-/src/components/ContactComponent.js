import React from 'react';
import myImage from 'public/img/bg/3.jpg';
import Link from "next/link";



function ContactComponent() {
    return (
        <>
            <section className="contact-area pb-30" data-background="assets/img/bg/bg-map.html">
                <div className="has-breadcrumb-bg mb-120  "  style={{backgroundImage: `url(${"img/bg/3.jpg"})`}}>
                    <div className="breadcrumb-content flex flex-col d-flex justify-content-center align-items-center"
                         >
                        <h2 className="title text-center">Contact</h2>
                        <nav aria-label="breadcrumb" className="mb-40">
                            <ol className="breadcrumb p-0 m-0 justify-center flex">
                                <li className="breadcrumb-item"><a href="index2.html">Home</a></li>
                                <li className="breadcrumb-item active" aria-current="page">Contact</li>
                            </ol>
                        </nav>
                    </div>
                </div>
                <div className="container container-1430">
                    <div className="row">
                        <div className="col-xl-6 col-lg-6 col-md-6">
                            <div className="contact text-center mb-30">
                                <div className={"justify-center flex"}>

                                    <div className=" pt-8 pl-9 mb-3 bg-gray-400 w-36 h-36 rounded-full">
                                        <svg className="w-16 h-16 text-gray-800 dark:text-white" aria-hidden="true"
                                             xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 20">
                                            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                                                  stroke-width="2"
                                                  d="M7 13A6 6 0 1 0 7 1a6 6 0 0 0 0 12Zm0 0v6M4.5 7A2.5 2.5 0 0 1 7 4.5"/>
                                        </svg>
                                    </div>
                                </div>

                                <h3>Visit Here</h3>
                                <a href={"https://www.google.com/maps/place/Borey+Hong+Lay+Trapeang+Thloeng/@11.5330655,104.8538112,17z/data=!3m1!4b1!4m6!3m5!1s0x31095025b12ce90d:0xf36f86ee817817b1!8m2!3d11.5330655!4d104.8538112!16s%2Fg%2F11dfpr7q2y?entry=ttu"}><p>Borey Hong Lay Trapeang Thloeng, Phnom Penh</p></a>
                            </div>
                        </div>
                        <div className="col-xl-6  col-lg-6 col-md-6 ">
                            <div className="contact text-center mb-30">
                                <div className={"justify-center flex"}>
                                    <div className=" pt-12 pl-11 mb-3 bg-gray-400 w-36 h-36 rounded-full">
                                        <svg className="w-[33px] h-[33px] text-gray-800 dark:text-white" aria-hidden="true"
                                             xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 14 20">
                                            <path
                                                d="M12 0H2a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2ZM7.5 17.5h-1a1 1 0 0 1 0-2h1a1 1 0 0 1 0 2ZM12 13H2V4h10v9Z"/>
                                        </svg>
                                    </div>
                                </div>

                                <h3>Call Here</h3>
                                <a href={"tel:719888232"}><p>+855 719888232</p></a>
                                <a href={"tel:012349929"}><p>+855 12349929</p></a>
                            </div>
                        </div>
                        <div className="col-xl-6  col-lg-6 col-md-6 ">
                            <div className="contact text-center mb-30">
                                <div className={"justify-center flex"}>
                                    <div className=" pt-12  pl-11 mb-28 bg-gray-400 w-36 h-36 rounded-full">
                                        <svg className={"mb-96 w-36 h-36"} xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 496 512"><path d="M248,8C111.033,8,0,119.033,0,256S111.033,504,248,504,496,392.967,496,256,384.967,8,248,8ZM362.952,176.66c-3.732,39.215-19.881,134.378-28.1,178.3-3.476,18.584-10.322,24.816-16.948,25.425-14.4,1.326-25.338-9.517-39.287-18.661-21.827-14.308-34.158-23.215-55.346-37.177-24.485-16.135-8.612-25,5.342-39.5,3.652-3.793,67.107-61.51,68.335-66.746.153-.655.3-3.1-1.154-4.384s-3.59-.849-5.135-.5q-3.283.746-104.608,69.142-14.845,10.194-26.894,9.934c-8.855-.191-25.888-5.006-38.551-9.123-15.531-5.048-27.875-7.717-26.8-16.291q.84-6.7,18.45-13.7,108.446-47.248,144.628-62.3c68.872-28.647,83.183-33.623,92.511-33.789,2.052-.034,6.639.474,9.61,2.885a10.452,10.452,0,0,1,3.53,6.716A43.765,43.765,0,0,1,362.952,176.66Z"/></svg>
                                    </div>
                                </div>

                                <h3>Telegram</h3>
                                <button type="button"
                                        className="text-gray-900 bg-white border border-gray-300 focus:outline-none hover:bg-gray-100 focus:ring-4 focus:ring-gray-200 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-gray-800 dark:text-white dark:border-gray-600 dark:hover:bg-gray-700 dark:hover:border-gray-600 dark:focus:ring-gray-700"><Link href={"https://t.me/lunlimhaist14"}>Click Here</Link>
                                </button>


                            </div>
                        </div>
                        <div className="col-xl-6  col-lg-6 col-md-6 ">
                            <div className="contact text-center mb-30">
                                <div className={"justify-center flex"}>
                                    <div className=" pt-12  pl-11 mb-28 bg-gray-400 w-36 h-36 rounded-full">
                                        <svg className={"mb-96 w-36 h-36"} xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512"><path d="M504 256C504 119 393 8 256 8S8 119 8 256c0 123.78 90.69 226.38 209.25 245V327.69h-63V256h63v-54.64c0-62.15 37-96.48 93.67-96.48 27.14 0 55.52 4.84 55.52 4.84v61h-31.28c-30.8 0-40.41 19.12-40.41 38.73V256h68.78l-11 71.69h-57.78V501C413.31 482.38 504 379.78 504 256z"/></svg>                                    </div>
                                </div>
                                {/*className={"mb-96 w-36 h-36"}*/}
                                <h3>Facebook</h3>
                                <button type="button"
                                        className="text-gray-900 bg-white border border-gray-300 focus:outline-none hover:bg-gray-100 focus:ring-4 focus:ring-gray-200 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-gray-800 dark:text-white dark:border-gray-600 dark:hover:bg-gray-700 dark:hover:border-gray-600 dark:focus:ring-gray-700"> Click Here
                                </button>
                            </div>
                        </div>
                        <div className="col-xl-6  col-lg-6 col-md-6 ">
                            <div className="contact text-center mb-30">
                                <div className={"justify-center flex"}>
                                    <div className=" pt-12  pl-11 mb-28 bg-gray-400 w-36 h-36 rounded-full">
                                        <svg className={"mb-96 w-36 h-36"} xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512"><path d="M224.1 141c-63.6 0-114.9 51.3-114.9 114.9s51.3 114.9 114.9 114.9S339 319.5 339 255.9 287.7 141 224.1 141zm0 189.6c-41.1 0-74.7-33.5-74.7-74.7s33.5-74.7 74.7-74.7 74.7 33.5 74.7 74.7-33.6 74.7-74.7 74.7zm146.4-194.3c0 14.9-12 26.8-26.8 26.8-14.9 0-26.8-12-26.8-26.8s12-26.8 26.8-26.8 26.8 12 26.8 26.8zm76.1 27.2c-1.7-35.9-9.9-67.7-36.2-93.9-26.2-26.2-58-34.4-93.9-36.2-37-2.1-147.9-2.1-184.9 0-35.8 1.7-67.6 9.9-93.9 36.1s-34.4 58-36.2 93.9c-2.1 37-2.1 147.9 0 184.9 1.7 35.9 9.9 67.7 36.2 93.9s58 34.4 93.9 36.2c37 2.1 147.9 2.1 184.9 0 35.9-1.7 67.7-9.9 93.9-36.2 26.2-26.2 34.4-58 36.2-93.9 2.1-37 2.1-147.8 0-184.8zM398.8 388c-7.8 19.6-22.9 34.7-42.6 42.6-29.5 11.7-99.5 9-132.1 9s-102.7 2.6-132.1-9c-19.6-7.8-34.7-22.9-42.6-42.6-11.7-29.5-9-99.5-9-132.1s-2.6-102.7 9-132.1c7.8-19.6 22.9-34.7 42.6-42.6 29.5-11.7 99.5-9 132.1-9s102.7-2.6 132.1 9c19.6 7.8 34.7 22.9 42.6 42.6 11.7 29.5 9 99.5 9 132.1s2.7 102.7-9 132.1z"/></svg>
                                    </div>
                                </div>
                                {/*className={"mb-96 w-36 h-36"}*/}
                                <h3>instagram</h3>
                                <button type="button"
                                        className="text-gray-900 bg-white border border-gray-300 focus:outline-none hover:bg-gray-100 focus:ring-4 focus:ring-gray-200 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-gray-800 dark:text-white dark:border-gray-600 dark:hover:bg-gray-700 dark:hover:border-gray-600 dark:focus:ring-gray-700"> Click Here
                                </button>

                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </>
    );
}

export default ContactComponent;