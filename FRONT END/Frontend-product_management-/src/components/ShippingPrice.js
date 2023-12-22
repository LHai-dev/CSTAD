import React from 'react';

function ShippingPrice() {
    return (
        <>
            {/*// <!-- shipping-price section start -->*/}
            <section className="shipping-price-section pt-130 mt-60 gray-border-top">
                <div className="container">
                    <div className="shipping-icon justify-center flex text-center">
                        <img src="/images/Shipping.svg" alt=""/>
                    </div>
                    <div className="shipping-desc pt-35">
                        <h2 className="mb-20">buy Over 3 product Ship Free!</h2>
                        <p className="mb-0">Shop for 3 or more free shipping nationwide.</p>
                        <p className="mb-0">accumsan ac bibendum ac in erat. Donec posuere consectetuer volutpat rutrum ac,
                            sollicitudin quam quisque, at</p>
                        <p className="mb-0">interdum dignissim, fringilla elit risus lorem, eu condimentum eros mollis.</p>
                      <div className={"flex justify-center"}>
                          <div className={"w-36 h-36"}>
                              <img src="/images/bun.svg"/>
                          </div>
                          <div className={"w-36 h-36 "}>
                              <img src="/images/J&T.svg"/>
                          </div>
                      </div>

                    </div>
                </div>
            </section>
            {/*// <!-- shipping-price section end -->*/}
        </>
    );
}

export default ShippingPrice;