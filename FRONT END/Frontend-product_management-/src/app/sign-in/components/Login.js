import React from 'react';
import Link from "next/link";
import Image from "next/image";

function Login() {
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
                                        <li className="breadcrumb-item"><a href={"/"}>Home</a></li>
                                        <li className="breadcrumb-item active" aria-current="page">Login</li>
                                    </ol>
                                </nav>
                                <h2 className="login-title mt-40 text-center">Login</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            {/*// <!-- breadcrumb-area-end -->*/}


            {/*<!-- login Area Strat-->*/}

            <section className="login-area pt-100 pb-100">
                <div className="container">
                    <div className="row">
                        <div className="col-lg-6 offset-lg-2">
                            <div className="basic-login">
                                <form action="#">
                                    <label htmlFor="name">Email Address <span>**</span></label>
                                    <input id="name" className={"rounded-lg"} type="text"
                                           placeholder="Enter Username or Email address..."/>
                                    <label htmlFor="pass">Password <span>**</span></label>
                                    <input id="pass" className={"rounded-lg"} type="password"
                                           placeholder="Enter password..."/>
                                    <div className="login-action mb-20 fix">
                  <span className="log-rem f-left">
                    <input id="remember" type="checkbox"/>
                    <label htmlFor="remember">Remember me!</label>
                  </span>
                                        <span className="forgot-login f-right">
                    <Link href="javascript:void(0)">Lost your password?</Link>
                  </span>
                                    </div>
                                    <button className="btn theme-btn-2 w-100 rounded-lg">Login Now</button>
                                    <div className="or-divide"><span>or</span></div>
                                    <Link
                                        href="/sign-up"> {/* Replace "/register" with the actual URL of the registration page */}
                                        <button className="btn theme-btn w-100 rounded-lg">Register Now</button>
                                    </Link>
                                </form>
                            </div>
                        </div>
                        <div className="col-lg-6 offset-lg-2">
                            <Image width={"1000"} height={"1000"} src={"/images/4957136.jpg"}
                                   alt={"loginImage"}></Image>
                        </div>
                    </div>
                </div>
            </section>

            {/*// <!-- login Area End-->*/}
        </>
    );
}

export default Login;