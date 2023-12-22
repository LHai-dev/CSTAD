import React from 'react';
import {Carousel} from "flowbite-react";
import {usePathname} from "next/navigation";
import Image from "next/image";

function SliderComponent(props) {
    const pathName= usePathname();
    if (pathName.includes("/product")){
        return null;
    } if (pathName.includes("/categorys")){
        return null;
    }
    if (pathName.includes("/user")){
        return null;
    }
    return (

        <div className="h-96 md:h-96 xl:h-full 2xl:h-96 my-12 ">
            <Carousel
                leftControl={false}
                rightControl={false}
            >

                <img  width={500} height={500} className="object-cover h-full w-full"
                    src="/slide1.jpg"
                    alt="..."
                />
                <img  width={500} height={500} className="object-cover h-full w-full"
                    src="/slide2.jpg"
                    alt="..."
                />
            </Carousel>
        </div>
    );
}

export default SliderComponent; 