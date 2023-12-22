import React from "react";
import NavBarComponent from "@/components/NavBarComponent";
import FooterComponent from "@/components/FooterComponent";

export default function Layout({children}){
    return(
        <>
            <NavBarComponent/>
            <main>
                {children}
            </main>
            <FooterComponent/>
        </>
    )
}