import React from 'react';

function CheckoutComponent() {
    return (
        <>
            {/*// <!-- breadcrumb-area-start -->*/}
            <section className="breadcrumb-area " data-background="img/bg/page-title.html">
                <div className="container">
                    <div className="row">
                        <div className="col-xl-12">
                            <div className="breadcrumb-content flex flex-col" >
                                <nav aria-label="breadcrumb">
                                    <ol className="breadcrumb p-0 m-0">
                                        <li className="breadcrumb-item"><a href="index2.html">Home</a></li>
                                        <li className="breadcrumb-item active" aria-current="page">Cart</li>
                                    </ol>
                                </nav>
                                <h2 className="cart-title mt-40">Cart</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            {/*// <!-- breadcrumb-area-end -->*/}


            {/*// <!-- checkout-area start -->*/}
            <section className="checkout-area pb-70 mt-6">
                <div className="container">
                    <form action="#">
                        <div className="row">
                            <div className="col-lg-12">
                                <div className="your-order mb-30">
                                    <h3>Your order</h3>
                                    <div className="your-order-table table-responsive">
                                        <table>
                                            <thead>
                                            <tr>
                                                <th className="product-name">Product</th>
                                                <th className="product-total">Total</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr className="cart_item">
                                                <td className="product-name">
                                                    Product QTY <strong className="product-quantity"> × 1</strong>
                                                </td>
                                                <td className="product-total">
                                                    <span className="amount">$5.00</span>
                                                </td>
                                            </tr>
                                            <tr className="cart_item">
                                                <td className="product-name">
                                                    color
                                                </td>
                                                <td className="product-total">
                                                    <span className="color">yellow</span>
                                                </td>
                                            </tr>
                                            <tr className="cart_item">
                                                <td className="product-name">
                                                    size
                                                </td>
                                                <td className="product-total">
                                                    <span className="size">M</span>
                                                </td>
                                            </tr>
                                            <tr className="cart_item">
                                                <td className="product-name">
                                                    type
                                                </td>
                                                <td className="product-total">
                                                    <span className="color">Shoes</span>
                                                </td>
                                            </tr>
                                            </tbody>

                                        </table>
                                    </div>

                                    <div className="payment-method">
                                        <div className="accordion" id="accordionExample">
                                            <div className="card">
                                                <div className="card-header" id="headingOne">
                                                    <h5 className="mb-0">
                                                        <button className="btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                                            Direct Bank Transfer
                                                        </button>
                                                    </h5>
                                                </div>

                                                <div id="collapseOne" className="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                                                    <div className="card-body">
                                                        Make your payment directly into our bank account. Please use your Order ID as the payment reference. Your order won&apos;t be shipped until the funds have cleared in our account.
                                                    </div>
                                                </div>
                                            </div>
                                            <div className="card">
                                                <div className="card-header" id="headingTwo">
                                                    <h5 className="mb-0">
                                                        <button className="btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                                            Cheque Payment
                                                        </button>
                                                    </h5>
                                                </div>
                                                <div id="collapseTwo" className="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                                                    <div className="card-body">
                                                        Please send your cheque to Store Name, Store Street, Store Town, Store State / County, Store Postcode.
                                                    </div>
                                                </div>
                                            </div>
                                            <div className="card">
                                                <div className="card-header" id="headingThree">
                                                    <h5 className="mb-0">
                                                        <button className="btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                                            PayPal
                                                        </button>
                                                    </h5>
                                                </div>
                                                <div id="collapseThree" className="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
                                                    <div className="card-body">
                                                        Pay via PayPal; you can pay with your credit card if you don&apos;t have a PayPal account.
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div className="order-button-payment mt-20">
                                            <button type="submit" className="btn theme-btn">Buy</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </section>
            {/*// <!-- checkout-area end -->*/}

        </>
    );
}

export default CheckoutComponent;