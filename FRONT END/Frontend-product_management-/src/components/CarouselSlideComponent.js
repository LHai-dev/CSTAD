import React from 'react';
import Link from "next/link";

function CarouselSlideComponent() {
    return (
        <>


            {/*// <!-- slider section start -->*/}
            <section className="slider">
                <div className="container pl-0 pr-0">
                    <div className="slider-active   center-dots number-dots">
                        <div className="single-slider large-content h-790 d-flex align-items-center "
                             style={{backgroundImage: `url(${"img/slider/7.jpg"})`}}>
                            <div className="container-fluid">
                                <div className="single-slider-inner">
                                    <div className="single-slider-content  light-content pl-10 mt-32  text-left">
                                        <div className="slider-heading small-heading-text" data-animation="flipInX"
                                             data-delay=".4s">
                                            <h2 className="mb-0">Sweater</h2>
                                            <h2 className="mb-0">New Trending 2019</h2>
                                        </div>
                                        <div className="slider-desc" data-animation="flipInX" data-delay=".6s">
                                            <p className="mt-35 mb-0">New Spring drops from Over. Shop the
                                                Collection</p>
                                        </div>
                                        <div className="slider-link slider-link-2" data-animation="flipInX"
                                             data-delay=".8s">
                                            <Link href="shop.html"
                                               className="generic-btn mt-70 red-hover-btn text-uppercase" tabindex="0">Discover
                                                now</Link>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            {/*// <!-- slider section end -->*/}


        </>
    );
}

export default CarouselSlideComponent;