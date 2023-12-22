import React from 'react';
import Link from "next/link";
import Image from "next/image";

function SignUp() {
    return (
        <>

            {/*// <!-- breadcrumb-area-start -->*/}
            <section className="breadcrumb-area" data-background="img/bg/page-title.html">
                <div className="container">
                    <div className="row">
                        <div className="col-xl-12">
                            <div className="breadcrumb-content flex flex-col">
                                <nav aria-label="breadcrumb">
                                    <ol className="breadcrumb p-0 m-0">
                                        <li className="breadcrumb-item"><a href="index4.html">Home</a></li>
                                        <li className="breadcrumb-item active " aria-current="page">Login</li>
                                    </ol>
                                </nav>
                                <h2 className="login-title mt-40 text-center">Sign Up</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            {/*// <!-- breadcrumb-area-end -->*/}

            {/*// <!-- login Area Strat-->*/}
            <section className="login-area pt-100 pb-100">
                <div className="container">
                    <div className="row">
                        <div className="col-lg-6 offset-lg-2">
                            <div className="basic-login">

                                <form action="#">
                                    <label for="name">Username <span>**</span></label>
                                    <input id="name" type="text" placeholder="Enter Username or Email address..."/>
                                    <label for="email-id">Email Address <span>**</span></label>
                                    <input id="email-id" type="text" placeholder="Enter Username or Email address..."/>
                                    <label for="pass">Password <span>**</span></label>
                                    <input id="pass" type="password" placeholder="Enter password..."/>
                                    <div className="mt-10"></div>


                                    <button className="btn theme-btn-2 w-100">Register Now</button>
                                    <div className="or-divide"><span>or</span></div>
                                    <Link href={"/sign-in"}>
                                        <button className="btn theme-btn w-100">login Now</button>
                                    </Link>
                                </form>
                            </div>
                        </div>
                        <div className="col-lg-6 offset-lg-2">
                           <Image width={1000} height={1000} src={"/images/6368592.jpg"} alt={"imagesignp"}>

                           </Image>
                        </div>
                    </div>
                </div>
            </section>
            {/*// <!-- login Area End-->*/}
        </>
    );
}

export default SignUp;