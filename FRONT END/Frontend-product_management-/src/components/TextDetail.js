import React from 'react';

function TextDetail() {
    return (
        <>
            <section className="welcome mt-125">
                <div className="container  pb-120 welcome-inner gray-border-bottom">
                    <div className="generic-title text-center">
                        <p className="pb-10 d-block"><span >Welcome to Heng Store</span></p>
                        <h2 className="mb-25">Your New Style From China Thailand and Korean</h2>
                        <p ><span
                            className="d-inline-block font-fontkon1">“ញកថសញាលកថញកលៈសាញថបនកៈលចហ</span>
                            <span className="d-inline-block">congue nisl accumsan ac bibendum ac in erat. Donec posuere consectetuer volutpat rutrum ac, sollicitudin quam quisque, at</span>
                            <span className="d-inline-block">interdum dignissim, fringilla elit risus lorem eu condimentum eros mollis…”</span>
                        </p>
                    </div>
                    <div className="signature mt-30">
                        <img src="/public/img/logo/singg.png" className="d-block mx-auto" alt=""/>
                    </div>
                    <div className="founder-name mt-35">
                        <h5 className="text-center mb-0"><span className="red-color">Lun LimHai</span> – Founder or Heng
                            Store</h5>
                    </div>
                </div>
            </section>
            <section className="service pt-57 mt-65">
                <div className="container container-1200">
                    <div className="row justify-content-center">
                        <div className="col-xl-4 col-md-6 service-item">
                            <div className="service-box service-box-3">
                                <div className=" text-center">
                                    <div className={"justify-center flex "}>
                                        <svg className="w-28 mb-6 h-28 text-gray-800 dark:text-white" aria-hidden="true"
                                             xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 18 18">
                                            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                                                  stroke-width="2"
                                                  d="m16.344 12.168-1.4-1.4a1.98 1.98 0 0 0-2.8 0l-.7.7a1.98 1.98 0 0 1-2.8 0l-2.1-2.1a1.98 1.98 0 0 1 0-2.8l.7-.7a1.981 1.981 0 0 0 0-2.8l-1.4-1.4a1.828 1.828 0 0 0-2.8 0C-.638 5.323 1.1 9.542 4.78 13.22c3.68 3.678 7.9 5.418 11.564 1.752a1.828 1.828 0 0 0 0-2.804Z"/>
                                        </svg>
                                    </div>

                                    <h4 className="title ">Online Support 24/7</h4>
                                    <p className="service-desc">Duis autem vel eum iriure dolor in hendrerit vulputate
                                        velit esse molestie consequat.</p>
                                </div>
                            </div>
                        </div>

                        <div className="col-xl-4 col-lg-6 hidden-md service-item">
                            <div className="service-box service-box-3">
                                <div className=" text-center">
                                    <div className={"justify-center flex"}>
                                        <svg className={"w-28 mb-6 h-28"} xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 576 512"><path d="M64 64C28.7 64 0 92.7 0 128V384c0 35.3 28.7 64 64 64H512c35.3 0 64-28.7 64-64V128c0-35.3-28.7-64-64-64H64zm64 320H64V320c35.3 0 64 28.7 64 64zM64 192V128h64c0 35.3-28.7 64-64 64zM448 384c0-35.3 28.7-64 64-64v64H448zm64-192c-35.3 0-64-28.7-64-64h64v64zM288 160a96 96 0 1 1 0 192 96 96 0 1 1 0-192z"/></svg>
                                    </div>
                                    <h4 className="title">Money Return Guarantee</h4>
                                    <p className="service-desc">Duis autem vel eum iriure dolor in hendrerit vulputate
                                        velit esse molestie consequat.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="container   gray-border-bottom pb-85"></div>
            </section>
        </>
    );
}

export default TextDetail;