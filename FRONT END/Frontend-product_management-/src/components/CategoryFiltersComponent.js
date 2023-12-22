import React from 'react';

function CategoryFiltersComponent() {

    return (
        <>


            <div className="col-xl-3 ">
                {/*// <!-- widget -->*/}
                <div className="widget">
                    <h4 className="mb-30">Product Categories</h4>
                    <div className="accordion" id="accordionExample">
                        <div className="list">
                            <a href="javascript:void(0)">Shirt<span>(0)</span></a>

                        </div>

                        <div className="list">
                            <a href="javascript:void(0)">Jeans<span>(10)</span></a>
                        </div>

                        <div className="list">
                            <a href="javascript:void(0)">Shoes <span>(10)</span></a>
                        </div>

                        <div className="list">
                            <a href="javascript:void(0)">Other <span>(15)</span></a>

                        </div>
                    </div>
                </div>

                <div className="widget mt-50">
                    <h4 className="mb-30">Filter By Color</h4>
                    <ul className="space-y-4 color-list">
                        <li className="w-8 h-8 bg-black"></li>
                        <li className="w-8 h-8 bg-blue-600"></li>
                        <li className="w-8 h-8 bg-yellow-400"></li>
                        <li className="w-8 h-8 bg-gray-300"></li>
                        <li className="w-8 h-8 bg-green-700"></li>
                        <li className="w-8 h-8 bg-yellow-500"></li>
                        <li className="w-8 h-8 bg-white"></li>
                        <li className="w-8 h-8 bg-red-600"></li>
                    </ul>
                </div>
                <div className="widget mt-50">
                    <h4 className="mb-30">Filter By Size</h4>
                    <div className="size-link">
                        <a href="shop2.html">3xl</a>
                        <a href="shop2.html">l</a>
                        <a href="shop2.html">m</a>
                        <a href="shop2.html">s</a>
                        <a href="shop2.html">xl</a>
                        <a href="shop2.html">xxl</a>
                    </div>
                </div>
            </div>

        </>
    );
}

export default CategoryFiltersComponent;